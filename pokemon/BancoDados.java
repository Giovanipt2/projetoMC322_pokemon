package pokemon;

import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class BancoDados {
    private static Map<String, Pokemon> pokemons;
    private static Map<String, Ataque> ataques;

    public void inicializar() {
        if (ataques == null) {
            ataques = new HashMap<>();
            // Adicionando os ataques especiais
            ataques.put("draco meteor", new AtaqueEspecial(Tipo.DRAGAO, 130, 5, 8, 0, 90, null, 0));
            ataques.put("fire blast", new AtaqueEspecial(Tipo.FOGO, 110, 5, 8, 0, 85, Efeito.QUEIMADO, 10));
            ataques.put("thunder", new AtaqueEspecial(Tipo.ELETRICO, 110, 5, 8, 0, 70, Efeito.PARALISADO, 30));
            ataques.put("flash cannon", new AtaqueEspecial(Tipo.METALICO, 80, 10, 16, 0, 100, null, 0));
            // Outros ataques...
        }

        if (pokemons == null) {
            pokemons = new HashMap<>();
            List<Tipo> tiposPokemon = new ArrayList<>();

            // Criando o Pokémon Dialga
            tiposPokemon.add(Tipo.METALICO);
            tiposPokemon.add(Tipo.DRAGAO);

            Map<Stat, Integer> statsBaseDialga = new HashMap<>();
            statsBaseDialga.put(Stat.HP, 100);
            statsBaseDialga.put(Stat.ATK, 120);
            statsBaseDialga.put(Stat.DEF, 120);
            statsBaseDialga.put(Stat.ATK_SP, 150);
            statsBaseDialga.put(Stat.DEF_SP, 100);
            statsBaseDialga.put(Stat.SPEED, 90);

            ArrayList<Ataque> ataquesDialga = new ArrayList<>();
            ataquesDialga.add(ataques.get("draco meteor"));
            ataquesDialga.add(ataques.get("fire blast"));
            ataquesDialga.add(ataques.get("thunder"));
            ataquesDialga.add(ataques.get("flash cannon"));

            pokemons.put("Dialga", new Pokemon("Dialga", tiposPokemon, 100, statsBaseDialga, ataquesDialga));

            
            // Criando o Pokémon Palkia
            tiposPokemon.clear();
            tiposPokemon.add(Tipo.AGUA);
            tiposPokemon.add(Tipo.DRAGAO);

            Map<Stat, Integer> statsBasePalkia = new HashMap<>();
            statsBasePalkia.put(Stat.HP, 90);
            statsBasePalkia.put(Stat.ATK, 120);
            statsBasePalkia.put(Stat.DEF, 100);
            statsBasePalkia.put(Stat.ATK_SP, 150);
            statsBasePalkia.put(Stat.DEF_SP, 120);
            statsBasePalkia.put(Stat.SPEED, 100);

            ArrayList<Ataque> ataquesPalkia = new ArrayList<>();
            ataquesPalkia.add(ataques.get("draco meteor"));
            ataquesPalkia.add(ataques.get("hydro pump"));
            ataquesPalkia.add(ataques.get("fire blast"));
            ataquesPalkia.add(ataques.get("earth power"));

            pokemons.put("Palkia", new Pokemon("Palkia", tiposPokemon, 90, statsBasePalkia, ataquesPalkia));
        }
    }
}
