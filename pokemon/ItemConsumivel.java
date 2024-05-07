package pokemon;

/*
 Essa classe será a responsável para classificar os itens
 que os treinadores podem usar ativamente durante o combate,
 isto é, eles atribuirão um efeito para o pokemon vigente em
 combate, consumindo o turno do treinador.
 */
public class ItemConsumivel {
    private String nome; // Refere-se ao nome do item
    private boolean aoe; // Refere-se a se o item afeta mais de 1 pokemon, se sim True, caso contrário False
    

    // Construtor
    public ItemConsumivel(String nome, boolean aoe) {
        this.nome = nome;
        this.aoe = aoe;
    }


    // Getters e Setters
    public String getNome() {
        return nome;
    }
    public void SetNome(String n_nome) {
        this.nome = n_nome;
    }

    public boolean getAOE() {
        return aoe;
    }
    public void setAOE(boolean n_aoe) {
        this.aoe = n_aoe;
    } 
}
// Essa classe configurará a superclasse para descrever os itens de fato e seus efeitos(Os itens serão classificados conforme seus efeitos)
