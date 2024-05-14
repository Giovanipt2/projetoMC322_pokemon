package pokemon;

public class Batalha {
    private Treinador jogador1;
    private Treinador jogador2;
    private Clima clima;
    private int ultimoDano;

    public Batalha(Treinador jogador1, Treinador jogador2) {
        if (jogador1 == null || jogador2 == null) {
            throw new IllegalArgumentException("Os jogadores não podem ser null");
        }
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        clima = Clima.NORMAL;
    }

    /**
     * @return {@code true} se o jogador 1 vencer;
     * {@code false} se o jogador 2 vencer.
     */
    public boolean iniciar() {
        

        return true;
    }

    private void iniciarTurno() {
        Ataque ataque1 = null, ataque2 = null;
        ItemBatalha item1 = null, item2 = null;
        Pokemon pokemon1 = null, pokemon2 = null;


        //Escolhe a acao do jogador 1
        Menu.Acao acao1;
        while (true) {
            acao1 = Menu.escolherAcao(jogador1);
            switch (acao1) {
                case Menu.ATACAR:
                    ataque1 = Menu.escolherAtaque(jogador1);
                    if (ataque1 == null) {
                        continue;
                    }
                    break;
                case Menu.TROCAR:
                    pokemon1 = Menu.trocarPokemon(jogador1);
                    if (pokemon1 == null) {
                        continue;
                    }
                    break;
                case Menu.ITEM:
                    item1 = Menu.escolherItem(jogador1);
                    if (pokemon1 == null) {
                        continue;
                    }
                    break;
            }
            break;
        }

        // Escolhe a acao do jogador 2
        Menu.Acao acao2;
        while (true) {
            acao = Menu.escolherAcao(jogador2);
            switch (acao) {
                case Menu.ATACAR:
                    ataque1 = Menu.escolherAtaque(jogador2);
                    if (ataque1 == null) {
                        continue;
                    }
                    break;
                case Menu.TROCAR:
                    pokemon1 = Menu.trocarPokemon(jogador2);
                    if (pokemon1 == null) {
                        continue;
                    }
                    break;
                case Menu.ITEM:
                    item1 = Menu.escolherItem(jogador2);
                    if (pokemon1 == null) {
                        continue;
                    }
                    break;
            }
            break;
        }

        int prioridade;
        if ((acao1 != Menu.ATACAR && acao2 != Menu.ATACAR) || acao1 == acao2) {
            if (jogador1.getPokemonAtivo().getStat(Stat.SPEED) >= jogador2.getPokemonAtivo().getStat(Stat.SPEED)) {
                prioridade = 1; // Jogador 1 vai primeiro
            }
            else {
                prioridade = 2; // Jogador 2 vai primeiro
            }
        }
        else if (acao1 = Menu.Acao.ATACAR) {
            prioridade = 2;  // Ataques ocorrem depois de itens e trocas
        }
        else {
            prioridade = 1; // Jogador 2 atacou
        }
    }
}
