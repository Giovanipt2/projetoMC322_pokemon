package pokemon.itens;


import pokemon.Pokemon;

/**
 * Um item que aumenta o PP de um ataque.
 * Sua implementação está incompleta.
 */
public class Ether extends ItemBatalha {
    private boolean isMax; // Booleano novamente para facilitar a implementação


    // Construtor
    public Ether(String nome, boolean isMax) {
        super(nome);
        this.isMax = isMax;
    }

    @Override
    public void uso(Pokemon pokemon) {

    }
}
