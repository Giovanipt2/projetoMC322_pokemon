package pokemon;

/**
  * Essa classe será a responsável para classificar os itens
  * que os treinadores podem usar ativamente durante o combate,
  * isto é, eles atribuirão um efeito para o pokemon vigente em
  * combate, consumindo o turno do treinador.
 */
public class Item {
    private String nome;    //Refere-se ao nome do item
    private boolean aoe;    //Refere-se a se o item afeta mais de 1 pokemon, se sim True, caso contrário False
    
    // Construtor
    public Item(String nome, boolean aoe) {
        this.nome = nome;
        this.aoe = aoe;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }
    public void SetNome(String nome) {
        this.nome = nome;
    }

    public boolean getAOE() {
        return aoe;
    }
    public void setAOE(boolean aoe) {
        this.aoe = aoe;
    } 
}

