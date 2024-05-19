package pokemon.itens;

import pokemon.Pokemon;
import pokemon.Stat;

/*
 * Classe responsável pelos itens que podem ser usados para reviver
 * um pokemon abatido. Esses itens só podem ser usados em pokemons com
 * 0 de HP, sem excessões.
 */
public class I_Reviver extends ItemBatalha {
    private boolean isMax;

    // Construtor;
    public I_Reviver(String nome, boolean isMax) {
        super(nome);
        this.isMax = isMax;
    }

    @Override
    public void uso(Pokemon pokemon) {
        if (isMax) {
            pokemon.setHP_atual(pokemon.getStat(Stat.HP));
        } else {
            pokemon.setHP_atual(pokemon.getStat(Stat.HP)/2);
        }
    }

    @Override
    public boolean usavel(Pokemon pokemon) {
        return (pokemon.getHP_atual() == 0);
    }
    
}
