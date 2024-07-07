package pokemon.GUI;

import pokemon.itens.Item;

import javax.swing.*;
import java.awt.*;
import java.util.Collection;

public class SeletorDeItens extends JPanel {
    private MenuPrincipal origem;
    private Runnable callback;
    private Item escolhido;

    // Construtor
    public SeletorDeItens(Collection<? extends Item> itens, String prompt) {
        super();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JPanel promptECancelar = new JPanel(new FlowLayout());
        promptECancelar.add(new JLabel(prompt));
        JButton cancelar = new JButton("Cancelar");
        cancelar.addActionListener(e -> {
            getParent().remove(this);
        });
        promptECancelar.add(cancelar);
        add(promptECancelar);

        JPanel botoes = new JPanel(new GridLayout(1, 0, 6, 6));
        for (Item item : itens) {
            botoes.add(criarBotao(item));
        }
        add(botoes);
        setVisible(true);
    }


    // Método de criação do botão para esse painel
    private JButton criarBotao(Item item) {
        JButton botao = new JButton(item.getNome());
        botao.setFocusPainted(false);
        botao.addActionListener(e -> {
            int escolha = JOptionPane.showConfirmDialog(null,
                    "Deseja usar " + item.getNome() + "?", null, JOptionPane.YES_NO_OPTION);
            if (escolha == 0) { //Sim
                escolhido = item;
                callback.run();
            }
        });
        return botao;
    }

    public void setCallback(Runnable callback) {
        this.callback = callback;
    }

    public Item itemEscolhido() {
        return escolhido;
    }
}