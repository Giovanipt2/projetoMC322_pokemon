package pokemon;

public class AtaqueEfeito extends Ataque {

    public AtaqueEfeito(String nome, Tipo tipo, int poder, int ppMax, int prioridade, int precisao, Efeito efeito, int precisaoEfeito) {
        super(nome, tipo, poder, ppMax, prioridade, precisao, efeito, precisaoEfeito);
    }


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
