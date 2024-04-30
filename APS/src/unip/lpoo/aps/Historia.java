package unip.lpoo.aps;

// Esse classe é única e exclusivamente para printar cada parte da historia
public class Historia {

    public static void printarIntro(){
        LogicaDoGame.limpaConsole();
        LogicaDoGame.separarPrint(30);
        System.out.println("Historia");
        LogicaDoGame.separarPrint(30);
        System.out.println("Intro da historia !!!");
        System.out.println("Placeholder da Historia!!!!");
        System.out.println("Placeholder da Historia!!!!!!!");
        LogicaDoGame.aguardarUsuario();
    }

    // Print do primeiro ato da historia
    public static void printarPrimeiroAtoInicio(){
        LogicaDoGame.limpaConsole();
        LogicaDoGame.separarPrint(30);
        System.out.println("Ato 1 - Introdução");
        LogicaDoGame.separarPrint(30);
        System.out.println("Placeholder do Ato 1 !!!");
        System.out.println("Placeholder da Historia!!!!");
        System.out.println("Placeholder da Historia!!!!!");
        LogicaDoGame.aguardarUsuario();
    }

    public static void printarPrimeiroAtoFinal(){
        LogicaDoGame.limpaConsole();
        LogicaDoGame.separarPrint(30);
        System.out.println("Ato 1 - Final da Introdução");
        LogicaDoGame.separarPrint(30);
        System.out.println("Placeholder do Ato 1 !!!");
        System.out.println("Placeholder da Historia!!!!");
        System.out.println("Placeholder da Historia!!!!!");
        LogicaDoGame.aguardarUsuario();
    }

    // print do segundo ato da historia
    public static void printarSegundoAtoInicio(){
        LogicaDoGame.limpaConsole();
        LogicaDoGame.separarPrint(30);
        System.out.println("Ato 2 - Inicio do segundo Ato");
        LogicaDoGame.separarPrint(30);
        System.out.println("Placeholder do Ato 2 !!!");
        System.out.println("Placeholder da Historia!!!!");
        System.out.println("Placeholder da Historia!!!!!");
        LogicaDoGame.aguardarUsuario();
    }

    public static void printarSegundoAtoFinal(){
        LogicaDoGame.limpaConsole();
        LogicaDoGame.separarPrint(30);
        System.out.println("Ato 2 - Final do segundo Ato");
        LogicaDoGame.separarPrint(30);
        System.out.println("Placeholder do final do Ato 2 !!!");
        System.out.println("Placeholder da Historia!!!!");
        System.out.println("Placeholder da Historia!!!!!");
        LogicaDoGame.aguardarUsuario();
    }

    // Printar Ato Final da Historia, ou Ato 3 se preferir
    public static void printarTerceiroAtoInicio(){
        LogicaDoGame.limpaConsole();
        LogicaDoGame.separarPrint(30);
        System.out.println("Ato 3 - Inicio do terceiro Ato");
        LogicaDoGame.separarPrint(30);
        System.out.println("Placeholder do Inicio do Ato 3 !!!");
        System.out.println("Placeholder da Historia!!!!");
        System.out.println("Placeholder da Historia!!!!!");
        LogicaDoGame.aguardarUsuario();
    }

    public static void printarTerceiroAtoFinal(){
        LogicaDoGame.limpaConsole();
        LogicaDoGame.separarPrint(30);
        System.out.println("Ato 3 - Final do terceiro Ato");
        LogicaDoGame.separarPrint(30);
        System.out.println("Placeholder do final do Ato 3 !!!");
        System.out.println("Placeholder da Historia!!!!");
        System.out.println("Placeholder da Historia!!!!!");
        LogicaDoGame.aguardarUsuario();
    }

    public static void printarQuartoAtoInicio(){
        LogicaDoGame.limpaConsole();
        LogicaDoGame.separarPrint(30);
        System.out.println("Ato 4 - Inicio do Quarto Ato");
        LogicaDoGame.separarPrint(30);
        System.out.println("Placeholder do Inicio do Ato 4 !!!");
        System.out.println("Placeholder da Historia!!!!");
        System.out.println("Placeholder da Historia!!!!!");
        LogicaDoGame.aguardarUsuario();
    }

    public static void printarQuartoAtoFinal(){
        LogicaDoGame.limpaConsole();
        LogicaDoGame.separarPrint(30);
        System.out.println("Ato 4 - Final do quarto Ato");
        LogicaDoGame.separarPrint(30);
        System.out.println("Placeholder do final do Ato 4 !!!");
        System.out.println("Placeholder da Historia!!!!");
        System.out.println("Placeholder da Historia!!!!!");
        LogicaDoGame.aguardarUsuario();
    }

    /*
        Se for necessario colocar mais atos na historia, não tem problema, é so manter o "public static void" colocar o nome da classe nesse formato
        "printarQuintoAtoInicio" dessa forma fica facil de entender oq está sendo feito, e mantem o padrão original.

        E tbm é necessario tbm alterar a quantidade de atos dentro do if do LogicaDoGame continuarAventura(), para garantir que dentro do ato final
        não tenha encontros aleatorios, o ato final é da batalha final, não de inimigos aleatorios.
        Esse valor é um int, e só precisa colocar a quantidade de atos que o jogo tem.

        Na forma que está escrito o código hoje 30/04 12:48h, se for colocado um novo ato é necessario ir
        na classe LogicaDoGame e acrescentar, a logica para o novo ato, usando o final do ato anterior
        o level up do personagem, a nova localização e usar o inicio do novo ato, ou ato final.

        // Tambem é necessario ir na classe LogicaDoGame é alterar o if no método de "fugir" da batalha com o total de arcos, para não ser possivel fugir da batalha final.

     */

    public static void printarFinalDoGame(Jogador jogador){
        LogicaDoGame.limpaConsole();
        LogicaDoGame.separarPrint(30);
        System.out.println("Parabens, " + jogador.nome + "! Você derrotou ***!");
        LogicaDoGame.separarPrint(30);
        System.out.println("Esse jogo foi desenvolvido pelo grupo da APS, David, Marcelo, Airton, Parker e Carlinhos");
        System.out.println("Para a APS de Lógica de Programação Orientada a Objetos do Prof. Veras");
        System.out.println("Espero que você tenha gostado!");
    }
}
