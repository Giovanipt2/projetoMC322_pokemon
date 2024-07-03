package pokemon.GUI;

import pokemon.Pokemon;

import javax.swing.*;
import java.awt.*;
import java.util.Collection;

public class SeletorDePokemon extends JPanel {
    private MenuPrincipal pai;

    /**
     * O último Pokémon clicado.
     */
    private Pokemon selecionado;

    public SeletorDePokemon(Collection<Pokemon> pokemons, MenuPrincipal pai) {
        super(new GridLayout((int) Math.sqrt(pokemons.size()), 0, 6, 6));
        this.pai = pai;
        for (Pokemon pokemon : pokemons) {
            add(criarBotao(pokemon));
        }
        setVisible(true);
    }

    private void inicializar(Collection<Pokemon> pokemons) {

    }

    private JButton criarBotao(Pokemon pokemon) {
        JButton botao = new JButton(pokemon.getNome());
        botao.setIcon(new ImageIcon(pokemon.getSprite()));
        botao.setFocusPainted(false);
        if (!pokemon.estaVivo()) {
            botao.setEnabled(false);
        }
        botao.setFocusPainted(false);
        botao.addActionListener(e -> {
            int escolha = JOptionPane.showConfirmDialog(null, "Deseja enviar " +
                    pokemon.getNome() + "?", null, JOptionPane.YES_NO_OPTION);
            if (escolha == 0) {  // Sim
                selecionado = pokemon;
                pai.setPokemonEscolhido(pokemon);
                setVisible(false);
            }
        });

        return botao;
    }
}
