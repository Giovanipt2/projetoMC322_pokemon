package pokemon;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Inicializar o banco de dados
        BancoDados.inicializar();
        //Inicializar o menu
        Menu menu = new Menu();
        //Inicializar o scanner
        Scanner scanner = new Scanner(System.in);
        
        //Criar os jogadores
        menu.CriarJogadores(scanner);
        
    }
}
