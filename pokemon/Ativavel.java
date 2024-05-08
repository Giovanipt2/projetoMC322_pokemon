package pokemon;

/**
 * Um Ativável causa um determinado
 * efeito em determinados momentos de uma batalha.
 *
 * <p> Cada ativável é responsável por implementar seus próprios
 * métodos (por exemplo, por meio de uma classe abstrata). Qualquer
 * estágio de batalha que permita o uso de ativáveis é responsável por
 * chamar os métodos adequados de cada ativável em jogo (por exemplo,
 * um método que cause dano em um Pokémon deve chamar o método danoTomado
 * de cada ativável relevantes).
 */
public interface Ativavel {
    /**
     * @return o fator pelo qual
     */
    default float multiplicadorStat(Stat s, Pokemon p) {
        return 1.0f;
    }

    /**
     * @param ataque o ataque utilizado
     * @param ataca o Pokémon que usa o ataque
     * @param alvo o Pokémon atacado
     *
     * @return o valor pelo o qual o ataque é multiplicado
     */
    default float multiplicadorDano(Ataque ataque, Pokemon ataca, Pokemon alvo) {
        return 1.0f;
    }

    /**
     * Chamado quando um efeito é aplicado no Pokémon alvo.
     */
    default void efeitoAplicado(Batalha b, Pokemon alvo) {}

    /**
     * Chamado quando um Pokémon toma dano.
     */
    default void danoTomado(Batalha b, Pokemon ataca, Pokemon alvo, int dano) {}

    /**
     * Chamado quando um Pokémon é atingido por um ataque físico
     * (mesmo que não haja dano).
     */
    default void houveContato(Batalha b, Pokemon ataca, Pokemon alvo) {}

    /**
     * Chamado quando o clima da batalha é alterado.
     */
    default void climaAlterado(Batalha b) {}

    /**
     * Chamado quando um turno acaba.
     */
    default void fimDoTurno(Batalha b) {}

    /**
     * Chamado no início da batalha.
     */
    default void inicioDaBatalha(Batalha b) {}

    /**
     * Chamado antes do fim da batalha.
     */
    default void fimDaBatalha(Batalha b) {}
}
