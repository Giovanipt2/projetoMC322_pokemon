package pokemon;

public class AtaqueEfeito extends Ataque {
    /**
     * @return 0 (ataques de efeito não causam dano).
     */
    @Override
    public int dano(Pokemon usuario, Pokemon alvo, Clima clima) {
        return 0;
    }

    //TODO
    @Override
    public Efeito efeito() {
        return null;
    }
}
