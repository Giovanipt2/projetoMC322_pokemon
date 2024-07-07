package pokemon;

import pokemon.GUI.MenuPrincipal;

import javax.swing.*;

public class Main {

    /**
     * Realiza um torneio de Pokémons e imprime o vencedor.
     */
    public static void main(String[] args) {
        //Inicializar o banco de dados
        BancoDados.inicializar();
        Treinador jogador1 = new Treinador(JOptionPane.showInputDialog(null,
                "Insira o nome do primeiro jogador:"));
        Treinador jogador2 = new Treinador(JOptionPane.showInputDialog(null,
                "Insira o nome do segundo jogador:"));
        Batalha batalha = new Batalha(jogador1, jogador2, null);

        SwingUtilities.invokeLater(() -> new MenuPrincipal(batalha).start());
    }
}