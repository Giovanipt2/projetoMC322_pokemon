package pokemon.GUI;

import pokemon.Pokemon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;

public class MontadorDeTime extends JPanel implements ActionListener {
    private int inicaisSelecionados = 0;
    private int lendariosSelecionados = 0;
    private JLabel explicacao;
    private ArrayList<PokemonCheckBox> botoesIniciais;
    private ArrayList<PokemonCheckBox> botoesLendarios;
    private JButton confirmador;

    private ArrayList<Pokemon> escolhidos;

    /**
     * Um JCheckBox com um ícone extra.
     */
    private class PokemonCheckBox extends JPanel {
        JCheckBox checkBox;
        JLabel sprite;
        Pokemon pokemon;

        PokemonCheckBox(Pokemon pokemon) {
            super();
            this.pokemon = pokemon;
            checkBox = new JCheckBox(pokemon.getNome());
            sprite = new JLabel(new ImageIcon(pokemon.getSprite()));
            add(checkBox);
            add(sprite);
        }

        @Override
        public void setEnabled(boolean enabled) {
            sprite.setEnabled(enabled);
            checkBox.setEnabled(enabled);
        }

        void addActionListener(ActionListener l) {
            checkBox.addActionListener(l);
        }

        @Override
        public boolean isEnabled() {
            return checkBox.isEnabled();
        }

        public boolean isSelected() {
            return checkBox.isSelected();
        }

        JCheckBox getCheckBox() {
            return checkBox;
        }
    }

    public MontadorDeTime(Collection<? extends Pokemon> iniciais, Collection<? extends Pokemon> lendarios) {
        super(new GridLayout(7, 4));
        botoesIniciais = new ArrayList<>();
        botoesLendarios = new ArrayList<>();
        escolhidos = new ArrayList<>();

        for (Pokemon pokemon : iniciais) {
            PokemonCheckBox checkBox = new PokemonCheckBox(pokemon);
            checkBox.addActionListener(e -> {
                if (checkBox.isSelected()) {
                    inicaisSelecionados++;
                    escolhidos.add(pokemon);
                }
                else {
                    inicaisSelecionados--;
                    escolhidos.remove(pokemon);
                }
                update();
            });
            botoesIniciais.add(checkBox);
            add(checkBox);
        }
        for (Pokemon pokemon : lendarios) {
            PokemonCheckBox checkBox = new PokemonCheckBox(pokemon);
            checkBox.addActionListener(e -> {
                if (checkBox.isSelected()) {
                    lendariosSelecionados++;
                    escolhidos.add(pokemon);
                }
                else {
                    lendariosSelecionados--;
                    escolhidos.remove(pokemon);
                }
                update();
            });
            botoesLendarios.add(checkBox);
            add(checkBox);
        }

        explicacao = new JLabel("Escolha um pokémon inicial e três lendários");
        add(explicacao);
        confirmador = new JButton("Confirmar");
        confirmador.addActionListener(e -> {
            // TODO sair
        });
        confirmador.setEnabled(false);
        add(confirmador);
    }

    public void update() {
        for (PokemonCheckBox checkBox : botoesIniciais) {
            if (!checkBox.isSelected() && inicaisSelecionados >= 1) {
                checkBox.setEnabled(false);
            } else if (!checkBox.isEnabled() && inicaisSelecionados < 1) {
                checkBox.setEnabled(true);
            }
        }
        for (PokemonCheckBox checkBox : botoesLendarios) {
            if (!checkBox.isSelected() && lendariosSelecionados >= 3) {
                checkBox.setEnabled(false);
            } else if (!checkBox.isEnabled() && lendariosSelecionados < 3) {
                checkBox.setEnabled(true);
            }
        }
        confirmador.setEnabled(inicaisSelecionados == 1 && lendariosSelecionados == 3);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (PokemonCheckBox checkBox : botoesIniciais) {
            if (e.getSource() == checkBox.getCheckBox()) {
                inicaisSelecionados += (checkBox.isSelected() ? 1 : -1);
                update();
                return;
            }
        }
        for (PokemonCheckBox checkBox : botoesLendarios) {
            if (e.getSource() == checkBox.getCheckBox()) {
                lendariosSelecionados += (checkBox.isSelected() ? 1 : -1);
                update();
                return;
            }
        }
    }
}
