import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

/**
 * Representa os obras da simulacao.
 * @author David J. Barnes and Michael Kolling and Luiz Merschmann
 */
public class Obra extends Item{
    private Image imagem;

    public Obra(Localizacao localizacaoAtual){
        super(localizacaoAtual);
        imagem = new ImageIcon(getClass().getResource("Imagens/obra.png")).getImage();
    }

    public Image getImagem(){
        return imagem;
    }

    @Override
    public Localizacao executarAcao(ArrayList<Obra> obras) {
        // TODO Auto-generated method stub
        return null;
    }
}
