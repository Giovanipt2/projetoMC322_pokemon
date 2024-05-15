package pokemon;

/*
 * Classe de itens responsável por adicionar um número fixo de pontos de vida para
 * o pokemon em batalha. Não será possível utilizar uma poção que tenha um efeito
 * em mais de 1 pokemon por vez, não é possível usar a poção se a vida do pokemon
 * for máxima ou 0 e não é possível sobrecarregar a vida do pokemon afetado.
 * [Exemplo: Gyarados com 141/150 de HP, caso você use uma SuperPotion, a qual cura 60
 * de HP, ele vai acabar com 150/150 e não 201/150.]
 */
public class I_Pocao extends ItemBatalha{
    private boolean isMax; //Usado na implementação da MaxPotion para facilitar a implementação
    private int cura; // Quanto a poção vai curar
    
    //Construtor
    public I_Pocao(String nome, boolean isMax, int cura) {
        super(nome);
        this.isMax = isMax;
        this.cura = cura;
    }

    public void uso(Pokemon pokemon) {
        if (pokemon.getHP_atual() > 0) {
            if (!isMax) {
                if (pokemon.getHP_atual() + cura <= pokemon.getStat(Stat.HP)) { //Caso a poção não dê overheal
                    pokemon.setHP_atual(pokemon.getHP_atual() + cura); 
                } else if (pokemon.getHP_atual() + cura > pokemon.getStat(Stat.HP)) { // Caso overheal
                    pokemon.setHP_atual(pokemon.getStat(Stat.HP));
                }
            } else {
                pokemon.setHP_atual(pokemon.getStat(Stat.HP)); // Uma max potion cura o pokemon para sua vida máxima sempre
            }
        } else {
            // PRINTAR NO MENU QUE O POKEMON ESTÁ MORTO
        }
    }
}
