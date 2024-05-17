package pokemon.itens;


import pokemon.Pokemon;

/**
 * Classe de itens que o PP de um ataque do pokemon em questão.
 * Só pode ser usada em Pokémons vivos e em um ataque que não esteja no seu valor
 * máximo de PP.
 */
public class I_Ether extends ItemBatalha {
    private boolean isMax; // Booleano novamente para facilitar a implementação


    // Construtor
    public I_Ether(String nome, boolean isMax) {
        super(nome);
        this.isMax = isMax;
    }

    @Override
    public void uso(Pokemon pokemon) {

    }
}
