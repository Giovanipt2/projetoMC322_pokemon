package pokemon.GUI;

import pokemon.Batalha;
import pokemon.Pokemon;
import pokemon.Stat;

import javax.swing.*;
import java.awt.*;

public class MenuBatalha extends JPanel {
    private Batalha batalha;
    private Pokemon pokemon1;
    private Pokemon pokemon2;
    private int jogadorAtivo;
    private final JLabel labelPokemon1;
    private final JLabel labelPokemon2;
    private final JLabel prompt;
    private final JProgressBar vida1;
    private final JProgressBar vida2;

    private String textoPrompt;
    private Runnable callbackAtacar;
    private Runnable callbackTrocar;
    private Runnable callbackItem;


    /**
     * Cria e inicializa um novo Menu de Batalha
     *
     * @param batalha a batalha
     */
    public MenuBatalha(Batalha batalha) {
        super();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.batalha = batalha;
        pokemon1 = batalha.getJogador1().getPokemonAtivo();
        pokemon2 = batalha.getJogador2().getPokemonAtivo();

        // Adiciona sprites e nomes dos Pokémons
        labelPokemon1 = new JLabel(new ImageIcon(pokemon1.getSpritesPath() + "/back.gif"));
        labelPokemon1.setText(pokemon1.getNome() + " (" + pokemon1.getHP_atual() + "/" +
                pokemon1.getStat(Stat.HP) + ")");
        labelPokemon1.setVerticalTextPosition(JLabel.BOTTOM);
        labelPokemon1.setHorizontalTextPosition(JLabel.CENTER);

        labelPokemon2 = new JLabel(new ImageIcon(pokemon2.getSpritesPath() + "/front.gif"));
        labelPokemon2.setText(pokemon2.getNome() + " (" + pokemon2.getHP_atual() + "/" +
                pokemon2.getStat(Stat.HP) + ")");
        labelPokemon2.setVerticalTextPosition(JLabel.BOTTOM);
        labelPokemon2.setHorizontalTextPosition(JLabel.CENTER);

        JPanel iconesPokemons = new JPanel();
        iconesPokemons.add(labelPokemon1);
        iconesPokemons.add(labelPokemon2);
        add(iconesPokemons);

        // Adiciona barras de vida aos Pokémons
        vida1 = new JProgressBar();
        vida1.setMaximum(pokemon1.getStat(Stat.HP));
        vida1.setValue(pokemon1.getHP_atual());
        vida1.setForeground(corBarra(vida1.getPercentComplete()));

        vida2 = new JProgressBar();
        vida2.setMaximum(pokemon1.getStat(Stat.HP));
        vida2.setValue(pokemon1.getHP_atual());
        vida2.setForeground(corBarra(vida2.getPercentComplete()));

        JPanel barrasDeVida = new JPanel();
        barrasDeVida.add(vida1);
        barrasDeVida.add(vida2);
        add(barrasDeVida);

        // Adiciona os botões correspondentes às ações
        prompt = new JLabel();
        prompt.setText(textoPrompt);
        JPanel texto = new JPanel();
        texto.add(prompt);
        add(texto);

        JButton atacar = new JButton("Atacar");
        atacar.addActionListener(e -> {
            callbackAtacar.run();
        });

        JButton trocar = new JButton("Trocar");
        trocar.addActionListener(e -> {
            callbackTrocar.run();
        });

        JButton item = new JButton("Item");
        item.addActionListener(e -> {
            callbackItem.run();
        });

        JPanel opcoes = new JPanel(new FlowLayout());
        opcoes.add(atacar);
        opcoes.add(trocar);
        opcoes.add(item);
        add(opcoes);
    }

    /**
     * Atualiza o painel com base nas informações da batalha.
     */
    public void update() {
        pokemon1 = batalha.getJogador1().getPokemonAtivo();
        pokemon2 = batalha.getJogador2().getPokemonAtivo();


        //BufferedImage gifPokemon1 = new BufferedImage();
        String gifPath1 = pokemon1.getSpritesPath() + "/back.gif";
        String gifPath2 = pokemon2.getSpritesPath() + "/front.gif";

        labelPokemon1.setIcon(new ImageIcon(gifPath1));
        labelPokemon1.setText(pokemon1.getNome() + " (" + pokemon1.getHP_atual() + "/" +
                pokemon1.getStat(Stat.HP) + ")");
        labelPokemon2.setIcon(new ImageIcon(gifPath2));
        labelPokemon2.setText(pokemon2.getNome() + " (" + pokemon2.getHP_atual() + "/" +
                pokemon2.getStat(Stat.HP) + ")");

        vida1.setMaximum(pokemon1.getStat(Stat.HP));
        updateHealthBar(vida1, pokemon1);

        vida2.setMaximum(pokemon2.getStat(Stat.HP));
        vida2.setValue(pokemon2.getHP_atual());
        vida2.setForeground(corBarra(vida2.getPercentComplete()));
    }

    public void setCallbackAtacar(Runnable callback) {
        callbackAtacar = callback;
    }

    public void setCallbackTrocar(Runnable callback) {
        callbackTrocar = callback;
    }

    public void setCallbackItem(Runnable callback) {
        callbackItem = callback;
    }

    public void setPrompt(String texto) {
        textoPrompt = texto;
        prompt.setText(texto);
    }

    /**
     * Retorna a cor que a barra de vida de um Pokémon deve ter.
     *
     * @param porcentagem a razão entre a vida atual e máxima do Pokémon (de 0.0 a 1.0)
     * @return a cor adequada
     */
    private Color corBarra(double porcentagem) {
        if (porcentagem > 0.635) {
            return Color.GREEN;
        } else if (porcentagem > 0.25) {
            return Color.ORANGE;
        }
        return Color.RED;
    }

    private void displayTextSlowly(JLabel label, String text) {
        new Thread(() -> {
            String displayed = "";
            for (char c : text.toCharArray()) {
                displayed += c;
                label.setText(displayed);
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    label.setText(text);
                }
            }
        }).start();
    }

    private void updateHealthBar(JProgressBar bar, Pokemon pokemon) {
        new Thread(() -> {
            int currentValue = bar.getValue();
            int targetValue = pokemon.getHP_atual();
            while (targetValue < currentValue) {
                currentValue--;
                bar.setValue(currentValue);
                setForeground(corBarra(bar.getPercentComplete()));
                try {
                    Thread.sleep(4);
                } catch (InterruptedException e) {
                    bar.setValue(targetValue);
                }
            }
            bar.setValue(targetValue);
        }).start();
    }

    public void setJogadorAtivo(int jogadorAtivo) {
        this.jogadorAtivo = jogadorAtivo;
    }
}
