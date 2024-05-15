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

    /**
     * Cria um novo Pokemón.
     *
     * @param nome o nome do Pokémon
     * @param tipos os tipos do Pokémon
     * @param nivel o nível inicial do Pokémon
     * @param statsBase os stats base do Pokémon.
     *                  Stats omitidos recebem o valor 0 por padrão.
     * @param ataques os ataques que o Pokémon pode usar
     */
    public Pokemon(String nome, List<Tipo> tipos, int nivel,  Map<Stat, Integer> statsBase, List<Ataque> ataques) {
        this.nome = nome;
        this.tipos = new ArrayList<>(tipos);
        this.nivel = nivel;
        this.statsBase = new HashMap<>(statsBase);
        this.evs = new HashMap<>();
        this.ivs = new HashMap<>();
        for (Stat s : Stat.values()) {
            if (!this.statsBase.containsKey(s)) {
                statsBase.put(s, 0);    // Stats não informados são zerados
            }
            evs.put(s, 0);
            ivs.put(s, Util.randInt(0, 32));
        }

        // TODO: Os ataques em si também precisam ser copiados
        this.ataques = new ArrayList<>(ataques);
        this.hp = getStat(Stat.HP);
        this.efeito = null;
    }

    /**
     * Cria uma cópia do Pokémon.
     * A cópia tem nível e EVs zerados,
     * e IVs aleatorizados.
     *
     * @param p o Pokémon a ser copiado
     * @param nivel o nível do novo Pokémon
     */
    public Pokemon(Pokemon p, int nivel) {
        this(p.nome, p.tipos, nivel, p.statsBase, p.ataques);
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

    public int getNivel() {
        return nivel;
    }

    public String getNome() {
        return nome;
    }

    // Setter e Getter para o EV do Pokémon
    public int getEV(Stat stat) {
        return evs.get(stat);
    }
    public void setEV(Stat stat, int new_EV) {
        this.evs.put(stat, new_EV);
    }

    //Setter e Getter para o HP atual do Pokémon
    public int getHP_atual() {
        return hp;
    }
    public void setHP_atual(int novo_hp){
        this.hp = novo_hp;
    }
    public void somaHP_atual(int aumento){
        this.hp += aumento;
    }

    //Setter e Getter para o efeito atual do Pokémon
    public Efeito getEfeito() {
        return efeito;
    }
    public void setEfeito(Efeito efeito) {
        this.efeito = efeito;
    }

    /**
     * Retorna uma cópia da lista de tipos do Pokémon
     */
    public List<Tipo> getTipos() {
        return new ArrayList<>(tipos);
    }
    
    /**
     * Retorna os ataques do Pokémon.
     */
    public List<Ataque> getAtaques() {
        return new ArrayList<>(ataques);
    }

    public boolean estaVivo() {
        return hp > 0;
    }

    /**
     * Retorna as informações do Pokémon.
     * @return uma string com as informações do Pokémon.
     */
    public String toString() {
        String out = "Nome: " + nome + "\n" +
              "Nível: " + nivel + "\n" +
              "Ataques: \n";
        //Mostrar os ataques
        for (int i = 0; i < ataques.size(); i++) {
            out += "[" + (i + 1) + "] " + ataques.get(i).toString() + "\n";
        }
        out += "Stats: \n";
        for (Stat s : Stat.values()) {
            out += s + ": " + getStat(s) + "\n";
        }
        return out;
    }
}
