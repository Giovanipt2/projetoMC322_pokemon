package pokemon.itens;

import pokemon.Pokemon;
import pokemon.Stat;

/**
 * Classe de itens responsáveis por adicionar um número fixo de pontos de vida para
 * o Pokémon em batalha. Não será possível utilizar uma poção que tenha um efeito
 * em mais de 1 pokemon por vez, não é possível usar a poção se a vida do pokemon
 * for máxima ou 0 e não é possível sobrecarregar a vida do pokemon afetado.
 * [Exemplo: Gyarados com 141/150 de HP, caso você use uma SuperPotion, a qual cura 60
 * de HP, ele vai acabar com 150/150 e não 201/150.]
 */
public class I_Pocao extends ItemBatalha {
    private boolean isMax; //Usado na implementação da MaxPotion para facilitar a implementação
    private int cura; // Quanto a poção vai curar

    //Construtor
    public I_Pocao(String nome, boolean isMax, int cura) {
        super(nome);
        this.isMax = isMax;
        this.cura = cura;
    }

    @Override
    public void uso(Pokemon pokemon) {
        int hpFinal = pokemon.getHP_atual() + cura;
        if (isMax || hpFinal >= pokemon.getStat(Stat.HP)) {
            pokemon.setHP_atual(pokemon.getStat(Stat.HP));
        } else {
            pokemon.setHP_atual(hpFinal);
        }
    }

    @Override
    public boolean usavel(Pokemon pokemon) {
        return (pokemon.estaVivo()) && (pokemon.getHP_atual() < pokemon.getStat(Stat.HP));
    }
}
