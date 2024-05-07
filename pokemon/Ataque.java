package pokemon;

public abstract class Ataque {
    protected Tipo tipo;
    protected int poder;
    protected int pp;
    protected int prioridade;
    protected int precisao;
    protected Efeito efeito;

    public abstract int dano(Pokemon usuario, Pokemon alvo, Clima clima);
    public abstract Efeito getEfeito();
}
