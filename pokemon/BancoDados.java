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
        }
    }
}