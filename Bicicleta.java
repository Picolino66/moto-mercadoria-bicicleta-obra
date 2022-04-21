import java.awt.Image;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;

/**
 * Representa os bicicletas da simulacao.
 * @author David J. Barnes and Michael Kolling and Luiz Merschmann
 */
public class Bicicleta extends Item{
    private int limX;
    private int limY;
    private Image imagem;

    public Bicicleta(Localizacao localizacaoAtual){
        super(localizacaoAtual);
        imagem = new ImageIcon(getClass().getResource("Imagens/bicicleta.png")).getImage();
    }

    public Image getImagem(){
        return imagem;
    }

    public void setLimitePercorrer(int x, int y) {
        this.limX = x;
        this.limY = y;
    }
    
    /**************ALTEREI************************/
    //Ação
    public void locomoverBicicleta(Localizacao pos){
        if(pos != null){
            Random rand = new Random();
            Localizacao destino = new Localizacao(rand.nextInt(this.limX),rand.nextInt(this.limY));
            Localizacao proximaLocalizacao = getLocalizacaoAtual().proximaLocalizacao(destino);
            while(pos == proximaLocalizacao){
                destino = new Localizacao(rand.nextInt(this.limX),rand.nextInt(this.limY));
                proximaLocalizacao = getLocalizacaoAtual().proximaLocalizacao(destino);
            }
            setLocalizacaoAtual(proximaLocalizacao);
        }
    }

    @Override
    public Localizacao executarAcao(ArrayList<Obra> obras) {
        return null;
    }
}
