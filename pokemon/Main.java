package pokemon;
import java.util.Scanner;

public class Main {
    private static Treinador torneio(Menu menu) {
        // As batalhas iniciais do torneio são entre o 1º e o 2º, 3º e 4º.
        Treinador jogador1 = menu.getJogador(0);
        Treinador jogador2 = menu.getJogador(1);
        Treinador jogador3 = menu.getJogador(2);
        Treinador jogador4 = menu.getJogador(3);

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

        //Criar os jogadores
        menu.CriarJogadores();

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
