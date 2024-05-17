package pokemon.ataques;

import pokemon.Clima;
import pokemon.Efeito;
import pokemon.Pokemon;
import pokemon.Tipo;

public abstract class Ataque {
    /**
     * O tipo do ataque.
     */
    protected Tipo tipo;
    /**
     * O poder (força) do ataque.
     */
    protected int poder;
    /**
     * O número de PPs disponíveis (pontos de poder,
     * que limitam quantas vezes é possível usar o ataque).
     */
    protected int pp;
    /**
     * O máximo de PPs que o ataque pode ter.
     */
    protected int ppMax;
    /**
     * A prioridade do ataque.
     * Ataques com prioridades mais altas acontecem primeiro.
     */
    protected int prioridade;
    /**
     * A probabilidade (em porcentagem) de o ataque
     * acertar o alvo, desprezando evasão e outros efeitos.
     */
    protected int precisao;
    /**
     * Efeito que um ataque pode ter
     */
    protected Efeito efeito;
    /**
     * A probabilidade (em porcentagem) do efeito ser aplicado
     */
    protected int precisaoEfeito;
    /**
     * String que representa o nome do ataque
     */
    protected String nome;

    /**
     * Retorna as informações do ataque.
     *
     * @return uma string com as informações do ataque.
     */
    public String toString() {
        return nome + " (" + tipo + ")";
    }


    public Ataque(String nome, Tipo tipo, int poder, int ppMax, int prioridade, int precisao, Efeito efeito, int precisaoEfeito) {
        this.nome = nome;
        this.tipo = tipo;
        this.poder = poder;
        this.pp = ppMax;
        this.ppMax = ppMax;
        this.prioridade = prioridade;
        this.precisao = precisao;
        this.efeito = efeito;
        this.precisaoEfeito = precisaoEfeito;
    }


    //Getter
    public String getNome() {
        return this.nome;
    }

    /**
     * Calcula o dano do ataque, caso ele acerte.
     *
     * @param usuario o Pokémon usando o ataque
     * @param alvo    o Pokémon alvo
     * @param clima   o clima atual
     * @return o dano.
     */
    public abstract int dano(Pokemon usuario, Pokemon alvo, Clima clima);

    public abstract Efeito efeito();

    public abstract Ataque copiar();

    public int getPrioridade() {
        return prioridade;
    }

    public int getPp() {
        return pp;
    }

    public void setPp(int pp) {
        this.pp = pp;
    }

    public int getPpMax() {
        return ppMax;
    }

    /**
     * Reduz o pp do ataque após sua utilização
     */
    public void somaPp(int soma) {
        this.pp += soma;
    }

    /**
     * Restaura o pp do ataque após a batalha
     */
    public void restauraPp() {
        this.pp = ppMax;
    }
}
