package pokemon;

public class AtaqueEspecial extends Ataque {
    //TODO
    @Override
    public int dano(Pokemon usuario, Pokemon alvo, Clima clima) {
        // Dano base
        int d = (2 * usuario.getNivel() / 5) + 2;
        d *= poder * (usuario.getStat(Stat.ATK_SP) / alvo.getStat(Stat.DEF_SP));

        // Eficácia do tipo
        d = Math.round((d * tipo.multiplicador(alvo.getTipos())));

        // Bônus se o ataque e o pokemon são do mesmo tipo (STAB)
        if (usuario.getTipos().contains(tipo)) {
            d *= Math.round(d * 1.5f);
        }

        return d;
    }

    //TODO
    @Override
    public Efeito getEfeito() {

    }

    /**
     * Determina se o ataque foi crítico.
     * Por enquanto, a probabilidade é de
     * 1/24 para qualquer ataque
     *
     * @return {@code true} se for crítico
     */
    private boolean critico() {
        // Chance de 1/24
        return Util.randBool(1,24);
    }
}
