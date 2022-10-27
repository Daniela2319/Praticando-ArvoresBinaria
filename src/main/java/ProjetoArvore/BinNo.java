package ProjetoArvore;

/**
 * Classe BinNo extenção e comparação dos nós.
 * @param <T> Tipo genérica.
 */
public class BinNo<T extends Comparable<T>> {

    //Atributos
    private T conteudo;
    private BinNo<T> noEsq;
    private BinNo<T> noDir;

    //Construtor
    public BinNo(T conteudo) {
        this.conteudo = conteudo;
        noEsq = noDir = null;
    }

    //Construtor vazio
    public BinNo(){
    }

    //Getter e Setter
    public T getConteudo() {
        return conteudo;
    }

    public void setConteudo(T conteudo) {
        this.conteudo = conteudo;
    }

    public BinNo<T> getNoEsq() {
        return noEsq;
    }

    public void setNoEsq(BinNo<T> noEsq) {
        this.noEsq = noEsq;
    }

    public BinNo<T> getNoDir() {
        return noDir;
    }

    public void setNoDir(BinNo<T> noDir) {
        this.noDir = noDir;
    }

    //To String
    @Override
    public String toString() {
        return "BinNo{" +
                "conteudo=" + conteudo +
                '}';
    }
}
