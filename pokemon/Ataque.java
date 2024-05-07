package pokemon;

public abstract class Ataque {
    private Tipo tipo;
    private int poder;
    private int pp;
    private int prioridade;
    private int precisao;

    public abstract int dano(Pokemon usuario, Pokemon alvo, Clima clima);
    public abstract Efeito efeito();
}
