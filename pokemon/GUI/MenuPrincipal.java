package pokemon.GUI;

import pokemon.BancoDados;
import pokemon.Pokemon;
import pokemon.itens.*;
import pokemon.ataques.*;
import javax.swing.*;
import java.awt.*;

public class MenuPrincipal extends JFrame {
    private JPanel painelAtivo;
    private Pokemon pokemonEscolhido;
    private Ataque ataqueEscolhido;
    private Item itemEscolhido; //!

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

    public void setAtaqueEscolhido(Ataque ataque) {
        ataqueEscolhido = ataque;
        System.out.println(ataqueEscolhido);
    }

    public void setItemEscolhido(Item item) {
        itemEscolhido = item;
        System.out.println(itemEscolhido);
    }
}
