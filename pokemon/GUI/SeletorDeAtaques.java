package pokemon.GUI;

import javax.swing.*;
import java.awt.*;
import java.util.Collection;
import pokemon.ataques.*;

public class SeletorDeAtaques extends JPanel {
    private MenuPrincipal pai;


    public SeletorDeAtaques(Collection<? extends Ataque> Ataques) {
        super(new GridLayout(2, 2)); // GridLayout com 2 linhas e 2 colunas

        // Criando os botões para cada ataque
        for (Ataque ataque : Ataques) {
            add(criarBotao(ataque));
        }

        setVisible(true);
    }

    private JButton criarBotao(Ataque ataque) {
        JButton botao = new JButton(ataque.getNome() + " (" + ataque.getTipo() + ")");
        botao.addActionListener(e -> {
            int escolha = JOptionPane.showConfirmDialog(null, "Deseja usar este ataque " +
                    ataque.getNome() + "?", null, JOptionPane.YES_NO_OPTION);
            if (escolha == 0) {  // Sim
                pai.setAtaqueEscolhido(ataque);
                setVisible(false);
            }
        });

        return botao;
    }
}
