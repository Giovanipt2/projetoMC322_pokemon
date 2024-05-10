package pokemon;

import java.util.Map;
import java.util.HashMap;

/*
 * Classe que representa os itens que adicionam diretamente
 * nos status de um pokemon temporareamente (duração da batalha/
 * enquanto a vida do pokemon não chega em 0).
 * !NOTA IMPORTANTE: OS ITENS DE EV NAO RESETAM QUANDO O POKEMON MORRE!
*/
public class I_Combate extends ItemBatalha{
    private static final HashMap<String,Runnable> usos; //Hash map contendo todos os itens dessa classe

    // Criando o hash de forma stática, pois os itens serão os mesmos sempre..
    static {
        usos = new HashMap<>();
        startUsos();
    }

    // Inicializador dos usos
    private static void startUsos() {
        usos.put("HP Up", () -> usarHP_UP());
        usos.put("Protein", () -> usarProtein());
        usos.put("Iron", () -> usarIron());
        usos.put("Calcium", () -> usarCalcium());
        usos.put("Zinc", () -> usarZinc());
        usos.put("Carbs", () -> usarCarbs());
        // Quando resolvermos a questão dos X Attack e colegas de serviço, novos itens serão adicionados ou não
    }
    
    // Construtor
    public I_Combate(String nome) {
        super(nome);
    }

    // Definindo os usos
    @Override
    public void uso(Pokemon pokemon) {
        Runnable uso = usos.get(getNome());
        if (uso != null) {
            
        }
    }
}
