package pokemon;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Inicializar o banco de dados
        BancoDados.inicializar();
        //Inicializar o scanner
        Scanner scanner = new Scanner(System.in);
        //Inicializar o menu
        Menu menu = new Menu(scanner);

        //Criar os jogadores
        menu.CriarJogadores();
        
    }
}
