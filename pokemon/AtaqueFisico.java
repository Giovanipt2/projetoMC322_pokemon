package pokemon;

public class AtaqueFisico extends Ataque {
    /**
     * Calcula o dano base (sem multiplicadores)
     * do ataque.
     *
     * @param usuario o Pokémon que usa o ataque
     * @param alvo    o Pokémon atacado
     * @return o dano base.
     */
    public int danoBase(Pokemon usuario, Pokemon alvo) {
        int d = 2 * usuario.getNivel() / 5 + 2;
        d *= poder * (usuario.getStat(Stat.ATK) / alvo.getStat(Stat.DEF));
        d /= 50;
        return d + 2;
    }

    @Override
    public int dano(Pokemon usuario, Pokemon alvo, Clima clima) {
        int d = danoBase(usuario, alvo);

        //TODO Considerar clima

        // Dano crítico
        if (critico()) {
            d = Math.round(d * 1.5f);
        }

        // Multiplicador aleatório (de 85% a 100%)
        d = Math.round(d * ((float) Util.randInt(85, 101) / 100));

        // STAB (Bônus de ataque do mesmo tipo do Pokémon
        if (usuario.getTipos().contains(tipo)) {
            d *= Math.round(d * 1.5f);
        }

        // Eficácia do tipo de ataque
        d = Math.round(d * tipo.multiplicador(alvo.getTipos()));

        return d;
    }

    //TODO
    @Override
    public Efeito efeito() {
        return null;
    }

    /**
     * Determina se o ataque deve ser crítico.
     * Por enquanto, todos os ataques têm uma chance
     * de 1/24 de serem críticos.
     *
     * @return {@code true} se o ataque for crítico.
     */
    private boolean critico() {
        return Util.randBool(1, 24);
    }
}