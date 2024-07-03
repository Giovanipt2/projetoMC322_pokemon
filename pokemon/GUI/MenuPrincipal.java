package pokemon.GUI;

import pokemon.BancoDados;
import pokemon.Pokemon;

import javax.swing.*;
import java.awt.*;

public class MenuPrincipal extends JFrame {
    private JPanel painelAtivo;
    private Pokemon pokemonEscolhido;

    public MenuPrincipal() {
        super();
        setTitle("Pokémon MC322");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        painelAtivo = new JPanel();
        getContentPane().add(painelAtivo, BorderLayout.CENTER);
        painelAtivo.add(new SeletorDePokemon(BancoDados.getPokemons().values(), this));

        setVisible(true);
        pack();
    }

    public void setPokemonEscolhido(Pokemon pokemon) {
        pokemonEscolhido = pokemon;
        System.out.println(pokemonEscolhido);
    }
}
