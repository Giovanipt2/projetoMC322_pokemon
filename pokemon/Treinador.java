package pokemon;

import java.util.ArrayList;

/**
 * Treinador.java
 * Representa um treinador de pokémon que participará do torneio
 * Seus atributos são: nome, time (array de pokémons) e itens (array de itens de batalha)
 */
public class Treinador {
    private String nome;        //String que representa o nome do treinador
    private int id;             //Número inteiro que representa o id de um treinador
    private ArrayList<Pokemon> time;    //Array que guarda os pokémons no time do treinador
    private ArrayList<ItemBatalha> itens;    //Array que guarda os itens de batlha do treinador
    public static int numTreinadores;  //Número inteiro que representa a quantidade de jogadores no torneio

    //Construtor
    public Treinador(String nome) {
        this.nome = nome;
        this.id = numTreinadores++;
        this.time = new ArrayList<Pokemon>();
        this.itens = new ArrayList<ItemBatalha>();
    }

    //Getters
    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public ArrayList<Pokemon> getTime() {
        return time;
    }

    public ArrayList<ItemBatalha> getItens() {
        return itens;
    }


    /**
     * Método para adicionar o pokémon escolhido ao time do treinador
     * @param pokemon Instância da classe Pokemon
     * @return True, se foi possível adicionar o pokémon; ou false, caso contrário
     */
    public boolean addPokemon(Pokemon pokemon) {
        return time.add(pokemon);
    }


    /**
     * Método que define como as informações do treinador serão exibidas
     */
    @Override
    public String toString() {
        String out = "";

        out += "Nome: " + nome + "\n";
        out += "ID: " + id + "\n";
        out += "Pokémons:";
        
        for (Pokemon pokemon : time) {
            out += " " + pokemon.getNome();
        }
        
        out += ".\n";

        out += "Itens de batalha:";

        for (ItemBatalha item : itens) {
            out += " " + item.getNome();
        }

        out += ".\n";

        return out;
    }
}
