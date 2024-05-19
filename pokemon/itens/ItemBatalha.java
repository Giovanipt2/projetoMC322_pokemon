package pokemon.itens;


import pokemon.Pokemon;

/**
 * Essa classe de itens será responsável por classificar
 * todos os itens consumíveis que podem ser usados em batalha
 * para garantir um aprimoramento de algum atributo do pokemon
 * instantaneamente e consome o turno do treinador para isso.
 */
public abstract class ItemBatalha extends Item {
    // Construtor
    public ItemBatalha(String nome) {
        super(nome);
    }

    /**
     * Usa o item em um Pokémon. Sempre verifique se o item pode ser
     * usado agora, por meio do método
     * {@link ItemBatalha#usavel(Pokemon)}.
     *
     * @param pokemon o Pokémon no qual o item é usado
     */
    public abstract void uso(Pokemon pokemon);
        //Uso fantasma para poder instanciar um array de Itens de Batalha

    /**
     * Diz se o item pode ser usado agora.
     *
     * @param pokemon o Pokémon no qual o item é usado
     * @return {@code true} se for usável.
     */
    public boolean usavel(Pokemon pokemon) {
        return true;
    }
}
