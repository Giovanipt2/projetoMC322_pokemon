package pokemon;


/*
 * Classe de itens destinada a curar o PP de um ataque do pokemon em questão.
 * Só pode ser usada em pokemons vivos e em um ataque que não esteja no seu valor
 * máximo de PP.
 */
public class I_Ether extends ItemBatalha{
    private boolean isMax; // Booleano novamente para facilitar a implementação


    // Construtor
    public I_Ether(String nome, boolean isMax) {
        super(nome);
        this.isMax = isMax;
    }

}
