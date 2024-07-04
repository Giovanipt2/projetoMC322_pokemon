package pokemon;

import pokemon.ataques.Ataque;
import pokemon.itens.ItemBatalha;

public class Batalha {
    private Treinador jogador1;
    private Treinador jogador2;
    private Menu menu;
    private Clima clima;
    private Treinador jogadorAtivo;

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

    /**
     * Realiza um ataque.
     *
     * @param ataque  o ataque a ser realizado
     * @param usuario o Pokémon que está usando o ataque
     * @param alvo    o Pokémon que está sendo atacado
     */
    private void atacar(Ataque ataque, Pokemon usuario, Pokemon alvo) {
        System.out.printf("%s usou %s\n", usuario.getNome(), ataque.getNome());
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
            System.out.printf("%s tomou %d de dano!\n", alvo.getNome(), ultimoDano);
            alvo.somaHP_atual(-ultimoDano);
        } else {
            System.out.println("O ataque não causou dano.");
        }

        if (alvo.estaVivo()) {
            System.out.printf("Seu HP caiu para %d.\n", alvo.getHP_atual());
            if (ultimoEfeito != null && alvo.getEfeito() == null) {
                alvo.setEfeito(ultimoEfeito);
                System.out.printf("%s está %s!\n", alvo.getNome(), ultimoEfeito);
            }
        }
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

