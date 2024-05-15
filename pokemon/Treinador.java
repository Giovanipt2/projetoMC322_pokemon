package pokemon;

import java.util.ArrayList;
import java.util.List;

/**
 * Treinador.java
 * Representa um treinador de pokémon que participará do torneio
 * Seus atributos são: nome, time (array de Pokémons) e itens (array de itens de batalha)
 */
public class Treinador {
    private String nome;        //String que representa o nome do treinador
    private int id;             //Número inteiro que representa o id de um treinador
    private ArrayList<Pokemon> time;    //Array que guarda os Pokémons no time do treinador
    private ArrayList<ItemBatalha> itens;    //Array que guarda os itens de batalha do treinador
    private Pokemon pokemonAtivo; //Pokemon que está em batalha
    public static int numTreinadores;  //Número inteiro que representa a quantidade de jogadores no torneio

    //Construtor
    public Treinador(String nome) {
        this.nome = nome;
        this.id = numTreinadores++;
        this.time = new ArrayList<Pokemon>();
        this.itens = new ArrayList<ItemBatalha>();
        this.pokemonAtivo = null;
    }

    //Getters
    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public ArrayList<Pokemon> getTime() {
        return new ArrayList<>(time);
    }

    public ArrayList<ItemBatalha> getItens() {
        return new ArrayList<>(itens);
    }
    public Pokemon getPokemonAtivo() {
        return pokemonAtivo;
    }
    public void setPokemonAtivo(Pokemon pokemon) {
        if (!time.contains(pokemon)) {
            throw new IllegalArgumentException("O Pokémon " + pokemon
                    + " não pertence ao jogador" + getNome() + ".");
        }
        pokemonAtivo = pokemon;
    }
    public List<Pokemon> getPokemons() {
        return time;
    }


    /**
     * Método para adicionar o pokémon escolhido ao time do treinador
     * @param pokemon Instância da classe Pokemon
     * @return True, se foi possível adicionar o pokémon; ou false, caso contrário
     */
    public boolean adicionarPokemon(Pokemon pokemon) {
        return time.add(pokemon);
    }


    /**
     * Método para adicionar o item de batatlha escolhido aos itens do treinador
     * @param item Item de batalha que o treinador escolheu
     * @return  True, se foi possível adicionar o item; ou false, caso contrário
     */
    public boolean adicionarItem(ItemBatalha item) {
        return itens.add(item);
    }


    /**
     * Método para remover o item de batlha que foi usado pelo treinador
     * @param item Item de batalha que o treinador gastou
     * @return True, se foi possível remover o item; ou false, caso contrário
     */
    public boolean removerItem(ItemBatalha item) {
        return itens.remove(item);
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
