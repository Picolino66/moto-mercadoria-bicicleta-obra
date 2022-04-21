import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Mercadoria extends Item{
    private Localizacao localizacaoDestino;
    private Image imagem;

    public Mercadoria(Localizacao localizacaoAtual) {
        super(localizacaoAtual);
        imagem = new ImageIcon(getClass().getResource("Imagens/pacote.png")).getImage();
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

    //A mercadoria não executa ações*AINDA(TALVEZ)*
    public Localizacao executarAcao(ArrayList<Obra> obras){
        return null;}

}
