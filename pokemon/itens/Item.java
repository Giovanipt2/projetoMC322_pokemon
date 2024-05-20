package pokemon.itens;

/**
 * Um item genérico.
 */
public abstract class Item {
    private String nome;    //Refere-se ao nome do item

    // Construtor
    public Item(String nome) {
        this.nome = nome;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void SetNome(String nome) {
        this.nome = nome;
    }

    public String toString() {
        return "Nome: " + nome + "\n" + "Aqui aparecerão os dados do item...\n";
    }
}