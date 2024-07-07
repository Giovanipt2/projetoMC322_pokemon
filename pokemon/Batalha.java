package pokemon;

import pokemon.ataques.Ataque;
import pokemon.itens.Item;
import pokemon.itens.ItemBatalha;

public class Batalha {
    private Treinador jogador1;
    private Treinador jogador2;
    private Menu menu;
    private Clima clima;
    private Treinador jogadorAtivo;

    // Últimas escolhas de cada jogador
    private Acao acao1;
    private Acao acao2;
    private Ataque ataque1;
    private Ataque ataque2;
    private Pokemon pokemon1;
    private Pokemon pokemon2;
    private Item item1;
    private Item item2;

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

    /**
     * @return o jogador 1.
     */
    public Treinador getJogador1() {
        return jogador1;
    }

    /**
     * @return o jogador 2.
     */
    public Treinador getJogador2() {
        return jogador2;
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
     * @return o jogador ativo (escolhendo ou realizando uma ação)
     */
    public Treinador getJogadorAtivo() {
        return jogadorAtivo;    //TODO alterar na hora certa
    }

    /**
     * Inicia a batalha entre os dois treinadores.
     *
     * @return o treinador vencedor da batalha.
     */
    public Treinador iniciar() {
        System.out.println("-----------------------------------");
        System.out.println("A batalha entre " + jogador1.getNome() + " e " + jogador2.getNome() + " vai começar!");
        System.out.println("-----------------------------------");
        // Cada jogador escolhe um Pokémon inicial
        System.out.println(jogador1.getNome() + ", escolha seu Pokémon inicial:");
        jogador1.setPokemonAtivo(menu.escolherPokemonDaBatalha(jogador1));
        System.out.println(jogador2.getNome() + ", escolha seu Pokémon inicial:");
        jogador2.setPokemonAtivo(menu.escolherPokemonDaBatalha(jogador2));

        // A batalha continua até um dos treinadores ser derrotado
        while (!jogador1.treinadorDerrotado() && !jogador2.treinadorDerrotado()) {
            iniciarTurno();
        }

        return jogador1.treinadorDerrotado() ? jogador2 : jogador1;
    }

    public boolean acabou() {
        return jogador1.treinadorDerrotado() || jogador2.treinadorDerrotado();
    }

    public void setAtaqueEscolhido(Ataque ataque, int jogador) {
        if (jogador == 1) {
            acao1 = Acao.ATACAR;
            ataque1 = ataque;
        } else {
            acao2 = Acao.ATACAR;
            ataque2 = ataque;
        }
    }

    public void setPokemonEscolhido(Pokemon pokemon, int jogador) {
        if (jogador == 1) {
            acao1 = Acao.TROCAR;
            pokemon1 = pokemon;
        } else {
            acao2 = Acao.TROCAR;
            pokemon2 = pokemon;
        }
    }

    public void setItemEscolhido(Item item, int jogador) {
        if (jogador == 1) {
            acao1 = Acao.ITEM;
            item1 = item;
        } else {
            acao2 = Acao.ITEM;
            item2 = item;
        }
    }

    public String realizarAcao(Treinador jogador) {
        if (jogador == jogador1) {
            return switch (acao1) {
                case ATACAR -> atacar(ataque1, jogador1.getPokemonAtivo(), jogador2.getPokemonAtivo());
                case TROCAR -> {
                    String out = jogador1.getPokemonAtivo().getNome() + ", volte!\n" +
                            pokemon1.getNome() + ", avance!";
                    jogador1.setPokemonAtivo(pokemon1);
                    yield out;
                }
                case ITEM -> jogador1.getNome() + " usou " + item1.getNome();
                case null -> null;
            };
        } else {
            return switch (acao2) {
                case ATACAR -> atacar(ataque2, jogador2.getPokemonAtivo(), jogador1.getPokemonAtivo());
                case TROCAR -> {
                    String out = jogador2.getPokemonAtivo().getNome() + ", volte!\n" +
                            pokemon2.getNome() + ", avance!";
                    jogador2.setPokemonAtivo(pokemon2);
                    yield out;
                }
                case ITEM -> jogador2.getNome() + " usou " + item2.getNome();
                case null -> null;
            };
        }
    }

    /**
     * Inicia um turno de batalha.
     * O jogador 1 escolhe sua ação, e então o jogador 2 escolhe a sua.
     * As ações são realizadas de acordo com a prioridade dos ataques e a
     * velocidade dos Pokémon.
     */
    private void iniciarTurno() {
        // Ataques escolhidos
        Ataque ataque1 = null, ataque2 = null;
        // Itens usados
        ItemBatalha item1 = null, item2 = null;
        // Pokémons substitutos
        Pokemon pokemon1 = null, pokemon2 = null;


        //Escolhe a ação do jogador 1
        Acao acao1;
        System.out.println("-----------------------------------");
        System.out.println("Agora é a vez de " + jogador1.getNome() + "!");
        System.out.println("Seu Pokémon ativo é " + jogador1.getPokemonAtivo().getNome() + ".");
        System.out.println("-----------------------------------");
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
                    } else {
                        System.out.printf("Vai, %s!\n", pokemon1.getNome());
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

        System.out.println("-----------------------------------");
        System.out.println("Agora é a vez de " + jogador2.getNome() + "!");
        System.out.println("Seu Pokémon ativo é " + jogador2.getPokemonAtivo().getNome() + ".");
        System.out.println("-----------------------------------");
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
                    } else {
                        System.out.printf("Vai, %s!\n", pokemon2.getNome());
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
                    try {
                        item2.uso(jogador2.getPokemonAtivo());
                    } catch (ExcecaoUsoItem e) {
                        System.out.println(e.getMessage());
                    }
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
                try {
                    item1.uso(jogador1.getPokemonAtivo());
                } catch (ExcecaoUsoItem e) {
                    System.out.println(e.getMessage());
                }
                break;
            case ATACAR: {
                Pokemon pokemonAtivo = jogador1.getPokemonAtivo();
                // Só pode ter desmaiado se ambos atacaram e o jogador 2 foi mais rápido.
                if (pokemonAtivo.estaVivo()) {
                    atacar(ataque1, pokemonAtivo, jogador2.getPokemonAtivo());
                } else {
                    System.out.printf("%s desmaiou!\n", pokemonAtivo.getNome());
                    if (jogador1.treinadorDerrotado()) {
                        System.out.printf("%s foi derrotado!\n", jogador1.getNome());
                        return;
                    }
                    trocarPokemon(jogador1, menu.trocarPosDesmaio(jogador1));
                }
                break;
            }
            case TROCAR:
                trocarPokemon(jogador1, pokemon1);
        }

        // Realiza a ação do jogador 2, caso ela ainda não tenha acontecido
        if (!segundoVaiAntes) {
            switch (acao2) {
                case ITEM:
                    try {
                        item2.uso(jogador2.getPokemonAtivo());
                    } catch (ExcecaoUsoItem e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case ATACAR: {
                    Pokemon pokemonAtivo = jogador2.getPokemonAtivo();
                    if (pokemonAtivo.estaVivo()) {
                        atacar(ataque2, pokemonAtivo, jogador1.getPokemonAtivo());
                    } else {
                        System.out.printf("%s desmaiou!\n", pokemonAtivo.getNome());
                        if (jogador2.treinadorDerrotado()) {
                            System.out.printf("%s foi derrotado!\n", jogador2.getNome());
                            return;
                        }
                        trocarPokemon(jogador2, menu.trocarPosDesmaio(jogador2));
                    }
                    break;
                }
                case TROCAR:
                    trocarPokemon(jogador2, pokemon2);
            }
        }
    }

    /**
     * Verifica se o jogador 2 deve agir antes do jogador 1.
     *
     * @param ataque1 o ataque escolhido pelo jogador 1
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

    public boolean primeiroComeca() {
        if (acao2 != Acao.ATACAR) {
            return false;
        }
        if (acao1 != Acao.ATACAR) {
            return true;
        }

        int difPrioridade = ataque1.getPrioridade() - ataque2.getPrioridade();
        if (difPrioridade != 0) {
            return difPrioridade > 0;
        }
        return (jogador1.getPokemonAtivo().getStat(Stat.SPEED)
                - jogador2.getPokemonAtivo().getStat(Stat.SPEED)) > 0;
    }

    /**
     * Realiza um ataque.
     *
     * @param ataque  o ataque a ser realizado
     * @param usuario o Pokémon que está usando o ataque
     * @param alvo    o Pokémon que está sendo atacado
     */
    private String atacar(Ataque ataque, Pokemon usuario, Pokemon alvo) {
        String out = usuario.getNome() + " usou " + ataque.getNome() + ".\n";
        ataque.somaPp(-1);

        // Verifica se o ataque acontece e
        boolean ataqueAcertou = (Util.randInt(0, 101) < ataque.getPrecisao());
        boolean fezEfeito = ataqueAcertou && (Util.randInt(0, 101) < ataque.getProbEfeito());

        ultimoDano = ataqueAcertou ? ataque.dano(usuario, alvo, clima) : 0;
        ultimoEfeito = fezEfeito ? ataque.getEfeito() : null;

        // Efeitos de held items virão aqui

        // Dá o dano
        ultimoDano = Math.min(ultimoDano, alvo.getHP_atual());
        if (ultimoDano > 0) {
            out += alvo.getNome() + " tomou " + ultimoDano + " de dano!";
            alvo.somaHP_atual(-ultimoDano);
        } else {
            out += "O ataque não causou dano.";
        }
        return out;
    }

    /**
     * Troca o Pokémon ativo de um treinador.
     *
     * @param treinador o treinador que está trocando de Pokémon
     * @param pokemon   o novo Pokémon ativo
     */
    private void trocarPokemon(Treinador treinador, Pokemon pokemon) {
        System.out.printf("Vai, %s!\n", pokemon.getNome());
        treinador.setPokemonAtivo(pokemon);
    }
}

