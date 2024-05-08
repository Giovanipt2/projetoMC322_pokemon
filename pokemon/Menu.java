package pokemon;

import java.util.Scanner;
import java.util.ArrayList;

/**
 * Menu.java
 *
 * Representa o menu principal do jogo, onde o jogador pode acessar suas informações, seu time de pokémons, seus itens, etc.
 */
public class Menu {
    // O menu possui uma lista de jogadores
    private ArrayList<Treinador> jogadores;

    // Construtor padrão
    public Menu() {
        this.jogadores = new ArrayList<Treinador>();
    }

    /**
     * Adiciona um jogador à lista de jogadores
     * @param jogador O jogador a ser adicionado
     */
    private void adicionarJogador(Treinador jogador) {
        this.jogadores.add(jogador);
    }

    /**
     * Mostra o menu principal
     */
    private void imprimirListaPokemons() {
        // Mostra os pokémons disponíveis
        System.out.println("-----------------------------------");
        System.out.println("Pokémons iniciais disponíveis: ");
        ArrayList<Pokemon> listaPokemon = new ArrayList<>(Pokemon.getEspecie().values());
        for (int i = 0; i < listaPokemon.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + listaPokemon.get(i).getNome());
        }
        System.out.println("-----------------------------------");
    }

    /**
     * Lê um jogador do console e o adiciona à lista de jogadores
     * @param input O scanner que será usado para ler o nome do jogador
     */
    private void leituraDeJogador(Scanner input) {
        // Lê o nome do jogador
        System.out.println("Digite o nome do jogador: ");
        String nome = input.nextLine();
        // Cria um novo jogador com o nome lido
        Treinador jogador = new Treinador(nome);
        // Adiciona o jogador à lista de jogadores
        this.adicionarJogador(jogador);

        System.out.println("Jogador " + nome + " criado com sucesso!");

        // Agora o jogador pode escolher três pokemon iniciais
        System.out.println("Escolha três pokémons iniciais: ");
        //ArrayList de pokemons iniciais
        ArrayList<Pokemon> pokemonsIniciais = new ArrayList<>(Pokemon.getEspecie().values());

        // Mostra os pokémons iniciais disponíveis
        imprimirListaPokemons();

        System.out.println("Escolha um dos pokemons para ter acesso a seus dados:");

        int escolhidos = 0;
        while (escolhidos != 3) {
            // Lê a escolha do jogador
            int escolha = input.nextInt();
            // Mostre os dados do pokemon escolhido
            Pokemon pokemonEscolhido = pokemonsIniciais.get(escolha - 1);
            System.out.println(pokemonEscolhido.toString());
            // Perguntar se ele deseja adicionar esse Pokemon ao time
            System.out.println("Deseja adicionar esse Pokemon ao seu time?");
            System.out.println("[1] Sim");
            System.out.println("[2] Não");
            int resposta = input.nextInt();

            if (resposta == 1) {
                jogador.adicionarPokemon(pokemonEscolhido);
                System.out.println("Pokemon adicionado ao time!");
                escolhidos++;
                System.out.println("Faltam " + (3 - escolhidos) + " pokémons para completar o time.");
            }
            else {
                System.out.println("Pokemon não adicionado ao time!");
            }

            // Mostra os pokémons iniciais disponíveis novamente
            imprimirListaPokemons();
        }
    }

    /**
     * Cria os jogadores
     * @param input O scanner que será usado para ler os nomes dos jogadores
     */
    public void CriarJogadores(Scanner input){
        for (int i = 0; i < 4; i++) {
            leituraDeJogador(input);
        }
    }
}
