package unip.lpoo.aps;
import java.util.Scanner;
public class LogicaDoGame {
    static Scanner leitura = new Scanner(System.in);
    static Jogador jogador;

    public static boolean oJogoEstaRodando;

    // Encontros ou acontecimentos aleatorios
    public static String[] encontroAleatorio = {"Batalha", "Batalha", "Batalha", "Batalha", "Batalha"};

    // Nome dos Inimigos
    public static String[] inimigos = {"Empresario Safado", "Rato Leptospiroso", "Capivara Filó", "Dona Largatixa", "Xana Calanga"};

    // Elementos da Historia
    public static int numLocalizacao = 0, ato = 1;

    // Esse Array localizacao vai armazenar os locais em que a historia acontece
    public static String[] localizacao = {"Parques", "Ruas", "A gente decide depois"};

    // Método para o usuario fazer as entradas no Console
    public static int lerInt(String menu, int escolhaUsuario){
        int input;

        do{
            System.out.println(menu);
            try{
                input = Integer.parseInt(leitura.next());
            }catch(Exception e){
                input = -1;
                System.out.println("Por entre com um número!");
            }
        }while (input < 1 || input > escolhaUsuario);

        return input;
    }
    // Método para simular a limpeza do console
    public static void limpaConsole(){
        for (int i = 0; i < 100; i++){
            System.out.println();
        }
    }

    // Método para separar algo por n valores
    public static void separarPrint(int n){
        for (int i = 0; i < n; i++){
            System.out.print("-");
        }
        System.out.println();
    }

    // Método para mostrar o titulo
    public static void printarValor(String tituto){
        separarPrint(30);
        System.out.println(tituto);
        separarPrint(30);
    }

    // Método para o jogo aguardar o click do usuario para continuar
    public static void aguardarUsuario(){
        System.out.println("\n Pressione qualquer tecla para continuar...");
        leitura.next();
    }

    // Método para iniciar o jogo
    public static void IniciarGame(){
        boolean nameSet = false;
        String nome;
        // Printando Titulo do jogo
        limpaConsole();
        separarPrint(40);
        separarPrint(30);
        System.out.println("Em teste!! Titulo !!!");
        System.out.println("RPG de TEXTO - APS LPOO - Unip Paulista");
        separarPrint(30);
        separarPrint(40);
        aguardarUsuario();

        // Pegando o nome do jogador
        do {
            limpaConsole();
            printarValor("Qual é o seu nome?");
            nome = leitura.next();
            // Perguntando o jogador se esse é o nome que ele(a) quer usar
            limpaConsole();
            printarValor("Seu nome é " + nome + ".\nEsse é o seu nome?");
            System.out.println("(1) Sim!");
            System.out.println("(2) Não, quero mudar esse nome.");
            int input = lerInt("-> ", 2);
            if (input == 1){
                nameSet = true;
            }
        }while (!nameSet);

        // Printando a Intro da Historia
        Historia.printarIntro();

        // Criando um novo jogador com um nome definido
        jogador = new Jogador(nome);

        //Printando o inicio do primeiro Ato da Historia
        Historia.printarPrimeiroAtoInicio();

        // Coloque a variavel oJogoEstaRodando como true, para que o loopDoGame continue
        oJogoEstaRodando = true;

        // Começar o loop do Jogo
        loopDoGame();
    }

    // Método que muda os valores do game, baseado no nivel de xp do jogador
    public static void checarAto(){
        // Muda o ato baseado na quantidade de xp do jogador
        if (jogador.xp >= 10 && ato == 1){
            // Incrementa o ato e o local
            ato = 2;
            numLocalizacao = 1;
            // Final do primeito ato da Historia
            Historia.printarPrimeiroAtoFinal();
            // Jogador sobi de nivel
            jogador.escolheHabilidade();
            // Inicio do segundo ato da Historia
            Historia.printarSegundoAtoInicio();
            // Colocando novos valores para inimigos
            inimigos[0] = "Mercenario";
            inimigos[1] = "Ogro";
            inimigos[2] = "Pitbull";
            inimigos[3] = "Manual Gomes";
            inimigos[4] = "Pinscher";
            // Colocando novos valores para encontros
            encontroAleatorio[0] = "Batalha";
            encontroAleatorio[1] = "Batalha";
            encontroAleatorio[2] = "Batalha";
            encontroAleatorio[3] = "Descanso";
            encontroAleatorio[4] = "Loja";
            // Recuperando a vida do jogador após a finalização do ato
            jogador.hp = jogador.maxHp;
        }
        else if(jogador.xp >= 50 && ato == 2){
            // Incrementa o ato e o local
            ato = 3;
            numLocalizacao = 2;
            // Final do segundo ato
            Historia.printarSegundoAtoFinal();
            // Jogador sobi de nivel
            jogador.escolheHabilidade();
            // Inicio do Terceiro ato
            Historia.printarTerceiroAtoInicio();
            // Colocando novos valores para inimigos
            inimigos[0] = "Mercenario";
            inimigos[1] = "Vira-Lata Caramelo";
            inimigos[2] = "Pinscher";
            inimigos[3] = "Manual Gomes";
            inimigos[4] = "Pinscher";
            // Colocando novos valores para encontros
            encontroAleatorio[0] = "Batalha";
            encontroAleatorio[1] = "Batalha";
            encontroAleatorio[2] = "Batalha";
            encontroAleatorio[3] = "Descanso";
            encontroAleatorio[4] = "Loja";
            // Recuperando a vida do jogador após a finalização do ato
            jogador.hp = jogador.maxHp;
        }
        else if (jogador.xp >= 100 && ato == 3) {
            // Incrementa o ato e o local
            ato = 4;
            numLocalizacao = 3;
            // Final do terceiro ato
            Historia.printarTerceiroAtoFinal();
            // Jogador sobi de nivel
            jogador.escolheHabilidade();
            // Inicio do Quarto ato
            Historia.printarQuartoAtoInicio();
            // Recuperando a vida do jogador após a finalização do ato
            jogador.hp = jogador.maxHp;

            // Iniciando a Batalha final!!
            // batalhaFinal();
        }
    }

    // Método que calcula uma chance de encontro aleatoria
    public static void chanceEncontroAleatorio(){
        // Isso calcula um numero aleatorio entre 0 e tamanho total do vetor encontroAleatorio
        int aleatorio = (int) (Math.random() * encontroAleatorio.length);

        // Chamando os método dos encontros aleatorios
        if(encontroAleatorio[aleatorio].equals("Batalha")){
            batalhaAleatoria();
        }
        else if(encontroAleatorio[aleatorio].equals("Descanso")){
            //descansar();
        }
        else{
            //loja();
        }
    }

    // Método para continuar a aventura
    public static void continuarAventura(){
        //Checando se o ato precisa ser acrescentado, para ato 2 ou 3 por exemplo
        checarAto();
        // Checando se o jogo já não está no ato final
        // Importante se o numero de atos mudar é necessario trocar esse valor dentro do if
        if(ato != 4){
            chanceEncontroAleatorio();
        }
    }


    // Printando as informações principais do Jogador
    public static void informacoesDoPersonagem(){
        limpaConsole();
        printarValor("Informações do Jogador");
        System.out.println(jogador.nome + "\tHP: " + jogador.hp + "/" + jogador.maxHp);
        separarPrint(20);
        System.out.println("XP: " + jogador.xp);
        separarPrint(20);

        // Printando as habilidades escolhidas do Jogador
        if(jogador.numAtkUpgrades > 0){
            System.out.println("Habilidades Ofensivas: " + jogador.atkUpgrades[jogador.numAtkUpgrades - 1]);
            separarPrint(20);
        }
        if(jogador.numDefUpgrades > 0){
            System.out.println("Habilidades Defensivas: " + jogador.defUpgrades[jogador.numDefUpgrades - 1]);
        }

        aguardarUsuario();
    }

    // Criando uma battle aleatoria
    public static void batalhaAleatoria(){
        limpaConsole();
        printarValor("Você encontrou um inimigo maligno. Você precisa enfrentá-lo!");
        aguardarUsuario();
        // Criando um inimigo aleatorio
        batalha(new Inimigo(inimigos[(int)(Math.random()*inimigos.length)], jogador.xp));
    }

    // Método da principal da Batalha
    public static void batalha(Inimigo inimigo){
        // Loop principal da batalha
        while(true){
            limpaConsole();
            printarValor(inimigo.nome + "\nHP: " + inimigo.hp + "/" + inimigo.maxHp);
            printarValor(jogador.nome + "\nHP: " + jogador.hp + "/" + jogador.maxHp);
            separarPrint(20);
            System.out.println("(1) Lutar\n(2) Usar Poção\n (3) Fugir");
            int input = lerInt("-> ", 3);
            // Comportamento em cada escolha do jogador
            if(input == 1){
                // Lutar
                //Calculo do dano desferido, e do dano recebido do inimigo
                int dano = jogador.atacar() - inimigo.defender();
                int danoRecebido = inimigo.atacar() - jogador.defender();

                // Checando se o dano feito e recebido não é zero
                if (danoRecebido < 0){
                    // Adicionando algum dano caso o jogador consiga uma defesa perfeita
                    dano -= danoRecebido/2;
                    danoRecebido = 0;
                }
                if(dano < 0){
                    dano = 0;
                }
                // dano distribuido na batalha
                jogador.hp -= danoRecebido;
                inimigo.hp -= dano;

                // Printando as informações do round da batalha
                limpaConsole();
                printarValor("BATALHA");
                System.out.println("Você deu " + dano + " de Dano em " + inimigo.nome + ".");
                System.out.println(inimigo.nome + " deu " + danoRecebido + " de dano em você");
                aguardarUsuario();

                // Checando se o Jogador ainda está vivo
                if(jogador.hp <= 0){
                    jogadorMorreu(); //Método de end game
                    break;
                }
                else if(inimigo.hp <= 0){
                    // Mostrando ao jogador que ele ganhou a batalha!
                    limpaConsole();
                    printarValor("Você derrotou " + inimigo.nome + "!");
                    // Aumentando o xp do jogador
                    jogador.xp += inimigo.xp;
                    System.out.println("Você ganhou " + inimigo.xp + " XP!");
                    aguardarUsuario();
                    break;
                }
            }
            else if(input == 2){
                // Usar poção
                // Ainda vai ser implementado
            }
            else {
                // Fugir
                limpaConsole();

                // Checando se o jogaodr não está na batalha final
                if (ato != 4) {
                    // Chance de 33% de fugir da batalha,
                    if (Math.random() * 10 + 1 <= 3.5) {
                        printarValor("Você conseguiu fugir de " + inimigo.nome + "!");
                        break;
                    } else {
                        printarValor("Você não conseguiu fugir.");
                        // Calculando o dano recebido após falhar a fuga
                        int danoRecebido = inimigo.atacar();
                        System.out.println("Nessa falha tentavida vocÊ recebeu " + danoRecebido + " de dano!");
                        aguardarUsuario();
                        if (jogador.hp <= 0) {
                            jogadorMorreu();
                        }
                    }
                } else {
                    printarValor("Você não pode fugir do Chefe final!");
                    aguardarUsuario();
                }
            }
        }
    }

    // Pritando o menu principal
    public static void printMenu(){
        limpaConsole();
        printarValor(localizacao[numLocalizacao]);
        System.out.println("Escolha uma ação:");
        separarPrint(20);
        System.out.println("(1) Continue sua jornada");
        System.out.println("(2) Informações do Jogador");
        System.out.println("(3) Sair do Jogo");
    }

    // Método chamado quando o jogador morre
    public static void jogadorMorreu(){
        printarValor("Você morreu...");
        printarValor("Você ganhou " + jogador.xp + " de XP na sua jornada. Tente ganhar mais na proxima vez!");
        System.out.println("Obrigado por jogar nosso jogo! Espero que tenha gostado :)");
        oJogoEstaRodando = false;
    }

    // Loop do Jogo
    public static void loopDoGame(){
        while (oJogoEstaRodando) {
            printMenu();
            int input = lerInt("-> ", 3);
            if(input == 1){
                continuarAventura();
            }
            else if(input == 2){
                informacoesDoPersonagem();
            }
            else{
                oJogoEstaRodando = false;
            }

        }

    }
}
