package pokemon;

import java.util.Map;
import java.util.List;

public class Pokemon {
    /**
     * Os protótipos de cada espécie de Pokémon
     */
    private static Map<String, Pokemon> especies;
    /**
     * O nome do Pokémon
     */
    private String nome;
    /**
     * Os tipos do Pokémon
     */
    private List<Tipo> types;
    /**
     * O nível do pokemon (de 1 a 100)
     */
    private int nivel;
    /**
     * A vida atual do Pokémon
     */
    private int hp;
    /**
     * Os stats base do Pokémon, usados no cálculo dos stats efetivos
     */
    private Map<Stat, Integer> statsBase;
    /**
     * Os EVs (valores de esforço) do Pokémon, usados no cálculo dos stats efetivos
     */
    private Map<Stat, Integer> evs;
    /**
     * Os IVs (valores individuais) do Pokémon, usados no cálculo dos stats efetivos
     */
    private Map<Stat, Integer> ivs;
    /**
     * Os ataques que podem ser usados pelo Pokémon
     */
    private List<Ataque> ataques;
    /**
     * O efeito atual do Pokémon (null se não há)
     */
    private Efeito efeito;

    /**
     * Calcula o valor efetivo de um stat.
     *
     * @param stat qual dos 6 stats
     * @return o valor do stat
     */
    public int getStat(Stat stat) {
        int valor = 2 * statsBase.get(stat) + ivs.get(stat) + evs.get(stat)/4;
        valor = (valor * nivel)/100;
        if (stat == Stat.HP) {
            valor += nivel + 10;
        }
        else {
            valor += 5;
        }
        return valor;
    }

    /**
     * Cria um Pokémon de uma dada espécie.
     * Os IVs são números aleatórios de 0 a 31.
     *
     * @param especie o nome da espécie
     * @return um novo Pokémon da espécie fornecida;
     * {@code null} se a espécie não for inválida.
     */
    //TODO
    public Pokemon clonar(String especie) {
        return null;
    }
}
