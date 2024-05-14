package pokemon;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

/**
 * Menu.java
 *
 * Representa o menu principal do jogo, onde o jogador pode acessar suas informações, seu time de pokémons, seus itens, etc.
 */
public class Menu {
    // O menu possui uma lista de jogadores
    private ArrayList<Treinador> jogadores;
    private Scanner input;

    // Construtor padrão
    public Menu(Scanner input) {
        this.jogadores = new ArrayList<Treinador>();
        this.input = input;
    }

    /**
     * Adiciona um jogador à lista de jogadores
     * @param jogador O jogador a ser adicionado
     */
    private void adicionarJogador(Treinador jogador) {
        this.jogadores.add(jogador);
    }

    /**
     * Enum com as ações possiveis
     */
    public enum Acao {
        ATACAR, TROCAR, ITEM;
    }


    /**
     * Mostra os pokemons iniciais disponiveis
     */
    private void imprimirListaPokemonsIniciais() {
        // Mostra os pokémons iniciais disponíveis
        System.out.println("-----------------------------------");
        System.out.println("Pokémons iniciais disponíveis: ");
        ArrayList<Pokemon> listaPokemonIniciais = new ArrayList<>(BancoDados.getPokemonsIniciais().values());
        for (int i = 0; i < listaPokemonIniciais.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + listaPokemonIniciais.get(i).getNome());
        }
        System.out.println("-----------------------------------");
    }


    /**
     * Mostra os pokemons disponiveis
     */
    private void imprimirListaPokemons() {
        // Mostra os pokémons disponíveis
        System.out.println("-----------------------------------");
        System.out.println("Pokémons disponíveis: ");
        ArrayList<Pokemon> listaPokemon = new ArrayList<>(BancoDados.getPokemons().values());
        for (int i = 0; i < listaPokemon.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + listaPokemon.get(i).getNome());
        }
        System.out.println("-----------------------------------");
    }

    /**
     * Mostra os itens disponiveis
     */
    private void imprimirListaItensPokemon() {
        // Mostra os itens disponíveis
        System.out.println("-----------------------------------");
        System.out.println("Itens disponíveis: ");
        ArrayList<ItemPokemon> listaItens = new ArrayList<>(BancoDados.getItensPokemon().values());
        for (int i = 0; i < listaItens.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + listaItens.get(i).getNome());
        }
        System.out.println("-----------------------------------");
    }

    /**
     * Permite que o jogador escolha um item para o pokemon atual
     * @return O item escolhido
     */
    private ItemPokemon leituraDeItem() {
        // Mostrar a lista de itens disponíveis
        System.out.println("Escolha um item para usar: ");
        imprimirListaItensPokemon();

        ItemPokemon item = null;
        ArrayList<ItemPokemon> listaItens = new ArrayList<>(BancoDados.getItensPokemon().values());


        // Lê a escolha do jogador (verificando se ele passou um inteiro)
        int escolha = 0;
        while (escolha < 1 || escolha > listaItens.size()) {
            try {
                escolha = input.nextInt();
                input.nextLine();
            } catch (InputMismatchException e) {
                input.nextLine();
            }
            System.out.println("Opção inválida. Digite um número entre 1 e " + listaItens.size() + ":");
        }
        boolean itemEscolhido = false;
        while (!itemEscolhido) {
            // Mostre os dados do item escolhido
            item = listaItens.get(escolha - 1);
            System.out.println(item.toString());
            // Perguntar se ele deseja adicionar esse item ao pokemon (verificando se ele passou um inteiro)
            System.out.println("Deseja adicionar esse item ao seu pokemon?");
            System.out.println("[1] Sim");
            System.out.println("[2] Não");
            int resposta = 0;
            while (resposta < 1 || resposta > 2) {
                try {
                    resposta = input.nextInt();
                    input.nextLine();
                } catch (InputMismatchException e) {
                    input.nextLine();
                }
                System.out.println("Opção inválida. Digite 1 para sim ou 2 para não:");
            }

            if (resposta == 1) {
                itemEscolhido = true;
                System.out.println("Item adicionado ao pokemon!");
            }
            else {
                System.out.println("Item não adicionado ao pokemon!");
                System.out.println("Escolha um item para usar: ");
                imprimirListaItensPokemon();
                // Lê novamente escolha do jogador (verificando se ele passou um inteiro)
                escolha = 0;
                while (escolha < 1 || escolha > listaItens.size()) {
                    try {
                        escolha = input.nextInt();
                        input.nextLine();
                    } catch (InputMismatchException e) {
                        input.nextLine();
                    }
                    System.out.println("Opção inválida. Digite um número entre 1 e " + listaItens.size() + ":");
                }
            }
        }
        
        return item;
    }

    /**
     * Lê um jogador do console e o adiciona à lista de jogadores
     */
    private void leituraDeJogador() {
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
        ArrayList<Pokemon> pokemonsIniciais = new ArrayList<>(BancoDados.getPokemons().values());

        // Mostra os pokémons iniciais disponíveis
        imprimirListaPokemons();

        System.out.println("Escolha um dos pokemons para ter acesso a seus dados:");

        int escolhidos = 0;
        while (escolhidos != 3) {
            // Lê a escolha do jogador (verificando se ele passou um inteiro)
            int escolha = 0;
            while (escolha < 1 || escolha > pokemonsIniciais.size()) {
                try {
                    escolha = input.nextInt();
                    input.nextLine();
                } catch (InputMismatchException e) {
                    input.nextLine();
                }
                System.out.println("Opção inválida. Digite um número entre 1 e " + pokemonsIniciais.size() + ":");
            }
            // Mostre os dados do pokemon escolhido
            Pokemon pokemonEscolhido = pokemonsIniciais.get(escolha - 1);
            System.out.println(pokemonEscolhido.toString());
            // Perguntar se ele deseja adicionar esse Pokemon ao time
            System.out.println("Deseja adicionar esse Pokemon ao seu time?");
            System.out.println("[1] Sim");
            System.out.println("[2] Não");
            int resposta = 0;
            while (resposta < 1 || resposta > 2) {
                try {
                    resposta = input.nextInt();
                    input.nextLine();
                } catch (InputMismatchException e) {
                    input.nextLine();
                }
                System.out.println("Opção inválida. Digite 1 para sim ou 2 para não:");
            }

            if (resposta == 1) {
                ItemPokemon item = leituraDeItem();
                pokemonEscolhido.adicionarItem(item);
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
     */
    public void CriarJogadores(){
        for (int i = 0; i < 4; i++) {
            leituraDeJogador();
        }
    }

    /**
     * Permite que o jogador escolha uma ação
     * @param treinador O treinador que escolherá a ação
     * @return A ação escolhida
     */
    public Acao escolherAcao(Treinador treinador) {
        // Mostrar as ações disponíveis
        System.out.println("Escolha uma ação: ");
        System.out.println("[1] Atacar");
        System.out.println("[2] Trocar pokemon");
        System.out.println("[3] Usar item");

        Acao acao = null;
        // Lê a escolha do jogador (verificando se ele passou um inteiro)
        int escolha = 0;
        while (escolha < 1 || escolha > 3) {
            try {
                escolha = input.nextInt();
                input.nextLine();
            } catch (InputMismatchException e) {
                input.nextLine();
            }
            System.out.println("Opção inválida. Digite um número entre 1 e 3:");
        }
        switch (escolha) {
            case 1:
                acao = Acao.ATACAR;
                break;
            case 2:
                acao = Acao.TROCAR;
                break;
            case 3:
                acao = Acao.ITEM;
                break;
        }
        return acao;
    }

    /**
     * Permite que o jogador escolha um ataque do pokemon ativo
     * @param treinador O treinador que escolherá o ataque
     * @return O ataque escolhido
     * Se o usuário digitar 0, a função retorna null
     */
    public Ataque escolherAtaque(Treinador treinador) {
        // Mostrar os ataques disponíveis
        System.out.println("Escolha um ataque para usar: ");
        System.out.println("[0] Voltar");
        Pokemon pokemonAtivo = treinador.getPokemonAtivo();
        List<Ataque> listaAtaques = pokemonAtivo.getAtaques();
        for (int i = 0; i < listaAtaques.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + listaAtaques.get(i).getNome());
        }

        Ataque ataque = null;
        // Lê a escolha do jogador (verificando se ele passou um inteiro)
        int escolha = 0;
        while (escolha < 0 || escolha > listaAtaques.size()) {
            try {
                escolha = input.nextInt();
                input.nextLine();
            } catch (InputMismatchException e) {
                input.nextLine();
            }
            System.out.println("Opção inválida. Digite um número entre 1 e " + listaAtaques.size() + ":");
        }
        // Se o jogador escolher 0, retorna null
        if (escolha == 0) {
            return null;
        }
        ataque = listaAtaques.get(escolha - 1);
        return ataque;
    }

    /**
     * Permite que o jogador escolha um pokemon para ser o ativo
     * @param treinador O treinador que escolherá o pokemon ativo
     * @return O pokemon escolhido
     * Se o usuário digitar 0, a função retorna null
     */
    public Pokemon trocarPokemon(Treinador treinador) {
        // Mostrar os pokémons disponíveis
        System.out.println("Escolha um pokemon para ser o ativo: ");
        System.out.println("[0] Voltar");
        List<Pokemon> listaPokemons = treinador.getPokemons();
        for (int i = 0; i < listaPokemons.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + listaPokemons.get(i).getNome());
        }
        for (int i = 0; i < listaPokemons.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + listaPokemons.get(i).getNome());
        }

        Pokemon pokemon = null;
        // Lê a escolha do jogador (verificando se ele passou um inteiro)
        int escolha = 0;
        while (escolha < 0 || escolha > listaPokemons.size()) {
            try {
                escolha = input.nextInt();
                input.nextLine();
            } catch (InputMismatchException e) {
                input.nextLine();
            }
            System.out.println("Opção inválida. Digite um número entre 1 e " + listaPokemons.size() + ":");
        }
        // Se o jogador escolher 0, retorna null
        if (escolha == 0) {
            return null;
        }
        pokemon = listaPokemons.get(escolha - 1);

        //Verifica se o pokemon escolhido está desmaiado
        while (pokemon.estaVivo() == false) {
            System.out.println("Esse pokemon está desmaiado! Escolha outro pokemon para ser o ativo: ");
            // Lê a escolha do jogador (verificando se ele passou um inteiro)
            escolha = 0;
            while (escolha < 1 || escolha > listaPokemons.size()) {
                try {
                    escolha = input.nextInt();
                    input.nextLine();
                } catch (InputMismatchException e) {
                    input.nextLine();
                }
                System.out.println("Opção inválida. Digite um número entre 1 e " + listaPokemons.size() + ":");
            }
            pokemon = listaPokemons.get(escolha - 1);
        }
        return pokemon;
    }

    /**
     * Permite que o jogador escolha um item para usar
     * @param treinador O treinador que escolherá o item
     * @return O item escolhido
     * Se o usuário digitar 0, a função retorna null
     */
    public Item escolherItem(Treinador treinador) {
        // Mostrar os itens disponíveis
        System.out.println("Escolha um item para usar: ");
        System.out.println("[0] Voltar");
        ArrayList<Item> listaItens = new ArrayList<>(treinador.getItens());
        for (int i = 0; i < listaItens.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + listaItens.get(i).getNome());
        }

        Item item = null;
        // Lê a escolha do jogador (verificando se ele passou um inteiro)
        int escolha = 0;
        while (escolha < 0 || escolha > listaItens.size()) {
            try {
                escolha = input.nextInt();
                input.nextLine();
            } catch (InputMismatchException e) {
                input.nextLine();
            }
            System.out.println("Opção inválida. Digite um número entre 0 e " + listaItens.size() + ":");
        }
        // Se o jogador escolher 0, retorna null
        if (escolha == 0) {
            return null;
        }
        item = listaItens.get(escolha - 1);
        return item;
    } 
}
