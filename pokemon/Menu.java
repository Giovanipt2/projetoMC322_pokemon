package pokemon;

import pokemon.ataques.Ataque;
import pokemon.itens.ItemBatalha;
import pokemon.itens.ItemPokemon;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Representa o menu principal do jogo, onde o jogador pode acessar suas informações, seu time de Pokémons, seus itens, etc.
 */
public class Menu {
    private Scanner input;

    // Construtor padrão
    public Menu(Scanner input) {
        this.input = input;
    }

    /**
     * Mostra os Pokémons iniciais disponíveis.
     */
    private void imprimirListaPokemonsIniciais() {
        // Mostra os Pokémons iniciais disponíveis
        System.out.println("-----------------------------------");
        System.out.println("Pokémons iniciais disponíveis: ");
        ArrayList<Pokemon> listaPokemonIniciais = new ArrayList<>(BancoDados.getPokemonsIniciais().values());
        for (int i = 0; i < listaPokemonIniciais.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + listaPokemonIniciais.get(i).getNome());
        }
        System.out.println("-----------------------------------");
    }


    /**
     * Mostra os Pokémons disponíveis.
     */
    private void imprimirListaPokemons() {
        // Mostra os Pokémons disponíveis
        System.out.println("-----------------------------------");
        System.out.println("Pokémons disponíveis: ");
        ArrayList<Pokemon> listaPokemon = new ArrayList<>(BancoDados.getPokemons().values());
        for (int i = 0; i < listaPokemon.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + listaPokemon.get(i).getNome());
        }
        System.out.println("-----------------------------------");
    }

    /**
     * Mostra os itens disponíveis.
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
     * Permite que o jogador escolha um item para o pokemon atual.
     *
     * @return o item escolhido.
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
                System.out.println("Opção inválida.");
                input.nextLine();
            }
            System.out.println("Digite um número entre 1 e " + listaItens.size() + ":");
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
                    System.out.println("Opção inválida.");
                    input.nextLine();
                }
                System.out.println("Digite 1 para sim ou 2 para não:");
            }

            if (resposta == 1) {
                itemEscolhido = true;
                System.out.println("Item adicionado ao pokemon!");
            } else {
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
                        System.out.println("Opção inválida.");
                        input.nextLine();
                    }
                    System.out.println("Digite um número entre 1 e " + listaItens.size() + ":");
                }
            }
        }

        return item;
    }

    private Pokemon leituraDePokemonInicial() {
        Pokemon pokemonEscolhido = null;
        ArrayList<Pokemon> PokemonsIniciais = new ArrayList<>(BancoDados.getPokemonsIniciais().values());
        // Mostra os Pokémons iniciais disponíveis
        imprimirListaPokemonsIniciais();
        // Lê a escolha do jogador (verificando se ele passou um inteiro)
        boolean escolhido = false;
        while (!escolhido) {
            int escolha = 0;
            while (escolha < 1 || escolha > PokemonsIniciais.size()) {
                try {
                    escolha = input.nextInt();
                    input.nextLine();
                } catch (InputMismatchException e) {
                    System.out.println("Opção inválida.");
                    input.nextLine();
                }
                if (escolha < 1 || escolha > PokemonsIniciais.size()) {
                    System.out.println("Digite um número entre 1 e " + PokemonsIniciais.size() + ":");
                }
            }
            // Mostre os dados do Pokémon escolhido
            pokemonEscolhido = PokemonsIniciais.get(escolha - 1);
            System.out.println(pokemonEscolhido.toString());
            // Perguntar se ele deseja adicionar esse Pokemon ao time
            System.out.println("Deseja adicionar esse Pokémon ao seu time?");
            System.out.println("[1] Sim");
            System.out.println("[2] Não");
            int resposta = 0;
            while (resposta < 1 || resposta > 2) {
                try {
                    resposta = input.nextInt();
                    input.nextLine();
                } catch (InputMismatchException e) {
                    System.out.println("Opção inválida.");
                    input.nextLine();
                }
                if (resposta < 1 || resposta > 2) {
                    System.out.println("Digite 1 para sim ou 2 para não:");
                }
            }
            if (resposta == 1) {
                escolhido = true;
                System.out.println("Pokémon adicionado ao time!");
            } else {
                System.out.println("Pokémon não adicionado ao time!");
                System.out.println("Escolha um dos Pokémons iniciais para ter acesso a seus dados:");
                imprimirListaPokemonsIniciais();
            }
        }

        return pokemonEscolhido;
    }

    /**
     * Lê um jogador do console e o adiciona à lista de jogadores
     */
    public Treinador lerJogador() {
        // Lê o nome do jogador
        System.out.println("Digite o nome do jogador: ");
        String nome = input.nextLine();
        // Cria um novo jogador com o nome lido
        Treinador jogador = new Treinador(nome);

        System.out.println("Jogador " + nome + " criado com sucesso!");
        System.out.println("Primeiro, escolha um dos Pokémons iniciais para ter acesso a seus dados: ");

        //ArrayList de pokemons gerais
        ArrayList<Pokemon> pokemonsgerais = new ArrayList<>(BancoDados.getPokemons().values());

        // Escolha do pokemon inicial
        int escolhidos = 1;
        Pokemon pokemonInicial = leituraDePokemonInicial();
        jogador.adicionarPokemon(pokemonInicial);
        System.out.println("Pokemon inicial adicionado ao time!");

        // Mostra os pokémons gerais disponíveis
        imprimirListaPokemons();
        // Agora o jogador pode escolher mais três pokemon
        System.out.println("Agora, você poderá escolher mais 3 Pokémons: ");
        System.out.println("Escolha um dos Pokémons para ter acesso a seus dados:");

        while (escolhidos != 4) {
            // Lê a escolha do jogador (verificando se ele passou um inteiro)
            int escolha = 0;
            while (escolha < 1 || escolha > pokemonsgerais.size()) {
                try {
                    escolha = input.nextInt();
                    input.nextLine();
                } catch (InputMismatchException e) {
                    System.out.println("Opção inválida.");
                    input.nextLine();
                }
                if (escolha < 1 || escolha > pokemonsgerais.size()) {
                    System.out.println("Digite um número entre 1 e " + pokemonsgerais.size() + ":");
                }
            }
            // Mostre os dados do pokemon escolhido
            Pokemon pokemonEscolhido = pokemonsgerais.get(escolha - 1);
            System.out.println(pokemonEscolhido.toString());
            // Perguntar se ele deseja adicionar esse Pokémon ao time
            System.out.println("Deseja adicionar esse Pokémon ao seu time?");
            System.out.println("[1] Sim");
            System.out.println("[2] Não");
            int resposta = 0;
            while (resposta < 1 || resposta > 2) {
                try {
                    resposta = input.nextInt();
                    input.nextLine();
                } catch (InputMismatchException e) {
                    System.out.println("Opção inválida.");
                    input.nextLine();
                }
                if (resposta < 1 || resposta > 2) {
                    System.out.println("Digite 1 para sim ou 2 para não:");
                }
            }

            if (resposta == 1) {
                // A escolha de itens de pokemon só será usada na segunda entrega
                // ItemPokemon item = leituraDeItem();
                // pokemonEscolhido.adicionarItem(item);jogador.adicionarPokemon(pokemonEscolhido);
                jogador.adicionarPokemon(pokemonEscolhido);
                System.out.println("Pokémon adicionado ao time!");
                escolhidos++;
                System.out.println("Faltam " + (4 - escolhidos) + " Pokémons para completar o time.");
                if (escolhidos == 4) {
                    System.out.println("Time completo! Parabéns!");
                }
            } else {
                System.out.println("Pokémon não adicionado ao time!");
            }

            // Mostra os Pokémons gerais disponíveis novamente
            if (escolhidos != 4) {
                imprimirListaPokemons();
            }
        }
        return jogador;
    }

    /**
     * Escolhe qual tipo de ação um jogador realizará na rodada.
     * A escolha pode ser alterada depois caso o jogador mude de ideia.
     *
     * @param treinador o jogador
     * @return a ação escolhida.
     */
    public Batalha.Acao escolherAcao(Treinador treinador) {
        // Mostrar as ações disponíveis
        System.out.println("Escolha uma ação: ");
        System.out.println("[1] Atacar");
        System.out.println("[2] Trocar pokemon");
        System.out.println("[3] Usar item");

        Batalha.Acao acao = null;
        // Lê a escolha do jogador (verificando se ele passou um inteiro)
        int escolha = 0;
        while (escolha < 1 || escolha > 3) {
            try {
                escolha = input.nextInt();
                input.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Opção inválida.");
                input.nextLine();
            }
            if (escolha < 1 || escolha > 3) {
                System.out.println("Digite um número entre 1 e 3:");
            }
        }
        switch (escolha) {
            case 1:
                acao = Batalha.Acao.ATACAR;
                break;
            case 2:
                acao = Batalha.Acao.TROCAR;
                break;
            case 3:
                acao = Batalha.Acao.ITEM;
                break;
        }
        return acao;
    }

    /**
     * Escolhe o ataque que um jogador utilizará na rodada.
     * Oferece a opção de voltar caso o jogador mude de ideia.
     *
     * @param treinador o jogador
     * @return o ataque escolhido;
     * {@code null} caso o jogador cancele a escolha.
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

        // Lê a escolha do jogador (verificando se ele passou um inteiro)
        int escolha = -1;
        while (escolha < 0 || escolha > listaAtaques.size()) {
            try {
                escolha = input.nextInt();
                input.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Opção inválida.");
                input.nextLine();
            }
            if (escolha < 0 || escolha > listaAtaques.size()) {
                System.out.println("Digite um número entre 1 e " + listaAtaques.size() + ":");
            }
        }
        // Se o jogador escolher 0, retorna null
        if (escolha == 0) {
            return null;
        }
        return listaAtaques.get(escolha - 1);
    }

    /**
     * Escolhe qual Pokémon um jogador quer ativar.
     * Oferece a opção de voltar caso o jogador mude de ideia.
     *
     * @param treinador o treinador que escolherá o pokemon ativo
     * @return o pokemon escolhido;
     * {@code null} caso o jogador cancele a escolha.
     */
    public Pokemon trocarPokemon(Treinador treinador) {
        // Imprime as opções possíveis
        System.out.println("Escolha um pokemon para ser o ativo:");
        System.out.println("[0] Voltar");
        List<Pokemon> listaPokemons = treinador.getPokemons();
        for (int i = 0; i < listaPokemons.size(); i++) {
            System.out.printf("[%d] %s\n", i + 1, listaPokemons.get(i).getNome());
        }

        // Escolhe uma opção
        Pokemon escolhido = null;
        while (escolhido == null) {
            try {
                int indice = input.nextInt() - 1;
                input.nextLine();

                if (indice == -1) { // Jogador quis voltar
                    return null;
                }
                if (indice >= 0 && indice < listaPokemons.size()) {
                    escolhido = listaPokemons.get(indice);
                    if (!escolhido.estaVivo()) {
                        System.out.printf("%s desmaiou, escolha outro Pokémon.\n", escolhido.getNome());
                        escolhido = null;
                    }
                } else {
                    System.out.println("Opção inválida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Opção inválida.");
                input.nextLine();
            }
        }
        return escolhido;
    }

    /**
     * Escolhe qual Pokémon um jogador quer ativar no lugar de outro que desmaiou.
     * Não pode ser cancelado.
     *
     * @param treinador o jogador
     * @return o pokemon escolhido.
     */
    public Pokemon trocarPosDesmaio(Treinador treinador) {
        // Imprime as opções
        System.out.println("Escolha um pokemon para ser o ativo:");
        List<Pokemon> listaPokemons = treinador.getPokemons();
        for (int i = 0; i < listaPokemons.size(); i++) {
            System.out.printf("[%d] %s\n", i + 1, listaPokemons.get(i).getNome());
        }

        // Escolhe uma opção
        Pokemon escolhido = null;
        while (escolhido == null) {
            try {
                int indice = input.nextInt() - 1;
                input.nextLine();

                if (indice >= 0 && indice < listaPokemons.size()) {
                    escolhido = listaPokemons.get(indice);
                    if (!escolhido.estaVivo()) {
                        System.out.printf("%s desmaiou, escolha outro Pokémon.\n", escolhido.getNome());
                        escolhido = null;
                    }
                } else {
                    System.out.println("Opção inválida.");  // Índice inteiro, mas inválido
                }
            } catch (InputMismatchException e) {
                System.out.println("Opção inválida.");  // Jogador não forneceu um inteiro
                input.nextLine();
            }
        }
        return escolhido;
    }

    /**
     * Escolhe o item que o jogador usará na rodada.
     * Oferece a opção de voltar caso o jogador mude de ideia.
     *
     * @param treinador O treinador que escolherá o item
     * @return o item escolhido;
     * {@code null} caso o jogador cancele a escolha.
     */
    public ItemBatalha escolherItem(Treinador treinador) {
        // Mostrar os itens disponíveis
        System.out.println("Escolha um item para usar: ");
        System.out.println("[0] Voltar");
        ArrayList<ItemBatalha> listaItens = new ArrayList<>(treinador.getItens());
        for (int i = 0; i < listaItens.size(); i++) {
            System.out.printf("[%d] %s\n", i + 1, listaItens.get(i).getNome());
        }

        // Lê a escolha do jogador (verificando se ele passou um inteiro)
        int escolha = -1;
        while (escolha < 0 || escolha > listaItens.size()) {
            try {
                escolha = input.nextInt();
                input.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Opção inválida.");
                input.nextLine();
            }
            if (escolha < 0 || escolha > listaItens.size()) {
                System.out.println("Digite um número entre 1 e " + listaItens.size() + ":");
            }
        }
        // Se o jogador escolher 0 (voltar), retorna null
        if (escolha == 0) {
            return null;
        }
        ItemBatalha item = listaItens.get(escolha - 1);

        if (!item.usavel(treinador.getPokemonAtivo())) {
            System.out.printf("Não é possível usar %s agora.\n", item.getNome());
            return null;
        }
        return item;
    }

    /**
     * Escolhe com qual Pokémon o jogador inicia a batalha.
     *
     * @param treinador o jogador
     * @return o Pokémon escolhido.
     */
    public Pokemon escolherPokemonDaBatalha(Treinador treinador) {
        // Mostrar o time do jogador
        System.out.println("Escolha um pokemon para começar a batalha: ");
        List<Pokemon> listaPokemons = treinador.getPokemons();
        for (int i = 0; i < listaPokemons.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + listaPokemons.get(i).getNome());
        }

        // Lê a escolha do jogador (verificando se ele passou um inteiro)
        int escolha = 0;
        while (escolha < 1 || escolha > listaPokemons.size()) {
            try {
                escolha = input.nextInt();
                input.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Opção inválida.");
                input.nextLine();
            }
            if (escolha < 1 || escolha > listaPokemons.size()) {
                System.out.println("Digite um número entre 1 e " + listaPokemons.size() + ":");
            }
        }
        Pokemon pokemon = listaPokemons.get(escolha - 1);
        System.out.println("Pokemon " + pokemon.getNome() + " escolhido para a batalha!");
        return pokemon;
    }
}
