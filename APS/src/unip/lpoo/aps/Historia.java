package unip.lpoo.aps;

// Esse classe é única e exclusivamente para printar cada parte da historia
public class Historia{

    public static void printarIntro(Jogador jogador){
        LogicaDoGame.limpaConsole();
        LogicaDoGame.separarPrint(30);
        System.out.println("Intro");
        LogicaDoGame.separarPrint(30);
        System.out.println("""
                Nossa história começa em Elisandria, um farol de prosperidade e harmonia entre a civilização e a natureza.
                Seus muros de pedra, adornados com trepadeiras floridas, cercavam casas aconchegantes e
                ruas movimentadas, onde mercadores trocavam seus produtos, crianças brincavam e artesãos criavam obras de
                rara beleza.
                Elisandria era a joia do reino, um exemplo de como humanos e natureza podem coexistir em perfeita sintonia.""");
        LogicaDoGame.aguardarUsuario();
        LogicaDoGame.espacoTexto(1);
        System.out.println("""
                Mas a sombra da ganância e do descuido logo se abateu sobre a cidade.
                Com a sucessão de Rei Eldred, obcecado por poder e riquezas, ignorou os avisos de seus
                conselheiros e do povo sobre os perigos da
                exploração desenfreada dos recursos naturais. Florestas ancestrais foram derrubadas, rios poluídos, e os campos
                férteis se tornaram áridos e erodidos.
                A fúria dos deuses da natureza não tardou a se manifestar. Tempestades violentas assolaram a região,
                colheitas falharam, e a fome se espalhou pelas ruas de Elisandria. O povo, desesperado e desiludido com a liderança do rei,
                começou a imitar seus maus hábitos, devastando o que restava da beleza natural em torno da cidade. A magia que assolava o
                local, não demoraria para se enegrecer.""");
        LogicaDoGame.aguardarUsuario();
        LogicaDoGame.espacoTexto(1);
        System.out.printf("""
                Quando então, em meio à uma tempestade mágica que assolava sua humilde casa, você, %s se viu à beira da morte.
                Raios flamejantes rasgavam os céus, enquanto a fúria da terra tremia sob seus pés.
                Uma inundação repentina brotou do chão, arrastando-o para um redemoinho de água e lama.
                Quando tudo parecia perdido, uma luz incandescente irrompeu da escuridão, envolvendo-o em sua radiância""", jogador.nome);
        LogicaDoGame.aguardarUsuario();
        LogicaDoGame.espacoTexto(1);
        System.out.println("""
                Ao abrir os olhos, você se vê em um lugar estranho e surreal.
                A tempestade mágica se dissipou, revelando um mundo em ruínas, marcado pela fúria dos elementos.
                Mas, em meio à devastação, uma voz poderosa ecoou em sua mente:
                                                "Você foi escolhido.\"""");
        LogicaDoGame.aguardarUsuario();
        LogicaDoGame.espacoTexto(2);
        System.out.println("""
                A voz era antiga e sábia, emanando de uma fonte invisível.
                Você se sentiu imbuído de uma nova força, um poder que pulsava em suas veias.
                Ele ergueu as mãos, e os elementos se curvaram à sua vontade.""");
        LogicaDoGame.espacoTexto(1);
        System.out.println("""
                A terra tremeu sob seus pés, respondendo ao seu comando.
                Ele podia moldá-la com facilidade, criando montanhas e vales, abrindo fendas e erguendo muros de pedra.
                A água brotou de suas palmas, fluindo com a graça de um rio ou a fúria de uma cachoeira.
                Ele podia controlá-la em todas as suas formas, desde a brisa suave até o furacão devastador.
                O ar crepitava em torno dele, carregado com a energia elétrica dos raios.
                Ele podia conjurar tempestades e controlar o clima, trazendo chuva ou sol, paz ou destruição.
                O fogo dançava em suas mãos, quente e brilhante.
                Ele podia incendiar objetos com um mero pensamento ou criar labaredas flamejantes para defender-se ou iluminar seu caminho.""");
        LogicaDoGame.espacoTexto(1);
        System.out.println("Você havia sobrevivido ao acidente, mas não era mais o mesmo. Um ser imbuído de poder sobre a própria natureza.");
        LogicaDoGame.espacoTexto(1);
        System.out.println("""
                E então você soube, que era o único que poderia defender Elisandria do pior.
                                               Sua jornada começa agora.""");
        LogicaDoGame.aguardarUsuario();
    }

    // Print do primeiro ato da historia
    public static void printarPrimeiroAtoInicio(){
        LogicaDoGame.limpaConsole();
        LogicaDoGame.separarPrint(30);
        System.out.println("Ato 1 - O Chamado Selvagem");
        LogicaDoGame.separarPrint(30);
        System.out.println("Você abre os olhos novamente, se encontrando onde antes já foi o seu quarto. Aquilo definitivamente não era um sonho.");
        LogicaDoGame.aguardarUsuario();
        System.out.println("""
                Você olha para as suas mãos. Elas estavam brilhando em diversas cores! Você sentiu a terra tremer levemente ao dar o seu primeiro passo.
                A água das poças parecia ser puxada como magnetismo diretamente para as suas mãos.""");
        LogicaDoGame.aguardarUsuario();
        System.out.println("""
                Há uma uma nova determinação em seu olhar ao observar o céu negro, coberto de nuvens que brilhavam um roxo mágico e maligno.
                A tempestade destruiria toda a cidade. Você sabia que não poderia deixar isso acontecer.
                Mas e quanto aos seus poderes? Como controlá-los? Como usá-los para proteger sua cidade e seu povo?""");
        LogicaDoGame.aguardarUsuario();
        System.out.println("De repente, a voz poderosa ecoa em sua mente:");
        LogicaDoGame.espacoTexto(1);
        System.out.println("\"Confie em seus instintos. Use seus poderes com sabedoria. O destino de Elisandria está em suas mãos.\"");
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
        System.out.println("""
        Esse jogo foi desenvolvido pelo grupo da APS, David, Marcelo, Airton, Parker e Carlinhos
        Para a APS de Lógica de Programação Orientada a Objetos do Prof. Veras
        Espero que você tenha gostado!""");
    }

}
