package pokemon.itens;


import pokemon.Efeito;
import pokemon.Pokemon;

/*
 * Classe responsável por classificar os itens que são usados para
 * remover os efeitos danosos aplicados em um pokemon em batalha.
 * Para os propósitos do nosso laboratório, eles não serão aplicados 
 * em pokemons com 0 de HP ou sem nenhum efeito aplicado.
 */
public class I_Efeito extends ItemBatalha {
    private Efeito effect; // Determina o efeito que o remédio cura
    private boolean isFull; // Determina se é o FullHeal(Cura qualquer efeito que o pokemon tenha)
    

    // Construtor
    public I_Efeito(String nome, Efeito effect, boolean isFull) {
        super(nome);
        this.effect = effect;
        this.isFull = isFull;
    }

    public void uso(Pokemon pokemon) {
        if (pokemon.getHP_atual() > 0 && pokemon.getEfeito() != null) {  // O pokemon precisa estar vivo e ter um efeito em si
            if (!isFull) {
                if (pokemon.getEfeito() == effect) {
                    pokemon.setEfeito(null);
                } else {
                    // Printar que não é possível usar esse remédio(NAO CONSUMIR A RODADA NESSE CASO)
                }
            } else {
                pokemon.setEfeito(null);
            }
        }
    }
    
}
