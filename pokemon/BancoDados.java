package pokemon;

import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class BancoDados {
    private static Map<String, Pokemon> pokemons;
    private static Map<String, Ataque> ataques;
    private static Map<String, ItemPokemon> itensPokemon;

    // Getters
    public static Map<String, Pokemon> getPokemons() {
        return pokemons;
    }

    public static Map<String, Ataque> getAtaques() {
        return ataques;
    }

    public static Map<String, ItemPokemon> getItensPokemon() {
        return itensPokemon;
    }

    /**
     * Retorna um novo Pokémon da espécie escolhida
     *
     * @param especie o nome da espécie do Pokémon,
     *                com a primeira letra maiúscula.
     * @return o novo Pokémon criado; {@code null} se a espécie
     * não estiver no banco de dados.
     */
    public Pokemon copiaPokemon(String especie) {
        if (pokemons.containsKey(especie)) {
            return new Pokemon(pokemons.get(especie), 50);
        }
        return null;
    }

    private static void inicializarItens(){
        //Criando 3 itens de exemplo
        itensPokemon = new HashMap<>();
        itensPokemon.put("HP Up", new ItemPokemon("HP Up"));
        itensPokemon.put("Protein", new ItemPokemon("Protein"));
        itensPokemon.put("Iron", new ItemPokemon("Iron"));
    }

    public static void inicializar() {
        if (itensPokemon == null) {
            inicializarItens();
        }
        if (ataques == null) {
            ataques = new HashMap<>();
            // Adicionando os ataques especiais
            ataques.put("draco meteor", new AtaqueEspecial(Tipo.DRAGAO, 130, 5, 8, 0, 90, null, 0));
            ataques.put("fire blast", new AtaqueEspecial(Tipo.FOGO, 110, 5, 8, 0, 85, Efeito.QUEIMADO, 10));
            ataques.put("thunder", new AtaqueEspecial(Tipo.ELETRICO, 110, 5, 8, 0, 70, Efeito.PARALISADO, 30));
            ataques.put("flash cannon", new AtaqueEspecial(Tipo.METALICO, 80, 10, 16, 0, 100, null, 0));
            ataques.put("spacial rend", new AtaqueEspecial(Tipo.DRAGAO, 100, 5, 8, 0, 95, null, 0));
            ataques.put("hydro pump", new AtaqueEspecial(Tipo.AGUA, 110, 5, 8, 0, 80, null, 0));
            ataques.put("earth power", new AtaqueEspecial(Tipo.TERRA, 90, 10, 16, 0, 100, null, 0));
            ataques.put("leaf blade", new AtaqueFisico(Tipo.PLANTA, 90, 15, 24, 0, 100, null, 0));
            ataques.put("sacred sword", new AtaqueFisico(Tipo.LUTADOR, 90, 15, 24, 0, 100, null, 0));
            ataques.put("knock off", new AtaqueFisico(Tipo.SOMBRIO, 65, 20, 32, 0, 100, null, 0));
            ataques.put("smart strike", new AtaqueFisico(Tipo.METALICO, 70, 10, 16, 0, 100, null, 0));
            ataques.put("behemoth blade", new AtaqueFisico(Tipo.METALICO, 100, 5, 8, 0, 100, null, 0));
            ataques.put("play rough", new AtaqueFisico(Tipo.FADA, 90, 10, 16, 0, 100, null, 0));
            ataques.put("wild charge", new AtaqueFisico(Tipo.ELETRICO, 90, 15, 24, 0, 100, null, 0));
            ataques.put("close combat", new AtaqueFisico(Tipo.LUTADOR, 120, 5, 8, 0, 100, null, 0));
            ataques.put("psystrike", new AtaqueEspecial(Tipo.PSIQUICO, 100, 10, 16, 0, 100, null, 0));
            ataques.put("shadow ball", new AtaqueEspecial(Tipo.FANTASMA, 80, 15, 24, 0, 100, null, 0));
            ataques.put("ice beam", new AtaqueEspecial(Tipo.GELO, 90, 10, 16, 0, 100, Efeito.CONGELADO, 10));
            ataques.put("aura sphere", new AtaqueEspecial(Tipo.LUTADOR, 80, 20, 32, 0, 100, null, 0));
            ataques.put("origin pulse", new AtaqueEspecial(Tipo.AGUA, 110, 10, 16, 0, 85, null, 0));
            ataques.put("water spout", new AtaqueEspecial(Tipo.AGUA, 150, 5, 8, 0, 100, null, 0));
            ataques.put("precipice blades", new AtaqueFisico(Tipo.TERRA, 120, 10, 16, 0, 85, null, 0));
            ataques.put("stone edge", new AtaqueFisico(Tipo.PEDRA, 100, 5, 8, 0, 80, null, 0));
            ataques.put("earthquake", new AtaqueFisico(Tipo.TERRA, 100, 10, 16, 0, 100, null, 0));
            ataques.put("toxic", new AtaqueEfeito(Tipo.VENENOSO, 0, 10, 16, 0, 90, Efeito.ENVENENADO, 90));
            ataques.put("flamethrower", new AtaqueEspecial(Tipo.FOGO, 90, 15, 24, 0, 90, Efeito.QUEIMADO, 10));
            ataques.put("blizzard", new AtaqueEspecial(Tipo.GELO, 110, 5, 8, 0, 70, Efeito.CONGELADO, 10));
            ataques.put("psychic", new AtaqueEspecial(Tipo.PSIQUICO, 90, 10, 16, 0, 100, null, 0));
            ataques.put("hypnosis", new AtaqueEfeito(Tipo.PSIQUICO, 0, 20, 32, 0, 60, Efeito.DORMINDO, 60));
            ataques.put("dark pulse", new AtaqueEspecial(Tipo.SOMBRIO, 80, 15, 24, 0, 100, null, 0));
            ataques.put("sludge bomb", new AtaqueEspecial(Tipo.VENENOSO, 90, 10, 16, 0, 100, Efeito.ENVENENADO, 30));
            ataques.put("hyper beam", new AtaqueEspecial(Tipo.NORMAL, 150, 5, 8, 0, 90, null, 0));
            ataques.put("aeroblast", new AtaqueEspecial(Tipo.VOADOR, 100, 5, 8, 0, 95, null, 0));
            ataques.put("blue flare", new AtaqueEspecial(Tipo.FOGO, 130, 5, 8, 0, 85, Efeito.QUEIMADO, 20));
            ataques.put("extreme speed", new AtaqueFisico(Tipo.NORMAL, 80, 5, 8, 2, 100, null, 0));
            ataques.put("drill peck", new AtaqueFisico(Tipo.VOADOR, 80, 20, 32, 0, 100, null, 0));
            ataques.put("outrage", new AtaqueFisico(Tipo.DRAGAO, 120, 10, 16, 0, 100, null, 0));
            ataques.put("bolt strike", new AtaqueFisico(Tipo.ELETRICO, 130, 5, 8, 0, 85, Efeito.PARALISADO, 20));
            ataques.put("moonblast", new AtaqueEspecial(Tipo.FADA, 95, 15, 24, 0, 100, null, 0));
            ataques.put("focus blast", new AtaqueEspecial(Tipo.LUTADOR, 120, 5, 8, 0, 70, null, 0));
            ataques.put("surf", new AtaqueEspecial(Tipo.AGUA, 90, 15, 24, 0, 100, null, 0));
            ataques.put("oblivion wing", new AtaqueEspecial(Tipo.VOADOR, 80, 10, 16, 0, 100, null, 0));
            ataques.put("u-turn", new AtaqueFisico(Tipo.INSETO, 70, 20, 32, 0, 100, null, 0));
            ataques.put("sacred fire", new AtaqueFisico(Tipo.FOGO, 100, 5, 8, 0, 90, Efeito.QUEIMADO, 50));
            ataques.put("brave bird", new AtaqueFisico(Tipo.VOADOR, 120, 15, 24, 0, 100, null, 0));
            ataques.put("gunk shot", new AtaqueFisico(Tipo.VENENOSO, 120, 5, 8, 0, 80, Efeito.ENVENENADO, 30));
            ataques.put("fire punch", new AtaqueFisico(Tipo.FOGO, 75, 15, 24, 0, 100, Efeito.QUEIMADO, 10));
            ataques.put("hyperspace fury", new AtaqueFisico(Tipo.SOMBRIO, 100, 5, 8, 0, 100, null, 0));
            ataques.put("psychic fangs", new AtaqueFisico(Tipo.PSIQUICO, 85, 10, 16, 0, 100, null, 0));
            
        }

        if (pokemons == null) {
            pokemons = new HashMap<>();
            //Array com os tipos do pokémon que está sendo criado
            List<Tipo> tiposPokemon = new ArrayList<>();
            //HashMap com os status base do pokémon que está senco criado
            Map<Stat, Integer> statsBasePokemon = new HashMap<>();
            //Array com os ataques do pokémon que está sendo criado
            ArrayList<Ataque> ataquesPokemon = new ArrayList<>();


            // Criando o Dialga
            tiposPokemon.add(Tipo.METALICO);
            tiposPokemon.add(Tipo.DRAGAO);

            statsBasePokemon.put(Stat.HP, 100);
            statsBasePokemon.put(Stat.ATK, 120);
            statsBasePokemon.put(Stat.DEF, 120);
            statsBasePokemon.put(Stat.ATK_SP, 150);
            statsBasePokemon.put(Stat.DEF_SP, 100);
            statsBasePokemon.put(Stat.SPEED, 90);

            ataquesPokemon.add(ataques.get("draco meteor"));
            ataquesPokemon.add(ataques.get("fire blast"));
            ataquesPokemon.add(ataques.get("thunder"));
            ataquesPokemon.add(ataques.get("flash cannon"));

            pokemons.put("Dialga", new Pokemon("Dialga", tiposPokemon, 100, statsBasePokemon, ataquesPokemon));

            
            // Criando o Palkia
            tiposPokemon.clear();
            statsBasePokemon.clear();
            ataquesPokemon.clear();

            tiposPokemon.add(Tipo.AGUA);
            tiposPokemon.add(Tipo.DRAGAO);

            statsBasePokemon.put(Stat.HP, 90);
            statsBasePokemon.put(Stat.ATK, 120);
            statsBasePokemon.put(Stat.DEF, 100);
            statsBasePokemon.put(Stat.ATK_SP, 150);
            statsBasePokemon.put(Stat.DEF_SP, 120);
            statsBasePokemon.put(Stat.SPEED, 100);

            ataquesPokemon.add(ataques.get("spacial rend"));
            ataquesPokemon.add(ataques.get("hydro pump"));
            ataquesPokemon.add(ataques.get("fire blast"));
            ataquesPokemon.add(ataques.get("earth power"));

            pokemons.put("Palkia", new Pokemon("Palkia", tiposPokemon, 100, statsBasePokemon, ataquesPokemon));


            //Criando a Kartana
            tiposPokemon.clear();
            statsBasePokemon.clear();
            ataquesPokemon.clear();

            tiposPokemon.add(Tipo.PLANTA);
            tiposPokemon.add(Tipo.METALICO);

            statsBasePokemon.put(Stat.HP, 59);
            statsBasePokemon.put(Stat.ATK, 181);
            statsBasePokemon.put(Stat.DEF, 131);
            statsBasePokemon.put(Stat.ATK_SP, 59);
            statsBasePokemon.put(Stat.DEF_SP, 31);
            statsBasePokemon.put(Stat.SPEED, 109);

            ataquesPokemon.add(ataques.get("leaf blade"));
            ataquesPokemon.add(ataques.get("sacred sword"));
            ataquesPokemon.add(ataques.get("smart strike"));
            ataquesPokemon.add(ataques.get("knock off"));

            pokemons.put("Kartana", new Pokemon("Kartana", tiposPokemon, 100, statsBasePokemon, ataquesPokemon));


            //Criando a Zacian
            tiposPokemon.clear();
            statsBasePokemon.clear();
            ataquesPokemon.clear();

            tiposPokemon.add(Tipo.FADA);
            tiposPokemon.add(Tipo.METALICO);

            statsBasePokemon.put(Stat.HP, 92);
            statsBasePokemon.put(Stat.ATK, 170);
            statsBasePokemon.put(Stat.DEF, 115);
            statsBasePokemon.put(Stat.ATK_SP, 80);
            statsBasePokemon.put(Stat.DEF_SP, 115);
            statsBasePokemon.put(Stat.SPEED, 148);

            ataquesPokemon.add(ataques.get("behemoth blade"));
            ataquesPokemon.add(ataques.get("wild charge"));
            ataquesPokemon.add(ataques.get("close combat"));
            ataquesPokemon.add(ataques.get("play rough"));

            pokemons.put("Kartana", new Pokemon("Kartana", tiposPokemon, 100, statsBasePokemon, ataquesPokemon));


            //Criando o Mewtwo
            tiposPokemon.clear();
            statsBasePokemon.clear();
            ataquesPokemon.clear();

            tiposPokemon.add(Tipo.PSIQUICO);

            statsBasePokemon.put(Stat.HP, 106);
            statsBasePokemon.put(Stat.ATK, 110);
            statsBasePokemon.put(Stat.DEF, 90);
            statsBasePokemon.put(Stat.ATK_SP, 154);
            statsBasePokemon.put(Stat.DEF_SP, 90);
            statsBasePokemon.put(Stat.SPEED, 130);

            ataquesPokemon.add(ataques.get("psystrike"));
            ataquesPokemon.add(ataques.get("shadow ball"));
            ataquesPokemon.add(ataques.get("aura sphere"));
            ataquesPokemon.add(ataques.get("ice beam"));

            pokemons.put("Mewtwo", new Pokemon("Mewtwo", tiposPokemon, 100, statsBasePokemon, ataquesPokemon));


            //Criando o Kyogre
            tiposPokemon.clear();
            statsBasePokemon.clear();
            ataquesPokemon.clear();

            tiposPokemon.add(Tipo.AGUA);

            statsBasePokemon.put(Stat.HP, 100);
            statsBasePokemon.put(Stat.ATK, 100);
            statsBasePokemon.put(Stat.DEF, 90);
            statsBasePokemon.put(Stat.ATK_SP, 150);
            statsBasePokemon.put(Stat.DEF_SP, 140);
            statsBasePokemon.put(Stat.SPEED, 90);

            ataquesPokemon.add(ataques.get("ice beam"));
            ataquesPokemon.add(ataques.get("thunder"));
            ataquesPokemon.add(ataques.get("origin pulse"));
            ataquesPokemon.add(ataques.get("water spout"));

            pokemons.put("Kyogre", new Pokemon("Kyogre", tiposPokemon, 100, statsBasePokemon, ataquesPokemon));


            //Criando o Groudon
            tiposPokemon.clear();
            statsBasePokemon.clear();
            ataquesPokemon.clear();

            tiposPokemon.add(Tipo.TERRA);

            statsBasePokemon.put(Stat.HP, 100);
            statsBasePokemon.put(Stat.ATK, 150);
            statsBasePokemon.put(Stat.DEF, 140);
            statsBasePokemon.put(Stat.ATK_SP, 100);
            statsBasePokemon.put(Stat.DEF_SP, 90);
            statsBasePokemon.put(Stat.SPEED, 90);

            ataquesPokemon.add(ataques.get("precipice blades"));
            ataquesPokemon.add(ataques.get("stone edge"));
            ataquesPokemon.add(ataques.get("toxic"));
            ataquesPokemon.add(ataques.get("earthquake"));

            pokemons.put("Groudon", new Pokemon("Groudon", tiposPokemon, 100, statsBasePokemon, ataquesPokemon));
        
            
            //Criando o Blacephalon
            tiposPokemon.clear();
            statsBasePokemon.clear();
            ataquesPokemon.clear();

            tiposPokemon.add(Tipo.FOGO);
            tiposPokemon.add(Tipo.FANTASMA);

            statsBasePokemon.put(Stat.HP, 53);
            statsBasePokemon.put(Stat.ATK, 127);
            statsBasePokemon.put(Stat.DEF, 53);
            statsBasePokemon.put(Stat.ATK_SP, 151);
            statsBasePokemon.put(Stat.DEF_SP, 79);
            statsBasePokemon.put(Stat.SPEED, 107);

            ataquesPokemon.add(ataques.get("flamethrower"));
            ataquesPokemon.add(ataques.get("shadow ball"));
            ataquesPokemon.add(ataques.get("blizzard"));
            ataquesPokemon.add(ataques.get("psychic"));

            pokemons.put("Blacephalon", new Pokemon("Blacephalon", tiposPokemon, 100, statsBasePokemon, ataquesPokemon));


            //Criando o Darkrai
            tiposPokemon.clear();
            statsBasePokemon.clear();
            ataquesPokemon.clear();

            tiposPokemon.add(Tipo.SOMBRIO);

            statsBasePokemon.put(Stat.HP, 70);
            statsBasePokemon.put(Stat.ATK, 90);
            statsBasePokemon.put(Stat.DEF, 90);
            statsBasePokemon.put(Stat.ATK_SP, 135);
            statsBasePokemon.put(Stat.DEF_SP, 90);
            statsBasePokemon.put(Stat.SPEED, 125);

            ataquesPokemon.add(ataques.get("hypnosis"));
            ataquesPokemon.add(ataques.get("sludge bomb"));
            ataquesPokemon.add(ataques.get("dark pulse"));
            ataquesPokemon.add(ataques.get("psychic"));

            pokemons.put("Darkrai", new Pokemon("Darkrai", tiposPokemon, 100, statsBasePokemon, ataquesPokemon));


            //Criando o Reshiram
            tiposPokemon.clear();
            statsBasePokemon.clear();
            ataquesPokemon.clear();

            tiposPokemon.add(Tipo.DRAGAO);
            tiposPokemon.add(Tipo.FOGO);

            statsBasePokemon.put(Stat.HP, 100);
            statsBasePokemon.put(Stat.ATK, 120);
            statsBasePokemon.put(Stat.DEF, 100);
            statsBasePokemon.put(Stat.ATK_SP, 150);
            statsBasePokemon.put(Stat.DEF_SP, 120);
            statsBasePokemon.put(Stat.SPEED, 90);

            ataquesPokemon.add(ataques.get("blue flare"));
            ataquesPokemon.add(ataques.get("draco meteor"));
            ataquesPokemon.add(ataques.get("hyper beam"));
            ataquesPokemon.add(ataques.get("aeroblast"));

            pokemons.put("Reshiram", new Pokemon("Reshiram", tiposPokemon, 100, statsBasePokemon, ataquesPokemon));

            
            //Criando o Zekrom
            tiposPokemon.clear();
            statsBasePokemon.clear();
            ataquesPokemon.clear();

            tiposPokemon.add(Tipo.DRAGAO);
            tiposPokemon.add(Tipo.ELETRICO);

            statsBasePokemon.put(Stat.HP, 100);
            statsBasePokemon.put(Stat.ATK, 150);
            statsBasePokemon.put(Stat.DEF, 120);
            statsBasePokemon.put(Stat.ATK_SP, 120);
            statsBasePokemon.put(Stat.DEF_SP, 100);
            statsBasePokemon.put(Stat.SPEED, 90);

            ataquesPokemon.add(ataques.get("bolt strike"));
            ataquesPokemon.add(ataques.get("outrage"));
            ataquesPokemon.add(ataques.get("extreme speed"));
            ataquesPokemon.add(ataques.get("drill peck"));

            pokemons.put("Zekrom", new Pokemon("Zekrom", tiposPokemon, 100, statsBasePokemon, ataquesPokemon));


            //Criando o Xerneas
            tiposPokemon.clear();
            statsBasePokemon.clear();
            ataquesPokemon.clear();

            tiposPokemon.add(Tipo.FADA);

            statsBasePokemon.put(Stat.HP, 126);
            statsBasePokemon.put(Stat.ATK, 131);
            statsBasePokemon.put(Stat.DEF, 95);
            statsBasePokemon.put(Stat.ATK_SP, 131);
            statsBasePokemon.put(Stat.DEF_SP, 98);
            statsBasePokemon.put(Stat.SPEED, 99);

            ataquesPokemon.add(ataques.get("moonblast"));
            ataquesPokemon.add(ataques.get("focus blast"));
            ataquesPokemon.add(ataques.get("surf"));
            ataquesPokemon.add(ataques.get("thunder"));

            pokemons.put("Xerneas", new Pokemon("Xerneas", tiposPokemon, 100, statsBasePokemon, ataquesPokemon));
            

            //Criando o Yveltal
            tiposPokemon.clear();
            statsBasePokemon.clear();
            ataquesPokemon.clear();

            tiposPokemon.add(Tipo.SOMBRIO);
            tiposPokemon.add(Tipo.VOADOR);

            statsBasePokemon.put(Stat.HP, 126);
            statsBasePokemon.put(Stat.ATK, 131);
            statsBasePokemon.put(Stat.DEF, 95);
            statsBasePokemon.put(Stat.ATK_SP, 131);
            statsBasePokemon.put(Stat.DEF_SP, 98);
            statsBasePokemon.put(Stat.SPEED, 99);

            ataquesPokemon.add(ataques.get("dark pulse"));
            ataquesPokemon.add(ataques.get("oblivion wing"));
            ataquesPokemon.add(ataques.get("u-turn"));
            ataquesPokemon.add(ataques.get("earth power"));

            pokemons.put("Yveltal", new Pokemon("Yveltal", tiposPokemon, 100, statsBasePokemon, ataquesPokemon));


            //Criando o Ho-Oh
            tiposPokemon.clear();
            statsBasePokemon.clear();
            ataquesPokemon.clear();

            tiposPokemon.add(Tipo.FOGO);
            tiposPokemon.add(Tipo.VOADOR);

            statsBasePokemon.put(Stat.HP, 106);
            statsBasePokemon.put(Stat.ATK, 130);
            statsBasePokemon.put(Stat.DEF, 90);
            statsBasePokemon.put(Stat.ATK_SP, 110);
            statsBasePokemon.put(Stat.DEF_SP, 154);
            statsBasePokemon.put(Stat.SPEED, 90);

            ataquesPokemon.add(ataques.get("sacred fire"));
            ataquesPokemon.add(ataques.get("brave bird"));
            ataquesPokemon.add(ataques.get("toxic"));
            ataquesPokemon.add(ataques.get("earthquake"));

            pokemons.put("Ho-OH", new Pokemon("Ho-Oh", tiposPokemon, 100, statsBasePokemon, ataquesPokemon));


            //Criando o Hoopa
            tiposPokemon.clear();
            statsBasePokemon.clear();
            ataquesPokemon.clear();

            tiposPokemon.add(Tipo.SOMBRIO);
            tiposPokemon.add(Tipo.PSIQUICO);

            statsBasePokemon.put(Stat.HP, 80);
            statsBasePokemon.put(Stat.ATK, 160);
            statsBasePokemon.put(Stat.DEF, 60);
            statsBasePokemon.put(Stat.ATK_SP, 170);
            statsBasePokemon.put(Stat.DEF_SP, 130);
            statsBasePokemon.put(Stat.SPEED, 80);

            ataquesPokemon.add(ataques.get("gunk shot"));
            ataquesPokemon.add(ataques.get("fire punch"));
            ataquesPokemon.add(ataques.get("hyperspace fury"));
            ataquesPokemon.add(ataques.get("psychic fangs"));

            pokemons.put("Hoopa", new Pokemon("Hoopa", tiposPokemon, 100, statsBasePokemon, ataquesPokemon));
        }
    }
}