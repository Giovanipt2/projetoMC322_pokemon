package pokemon.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import pokemon.BancoDados;
import pokemon.Pokemon;

public class SeletorDePokemon extends JFrame {
    private JPanel painel;
    private ArrayList<JButton> opcoes;
    private Pokemon selecionado;
    public SeletorDePokemon(ArrayList<Pokemon> pokemons) {
        super();
        inicializar(pokemons);
    }

    private void inicializar(ArrayList<Pokemon> pokemons) {
        painel = new JPanel(new GridLayout(pokemons.size()/4 + 1, 3, 6, 5));
        setTitle("Pokémon Demo");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800,600);
        for (Pokemon p : pokemons) {
            //TODO colocar sprites dos pokemons
            JButton b = new JButton(p.getNome(), new ImageIcon(p.getSprite()));
            b.setFocusPainted(false);
            b.addActionListener(e -> {
                //TODO implementar direito
                selecionado = p;
                System.out.println(selecionado);
            });
            painel.add(b);
        }
        add(painel);
        pack();
        setVisible(true);
    }
}
