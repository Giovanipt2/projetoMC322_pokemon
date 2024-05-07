package pokemon;

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
     * Calcula o dano do ataque, caso ele acerte.
     *
     * @param usuario o Pokémon usando o ataque
     * @param alvo    o Pokémon alvo
     * @param clima   o clima atual
     * @return o dano.
     */
    public abstract int dano(Pokemon usuario, Pokemon alvo, Clima clima);

    public abstract Efeito efeito();
}
