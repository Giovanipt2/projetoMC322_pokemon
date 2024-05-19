package pokemon.itens;


import pokemon.Efeito;
import pokemon.Pokemon;

/**
 * Classe de itens usados para remover os efeitos danosos aplicados em um
 * Pokémon em batalha. Para os propósitos do nosso laboratório, eles não
 * serão aplicados em Pokémons com 0 de HP ou sem nenhum efeito aplicado.
 */
public class I_Efeito extends ItemBatalha {
    private Efeito efeito; // Determina o efeito que o remédio cura
    private boolean isFull; // Determina se é o FullHeal(Cura qualquer efeito que o pokemon tenha)


    // Construtor
    public I_Efeito(String nome, Efeito efeito, boolean isFull) {
        super(nome);
        this.efeito = efeito;
        this.isFull = isFull;
    }

    @Override
    public void uso(Pokemon pokemon) {
        pokemon.setEfeito(null);
    }

    @Override
    public boolean usavel(Pokemon pokemon) {
        if (isFull) {
            return pokemon.getEfeito() != null;
        }
        return (pokemon.getEfeito() == efeito);
    }
}
