package pokemon.GUI;

import pokemon.BancoDados;
import pokemon.Batalha;
import pokemon.Pokemon;

import javax.swing.*;
import java.awt.*;

public class MenuBatalha extends JPanel {
    private JPanel pokemons;
    private Pokemon pokemon1;
    private Pokemon pokemon2;

    public MenuBatalha(Batalha batalha) {
        super(new GridLayout(0,1,6,6));
        pokemon1 = batalha.getJogador1().getPokemonAtivo();
        pokemon2 = batalha.getJogador2().getPokemonAtivo();
        pokemons = new JPanel();
        pokemons.add(new JLabel(new ImageIcon(pokemon1.getSprite())));
        pokemons.add(new JLabel(new ImageIcon(pokemon2.getSprite())));
        add(pokemons);

        JPanel barrasDeVida = new JPanel();
        JProgressBar vida1 = new JProgressBar();
        JProgressBar vida2 = new JProgressBar();
        vida1.setValue(90);
        vida2.setValue(60);
        barrasDeVida.add(vida1);
        barrasDeVida.add(vida2);
        add(barrasDeVida);

        JPanel p = new JPanel(new FlowLayout());
        p.add(new Button("Atacar"));
        p.add(new Button("Trocar"));
        p.add(new Button("Item"));
        add(p);
    }
}
