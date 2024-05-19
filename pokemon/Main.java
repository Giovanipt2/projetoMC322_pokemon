package pokemon;

import pokemon.itens.ItemBatalha;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Treinador torneio(Menu menu) {
        // As batalhas iniciais do torneio são entre o 1º e o 2º, 3º e 4º.
        Treinador jogador1 = menu.lerJogador();
        Treinador jogador2 = menu.lerJogador();
        Treinador jogador3 = menu.lerJogador();
        Treinador jogador4 = menu.lerJogador();

        // Dá três itens aleatórios a cada jogador
        ArrayList<ItemBatalha> itens = new ArrayList<>(BancoDados.getItensBatalha().values());
        for (int i = 0; i < 3; i++) {
            jogador1.adicionarItem(itens.get(Util.randInt(0, itens.size())));
            jogador2.adicionarItem(itens.get(Util.randInt(0, itens.size())));
            jogador3.adicionarItem(itens.get(Util.randInt(0, itens.size())));
            jogador4.adicionarItem(itens.get(Util.randInt(0, itens.size())));
        }

        Batalha batalha1 = new Batalha(jogador1, jogador2, menu);
        Batalha batalha2 = new Batalha(jogador3, jogador4, menu);

        // A batalha 1 é entre o jogador 1 e o jogador 2.
        Treinador vencedor1 = batalha1.iniciar();

        // A batalha 2 é entre o jogador 3 e o jogador 4.
        Treinador vencedor2 = batalha2.iniciar();

        // A batalha final é entre o vencedor da batalha 1 e o vencedor da batalha 2.
        //Antes da batalha final, é necessário curar os pokemons dos jogadores
        vencedor1.curarPokemons();
        vencedor2.curarPokemons();

        Batalha batalhaFinal = new Batalha(vencedor1, vencedor2, menu);
        // O vencedor do torneio é o vencedor da batalha final.
        return batalhaFinal.iniciar();
    }

    public static void main(String[] args) {
        //Inicializar o banco de dados
        BancoDados.inicializar();
        //Inicializar o scanner
        Scanner scanner = new Scanner(System.in);
        //Inicializar o menu
        Menu menu = new Menu(scanner);

        //Iniciar o torneio
        Treinador vencedor = torneio(menu);
        // Imprimir o vencedor
        System.out.println("-----------------------------------");
        System.out.println("O vencedor do torneio é " + vencedor.getNome() + "!");
        System.out.println("-----------------------------------");

        //Fechar o scanner
        scanner.close();
    }
}