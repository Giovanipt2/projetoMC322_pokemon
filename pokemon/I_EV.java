package pokemon;


/*
 * Classe que representa os itens que adicionam diretamente
 * nos EVs de um pokemon.
 * !NOTA IMPORTANTE: OS ITENS DE EV NAO RESETAM QUANDO O POKEMON MORRE!
*/
public class I_EV extends ItemBatalha{
    private Stat boostEV; // Responsável por adicionar 
    //Construtor
    public I_EV(String nome, Stat boostEV) {
        super(nome);
        this.boostEV = boostEV;
    } 

    //Getter e Setter
    public Stat getBoost() {
        return boostEV;
    };

    public void uso(Pokemon pokemon) {
        pokemon.setEV(boostEV, pokemon.getEV(boostEV));
    }
}