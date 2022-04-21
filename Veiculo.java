import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

/**
 * Representa os veiculos da simulacao.
 * @author David J. Barnes and Michael Kolling and Luiz Merschmann
 */
public class Veiculo extends Item{
    private Localizacao localizacaoDestino;
    private Mercadoria mercadoria;
    private Image imagem;

    public Veiculo(Localizacao localizacaoAtual){
        super(localizacaoAtual);
        imagem = new ImageIcon(getClass().getResource("Imagens/entregador.png")).getImage();
        localizacaoDestino = null;
    }

    public Image getImagem(){
        return imagem;
    }


    public Localizacao getLocalizacaoDestino() {
        return localizacaoDestino;
    }

    public void setLocalizacaoDestino(Localizacao localizacaoDestino) {
        this.localizacaoDestino = localizacaoDestino;
    }
    
    public void limpaLocalizacaoDestino(){
        localizacaoDestino = null;
    }
    
    public Localizacao executarAcao(ArrayList<Obra> obras){
        Localizacao destino = getLocalizacaoDestino();
        if(destino != null){
            Localizacao proximaLocalizacao = getLocalizacaoAtual().proximaLocalizacao(destino);

            Obra ob = this.temObra(obras, proximaLocalizacao);
            if(ob != null){
                proximaLocalizacao = getLocalizacaoAtual().mudarRota(ob.getLocalizacaoAtual());
            }
            
            setLocalizacaoAtual(proximaLocalizacao);
            if(mercadoria != null && foiEntregue()){//Se o veiculo tem uma mercadoria e chegou o ponto de entrega
                descarregaMercadoria();             //Então descarrega a mercadoria
                System.out.println("Entregue!"); //Messagem dizendo que a mercadoria foi entregue  
            }
            return proximaLocalizacao;
        }else return null;
    }

    public void pegaMercadoria(Localizacao localizacao){
        setLocalizacaoDestino(localizacao);
    }

    public void recebeMercadoria(Mercadoria mercadoria){
        this.mercadoria = mercadoria;
        setLocalizacaoDestino(mercadoria.getLocalizacaoDestino());
    }

    public void descarregaMercadoria(){
        mercadoria = null;
        limpaLocalizacaoDestino();
    }
    public boolean foiEntregue(){
        return mercadoria.getLocalizacaoDestino() == getLocalizacaoAtual();
    }

    public boolean livre(){
        return mercadoria == null && getLocalizacaoDestino() == null;
    }

    private Obra temObra(ArrayList<Obra> obras, Localizacao proximaLocalizacao){
        for (Obra obra : obras) {
            if (obra.getLocalizacaoAtual().equals(proximaLocalizacao)){
                return obra;
            }
        }
        return null;
    }
}
