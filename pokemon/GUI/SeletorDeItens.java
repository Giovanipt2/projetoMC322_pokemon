package pokemon.GUI;

import pokemon.itens.*;

import javax.swing.*;
import java.awt.*;
import java.util.Collection;

public class SeletorDeItens extends JPanel{
	private MenuPrincipal origem;


	// Construtor
	public SeletorDeItens(Collection<? extends Item> itens, MenuPrincipal origem) {
		super(new GridLayout(0, itens.size(), 6, 6));
		this.origem = origem;
            for (Item item : itens) {
                add(criarBotao(item));
            }
		setVisible(true);
    	}

	
	// Método de criação do botão para esse painel
    	private JButton criarBotao(Item item) {
		JButton botao = new JButton(item.getNome());
		botao.setFocusPainted(false);
		botao.addActionListener(e -> {
			int escolha = JOptionPane.showConfirmDialog(null, "Deseja usar " + item.getNome() +  "?", null, JOptionPane.YES_NO_OPTION);
                if (escolha == 0) { //Sim
                    origem.setItemEscolhido(item);
                    setVisible(false);	
                }
		    });
            return botao;
        }	
}