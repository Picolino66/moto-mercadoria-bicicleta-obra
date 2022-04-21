import java.util.ArrayList;
import java.util.Random;
/**
 * Responsavel pela simulacao.
 * @author David J. Barnes and Michael Kolling and Luiz Merschmann
 */
public class Simulacao {
    private Veiculo veiculo;
    private Mercadoria mercadoria;
    private Bicicleta bicicleta1;
    private Bicicleta bicicleta2;
    private Bicicleta bicicleta3;
    private Destino destino;
    private ArrayList<Obra> obras = new ArrayList<Obra>();
    private JanelaSimulacao janelaSimulacao;
    private Mapa mapa;
    
    public Simulacao(int numeroObras) {
        Random rand = new Random();
        mapa = new Mapa();
        int largura = mapa.getLargura();
        int altura = mapa.getAltura();

        veiculo = new Veiculo(new Localizacao(rand.nextInt(largura),rand.nextInt(altura)));//Cria um veiculo em uma posicao aleatoria
        bicicleta1 = new Bicicleta(new Localizacao(rand.nextInt(largura),rand.nextInt(altura)));//Cria uma bicicleta
        bicicleta2 = new Bicicleta(new Localizacao(rand.nextInt(largura),rand.nextInt(altura)));//Cria uma bicicleta
        bicicleta3 = new Bicicleta(new Localizacao(rand.nextInt(largura),rand.nextInt(altura)));//Cria uma bicicleta
        for(int i = 0; i < numeroObras; i++){
            Obra obra = new Obra(new Localizacao(rand.nextInt(largura),rand.nextInt(altura)));//Cria uma obra
            obras.add(obra);
            mapa.adicionarItem(obra);
        }
        mercadoria = new Mercadoria(new Localizacao(rand.nextInt(largura),rand.nextInt(altura)));//Cria uma mercadoria em uma posicao aleatoria
        janelaSimulacao = new JanelaSimulacao(mapa);

        mercadoria.setLocalizacaoDestino(new Localizacao(rand.nextInt(largura),rand.nextInt(altura)));//Define a posicao destino aleatoriamente
        bicicleta1.setLimitePercorrer(largura, altura);
        bicicleta2.setLimitePercorrer(largura, altura);
        bicicleta3.setLimitePercorrer(largura, altura);

        destino = new Destino(mercadoria.getLocalizacaoDestino());

        mapa.adicionarItem(veiculo);//Inicializando o mapa com o veículo
        mapa.adicionarItem(bicicleta1);//Inicializando o mapa com a bicicleta
        mapa.adicionarItem(bicicleta2);//Inicializando o mapa com a bicicleta
        mapa.adicionarItem(bicicleta3);//Inicializando o mapa com a bicicleta
        mapa.adicionarItem(mercadoria);//Inicializando o mapa com uma mercadoria
        mapa.adicionarItem(destino);
    }

    public void executarSimulacao(int numPassos){
        if(veiculo.livre()){//Se o veiculo não tem nenhuma mercadoria a bordo então ele vai buscar uma
            veiculo.pegaMercadoria(mercadoria.getLocalizacaoAtual());
        }
        janelaSimulacao.executarAcao();
        for (int i = 0; i < numPassos; i++) {
            executarUmPasso();
            esperar(500);
        }        
    }

    private void executarUmPasso() {
        if(veiculo.getLocalizacaoAtual() == mercadoria.getLocalizacaoAtual()){//Se ao veiculo chegou na mesma posição da mercadoria
            veiculo.recebeMercadoria(mercadoria);
        }
        mapa.removerItem(veiculo);
        Localizacao fim = veiculo.executarAcao(obras);
        bicicleta1.locomoverBicicleta(fim);
        bicicleta2.locomoverBicicleta(fim);
        bicicleta3.locomoverBicicleta(fim);
        mapa.adicionarItem(veiculo);
        janelaSimulacao.executarAcao();
    }
    
    private void esperar(int milisegundos){
        try{
            Thread.sleep(milisegundos);
        }catch(InterruptedException e){
            System.out.println(e.getMessage());
        }
    }
    
}
