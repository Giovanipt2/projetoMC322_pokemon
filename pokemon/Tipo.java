package pokemon;

import java.util.Collection;

/**
 * Os tipos (elementos) dos ataques e Pokémons.
 */
public enum Tipo {
    // NÂO MUDAR ORDEM
    NORMAL, FOGO, AGUA, PLANTA, ELETRICO, GELO,
    LUTADOR, VENENOSO, TERRA, VOADOR, PSIQUICO, INSETO,
    PEDRA, FANTASMA, DRAGAO, SOMBRIO, METALICO, FADA;

    /**
     * A tabela de fraquezas
     */
    private static final float[][] fraquezas = new float[][]{
            // Def → NOR FIR WAT ELE GRA ICE FIG POI GRO FLY PSY BUG ROC GHO DRA DAR STE FAI  Atk ↓
            {1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, .5f, 0f, 1f, 1f, .5f, 1f}, // NOR
            {1f, .5f, .5f, 1f, 2f, 2f, 1f, 1f, 1f, 1f, 1f, 2f, .5f, 1f, .5f, 1f, 2f, 1f}, // FIR
            {1f, 2f, .5f, 1f, .5f, 1f, 1f, 1f, 2f, 1f, 1f, 1f, 2f, 1f, .5f, 1f, 1f, 1f}, // WAT
            {1f, 1f, 2f, .5f, .5f, 1f, 1f, 1f, 0f, 2f, 1f, 1f, 1f, 1f, .5f, 1f, 1f, 1f}, // ELE
            {1f, .5f, 2f, 1f, .5f, 1f, 1f, .5f, 2f, .5f, 1f, .5f, 2f, 1f, .5f, 1f, .5f, 1f}, // GRA
            {1f, .5f, .5f, 1f, 2f, .5f, 1f, 1f, 2f, 2f, 1f, 1f, 1f, 1f, 2f, 1f, .5f, 1f}, // ICE
            {2f, 1f, 1f, 1f, 1f, 2f, 1f, .5f, 1f, .5f, .5f, .5f, 2f, 0f, 1f, 2f, 1f, 1f}, // FIG
            {1f, 1f, 1f, 1f, 2f, 1f, 1f, .5f, .5f, 1f, 1f, 1f, .5f, .5f, 1f, 1f, 0f, 2f}, // POI
            {1f, 2f, 1f, 2f, .5f, 1f, 1f, 2f, 1f, 0f, 1f, .5f, 2f, 1f, 1f, 1f, 2f, 1f}, // GRO
            {1f, 1f, 1f, .5f, 2f, 1f, 2f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f}, // FLY
            {1f, 1f, 1f, 1f, 1f, 1f, 2f, 2f, 1f, 1f, .5f, 1f, 1f, 1f, 1f, .5f, .5f, 1f}, // PSY
            {1f, .5f, 1f, 1f, 2f, 1f, .5f, .5f, 1f, .5f, 2f, 1f, 1f, .5f, 1f, 2f, .5f, .5f}, // BUG
            {1f, 2f, 1f, 1f, 1f, 2f, .5f, 1f, .5f, 2f, 1f, 2f, 1f, 1f, 1f, 1f, .5f, 1f}, // ROC
            {0f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 2f, 1f, 1f, 2f, 1f, .5f, 1f, 1f}, // GHO
            {1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 2f, 1f, .5f, 0f}, // DRA
            {1f, 1f, 1f, 1f, 1f, 1f, .5f, 1f, 1f, 1f, 2f, 1f, 1f, 2f, 1f, .5f, 1f, .5f}, // DAR
            {1f, .5f, .5f, .5f, 1f, 2f, 1f, 1f, 1f, 1f, 1f, 1f, 2f, 1f, 1f, 1f, .5f, 2f}, // STE
            {1f, .5f, 1f, 1f, 1f, 1f, 2f, .5f, 1f, 1f, 1f, 1f, 1f, 1f, 2f, 2f, .5f, 1f}  // FAI
    };

    /**
     * Calcula a eficácia de um ataque deste tipo.
     * Esse valor deve multiplicar o dano total do ataque.
     *
     * @param tiposAlvo os tipos do Pokémon atacado
     * @return o multiplicador de eficácia
     */
    public float multiplicador(Collection<Tipo> tiposAlvo) {
        float multiplicador = 1f;
        for (Tipo t : tiposAlvo) {
            multiplicador *= fraquezas[this.ordinal()][t.ordinal()];
        }
        return multiplicador;
    }
}
