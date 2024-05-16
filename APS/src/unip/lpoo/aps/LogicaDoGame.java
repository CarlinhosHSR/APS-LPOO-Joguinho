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

    // Esse Array localizacao vai armazenar os locais em que a história acontece
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


    // Método para dar espaço entre os textos da História
    public static void espacoTexto(int qtd){
        for (int i = 0; i < qtd; i++){
            System.out.println("\n");
        }
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
        System.out.println("EcoQuest");
        System.out.println("RPG de texto - APS LPOO - Unip Paulista");
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
                }
            }
        }while (!nameSet);

        // Criando um jogador com um nome definido
        jogador = new Jogador(nome, forca, defesa);

        // Printando a Intro da história

        Historia.printarIntro(jogador);
        System.out.println("força: "+ forca + "\t defesa: "+ defesa);

        // Equipando o Jogador com a Armadura padrão
        equipamentos(0);
        armas(0);

        //Printando o início do primeiro Ato da história
        Historia.printarPrimeiroAtoInicio();

        // Coloque a variavel oJogoEstaRodando como true, para que o loopDoGame continue
        oJogoEstaRodando = true;

        // Chamando a primeira missão do jogo antes do ‘loop’ do jogo
        missao(0);
        // Começar o ‘loop’ do Jogo
        loopDoGame();
    }
    public static void missao(int index){
        // Método para chamar as missões baseados no index

        if (index == 0){
            System.out.println("""
                    Você caminha pelas ruas de Elisandria, ainda se adaptando à sua nova realidade.
                    As pessoas tentam tapar as janelas de suas casas com madeira. Algumas correm por ai, desesperadas sem saber o que fazer.
                    De repente, uma sensação de perigo invade seus pensamentos. Você fecha os olhos, concentrando-se em seus sentidos.
                    Você consegue sentir uma energia maligna emanando de um lugar próximo. E então, escuta uma grande gritaria.
                    """);
            aguardarUsuario();
            System.out.println("""
                    Você segue até o parque no centro da cidade.
                    Lá, você encontra um grupo de criaturas sombrias, queimando o que restava das árvores.
                    Havia uma multidão de cidadãos correndo para todos os lados. Goblins do Fogo… Você precisa agir.
                    Não pode permitir que eles destruam ainda mais Elisandria. Você respira fundo, reunindo toda a sua coragem.
                    """);
            System.out.println("\nOq você vai fazer?\n(1) Lutar\n(2) Descansar");
            int escolha;
            do {
                escolha = lerInt("-->", 2);

                if (escolha == 1){
                    limpaConsole();
                    System.out.println("""
                            Você se aproxima das criaturas, pronto para enfrentá-las.
                            Um deles, nota a sua aproximação repentina e começa a rir de forma travessa, indo em sua direção.""");
                    aguardarUsuario();
                    Inimigo goblinDeFogo = new Inimigo("Goblin de Fogo", 20, 5, 2, 3);
                    batalha(goblinDeFogo);
                    limpaConsole();
                    System.out.println("Você consegue vencer o Goblin de Fogo, mas ele não está sozinho outro Goblin está pronto para atacar!");
                    LogicaDoGame.aguardarUsuario();
                    goblinDeFogo.hp = 20;
                    batalha(goblinDeFogo);
                    System.out.println("Você consegue afastar os goblins de fogo.");

                    limpaConsole();
                    System.out.println("Parabens você concluiu sua primeira missão!");
                    System.out.println("Você recebe uma armadura de couro e 10 ouros!");
                    Equipamento armaduraDeCouro;
                    armaduraDeCouro = new Equipamento("Armadura de Couro", 3);
                    jogador.equiparArmadura(armaduraDeCouro.getNomeEquipamento(), armaduraDeCouro.getResistenciaDefesa());
                    aguardarUsuario();
                    System.out.println("Você a veste, e decide descansar antes de continuar sua aventura.");
                    jogador.hp = jogador.maxHp;
                    LogicaDoGame.aguardarUsuario();
                }
                else if(escolha == 2){
                    limpaConsole();
                    System.out.println("Você descansa antes da batalha, seu hp é maximizado.");
                    aguardarUsuario();
                }
                else{
                    limpaConsole();
                }
            }while (escolha != 1);


        }
    }


    // Método que muda os valores do game, baseado no nivel de xp do jogador
    public static void checarAto(){
        // Muda o ato baseado na quantidade de xp do jogador

        if (jogador.xp >= 40 && ato == 1){
            // Incrementa o ato e o local
            ato = 2;
            numLocalizacao = 1;

            // Chamando o primeiro chefe no final do ato.
            bossPrimeiroAto();
            // Final do primeito ato da Historia
            Historia.printarPrimeiroAtoFinal();
            // Jogador sobi de nivel
            jogador.escolheHabilidade();
            // Jogador ganha um atributo
            jogador.ganharPontoAtributo();
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
        else if(jogador.xp >= 90 && ato == 2){
            // Incrementa o ato e o local
            ato = 3;
            numLocalizacao = 2;
            // Final do segundo ato
            Historia.printarSegundoAtoFinal();
            // Jogador sobi de nivel
            jogador.escolheHabilidade();
            // Jogador ganha um atributo
            jogador.ganharPontoAtributo();
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
        else if (jogador.xp >= 160 && ato == 3) {
            // Incrementa o ato e o local
            ato = 4;
            numLocalizacao = 3;
            // Final do terceiro ato
            Historia.printarTerceiroAtoFinal();
            // Jogador sobi de nivel
            jogador.escolheHabilidade();
            // Jogador ganha um atributo
            jogador.ganharPontoAtributo();
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
        System.out.println("Arma: " + jogador.getNomeArma() + "\tDano: " + jogador.getDanoArma());
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
        int valorEspadaDeOuro = 20; // Pode ser random, mas acho melhor setar um valor fixo, para garantir o balanceamento
        int valorArmaduraDeOuro = 25;

        // Mostrando as opções para venda.
        System.out.println("Poções\n(1)- Poção de cura: " + valorPocaoCura + " ouros.");
        separarPrint(3);

        System.out.println("Armas\n(2)- Espada de ouro: " + valorEspadaDeOuro + " ouros.");

        separarPrint(3);

        System.out.println("Armadura\n(3)- Armadura de Ouro: " + valorArmaduraDeOuro + " ouros.");

        System.out.println("\n(4)- Para sair.");

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
                aguardarUsuario();
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
                aguardarUsuario();
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
        if(ato == 2){
            hpMonterOrc = (18 + (jogador.xp / 2)); hpMonsterZumbi = 15 + (jogador.xp / 2);
            hpMonsterGoblin = 18 + (jogador.xp / 2); hpMonsterLobo = 17 + (jogador.xp / 2);

            xpMonsters = (jogador.xp / 2 + 3);
             Inimigo orcSuperior = new Inimigo("Orc Superior", hpMonsterOrcSup, xpMonsterSup, 9, 8);
        } else if (ato == 3) {
            hpMonterOrc = (25 + (jogador.xp / 2)); hpMonsterZumbi = 20 + (jogador.xp / 2);
            hpMonsterGoblin = 20 + (jogador.xp / 2); hpMonsterLobo = 20 + (jogador.xp / 2);

            xpMonsters = (int) (jogador.xp / 2.5 + 3);
        }

        Inimigo orc = new Inimigo("Orc", hpMonterOrc, xpMonsters, 7, 3);
        Inimigo zumbi = new Inimigo("Zumbi", hpMonsterZumbi, xpMonsters, 5, 2);
        Inimigo goblin = new Inimigo("Goblin", hpMonsterGoblin, xpMonsters, 6, 2);
        Inimigo lobo = new Inimigo("Lobo", hpMonsterLobo, xpMonsters, 6, 3);



        ArrayList<Inimigo> listaDeInimigos = new ArrayList<>();
        listaDeInimigos.add(orc);
        listaDeInimigos.add(zumbi);
        listaDeInimigos.add(goblin);
        listaDeInimigos.add(lobo);

        //Variavel que armazena o valor que ira escolher o monstro
        int monstroEscolhido;

        //Método para inimigos aleatorios, mas com maior possibilidade de ser um inimigo fraco
        int aleatorio = (int) (Math.random() * 100) ;
        if (aleatorio <= 30){
            //Nesse caso escolhendo o Zumbi
            monstroEscolhido = 1;
        }
        else if(aleatorio <= 55){
            //Nesse caso escolhendo o Goblin
            monstroEscolhido = 2;
        }
        else if(aleatorio <= 85){
            //Nesse Caso escolhendo o Lobo
            monstroEscolhido = 3;
        }
        else{
            //Nesse caso escolhendo o Orc
            monstroEscolhido = 0;
        }

        //Criando uma batalha aleatoria
        batalha(listaDeInimigos.get(monstroEscolhido));
    }

    // Método da principal da Batalha
    public static void batalha(Inimigo inimigo){
        // Loop principal da batalha
        int turnosHabilidadeAtaque = 0;
        int turnosHabilidadeDefesa = 0;
        while(true){
            limpaConsole();
            printarValor(inimigo.nome + "\nHP: " + inimigo.hp + "/" + inimigo.maxHp);
            printarValor(jogador.nome + "\nHP: " + jogador.hp + "/" + jogador.maxHp);
            separarPrint(20);
            System.out.println("""
                    (1) Lutar
                    (2) Usar Poção
                    (3) Usar Habilidade
                    (4) Fugir""");

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

                // Se o jogador tiver usado a habilidade ele fica contado, para quando der 3 rounds zerar o contador.
                // E o usuario poder usar a habilidade novamente
                if (turnosHabilidadeAtaque > 0){
                    turnosHabilidadeAtaque++;
                }
                if (turnosHabilidadeAtaque == 4){
                    turnosHabilidadeAtaque = 0;
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

                    // Tirando o aumento de defesa do personagem, caso ele tenha usado a habilidade de defesa
                    if (turnosHabilidadeDefesa != 0){
                        jogador.resistencia -= 5 + jogador.getNumDefUpgrades();
                    }

                    break;
                }
            }
            else if(input == 2){
                // Usar poção
                limpaConsole();
                if(jogador.pocoes > 0 && jogador.hp < jogador.maxHp){
                    //Nesse caso o jogador consegue tomar poções
                    printarValor("Você quer beber uma poção de cura? (" + jogador.pocoes + " poções disponiveis).");
                    System.out.println("""
                            (1) Sim
                            (2) Não""");
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
            else if (input == 3){
                // Usar Habilidades
                limpaConsole();
                int escolha;
                System.out.println("""
                        Você vai usar qual habilidade?
                        (1) Corte Rapido (Desfere um dano massivo, só pode ser usado a cada 3 turnos.)
                        (2) Pele Dura Aumenta seus status de defesa em 5 ou mais temporariamente, só pode ser usado uma vez por luta.)
                        (3) Para sair, caso não consiga usar as habilides ou não queira.""");
                do{
                    escolha = lerInt("-->", 3);
                    if (escolha == 1){
                        if (turnosHabilidadeAtaque == 0 && jogador.getNumAtkUpgrades() > 0 && jogador.forca > 5){
                            int danoEspecial = jogador.atacarComHabilidade(jogador.getNumAtkUpgrades());
                            int danoRecebido = inimigo.atacar() - jogador.defender();
                            // Checando se o dano feito e recebido não é zero
                            if (danoRecebido <= 0){
                                danoRecebido = 0;
                            }
                            // dano distribuido na batalha
                            jogador.hp -= danoRecebido;
                            inimigo.hp -= danoEspecial;

                            // Printando as informações do round da batalha
                            limpaConsole();
                            printarValor("BATALHA");
                            System.out.println("Você usou Corte Rapido e deu " + danoEspecial + " de Dano em " + inimigo.nome + ".");
                            System.out.println(inimigo.nome + " deu " + danoRecebido + " de dano em você");
                            aguardarUsuario();
                            turnosHabilidadeAtaque++;
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
                        else if(turnosHabilidadeAtaque == 0 && jogador.getNumAtkUpgrades() > 0 && jogador.forca <= 5){
                            System.out.println("Você não tem força suficiente para usar essa habilidade.");
                            aguardarUsuario();
                        }
                        else if(turnosHabilidadeAtaque == 0 && jogador.getNumAtkUpgrades() == 0){
                            System.out.println("Você ainda não tem essa habilidade.");
                            aguardarUsuario();
                        }
                    }
                    else if(escolha == 2) {
                        // Usar habilidade de defesa, mas só pode ser usado se o jogador já tiver pegado um ponto em def upgrade
                        if (turnosHabilidadeDefesa == 0 && jogador.getNumDefUpgrades() > 0 && jogador.resistencia > 5) {
                            jogador.defendeComHabilidade(jogador.getNumDefUpgrades());
                            turnosHabilidadeDefesa++;
                            System.out.println("Você enrijese sua pele, e aumenta a sua defesa.");
                            aguardarUsuario();
                        }
                        else if(turnosHabilidadeDefesa == 0 && jogador.getNumDefUpgrades() > 0 && jogador.resistencia <= 5){
                            System.out.println("Você não tem resistencia suficiente para usar essa habilidade");
                            aguardarUsuario();
                        }
                        // Se o jogador não tiver pegado um upgrade de defesa, o jogo retorna uma mensagem que o jogador não pode usar essa skill ainda.
                        else if(turnosHabilidadeDefesa == 0 && jogador.getNumDefUpgrades() == 0){
                            System.out.println("Você ainda não consegue usar essa habilidade.");
                            aguardarUsuario();
                        }
                        // O jogador só pode usar a habilidade uma vez por luta, então se já tiver usado, ele retorna essa mensagem.
                        else{
                            System.out.println("A Habilidade está ativa no momento, é só pode ser usada uma vez por batalha.");
                            aguardarUsuario();
                        }
                    }
                }while (escolha != 1 && escolha != 2 && escolha != 3);

                // Checando se o inimigo foi derrotado para sair da batalha
                if (inimigo.hp <= 0)
                    break;
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
                        System.out.println("Nessa falha você recebeu " + danoRecebido + " de dano!");
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
        System.out.println("""
        (1) Continue sua jornada
        (2) Informações do Jogador
        (3) Sair do Jogo""");
    }
    //Luta final do jogo
    public static void batalhaFinal(){
        batalha(new Inimigo("Bonoro", 200, 120, 12, 14));
        Historia.printarFinalDoGame(jogador);
        oJogoEstaRodando = false;
    }
    public static void bossPrimeiroAto(){
        /* Criando os Bosses do jogo!!
           A ideia é que os bosses do jogo dropem uma boa quantidade de dinheiro, e obrigatorio derrotar para passar de ato. *Caso seja implemetado os equipamentos os bosses devem dropas itens para o Jogador sejam ofensivos ou defensivos.
        */
        batalhaBoss = true;
        batalha(new Inimigo("Orc Chefe", 60,10, 7 ,4));
        batalhaBoss = false;
        equipamentos(1);

    }

    // Método chamado quando o jogador morre
    public static void jogadorMorreu(){
        limpaConsole();
        printarValor("Você morreu...");
        printarValor("Você ganhou " + jogador.xp + " de XP na sua jornada. Tente ganhar mais na proxima vez!");
        System.out.println("Obrigado por jogar nosso jogo! Espero que tenha gostado :)");
        aguardarUsuario();
        oJogoEstaRodando = false;
    }

    // ‘Loop’ do Jogo
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
    public static void equiparArma(String nome, int dano, String tipo){
        if (nome.equals("Faca de Manteiga")){
            jogador.equiparArma(nome, dano, tipo);
        }
        else {
            System.out.println("Você encontrou uma nova arma!\nÉ uma " + nome + ", com " + dano + " de ataque!");
            separarPrint(1);
            System.out.println("Você nesse momento tem uma "+ jogador.getNomeArma() + ":\t Dano: "+ jogador.getDanoArma());
            separarPrint(3);
            System.out.println("\t" + jogador.getNomeArma() + " - " + nome + "\n\t" + jogador.getDanoArma() + " - " + dano);
            System.out.println("Deseja trocar de arma? \n(1) Sim\n(2) Não, quero continuar com ela.");
            int escolha = lerInt("-->", 2);


            if (escolha == 1) {
                limpaConsole();
                jogador.equiparArma(nome, dano, tipo);
                System.out.println("Você equipou sua nova " + tipo);
            } else {
                separarPrint(5);
                System.out.printf("""
                        Tem certeza? você só poderá obter essa arma novamente no vendedor.
                        (1) Sim, tenho certeza.
                        (2) Não, mudei de ideia vou usar essa %s!""", tipo);
                escolha = lerInt("-->", 2);
                limpaConsole();
                if (escolha == 1) {
                    System.out.println("Você vai embora sem a " + tipo + ".");
                } else {
                    jogador.equiparArma(nome, dano, tipo);
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
            espadaDeOuro = new Arma("Espada de Ouro", "Espada", 9);
            String nomeArma = espadaDeOuro.getNomeArma(); String tipo = espadaDeOuro.getTipoArma(); int danoArma = espadaDeOuro.getDanoAtaque();

            // String nomeArma, int danoArma, String tipo, double chanceAcerto, double chanceCritico
            System.out.println("Tem certeza que quer comprar essa Arma? \n(1) Sim\n(2) Não\n" + nomeArma + ", com " + danoArma + " de ataque!");
            int escolha = lerInt("-->", 2);
            if (escolha == 1){
                jogador.equiparArma(nomeArma, danoArma, tipo);
                printarValor("Você comprou uma Espada de Ouro por " + valor + " ouros.");
                aguardarUsuario();
            }
            else{
                loja();
            }
        }
        if (index == 2){
            // Para caso tenha outras armas na loja é só colocar nessas condicionais.
        }
    }

    // Método que criar Armas no jogo
    public static void armas(int index){
        Arma espadaDeFerro, adagaDeAco, espadaDeOuro, espadaDeDiamente, facaDeManteiga;
        espadaDeFerro = new Arma("Espada de Ferro", "Espada", 6);
        adagaDeAco = new Arma("Adaga de Aço", "Adaga", 5);
        espadaDeOuro = new Arma("Espada de Ouro", "Espada", 9);
        espadaDeDiamente = new Arma("Espada de Diamante", "Espada", 15);
        facaDeManteiga = new Arma("Faca de Manteiga", "Faca", 3);

        switch (index){
            case 1:
                limpaConsole();
                equiparArma(espadaDeFerro.getNomeArma(), espadaDeFerro.getDanoAtaque(), espadaDeFerro.getTipoArma());
                break;

            case 2:
                limpaConsole();
                equiparArma(adagaDeAco.getNomeArma(), adagaDeAco.getDanoAtaque(), adagaDeAco.getTipoArma());
                break;
            case 3:
                equiparArma(espadaDeOuro.getNomeArma(), espadaDeOuro.getDanoAtaque(), espadaDeOuro.getTipoArma());
                break;
            case 4:
                equiparArma(espadaDeDiamente.getNomeArma(), espadaDeDiamente.getDanoAtaque(), espadaDeDiamente.getTipoArma());
                break;

            case 0:
                equiparArma(facaDeManteiga.getNomeArma(), facaDeManteiga.getDanoAtaque(), facaDeManteiga.getTipoArma());
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
            System.out.println("Você está atualmente com uma " + jogador.getNomeEquipamento() + ", com " + jogador.getResistenciaDefesa()
                    + " de defesa. " + "Deseja equipar essa? \n(1) Sim\n(2) Não, quero continuar com minha armadura.");
            int escolha = lerInt("-->", 2);


            if (escolha == 1) {
                limpaConsole();
                jogador.equiparArmadura(nomeEquip, defEquip);
                System.out.println("Você equipou sua nova armadura.");
            } else {
                separarPrint(5);
                System.out.println("Tem certeza? você só poderá obter essa armadura novamente no vendedor.\n(1) Sim\n(2) Não, mudei de ideia vou usar essa armadura!");
                escolha = lerInt("-->", 2);
                limpaConsole();
                if (escolha == 1) {
                    System.out.println("Você vai embora sem a armadura.");
                } else {
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
