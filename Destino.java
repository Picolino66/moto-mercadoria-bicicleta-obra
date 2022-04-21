import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

/**
 * Representa os destinos da simulacao.
 * @author David J. Barnes and Michael Kolling and Luiz Merschmann
 */
public class Destino extends Item{
    private Image imagem;

    public Destino(Localizacao localizacaoAtual){
        super(localizacaoAtual);
        imagem = new ImageIcon(getClass().getResource("Imagens/casa.png")).getImage();
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
