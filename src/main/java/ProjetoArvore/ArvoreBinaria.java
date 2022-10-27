package ProjetoArvore;

/**
 * Classe ArvoreBinaria
 * Implementando a interfase comparable.
 * @param <T> Tipo genérica.
 */
public class ArvoreBinaria<T extends Comparable<T>> {

    //Atributo
    private BinNo<T> raiz;

    //Construtor
    public ArvoreBinaria(){
        this.raiz = null;
    }

    /**
     * Método Inserir
     * Recebe contéudo
     * criando nó novoNo neste contéudo
     * @param conteudo Tipo genérico.
     */
    public void inserir(T conteudo){
        BinNo<T> novoNo = new BinNo<>(conteudo);
        raiz = inserir(raiz, novoNo);
    }

    /**
     * Método Inserir Privado
     * Recebe nó atual e nó novoNo.
     * Três condições para inserir um nó novoNo. Primeira se nó atual igual nulo,
     * segunda compara se contéudo novoNo com nó atual da esquerda é menor se for inserido a lado esquerdo e a
     * terceira se for maior que Nó atual, o contéudo novoNo vai se inserindo no lado direito.
     * @param atual Tipo genérico
     * @param novoNo Tipo genérico
     * @return atual
     */
    private BinNo<T> inserir(BinNo<T> atual, BinNo<T> novoNo){
        if (atual == null){
            return novoNo;
        } else if (novoNo.getConteudo().compareTo(atual.getConteudo()) < 0) {
            atual.setNoEsq(inserir(atual.getNoEsq(), novoNo));

        }else {
            atual.setNoDir(inserir(atual.getNoDir(), novoNo));
        }
        return atual;
    }

    /**
     * Método ExibirInOrdem
     * Exibir elementos em ordem crescente apartir da raiz.
     */
    public void exibirInOrdem(){
        System.out.println("\n Exibindo InOrdem");
        exibirInOrdem(this.raiz);
    }

    /**
     * Método Exibir InOrdem
     * Primeiro exibir nó esquerda, exibi o nó e depois exibir nó da direita.
     * @param atual Tipo genérico
     */
    private void exibirInOrdem(BinNo<T> atual){
        if (atual != null){
            exibirInOrdem(atual.getNoEsq());
            System.out.print(atual.getConteudo() + ",");
            exibirInOrdem(atual.getNoDir());

        }
    }

    /**
     * Método Exibir PosOrdem
     * Chama método reponsivo passando a raíz.
     */
    public void exibirPosOrdem(){
        System.out.println("\n Exibindo PosOrdem");
        exibirPosOrdem(this.raiz);
    }

    /** Método Exibir PosOrdem
     * Exibir os elemento apartir lado esquerdo em seguida o lado direito por último exibir a raíz.
     * @param atual Tipo genérica.
     */
    private void exibirPosOrdem(BinNo<T> atual){
        if (atual != null){
            exibirPosOrdem(atual.getNoEsq());
            exibirPosOrdem(atual.getNoDir());
            System.out.print(atual.getConteudo() + ",");

        }
    }

    /**
     * Método Exibir PreOrdem
     * Chama método reponsivo passando a raiz.
     */
    public void exibirPreOrdem(){
        System.out.println("\n Exibindo PreOrdem");
        exibirPreOrdem(this.raiz);
    }

    /**
     * Método Exibir PreOrdem
     * Exibir a raíz, depois exibir o lado esquerdo em seguinda o lado direito.
     * @param atual Tipo genérico.
     */
    private void exibirPreOrdem(BinNo<T> atual){
        if (atual != null){
            System.out.print(atual.getConteudo() + ",");
            exibirPreOrdem(atual.getNoEsq());
            exibirPreOrdem(atual.getNoDir());

        }
    }

    /**
     * Método Remover
     * Bloco Try/Catch quando não encontra o contéudo.
     * Criando os nós: atual, pai, filho e temp(temporário).
     *
     * @param conteudo Tipo genérico
     */
    public void remover(T conteudo){
        try {
            BinNo<T> atual = this.raiz;
            BinNo<T> pai = null;
            BinNo<T> filho = null;
            BinNo<T> temp = null;

            while (atual != null && !atual.getConteudo().equals(conteudo)){ //Procurando o contéudo.
                pai = atual;
                if (conteudo.compareTo(atual.getConteudo()) < 0){ // testando o contéudo e comparando se contéudo menor que nó atual.
                    atual = atual.getNoEsq(); // se for vai para esquerda.
                }else{
                    atual = atual.getNoDir(); // se não for vai para direita sendo maior.
                }
            }

            if (atual == null){ // caso se não encontra ninguém.
                System.out.println("Conteudo não encontrado. Bloco Try");
            }

            if (pai == null){ // testar pai igual a nulo.
                if (atual.getNoDir() == null){ // testa se nó Atual direita é igual a nulo.
                    this.raiz = atual.getNoEsq(); // se for vai para esquerda.
                } else if (atual.getNoEsq() == null) { // testo se nó Atual é igual a nulo.
                    this.raiz = atual.getNoDir(); // se for nó vai para direita.
                }else{
                    for (temp = atual, filho = atual.getNoEsq(); // Condições
                        filho.getNoDir() != null;               // condições de parada.
                        temp = filho, filho = filho.getNoEsq()
                    ){
                        if (filho != atual.getNoEsq()){       // teste filho difente de nó atual esquerda.
                            temp.setNoDir(filho.getNoEsq());
                            filho.setNoEsq(raiz.getNoEsq());
                        }
                    }
                    filho.setNoDir(raiz.getNoDir());
                    raiz = filho;
                }
            } else if (atual.getNoDir() == null) { // testa nó atual da direita igual a nula.
                if (pai.getNoEsq() == atual){
                    pai.setNoEsq(atual.getNoEsq());
                }else{
                    pai.setNoDir(atual.getNoEsq());
                }
            } else if (atual.getNoEsq() == null) { // testa nó atual da esquerda igual a nula.
                if (pai.getNoEsq() == atual){
                    pai.setNoEsq(atual.getNoDir());
                }else {
                    pai.setNoDir(atual.getNoDir());
                }
            }else {
                for (
                        temp = atual, filho = atual.getNoEsq();
                        filho.getNoDir() != null;
                        temp = filho, filho = filho.getNoDir()
                ) {
                    if (filho != atual.getNoEsq()) {
                        temp.setNoDir(filho.getNoEsq());
                        filho.setNoEsq(atual.getNoEsq());
                    }
                    filho.setNoDir(atual.getNoDir());
                    if (pai.getNoEsq() == atual) {
                        pai.setNoEsq(filho);
                    } else {
                        pai.setNoDir(filho);
                    }
                }

            }
        }catch (NullPointerException erro){
            System.out.println("Conteudo não encontrado. Bloco Cartch");
        }
    }
}
