package pokemon;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.List;
import java.util.HashMap;

public class Pokemon {
    /**
     * O nome do Pokémon
     */
    private String nome;
    /**
     * Os tipos do Pokémon
     */
    private List<Tipo> tipos;
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
     * O item atual do Pokémon (null se não há)
     */
    private ItemPokemon item;
    /**
     * O efeito atual do Pokémon (null se não há)
     */
    private Efeito efeito;

    public Pokemon(String nome, List<Tipo> tipos, int nivel,  Map<Stat, Integer> statsBase, Map<Stat, Integer> evs, Map<Stat, Integer> ivs, List<Ataque> ataques) {
        this.nome = nome;
        this.tipos = new ArrayList<>(tipos);
        this.nivel = nivel;
        this.statsBase = new HashMap<>(statsBase);
        this.evs = new HashMap<>(evs);
        this.ivs = new HashMap<>(ivs);
        this.ataques = new ArrayList<>(ataques);
        this.hp = getStat(Stat.HP);
        this.efeito = null;
    }

    /**
     * Adiciona um item ao pokemon.
     * @param item O item a ser adicionado
     */
    public void adicionarItem(ItemPokemon item) {
        this.item = item;
    }

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

    public int getNivel() {
        return nivel;
    }

    public String getNome() {
        return nome;
    }

    /**
     * Retorna uma cópia da lista de tipos do Pokémon
     */
    public List<Tipo> getTipos() {
        return new ArrayList<>(tipos);
    }
}
