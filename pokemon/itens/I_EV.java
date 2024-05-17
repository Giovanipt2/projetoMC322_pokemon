package pokemon.itens;


import pokemon.Pokemon;
import pokemon.Stat;

/**
 * Classe que representa os itens que adicionam diretamente
 * nos EVs de um pokemon.
 * !NOTA IMPORTANTE: OS ITENS DE EV NAO RESETAM QUANDO O POKEMON MORRE!
 */
public class I_EV extends ItemBatalha {
    private Stat statAfetado; // Responsável por indicar qual EV será boostado
    private int aumento;

    //Construtor
    public I_EV(String nome, Stat statAfetado, int aumento) {
        super(nome);
        this.statAfetado = statAfetado;
        this.aumento = aumento;
    }

    //Getter e Setter
    public Stat getBoost() {
        return statAfetado;
    }

    ;

    /**
     * Adiciona diretamente 10 pontos no EV indicado por boostEV.Para os fins do projeto 1,
     * não adicionamos as penas que somam apenas 1 ponto no EV, todos os 6 itens de EV adicionam
     * diretamente 10 pontos a tal EV(O limite de EVs não será explorado, por que nenhum pokemon alcançará
     * esse limite na nossa definição)
     */
    public void uso(Pokemon pokemon) {
        pokemon.setEV(statAfetado, (pokemon.getEV(statAfetado) + aumento));
    }
}