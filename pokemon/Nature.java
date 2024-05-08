package pokemon;

/**
 * Enumeração usada para representar as possíveis naturezas dos pokémons
 * Cada uma está relacionada com um possível incremento ou decremento em determinado atributo
 */
public enum Nature {
    LONELY(1.1, 1.0, 1.0, 1.0, 1.0, 0.9),
    ADAMANT(1.0, 1.1, 1.0, 0.9, 1.0, 1.0),
    NAUGHTY(1.0, 1.0, 1.1, 1.0, 0.9, 1.0),
    BRAVE(1.0, 1.0, 1.0, 1.0, 1.0, 0.9),
    HARDY(1.0, 1.0, 1.0, 1.0, 1.0, 1.0),
    BOLD(0.9, 1.0, 1.1, 1.0, 1.0, 1.0),
    IMPISH(1.0, 0.9, 1.1, 1.0, 1.0, 1.0),
    LAX(1.0, 1.0, 1.0, 1.0, 1.1, 0.9),
    RELAXED(1.0, 1.0, 1.0, 1.0, 1.1, 0.9),
    DOCILE(1.0, 1.0, 1.0, 1.0, 1.0, 1.0),
    MILD(1.0, 0.9, 1.0, 1.1, 1.0, 1.0),
    MODEST(0.9, 1.0, 1.0, 1.1, 1.0, 1.0),
    RASH(1.0, 1.0, 0.9, 1.1, 1.0, 1.0),
    QUIET(1.0, 1.0, 1.0, 1.1, 1.0, 0.9),
    BASHFUL(1.0, 1.0, 1.0, 1.0, 1.0, 1.0),
    GENTLE(1.0, 1.0, 1.0, 0.9, 1.1, 1.0),
    CALM(0.9, 1.0, 1.0, 1.0, 1.1, 1.0),
    CAREFUL(1.0, 1.0, 0.9, 1.0, 1.1, 1.0),
    SASSY(1.0, 1.0, 1.0, 1.0, 1.1, 0.9),
    SERIOUS(1.0, 1.0, 1.0, 1.0, 1.0, 1.0),
    HASTY(1.0, 1.0, 1.0, 0.9, 1.0, 1.1),
    TIMID(0.9, 1.0, 1.0, 1.0, 1.0, 1.1),
    JOLLY(1.0, 0.9, 1.0, 1.0, 1.0, 1.1),
    NAIVE(1.0, 1.0, 0.9, 1.0, 1.0, 1.1),
    QUIRKY(1.0, 1.0, 1.0, 1.0, 1.0, 1.0);

    private final double hp;
    private final double atk;
    private final double def;
    private final double atk_sp;
    private final double def_sp;
    private final double spe;

    //Construtor
    Nature(double hp, double atk, double def, double atk_sp, double def_sp, double spe) {
        this.hp = hp;
        this.atk = atk;
        this.def = def;
        this.atk_sp = atk_sp;
        this.def_sp = def_sp;
        this.spe = spe;
    }

    //Getters
    public double getHpMultiplier() {
        return hp;
    }

    public double getAtkMultiplier() {
        return atk;
    }

    public double getDefMultiplier() {
        return def;
    }

    public double getAtkSpMultiplier() {
        return atk_sp;
    }

    public double getDefSpMultiplier() {
        return def_sp;
    }

    public double getSpeMultiplier() {
        return spe;
    }
}

