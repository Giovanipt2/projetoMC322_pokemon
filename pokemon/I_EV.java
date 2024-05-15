package pokemon;


/*
 * Classe que representa os itens que adicionam diretamente
 * nos EVs de um pokemon.
 * !NOTA IMPORTANTE: OS ITENS DE EV NAO RESETAM QUANDO O POKEMON MORRE!
*/
public class I_EV extends ItemBatalha{
    private Stat boostEV; // Responsável por indicar qual EV será boostado 
    //Construtor
    public I_EV(String nome, Stat boostEV) {
        super(nome);
        this.boostEV = boostEV;
    } 

    //Getter e Setter
    public Stat getBoost() {
        return boostEV;
    };

    /*Adiciona diretamente 10 pontos no EV indicado por boostEV.Para os fins do projeto 1,
    não adicionamos as penas que somam apenas 1 ponto no EV, todos os 6 itens de EV adicionam
    diretamente 10 pontos a tal EV(O limite de EVs não será explorado, por que nenhum pokemon alcançará
    esse limite na nossa definição)
    */
    public void uso(Pokemon pokemon) {
        pokemon.setEV(boostEV, (pokemon.getEV(boostEV) + 10));
    }
}