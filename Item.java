import java.awt.Image;
import java.util.ArrayList;
/**************ALTEREI************************/
//Criei uma Classe Item pra facilita na manipulação do mapa
public abstract class Item{
    private Localizacao localizacaoAtual;


    public Item(Localizacao localizacaoAtual){
        this.localizacaoAtual = localizacaoAtual;
    }

    public Localizacao getLocalizacaoAtual() {
        return localizacaoAtual;
    }

    public void setLocalizacaoAtual(Localizacao localizacaoAtual) {
        this.localizacaoAtual = localizacaoAtual;
    }

    public abstract Image getImagem();

    public abstract Localizacao executarAcao(ArrayList<Obra> obras);



}
