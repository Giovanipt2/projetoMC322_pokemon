package pokemon;


/* Essa classe de itens será responsável por classificar
 * todos os itens consumíveis que podem ser usados em batalha
 * para garantir um aprimoramento de algum atributo do pokemon
 * instantaneamente e consome o turno do treinador para isso.
 * 
 * Eles serão separados em 4 subclasses: I_Combate
 */
abstract class ItemBatalha extends Item {
    // Construtor
    public ItemBatalha(String nome) {
        super(nome);
    }
    // Método abstrato que será usado para cada tipo de item de batalha
    public abstract void uso(Pokemon pokemon);
}
