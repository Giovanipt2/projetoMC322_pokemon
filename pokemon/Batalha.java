package pokemon;

public class Batalha {
    private Treinador jogador1;
    private Treinador jogador2;
    private Menu menu;
    private Clima clima;

    /**
     * O último dano calculado. Salvo caso precise ser
     * alterado devido ao efeito de um item.
     */
    private int ultimoDano;
    /**
     * O último efeito aplicado em um Pokémon. Salvo caso
     * precise ser alterado devido ao efeito de um item.
     */
    private Efeito ultimoEfeito;

    /**
     * Os tipos de ação que um jogador pode fazer em um turno
     */
    public enum Acao {
        ATACAR, TROCAR, ITEM;
    }

    public Batalha(Treinador jogador1, Treinador jogador2, Menu menu) {
        if (jogador1 == null || jogador2 == null) {
            throw new IllegalArgumentException("Os jogadores não podem ser null.");
        }
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        clima = Clima.NORMAL;
        this.menu = menu;
    }

    /**
     * @return {@code true} se o jogador 1 vencer;
     * {@code false} se o jogador 2 vencer.
     */
    public boolean iniciar() {
        

        return true;
    }

    private void iniciarTurno() {
        // Ataques escolhidos
        Ataque ataque1 = null, ataque2 = null;
        // Itens usados
        ItemBatalha item1 = null, item2 = null;
        // Pokémons substitutos
        Pokemon pokemon1 = null, pokemon2 = null;


        //Escolhe a ação do jogador 1
        Acao acao1;
        while (true) {
            acao1 = menu.escolherAcao(jogador1);
            switch (acao1) {
                case ATACAR:
                    ataque1 = menu.escolherAtaque(jogador1);
                    if (ataque1 == null) {
                        continue;
                    }
                    break;
                case TROCAR:
                    pokemon1 = menu.trocarPokemon(jogador1);
                    if (pokemon1 == null) {
                        continue;
                    }
                    break;
                case ITEM:
                    item1 = menu.escolherItem(jogador1);
                    if (item1 == null) {
                        continue;
                    }
                    break;
            }
            break;
        }

        // Escolhe a ação do jogador 2
        Acao acao2;
        while (true) {
            acao2 = menu.escolherAcao(jogador2);
            switch (acao2) {
                case ATACAR:
                    ataque2 = menu.escolherAtaque(jogador2);
                    if (ataque2 == null) {
                        continue;
                    }
                    break;
                case TROCAR:
                    pokemon2 = menu.trocarPokemon(jogador2);
                    if (pokemon2 == null) {
                        continue;
                    }
                    break;
                case ITEM:
                    item2 = menu.escolherItem(jogador2);
                    if (item2 == null) {
                        continue;
                    }
                    break;
            }
            break;
        }

        boolean segundoVaiAntes = segundoVaiAntes(ataque1, ataque2);

        // Realiza a ação do jogador 2, caso ela tenha prioridade
        if (segundoVaiAntes) {
            switch (acao2) {
                case ITEM:
                    item2.uso(jogador2.getPokemonAtivo());
                    break;
                case ATACAR:
                    atacar(ataque2, jogador2.getPokemonAtivo(), jogador1.getPokemonAtivo());
                    break;
                case TROCAR:
                    trocarPokemon(jogador2, pokemon2);
            }
        }

        // Realiza a ação do jogador 1
        switch (acao1) {
            case ITEM:
                item1.uso(jogador1.getPokemonAtivo());
                break;
            case ATACAR:
                atacar(ataque1, jogador1.getPokemonAtivo(), jogador2.getPokemonAtivo());
                break;
            case TROCAR:
                trocarPokemon(jogador1, pokemon1);
        }

        // Realiza a ação do jogador 2, caso ela ainda não tenha acontecido
        if (!segundoVaiAntes) {
            switch (acao2) {
                case ITEM:
                    item2.uso(jogador2.getPokemonAtivo());
                    break;
                case ATACAR:
                    atacar(ataque2, jogador2.getPokemonAtivo(), jogador1.getPokemonAtivo());
                    break;
                case TROCAR:
                    trocarPokemon(jogador2, pokemon2);
            }
        }
    }

    /**
     * @return {@code true} se o jogador 2 tem prioridade
     */
    private boolean segundoVaiAntes(Ataque ataque1, Ataque ataque2) {
        if (ataque1 == null) {
            return false;
        }
        if (ataque2 == null) {
            return true;
        }

        int difPrioridade = ataque1.getPrioridade() - ataque2.getPrioridade();
        if (difPrioridade != 0) {
            return difPrioridade < 0;
        }
        return (jogador1.getPokemonAtivo().getStat(Stat.SPEED)
                - jogador2.getPokemonAtivo().getStat(Stat.SPEED)) < 0;
    }

    private void atacar(Ataque ataque, Pokemon usuario, Pokemon alvo) {
        ultimoDano = ataque.dano(usuario, alvo, clima);
        ultimoEfeito = ataque.efeito();

        // Efeitos de held items virão aqui

        alvo.somaHP_atual(ultimoDano);
        if (alvo.getEfeito() == null) {
            alvo.setEfeito(ultimoEfeito);
        }
    }

    private void trocarPokemon(Treinador treinador, Pokemon pokemon) {
        treinador.setPokemonAtivo(pokemon);
    }
}

