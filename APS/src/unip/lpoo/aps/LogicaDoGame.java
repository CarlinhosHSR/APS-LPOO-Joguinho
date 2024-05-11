package unip.lpoo.aps;
import java.util.ArrayList;
import java.util.Scanner;
public class LogicaDoGame{
    static Scanner leitura = new Scanner(System.in);
    static Jogador jogador;

    public static boolean oJogoEstaRodando;
    static boolean batalhaBoss = false;

    // Encontros ou acontecimentos aleatorios
    public static String[] encontroAleatorio = {"Batalha", "Batalha", "Descanso", "Loja", "Loja"};


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
                System.out.println("Por favor entre com um número!");
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
        System.out.println("\nPressione qualquer tecla para continuar...");
        leitura.next();
    }

    // Método para iniciar o jogo
    public static void IniciarGame(){
        boolean nameSet = false;
        String nome;
        int forca = 0;
        int defesa = 0;

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
            leitura.useDelimiter("\n");
            nome = leitura.next();
            // Perguntando o jogador se esse é o nome que ele(a) quer usar
            limpaConsole();
            printarValor("Seu nome é " + nome + ".\nEsse é o seu nome?");
                System.out.println("(1) Sim!");
                System.out.println("(2) Não, quero mudar esse nome.");
                int input = lerInt("-> ", 2);
                if (input == 1)
                    nameSet = true;

            if (nameSet) {
                while ((forca + defesa) != 10) {
                    limpaConsole();
                    printarValor("Quantos pontos em força e defesa quer colocar?\nA soma dos dois tem que totalizar 10!\nVamos começar com Força quantos pontos quer colocar?");
                    forca = lerInt("Força -> ", 10);
                    printarValor("E em defesa?");
                    defesa = lerInt("Defesa -> ", 10);

                    if ((forca + defesa) < 10) {
                        limpaConsole();
                        System.out.println("O total de força é defesa é menor que 10, coloque mais pontos em um dos atributos.");
                        separarPrint(5);
                    } else if ((forca + defesa) > 10) {
                        limpaConsole();
                        System.out.println("O total de força é defesa é maior que 10, coloque menos pontos em um dos atributos.");
                        separarPrint(5);
                    }
                    if (input == 1)
                        nameSet = true;

                }
            }
        }while (!nameSet);

        // Printando a Intro da Historia
        Historia.printarIntro();
        System.out.println("força: "+ forca + "\t defesa: "+ defesa);

        // Criando um novo jogador com um nome definido
        jogador = new Jogador(nome, forca, defesa);
        // Equipando o Jogador com a Armadura padrão
        equipamentos(0);
        armas(0);

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

        if (jogador.xp >= 25 && ato == 1){
            // Incrementa o ato e o local
            ato = 2;
            numLocalizacao = 1;

            // Chamando o primeiro boss no final do ato.
            bossPrimeiroAto();
            // Final do primeito ato da Historia
            Historia.printarPrimeiroAtoFinal();
            // Jogador sobi de nivel
            jogador.escolheHabilidade();
            // Inicio do segundo ato da Historia
            Historia.printarSegundoAtoInicio();

            // Colocando novos valores para encontros
            encontroAleatorio[0] = "Batalha";
            encontroAleatorio[1] = "Batalha";
            encontroAleatorio[2] = "Batalha";
            encontroAleatorio[3] = "Descanso";
            encontroAleatorio[4] = "Loja";
            // Recuperando a vida do jogador após a finalização do ato
            jogador.hp = jogador.maxHp;
        }
        else if(jogador.xp >= 75 && ato == 2){
            // Incrementa o ato e o local
            ato = 3;
            numLocalizacao = 2;
            // Final do segundo ato
            Historia.printarSegundoAtoFinal();
            // Jogador sobi de nivel
            jogador.escolheHabilidade();
            // Inicio do Terceiro ato
            Historia.printarTerceiroAtoInicio();

            // Colocando novos valores para encontros
            encontroAleatorio[0] = "Batalha";
            encontroAleatorio[1] = "Batalha";
            encontroAleatorio[2] = "Batalha";
            encontroAleatorio[3] = "Descanso";
            encontroAleatorio[4] = "Loja";
            // Recuperando a vida do jogador após a finalização do ato
            jogador.hp = jogador.maxHp;
        }
        else if (jogador.xp >= 125 && ato == 3) {
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
            batalhaFinal();
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
            descansar();
        }
        else{
            loja();
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
        System.out.println("Equipado: " + jogador.getNomeEquipamento() + "\t Defesa: " + jogador.getResistenciaDefesa());
        System.out.println("Arma: " + jogador.getNomeArma() + "\tDano: " + jogador.getDanoArma() + " | Chance Acerto: " + jogador.getChanceDeAcertoArma()
        + " | Chance de Critico: " + jogador.getChanceDeCriticoArma()); // Melhor usar o String format para melhorar o visualização
        System.out.println("Força: " + jogador.forca + " + "+ jogador.getDanoArma() + " Bonus arma!\n" + "Resistencia: " + jogador.resistencia + " + " + jogador.getResistenciaDefesa()
        + " Bonus armadura!");
        separarPrint(20);
        // Quantidade de xp e ouros do jogador
        System.out.println("XP: " + jogador.xp + "\tOuros: " + jogador.gold);
        separarPrint(20);
        // numero de poções
        System.out.println("Poções de cura: " + jogador.pocoes + "\tTravesseiros: "+ jogador.travesseiros);
        separarPrint(20);

        // Printando as habilidades escolhidas do Jogador
        if(jogador.getNumAtkUpgrades() > 0){
            System.out.println("Habilidades Ofensivas: " + jogador.atkUpgrades[jogador.getNumAtkUpgrades() - 1]);
            separarPrint(20);
        }
        if(jogador.getNumDefUpgrades() > 0){
            System.out.println("Habilidades Defensivas: " + jogador.defUpgrades[jogador.getNumDefUpgrades() - 1]);
        }

        aguardarUsuario();
    }

    // Criando a Lojinha do jogo
    public static void loja(){
        limpaConsole();
        printarValor("Você encontra um estranho misterioso.\nEle te oferece algo:");

        // Criando as variaveis para armazenar os valores dos equipamentos vendidos na loja.
        int valorPocaoCura = (int) (Math.random() * (10 + jogador.pocoes*3) + 10 + jogador.pocoes);
        int valorEspadaDeOuro = 2; // Pode ser random, mas acho melhor setar um valor fixo, para garantir o balanceamento
        int valorArmaduraDeOuro = 1;

        // Mostrando as opções para venda.
        System.out.println("Poções\n(1)- Poção de cura: " + valorPocaoCura + " ouros.");
        separarPrint(3);

        System.out.println("Armas\n(2)- Espada de ouro: " + valorEspadaDeOuro + " ouros.");

        separarPrint(3);

        System.out.println("Armadura\n(3)- Armadura de Ouro: " + valorArmaduraDeOuro + " ouros.");

        System.out.println("\n(4)- para sair.");

        separarPrint(20);

        // Perguntando ao jogador se ele quer comprar
        System.out.println("O que deseja comprar?");
        int input = lerInt("-> ", 4);

        //Opções de compra começando com (1) Poção de cura
        if (input == 1){
            limpaConsole();
            //Verificando se o jogador tem dinheiro suficiente
            if (jogador.gold >= valorPocaoCura){
                printarValor("Você comprou uma poção de cura por " + valorPocaoCura + " ouros.");
                jogador.pocoes++;
                jogador.gold -= valorPocaoCura;
            }
            else{
                printarValor("Você não tem ouro suficiente para isso...");
                aguardarUsuario();
                loja();
            }
        }
        else if(input == 2){
            limpaConsole();
            //Verificando se o jogador tem dinheiro suficiente
            if (jogador.gold >= valorEspadaDeOuro){
                armasCompradasNaLoja(1, valorEspadaDeOuro);
                jogador.gold -= valorEspadaDeOuro;
            }
            else {
                printarValor("Você não tem ouro suficiente para isso...");
                loja();
            }
        }
        else if(input == 3){
            limpaConsole();
            //Verificando se o jogador tem dinheiro suficiente
            if (jogador.gold >= valorArmaduraDeOuro){
                printarValor("Você comprou uma Armadura de ouro por " + valorArmaduraDeOuro + " ouros.");
                armadurasCompradasNaLoja(1, valorArmaduraDeOuro);
                jogador.gold -= valorArmaduraDeOuro;
            }
            else {
                printarValor("Você não tem ouro suficiente para isso...");
                loja();
            }
        }
        else if (input == 4){
            loopDoGame();
        }
    limpaConsole();
    }

    // Descanso do jogador
    public static void descansar(){
        limpaConsole();
        if (jogador.travesseiros >= 1){
            printarValor("Você quer descansar um pouco? (" + jogador.travesseiros + " travesseiros restantes).");
            System.out.println("(1) Sim\n(2) Não, agora não.");
            int input = lerInt("-> ", 3);
            if (input == 1){
                // Jogador escolher descansar
                if (jogador.hp < jogador.maxHp){
                    int hpRecuperado = (int) (Math.random() * (jogador.xp/4 + 1) + 10);
                    jogador.hp += hpRecuperado;
                    //Garantindo que o hp não passe do máximo, se passar volta para o máximo
                    if (jogador.hp > jogador.maxHp){
                        jogador.hp = jogador.maxHp;
                    }
                    System.out.println("Você descansou e recuperou " + hpRecuperado + " pontos de vida.");
                    System.out.println("Agora você está com " + jogador.hp + "/" + jogador.maxHp + " pontos de vida.");
                    jogador.travesseiros--;
                }
            }
            else{
                System.out.println("Você continua sua jornada.");
            }
            aguardarUsuario();
        }
    }

    // Criando uma battle aleatoria
    public static void batalhaAleatoria(){
        limpaConsole();
        printarValor("Você encontrou um inimigo maligno. Você precisa enfrentá-lo!");
        aguardarUsuario();
        // Variavel para armazenar o xp dos monstros, alterada a cada ato, para melhorar o balanceamento do jogo.
        int xpMonsters = (int) (jogador.xp / 1.5 + 3); int xpMonsterSup = (int) (jogador.xp / 1.3 + 10);
        // Variaveis para o hp dos monstros. Definitivamente tem um jeito melhor de fazer isso, mas na minha rapida pesquisa, eu não achei.
        int hpMonterOrc = 20; int hpMonsterZumbi = 25; int hpMonsterGoblin = 18; int hpMonsterLobo = 17; int hpMonsterOrcSup = 40;



        // Criando os inimigos aleatorios, mas unicos.
        if(ato == 1){

        }
        else if(ato == 2){
             hpMonterOrc = (25 + (jogador.xp / 2)); hpMonsterZumbi = 15 + (jogador.xp / 2);
             hpMonsterGoblin = 18 + (jogador.xp / 2); hpMonsterLobo = 17 + (jogador.xp / 2);

             Inimigo orcSuperior = new Inimigo("Orc Superior", hpMonsterOrcSup, xpMonsterSup, 9, 8);
        }

        Inimigo orc = new Inimigo("Orc", hpMonterOrc, xpMonsters, 6, 6);
        Inimigo zumbi = new Inimigo("Zumbi", hpMonsterZumbi, xpMonsters, 4, 2);
        Inimigo goblin = new Inimigo("Goblin", hpMonsterGoblin, xpMonsters, 5, 3);
        Inimigo lobo = new Inimigo("Lobo", hpMonsterLobo, xpMonsters, 4, 3);



        ArrayList<Inimigo> listaDeInimigos = new ArrayList<>();
        listaDeInimigos.add(orc);
        listaDeInimigos.add(zumbi);
        listaDeInimigos.add(goblin);
        listaDeInimigos.add(lobo);


        //Numero random
        int aleatorio = (int) (Math.random() * listaDeInimigos.size() - 1) ;

        //Criando uma batalha aleatoria
        batalha(listaDeInimigos.get(aleatorio));
    }

    // Método da principal da Batalha
    public static void batalha(Inimigo inimigo){
        // Loop principal da batalha

        while(true){
            limpaConsole();
            printarValor(inimigo.nome + "\nHP: " + inimigo.hp + "/" + inimigo.maxHp);
            printarValor(jogador.nome + "\nHP: " + jogador.hp + "/" + jogador.maxHp);
            separarPrint(20);
            System.out.println("(1) Lutar\n(2) Usar Poção\n(3) Fugir");
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


                    // Drops aleatorios
                    boolean adicionarTravesseiro = (Math.random()*5 + 1 <= 2.25);
                    int goldEncontrado = (int) (Math.random() * inimigo.xp);
                    if (adicionarTravesseiro){
                        jogador.travesseiros++;
                        System.out.println("Você conseguiu um novo travesseiro!");
                    }
                    if (goldEncontrado > 0){
                        jogador.gold += goldEncontrado;
                        System.out.println("Você encontrou " + goldEncontrado + " ouros no corpo de " + inimigo.nome);
                    }
                    aguardarUsuario();
                    break;
                }
            }
            else if(input == 2){
                // Usar poção
                limpaConsole();
                if(jogador.pocoes > 0 && jogador.hp < jogador.maxHp){
                    //Nesse caso o jogador consegue tomar poções
                    printarValor("Você quer beber uma poção de cura? (" + jogador.pocoes + " poções disponiveis).");
                    System.out.println("(1) Sim\n(2) Não");
                    input = lerInt("-> ", 3);
                    if (input == 1){
                        // O jogador toma a poção
                        jogador.hp = jogador.maxHp;
                        limpaConsole();
                        printarValor("Você tomou a poção de cura. Ela restaurou sua vida de volta para " + jogador.maxHp);
                        aguardarUsuario();
                    }
                }
                else{
                    //Nesse caso o jogador não consegue tomar poções
                    printarValor("Você não tem poções disponiveis ou está com o HP cheio.");
                    aguardarUsuario();
                }
            }
            else {
                // Fugir
                limpaConsole();

                // Checando se o jogaodr não está na batalha final
                if (ato != 4 && !batalhaBoss) {
                    // Chance de 33% de fugir da batalha,
                    if (Math.random() * 10 + 1 <= 3.5) {
                        printarValor("Você conseguiu fugir de " + inimigo.nome + "!");
                        break;
                    } else {
                        printarValor("Você não conseguiu fugir.");
                        // Calculando o dano recebido após falhar a fuga
                        int danoRecebido = inimigo.atacar();
                        System.out.println("Nessa falha tentavida vocÊ recebeu " + danoRecebido + " de dano!");
                        jogador.hp -= danoRecebido;
                        aguardarUsuario();
                        if (jogador.hp <= 0) {
                            jogadorMorreu();
                        }
                    }
                } else {
                    printarValor("Você não pode fugir de um Chefe!");
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
    //Luta final do jogo
    public static void batalhaFinal(){
        batalha(new Inimigo("Bonoro", 300, 120, 17, 22));
        Historia.printarFinalDoGame(jogador);
        oJogoEstaRodando = false;
    }
    public static void bossPrimeiroAto(){
        /* Criando os Bosses do jogo!!
           A ideia é que os bosses do jogo dropem uma boa quantidade de dinheiro, e obrigatorio derrotar para passar de ato. *Caso seja implemetado os equipamentos os bosses devem dropas itens para o Jogador sejam ofensivos ou defensivos.
        */
        batalhaBoss = true;
        batalha(new Inimigo("Orc Chefe", 70,20, 7, 5));
        batalhaBoss = false;
        int index = 1;
        equipamentos(1);

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
    // Método para perguntar se o Jogador quer manter a arma que encontrou ou deixar para tras.
    public static void equiparArma(String nome, int dano, String tipo, double chanceAcerto, double chanceCritico){
        if (nome.equals("Faca de Manteiga")){
            jogador.equiparArma(nome, dano, tipo, chanceAcerto, chanceCritico);
        }
        else {
            System.out.println("Você encontrou uma nova arma!\nÉ uma " + nome + ", com " + dano + " de ataque!\tChance de Acerto: " + chanceAcerto + "\tChance Critico: " + chanceCritico + "%.");
            separarPrint(1);
            System.out.println("Você nesse momento tem uma "+ jogador.getNomeArma() + ":\t Dano: "+ jogador.getDanoArma() + "\tChance de Acerto: " + jogador.getChanceDeAcertoArma() +
                    "\tChance de Critico: " + jogador.getChanceDeCriticoArma());
            separarPrint(3);
            System.out.println("\t" + jogador.getNomeArma() + " - " + nome + "\n\t" + jogador.getDanoArma() + " - " + dano + "\n\t" + jogador.getChanceDeCriticoArma()
            + "% - " + chanceCritico + "%\n\t" + jogador.getChanceDeAcertoArma() + "% - " + chanceAcerto + "%");
            System.out.println("Deseja trocar de arma? \n(1) Sim\n(2) Não, quero continuar com ela.");
            int escolha = lerInt("-->", 2);


            if (escolha == 1) {
                limpaConsole();
                jogador.equiparArma(nome, dano, tipo, chanceAcerto, chanceCritico);
                System.out.println("Você equipou sua nova " + tipo);
            } else {
                separarPrint(5);
                System.out.println("Tem certeza? você só poderá obter essa arma novamente no vendedor.\n(1) Sim, tenho certeza.\n(2) Não, mudei de ideia vou usar essa " + tipo + "!");
                escolha = lerInt("-->", 2);
                if (escolha == 1) {
                    limpaConsole();
                    System.out.println("Você vai embora sem a " + tipo + ".");
                } else {
                    limpaConsole();
                    jogador.equiparArma(nome, dano, tipo, chanceAcerto, chanceCritico);
                    System.out.println("Você equipou sua nova " + tipo + "!");
                }
            }
            aguardarUsuario();
        }
    }

    // Método para comprar armas dentro da loja
    public static void armasCompradasNaLoja(int index, int valor){
        if (index == 1){
            // Criando o objeto Espada de Ouro
            Arma espadaDeOuro;
            espadaDeOuro = new Arma("Espada de Ouro", "Espada", 9, 0.97, 0.12);
            String nomeArma = espadaDeOuro.getNomeArma(); String tipo = espadaDeOuro.getTipoArma(); int danoArma = espadaDeOuro.getDanoAtaque(); double chanceAcerto = espadaDeOuro.getChanceAcerto();
            double chanceCritico = espadaDeOuro.getChanceCritico();

            // String nomeArma, int danoArma, String tipo, double chanceAcerto, double chanceCritico
            System.out.println("Tem certeza que quer comprar essa Arma? \n(1) Sim\n(2) Não\n" + nomeArma + ", com " + danoArma + " de ataque!\tChance de Acerto: " + chanceAcerto + "\tChance Critico: " + chanceCritico + "%.");
            int escolha = lerInt("-->", 2);
            if (escolha == 1){
                jogador.equiparArma(nomeArma, danoArma, tipo, chanceAcerto, chanceCritico);
                printarValor("Você comprou uma Espada de Ouro por " + valor + " ouros.");
                aguardarUsuario();
            }
            else{
                loja();
            }
        }
        if (index == 2){
            // Pra caso tenha outras armas na loja é só colocar nessas condicionais.
        }
    }

    // Método que criar Armas no jogo
    public static void armas(int index){
        Arma espadaDeFerro, adagaDeAco, espadaDeOuro, espadaDeDiamente, facaDeManteiga;
        espadaDeFerro = new Arma("Espada de Ferro", "Espada", 6, 0.95, 0.10);
        adagaDeAco = new Arma("Adaga de Aço", "Adaga", 5, 0.99, 0.50);
        espadaDeOuro = new Arma("Espada de Ouro", "Espada", 9, 0.97, 0.12);
        espadaDeDiamente = new Arma("Espada de Diamante", "Espada", 15, 0.99, 0.15);
        facaDeManteiga = new Arma("Faca de Manteiga", "Faca", 3, 1, 0.05);

        switch (index){
            case 1:
                limpaConsole();
                equiparArma(espadaDeFerro.getNomeArma(), espadaDeFerro.getDanoAtaque(), espadaDeFerro.getTipoArma(), espadaDeFerro.getChanceAcerto(), espadaDeFerro.getChanceCritico());
                break;

            case 2:
                limpaConsole();
                equiparArma(adagaDeAco.getNomeArma(), adagaDeAco.getDanoAtaque(), adagaDeAco.getTipoArma(), adagaDeAco.getChanceAcerto(), adagaDeAco.getChanceCritico());
                break;
            case 3:
                equiparArma(espadaDeOuro.getNomeArma(), espadaDeOuro.getDanoAtaque(), espadaDeOuro.getTipoArma(), espadaDeOuro.getChanceAcerto(), espadaDeOuro.getChanceCritico());
                break;
            case 4:
                equiparArma(espadaDeDiamente.getNomeArma(), espadaDeDiamente.getDanoAtaque(), espadaDeDiamente.getTipoArma(), espadaDeDiamente.getChanceAcerto(), espadaDeDiamente.getChanceCritico());
                break;

            case 0:
                equiparArma(facaDeManteiga.getNomeArma(), facaDeManteiga.getDanoAtaque(), facaDeManteiga.getTipoArma(), facaDeManteiga.getChanceAcerto(), facaDeManteiga.getChanceCritico());
                break;
        }
    }



    // Método para perguntar se o jogador quer manter a armadura que encontrou ou deixar para tras.
    public static void equiparArmadura(String nomeEquip, int defEquip){
        if (defEquip == 0){
            jogador.equiparArmadura(nomeEquip, defEquip);
        }
        else {
            System.out.println("Você encontrou um novo equipamento!\nÉ uma " + nomeEquip + ", com " + defEquip + " de defesa!");
            System.out.println("Você está atualmente sem armadura, deseja equipar essa? \n(1) Sim\n(2) Não, quero continuar sem armadura.");
            int escolha = lerInt("-->", 2);


            if (escolha == 1) {
                limpaConsole();
                jogador.equiparArmadura(nomeEquip, defEquip);
                System.out.println("Você equipou sua nova armadura.");
            } else {
                separarPrint(5);
                System.out.println("Tem certeza? você só poderá obter essa armadura novamente no vendedor.\n(1) Sim\n(2) Não, mudei de ideia vou usar essa armadura!");
                escolha = lerInt("-->", 2);
                if (escolha == 1) {
                    limpaConsole();
                    System.out.println("Você vai embora sem a armadura.");
                } else {
                    limpaConsole();
                    jogador.equiparArmadura(nomeEquip, defEquip);
                    System.out.println("Você equipou sua nova armadura.");
                }
            }
            aguardarUsuario();
        }
    }

    // Método para armaduras compradas na loja.
    public static void armadurasCompradasNaLoja(int index, int valor){
        if (index == 1){
            Equipamento armaduraDeOuro;
            armaduraDeOuro = new Equipamento("Armadura de Ouro", 13);
            String nomeEquipamento = armaduraDeOuro.getNomeEquipamento(); int defesaEquipamento = armaduraDeOuro.getResistenciaDefesa();
            System.out.println("Tem certeza que quer comprar essa Armadura? \n(1) Sim\n(2) Não \n" + nomeEquipamento + "\tDefesa: " + defesaEquipamento);
            int escolha = lerInt("-->", 2);
            if (escolha == 1){
                jogador.equiparArmadura(nomeEquipamento, defesaEquipamento);
                System.out.println("Você comprou uma Armadura de Ouro por " + valor + " ouros.");
            }
            else
                loja();
        }
        if (index == 2){
            // Pra caso tenha outras Armaduras na loja é só colocar nessas condicionais.
        }
    }


    // Método que cria as armaduras
    public static void equipamentos(int index){
        Equipamento armaduraDeFerro, armaduraDeOuro, armaduraDeBronze, semArmadura;
        semArmadura = new Equipamento("Roupas Comuns", 0);
        armaduraDeFerro = new Equipamento("Armadura de Ferro", 10);
        armaduraDeOuro = new Equipamento("Armadura de Ouro", 13);
        armaduraDeBronze = new Equipamento("Armadura de Bronze", 7);
        switch (index){
            case 1:
                limpaConsole();
                equiparArmadura(armaduraDeBronze.getNomeEquipamento(), armaduraDeBronze.getResistenciaDefesa());
                break;

            case 2:
                limpaConsole();
                equiparArmadura(armaduraDeFerro.getNomeEquipamento(), armaduraDeFerro.getResistenciaDefesa());
                break;
            case 3:
                equiparArmadura(armaduraDeOuro.getNomeEquipamento(), armaduraDeOuro.getResistenciaDefesa());
                break;

            case 0:
                equiparArmadura(semArmadura.getNomeEquipamento(), semArmadura.getResistenciaDefesa());
                break;
        }

    }

}
