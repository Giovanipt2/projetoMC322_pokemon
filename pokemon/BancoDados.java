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
            ataques.put("Draco Meteor", new AtaqueEspecial("Draco Meteor", Tipo.DRAGAO, 130, 5, 0, 90, null, 0));
            ataques.put("Fire Blast", new AtaqueEspecial("Fire Blast", Tipo.FOGO, 110, 5, 0, 85, Efeito.QUEIMADO, 10));
            ataques.put("Thunder", new AtaqueEspecial("Thunder", Tipo.ELETRICO, 110, 5, 0, 70, Efeito.PARALISADO, 30));
            ataques.put("Flash Cannon", new AtaqueEspecial("Flash Cannon", Tipo.METALICO, 80, 10, 0, 100, null, 0));
            ataques.put("Spacial Rend", new AtaqueEspecial("Spacial Rend", Tipo.DRAGAO, 100, 5, 0, 95, null, 0));
            ataques.put("Hydro Pump", new AtaqueEspecial("Hydro Pump", Tipo.AGUA, 110, 5, 0, 80, null, 0));
            ataques.put("Earth Power", new AtaqueEspecial("Earth Power", Tipo.TERRA, 90, 10, 0, 100, null, 0));
            ataques.put("Leaf Blade", new AtaqueFisico("Leaf Blade", Tipo.PLANTA, 90, 15, 0, 100, null, 0));
            ataques.put("Sacred Sword", new AtaqueFisico("Sacred Sword", Tipo.LUTADOR, 90, 15, 0, 100, null, 0));
            ataques.put("Knock Off", new AtaqueFisico("Knock Off", Tipo.SOMBRIO, 65, 20, 0, 100, null, 0));
            ataques.put("Smart Strike", new AtaqueFisico("Smart Strike", Tipo.METALICO, 70, 10, 0, 100, null, 0));
            ataques.put("Behemoth Blade", new AtaqueFisico("Behemoth Blade", Tipo.METALICO, 100, 5, 0, 100, null, 0));
            ataques.put("Play Rough", new AtaqueFisico("Play Rough", Tipo.FADA, 90, 10, 0, 100, null, 0));
            ataques.put("Wild Charge", new AtaqueFisico("Wild Charge", Tipo.ELETRICO, 90, 15, 0, 100, null, 0));
            ataques.put("Close Combat", new AtaqueFisico("Close Combat", Tipo.LUTADOR, 120, 5, 0, 100, null, 0));
            ataques.put("Psystrike", new AtaqueEspecial("Psystrike", Tipo.PSIQUICO, 100, 10, 0, 100, null, 0));
            ataques.put("Shadow Ball", new AtaqueEspecial("Shadow Ball", Tipo.FANTASMA, 80, 15, 0, 100, null, 0));
            ataques.put("Ice Beam", new AtaqueEspecial("Ice Beam", Tipo.GELO, 90, 10, 0, 100, Efeito.CONGELADO, 10));
            ataques.put("Aura Sphere", new AtaqueEspecial("Aura Sphere", Tipo.LUTADOR, 80, 20, 0, 100, null, 0));
            ataques.put("Origin Pulse", new AtaqueEspecial("Origin Pulse", Tipo.AGUA, 110, 10, 0, 85, null, 0));
            ataques.put("Water Spout", new AtaqueEspecial("Water Spout", Tipo.AGUA, 150, 5, 0, 100, null, 0));
            ataques.put("Precipice Blades", new AtaqueFisico("Precipice Blades", Tipo.TERRA, 120, 10, 0, 85, null, 0));
            ataques.put("Stone Edge", new AtaqueFisico("Stone Edge", Tipo.PEDRA, 100, 5, 0, 80, null, 0));
            ataques.put("Earthquake", new AtaqueFisico("Earthquake", Tipo.TERRA, 100, 10, 0, 100, null, 0));
            ataques.put("Toxic", new AtaqueEfeito("Toxic", Tipo.VENENOSO, 0, 10, 0, 90, Efeito.ENVENENADO, 90));
            ataques.put("Flamethrower", new AtaqueEspecial("Flamethrower", Tipo.FOGO, 90, 15, 0, 90, Efeito.QUEIMADO, 10));
            ataques.put("Blizzard", new AtaqueEspecial("Blizzard", Tipo.GELO, 110, 5, 0, 70, Efeito.CONGELADO, 10));
            ataques.put("Psychic", new AtaqueEspecial("Psychic", Tipo.PSIQUICO, 90, 10, 0, 100, null, 0));
            ataques.put("Hypnosis", new AtaqueEfeito("Hypnosis", Tipo.PSIQUICO, 0, 20, 0, 60, Efeito.DORMINDO, 60));
            ataques.put("Dark Pulse", new AtaqueEspecial("Dark Pulse", Tipo.SOMBRIO, 80, 15, 0, 100, null, 0));
            ataques.put("Sludge Bomb", new AtaqueEspecial("Sludge Bomb", Tipo.VENENOSO, 90, 10, 0, 100, Efeito.ENVENENADO, 30));
            ataques.put("Hyper Beam", new AtaqueEspecial("Hyper Beam", Tipo.NORMAL, 150, 5, 0, 90, null, 0));
            ataques.put("Aeroblast", new AtaqueEspecial("Aeroblast", Tipo.VOADOR, 100, 5, 0, 95, null, 0));
            ataques.put("Blue Flare", new AtaqueEspecial("Blue Flare", Tipo.FOGO, 130, 5, 0, 85, Efeito.QUEIMADO, 20));
            ataques.put("Extreme Speed", new AtaqueFisico("Extreme Speed", Tipo.NORMAL, 80, 5, 2, 100, null, 0));
            ataques.put("Drill Peck", new AtaqueFisico("Drill Peck", Tipo.VOADOR, 80, 20, 0, 100, null, 0));
            ataques.put("Outrage", new AtaqueFisico("Outrage", Tipo.DRAGAO, 120, 10, 0, 100, null, 0));
            ataques.put("Bolt Strike", new AtaqueFisico("Bolt Strike", Tipo.ELETRICO, 130, 5, 0, 85, Efeito.PARALISADO, 20));
            ataques.put("Moonblast", new AtaqueEspecial("Moonblast", Tipo.FADA, 95, 15, 0, 100, null, 0));
            ataques.put("Focus Blast", new AtaqueEspecial("Focus Blast", Tipo.LUTADOR, 120, 5, 0, 70, null, 0));
            ataques.put("Surf", new AtaqueEspecial("Surf", Tipo.AGUA, 90, 15, 0, 100, null, 0));
            ataques.put("Oblivion Wing", new AtaqueEspecial("Oblivion Wing", Tipo.VOADOR, 80, 10, 0, 100, null, 0));
            ataques.put("U-turn", new AtaqueFisico("U-turn", Tipo.INSETO, 70, 20, 0, 100, null, 0));
            ataques.put("Sacred Fire", new AtaqueFisico("Sacred Fire", Tipo.FOGO, 100, 5, 0, 90, Efeito.QUEIMADO, 50));
            ataques.put("Brave Bird", new AtaqueFisico("Brave Bird", Tipo.VOADOR, 120, 15, 0, 100, null, 0));
            ataques.put("Gunk Shot", new AtaqueFisico("Gunk Shot", Tipo.VENENOSO, 120, 5, 0, 80, Efeito.ENVENENADO, 30));
            ataques.put("Fire Punch", new AtaqueFisico("Fire Punch", Tipo.FOGO, 75, 15, 0, 100, Efeito.QUEIMADO, 10));
            ataques.put("Hyperspace Fury", new AtaqueFisico("Hyperspace Fury",Tipo.SOMBRIO, 100, 5, 0, 100, null, 0));
            ataques.put("Psychic Fangs", new AtaqueFisico("Psychic Fangs", Tipo.PSIQUICO, 85, 10, 0, 100, null, 0));
            ataques.put("High Horsepower", new AtaqueFisico("High Horsepower", Tipo.TERRA, 95, 10, 0, 95, null, 0));
            ataques.put("Glacial Lance", new AtaqueFisico("Glacial Lance", Tipo.GELO, 130, 5, 0, 100, null, 0));
            ataques.put("Psyshock", new AtaqueEspecial("Psyshock", Tipo.PSIQUICO, 80, 10, 0, 100, null, 0));
            ataques.put("Astral Barrage", new AtaqueEspecial("Astral Barrage", Tipo.FANTASMA, 120, 5, 0, 100, null, 0));


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

            ataquesPokemon.add(ataques.get("Draco Meteor"));
            ataquesPokemon.add(ataques.get("Fire Blast"));
            ataquesPokemon.add(ataques.get("Thunder"));
            ataquesPokemon.add(ataques.get("Flash Cannon"));

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

            ataquesPokemon.add(ataques.get("Spacial Rend"));
            ataquesPokemon.add(ataques.get("Hydro Pump"));
            ataquesPokemon.add(ataques.get("Fire Blast"));
            ataquesPokemon.add(ataques.get("Earth Power"));

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

            ataquesPokemon.add(ataques.get("Leaf Blade"));
            ataquesPokemon.add(ataques.get("Sacred Sword"));
            ataquesPokemon.add(ataques.get("Smart Strike"));
            ataquesPokemon.add(ataques.get("Knock Off"));

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

            ataquesPokemon.add(ataques.get("Behemoth Blade"));
            ataquesPokemon.add(ataques.get("Wild Charge"));
            ataquesPokemon.add(ataques.get("Close Combat"));
            ataquesPokemon.add(ataques.get("Play Rough"));

            pokemons.put("Zacian", new Pokemon("Zacian", tiposPokemon, 100, statsBasePokemon, ataquesPokemon));


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

            ataquesPokemon.add(ataques.get("Psystrike"));
            ataquesPokemon.add(ataques.get("Shadow Ball"));
            ataquesPokemon.add(ataques.get("Aura Sphere"));
            ataquesPokemon.add(ataques.get("Ice Beam"));

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

            ataquesPokemon.add(ataques.get("Ice Beam"));
            ataquesPokemon.add(ataques.get("Thunder"));
            ataquesPokemon.add(ataques.get("Origin Pulse"));
            ataquesPokemon.add(ataques.get("Water Spout"));

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

            ataquesPokemon.add(ataques.get("Precipice Blades"));
            ataquesPokemon.add(ataques.get("Stone Edge"));
            ataquesPokemon.add(ataques.get("Toxic"));
            ataquesPokemon.add(ataques.get("Earthquake"));

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

            ataquesPokemon.add(ataques.get("Flamethrower"));
            ataquesPokemon.add(ataques.get("Shadow Ball"));
            ataquesPokemon.add(ataques.get("Blizzard"));
            ataquesPokemon.add(ataques.get("Psychic"));

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

            ataquesPokemon.add(ataques.get("Hypnosis"));
            ataquesPokemon.add(ataques.get("Sludge bomb"));
            ataquesPokemon.add(ataques.get("Dark Pulse"));
            ataquesPokemon.add(ataques.get("Psychic"));

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

            ataquesPokemon.add(ataques.get("Blue Flare"));
            ataquesPokemon.add(ataques.get("Draco Meteor"));
            ataquesPokemon.add(ataques.get("Hyper Beam"));
            ataquesPokemon.add(ataques.get("Aeroblast"));

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

            ataquesPokemon.add(ataques.get("Bolt Strike"));
            ataquesPokemon.add(ataques.get("Outrage"));
            ataquesPokemon.add(ataques.get("Extreme Speed"));
            ataquesPokemon.add(ataques.get("Drill Peck"));

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

            ataquesPokemon.add(ataques.get("Moonblast"));
            ataquesPokemon.add(ataques.get("Focus Blast"));
            ataquesPokemon.add(ataques.get("Surf"));
            ataquesPokemon.add(ataques.get("Thunder"));

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

            ataquesPokemon.add(ataques.get("Dark Pulse"));
            ataquesPokemon.add(ataques.get("Oblivion Wing"));
            ataquesPokemon.add(ataques.get("U-turn"));
            ataquesPokemon.add(ataques.get("Earth Power"));

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

            ataquesPokemon.add(ataques.get("Sacred Fire"));
            ataquesPokemon.add(ataques.get("Brave Bird"));
            ataquesPokemon.add(ataques.get("Toxic"));
            ataquesPokemon.add(ataques.get("Earthquake"));

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

            ataquesPokemon.add(ataques.get("Gunk Shot"));
            ataquesPokemon.add(ataques.get("Fire Punch"));
            ataquesPokemon.add(ataques.get("Hyperspace Fury"));
            ataquesPokemon.add(ataques.get("Psychic Fangs"));

            pokemons.put("Hoopa", new Pokemon("Hoopa", tiposPokemon, 100, statsBasePokemon, ataquesPokemon));


            //Criando o Calyrex-Ice
            tiposPokemon.clear();
            statsBasePokemon.clear();
            ataquesPokemon.clear();

            tiposPokemon.add(Tipo.PSIQUICO);
            tiposPokemon.add(Tipo.GELO);

            statsBasePokemon.put(Stat.HP, 100);
            statsBasePokemon.put(Stat.ATK, 165);
            statsBasePokemon.put(Stat.DEF, 150);
            statsBasePokemon.put(Stat.ATK_SP, 85);
            statsBasePokemon.put(Stat.DEF_SP, 130);
            statsBasePokemon.put(Stat.SPEED, 50);

            ataquesPokemon.add(ataques.get("Glacial Lance"));
            ataquesPokemon.add(ataques.get("Psychic Fangs"));
            ataquesPokemon.add(ataques.get("High Horsepower"));
            ataquesPokemon.add(ataques.get("Close Combat"));

            pokemons.put("Calyrex-Ice", new Pokemon("Calyrex-Ice", tiposPokemon, 100, statsBasePokemon, ataquesPokemon));


            //Criando o Calyrex-Shadow
            tiposPokemon.clear();
            statsBasePokemon.clear();
            ataquesPokemon.clear();

            tiposPokemon.add(Tipo.PSIQUICO);
            tiposPokemon.add(Tipo.FANTASMA);

            statsBasePokemon.put(Stat.HP, 100);
            statsBasePokemon.put(Stat.ATK, 165);
            statsBasePokemon.put(Stat.DEF, 150);
            statsBasePokemon.put(Stat.ATK_SP, 85);
            statsBasePokemon.put(Stat.DEF_SP, 130);
            statsBasePokemon.put(Stat.SPEED, 50);

            ataquesPokemon.add(ataques.get("Psyshock"));
            ataquesPokemon.add(ataques.get("Astral Barrage"));
            ataquesPokemon.add(ataques.get("Moonblast"));
            ataquesPokemon.add(ataques.get("Aura Sphere"));

            pokemons.put("Calyrex-Shadow", new Pokemon("Calyrex-Shadow", tiposPokemon, 100, statsBasePokemon, ataquesPokemon));
        }
    }
}