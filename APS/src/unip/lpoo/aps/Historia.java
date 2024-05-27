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
                Seus muros de pedra, adornados com trepadeiras floridas, cercavam casas aconchegantes e ruas movimentadas,
                onde mercadores trocavam seus produtos, crianças brincavam e artesãos criavam obras de rara beleza.
                Elisandria era a joia do reino, um exemplo de como humanos e natureza podem coexistir em perfeita sintonia.
            
                Mas a sombra da ganância e do descuido logo se abateu sobre a cidade.
                Com a sucessão de Rei Eldred, obcecado por poder e riquezas, ignorou os avisos de seus conselheiros e do
                povo sobre os perigos da exploração desenfreada dos recursos naturais.
                Florestas ancestrais foram derrubadas, rios poluídos, e os campos férteis se tornaram áridos e erodidos.
                A fúria dos deuses da natureza não tardou a se manifestar.
                Tempestades violentas assolaram a região, colheitas falharam, e a fome se espalhou pelas ruas de Elisandria.
                O povo, desesperado e desiludido com a liderança do rei, começou a imitar seus maus hábitos, devastando o que restava da beleza natural em torno da cidade.
                A magia que assolava o local, não demoraria para se enegrecer.""");
        LogicaDoGame.aguardarUsuario();
        LogicaDoGame.limpaConsole();
        System.out.printf("""
                
                Quando então, em meio à uma tempestade mágica que assolava sua humilde casa, você, %s se viu à beira da morte.
                Raios flamejantes rasgavam os céus, enquanto a fúria da terra tremia sob seus pés.
                Uma inundação repentina brotou do chão, arrastando-o para um redemoinho de água e lama.
                Quando tudo parecia perdido, uma luz incandescente irrompeu da escuridão, envolvendo-o em sua radiância

                Ao abrir os olhos, você se vê em um lugar estranho e surreal. A  tempestade mágica se dissipou, revelando um mundo em ruínas, marcado pela fúria dos elementos.
                Mas, em meio à devastação, uma voz poderosa ecoou em sua mente:
                
                                                "Você foi escolhido.\"""", jogador.nome);
        LogicaDoGame.aguardarUsuario();
        LogicaDoGame.limpaConsole();
        System.out.println("""
                A voz era antiga e sábia, emanando de uma fonte invisível. Você se sentiu imbuído de uma nova força, um poder que pulsava em suas veias. Você ergueu as mãos e um raio de energia pairava sobre elas.
                
                Você havia sobrevivido ao acidente, mas não era mais o mesmo. Um ser imbuído de poder sobre a própria natureza.
                
                E então você soube, que era o único que poderia defender Elisandria do pior.
                
                Sua jornada começa agora.
                """);
        LogicaDoGame.aguardarUsuario();
    }

    // Print do primeiro ato da historia
    public static void printarPrimeiroAtoInicio(){
        LogicaDoGame.limpaConsole();
        LogicaDoGame.separarPrint(30);
        System.out.println("Ato 1 - O Chamado Selvagem");
        LogicaDoGame.separarPrint(30);
        System.out.println("""
                Você abre os olhos novamente, se encontrando onde antes já foi o seu quarto. Aquilo definitivamente não era um sonho.
                
                Você olha para as suas mãos. Elas estavam brilhando em diversas cores! Você sentiu a terra tremer levemente ao dar o seu primeiro passo.
                A água das poças parecia ser puxada como magnetismo diretamente para as suas mãos.""");

        System.out.println("""
                
                Há uma uma nova determinação em seu olhar ao observar o céu negro, coberto de nuvens que brilhavam um roxo mágico e maligno.
                A tempestade destruiria toda a cidade. Você sabia que não poderia deixar isso acontecer.
                Mas e quanto aos seus poderes? Como controlá-los? Como usá-los para proteger sua cidade e seu povo?""");
        LogicaDoGame.aguardarUsuario();
        LogicaDoGame.limpaConsole();
        System.out.println("""
        De repente, a voz poderosa ecoa em sua mente:
        
        "Confie em seus instintos. Use seus poderes com sabedoria. O destino de Elisandria está em suas mãos.\"""");
        LogicaDoGame.aguardarUsuario();
    }
    public static void printarPrimeiroAto(Jogador jogador){
        // Método para chamar as missões baseados no index


        LogicaDoGame.limpaConsole();
        System.out.println("""
                    Você caminha pelas ruas de Elisandria, ainda se adaptando à sua nova realidade.
                    As pessoas tentam tapar as janelas de suas casas com madeira. Algumas correm por ai, desesperadas sem saber o que fazer.
                    De repente, uma sensação de perigo invade seus pensamentos. Você fecha os olhos, concentrando-se em seus sentidos.
                    Você consegue sentir uma energia maligna emanando de um lugar próximo. E então, escuta uma grande gritaria.
                    """);
        LogicaDoGame.aguardarUsuario();
        LogicaDoGame.limpaConsole();
        System.out.println("""
                    Você segue até o parque no centro da cidade. Lá, você encontra um grupo de criaturas sombrias, queimando o que restava das árvores.
                    Havia uma multidão de cidadãos correndo para todos os lados. Goblins do Fogo… Você precisa agir.
                    Não pode permitir que eles destruam ainda mais Elisandria. Você respira fundo, reunindo toda a sua coragem.
                    
                    """);


        // Variaveis usadas nas escolhas desse ato
        int escolha, escolha11, escolha12, escolha21;
        //Armazenara as escolhas do jogador nessa missão se for true ele fez a escolha certa, se não a ruim
        boolean decisao1, decisao2;
        do {
            System.out.println("Oq você vai fazer?\n(1) - Lutar\n(2) - Descansar");
            escolha = LogicaDoGame.lerInt("-->", 2);

            if (escolha == 1){
                LogicaDoGame.limpaConsole();
                System.out.println("""
                            Você se aproxima das criaturas, pronto para enfrentá-las.
                            Um deles, nota a sua aproximação repentina e começa a rir de forma travessa, indo em sua direção.""");
                LogicaDoGame.aguardarUsuario();
                Inimigo goblinDeFogo = new Inimigo("Goblin de Fogo", 20, 5, 2, 3);
                LogicaDoGame.batalha(goblinDeFogo);
                LogicaDoGame.limpaConsole();
                System.out.println("Você consegue vencer o Goblin de Fogo, mas ele não está sozinho.");
                LogicaDoGame.aguardarUsuario();
                goblinDeFogo.hp = 20;
                LogicaDoGame.batalha(goblinDeFogo);
                LogicaDoGame.limpaConsole();
                System.out.println("""
                    Missão Concluída! Você derrotou os inimigos e liberou o parque!
                    Você recebe uma armadura de couro e 10 ouros!""");
                Equipamento armaduraDeCouro;
                armaduraDeCouro = new Equipamento("Armadura de Couro", 3);
                jogador.equiparArmadura(armaduraDeCouro.getNomeEquipamento(), armaduraDeCouro.getResistenciaDefesa());
                jogador.gold += 10;
                LogicaDoGame.aguardarUsuario();

            }
            else if(escolha == 2){
                LogicaDoGame.limpaConsole();
                System.out.println("Você descansa antes da batalha, seu hp é maximizado.");
                LogicaDoGame.aguardarUsuario();
                LogicaDoGame.limpaConsole();
            }
            else{
                LogicaDoGame.limpaConsole();
            }
        }while (escolha != 1);
        LogicaDoGame.limpaConsole();
        System.out.println("""
                    Ao afastar-se do local da batalha, um brilho dourado floresce a sua frente, de onde materializa-se um ser vestindo uma túnica amarela,
                    o capuz impedindo que se visualizasse seu rosto. Ou sequer se ele tinha um.

                    Vi o que você fez. Aparentemente ainda há esperança para a cidade. No ritmo atual, a erradicação da existência de Elisandria e seu povo não tardará.
                    Está se materializando a profecia de que a cidade se auto-destruiria.
                    Reza a lenda de que a manifestação de uma entidade além de nossa compreensão virá com o poder da salvação de Elisandria,
                    o fim da magia negra que destroi a cidade, porém ela pedirá um sacrifício: A alma de todos aqueles que não possuem casa.
                    Sem esse sacrifício, teremos de lutar por Elisandria com nossas próprias mãos, arriscando não conseguir e perdermos todas as construções e riquezas da cidade!

                    Diga-me, aspirante a heroi, caso a decisão caia em suas mãos,
                    você fará a escolha difícil de preservar a cidade e seu poder de prosperidade, ou arriscará tudo em razão de salvar uma parte menor do povo?
                    """);

        do {

            System.out.println("""
                        (1) - Porquê eu escolheria a Cidade no lugar de VIDAS?
                        (2) - E o que acontecerá com aqueles sacrificados?...
                        """);
            escolha11 = LogicaDoGame.lerInt("-->", 2);
            // Essa variavel vai armazenar se o jogador fez a escolha "certa ou boa"
            decisao1 = escolha11 == 1;

        } while(escolha11 != 1 && escolha11 != 2);

        LogicaDoGame.limpaConsole();

        if (escolha11 == 1) {
            System.out.println("""
                        Quando Elisandria estava em seu melhor momento, havia prosperidade!
                        Havia estabilidade, recursos para praticamente todos, alegria e uma qualidade de vida superior para todos os seus moradores!
                        Não podemos descartar um futuro melhor em troca de uma quantidade pequena de vidas cujo sacrificio será honrado eternamente.
                        """);
            do {
                System.out.println("""
                            (1) - Se salvarmos Elisandria, salvamos as pessoas e essa será minha prioridade!
                            (2) - Elisandria pode deixar de existir, se isso significa salvar a todos!
                            """);
                escolha12 = LogicaDoGame.lerInt("-->", 2);
                decisao2 = escolha12 == 1;

            } while (escolha12 != 1 && escolha12 != 2);
        }
        else{
            System.out.println("""
                        Pouco se sabe. O que dizem os livros é que a entidade em questão tem interesse na força vital de indivíduos enquanto corpos físicos,
                        e que existirá um pós-vida eterno para aqueles sacrificados.
                        """);
            do {

                System.out.println("""
                            (1) - Parece um preço justo pela restauração da cidade, acho que o sacrifício valerá a pena...
                            (2) - Não tenho o direito de escolher quem vive e quem morre e por qual motivo, lutarei pelo povo até a morte!
                            
                            """);
                escolha21 = LogicaDoGame.lerInt("-->", 2);
                decisao2 = escolha21 == 1;
            } while (escolha21 != 1 && escolha21 != 2);
        }
        LogicaDoGame.limpaConsole();
        // Se o Jogador tomou as decisões certas!
        if ((decisao1 && !decisao2) || (!decisao1 && decisao2)) {
            System.out.println("""
                        O ser encapuzado solta uma risada curta, baixa, com um leve tom de alívio e diversão.
                        Vejo que a cidade está em boas mãos. Nem todos percebem que o que colocou a cidade nesta situação não foi a revolta das forças da natureza, mas ideais errados.
                        E os seus estão alinhados com a bondade. Por isso, você merece uma ajuda.
                        O ser desaparece com o mesmo brilho dourado que apareceu, deixando logo abaixo de onde pairava, uma poção.
                        """);
            jogador.pocoes++;
        }
        // Se o jogador tomou as decisões erradas
        else {
            System.out.println("""
                        O ser encapuzado abaixa a cabeça, claramente decepcionado, e enquanto encara o chão diz:
                        Você aparenta ser facilmente seduzido por uma saída fácil.
                        Riqueza e prosperidade são desejáveis porém inuteis quando colocados acima da ética e bondade. Espero que sua jornada te ensine algo sobre humildade.
                        """);
        }
        LogicaDoGame.aguardarUsuario();
        LogicaDoGame.limpaConsole();
        System.out.println("""                  
                    Você está atônito pelo que acabou de acontecer.
                    Era quase possível ignorar os céus trovejantes e a ventania ao redor e se perder na adrenalina de recém usar seus poderes.
                    Mas no seguinte instante, você retorna em meio ao caos. Era preciso continuar.
                    """);

        do {
            System.out.println("""
                        (1) - Parar para descansar
                        (2) - Continuar
                        """);
            escolha = LogicaDoGame.lerInt("-->", 2);

            if (escolha == 1){
                LogicaDoGame.descansar();
            }
        } while (escolha != 2);
        LogicaDoGame.limpaConsole();
        System.out.println("""
                Você segue correndo para o centro da cidade. A confusão parecia crescer por ali, enquanto uma multidão de pessoas tentava desesperadamente fugir para fora dos limites da cidade.
                À sua frente, soldados da guarda real usavam máscaras e tentavam conter pessoas a subirem para a avenida principal, montados em seus cavalos agitados.
                A sua volta, algumas casas pegavam fogo.
                Uma delas bem ao lado de uma venda de um mercante, que de sua barraca não parecia nem um pouco preocupado com o caos a sua volta.
            
                (1) - Se aproximar de uma das casas
                (2) - Se aproximar do mercante
                """);
        escolha = LogicaDoGame.lerInt("-->", 2);
        LogicaDoGame.limpaConsole();
        // Jogador escolhe se aproximar das casas
        if (escolha == 1){
            System.out.println("""
                            Você percebe uma coluna de fumaça negra subindo ao céu. Em uma das casas em chamas, os gritos de desespero ecoam enquanto você se aproxima.
                            Seu coração bate forte no peito.
                            Você sabe que precisa ajudar, mas também precisa ser rápido.
                            
                            Com um aperto no estômago, você corre em direção à casa em chamas
                            """);
            LogicaDoGame.limpaConsole();
            System.out.println("""
                            Ao chegar à casa em chamas, você encontra uma família desesperada presa no interior. As chamas bloqueiam a porta da frente, e a fumaça densa torna a respiração difícil.
                            
                            (1) - Dar um soco na porta
                            (2) - Tentar subir pelas janelas
                            """);
            escolha = LogicaDoGame.lerInt("-->", 2);
            if (escolha == 1){
                LogicaDoGame.limpaConsole();
                System.out.println("""
                                        As chamas lambem a porta, e a fumaça densa invade seus olhos.
                                        Você fecha os punhos com força, concentrando sua energia espiritual em seus músculos.
                                        Com um grito de guerra, você desfere um golpe poderoso na porta.
                                        A madeira racha e se estilhaça, e a porta se abre com um estrondo.
                                        A madeira da porta estava frágil o suficiente, mas assim estava a casa.
                                        Ao fazer isso, um grande pedaço do que era o chão do segundo andar cai a sua frente, em chamas.
                                        
                                        Você escuta a voz que conversava com você em sua mente.
                                        “Não se preocupe com as chamas. Você tem nossa proteção”.
                                        
                                        """);
            }
            else{
                System.out.printf("""
                                        As chamas lambem as paredes da casa, e a fumaça densa dificulta sua visão.
                                        Você observa as janelas do segundo andar, buscando uma que não esteja bloqueada pelas chamas.
                                        Com movimentos rápidos e precisos, você escala a parede externa, usando suas habilidades físicas para se esquivar das labaredas.
                                        Finalmente, você consegue alcançar a janela do segundo andar e se esgueirar para dentro da casa em chamas.
                                        A madeira da porta estava frágil o suficiente, mas assim estava a casa.
                                        Você sente a sustentação do chão aos seus pés ceder e com isso, o seu corpo indo de encontro ao primeiro andar da casa junto. Você toma %s de dano.
                                        
                                        Você escuta a voz que conversava com você em sua mente.
                                        “Não se preocupe com as chamas. Você tem nossa proteção”.
                                        """, "15");
                jogador.hp -= 15;
            }
            LogicaDoGame.aguardarUsuario();
        }
        // Jogador decide se aproximar do vendedor
        else{
            System.out.println("""
                            Você se impressiona com a apatia do homem azul sentado em sua vendinha. Ele sorri, um sorriso suspeito ao ver a sua aproximação.
                            
                            “Aproxime-se! Hoje estou com uma série de itens em desconto. Aproveite enquanto ainda estou de bom humor!”
                            """);
            do {
                LogicaDoGame.limpaConsole();
                System.out.println("""
                    (1) - Você não reparou que está tudo caindo aos pedaços a sua volta?
                    (2) - O que você tem a venda?""");
                escolha = LogicaDoGame.lerInt("-->",2);

                if(escolha == 1){
                    LogicaDoGame.limpaConsole();
                    System.out.println("Nenhum dia é um dia ruim para se vender, meu rapaz!");
                    LogicaDoGame.aguardarUsuario();
                }
                else{
                    LogicaDoGame.lojaMercante();
                }
            } while (escolha != 2);
        }
        LogicaDoGame.limpaConsole();

        System.out.println("""
                    O cheiro de fumaça paira no ar e o pânico se espalha pelas ruas.
                    Goblins de Fogo agora invadiam a praça central. Os guardas se dividiram.
                    Eles lançam bolas de fogo em todas as direções, incendiando casas e lojas, espalhando terror entre os cidadãos indefesos.
                    
                    Os guardas do reino tentam conter a horda flamejante, mas estão em menor número e sem estratégia.
                    A confusão reina, e os gritos dos civis se misturam com o rugido das chamas.
                    """);
        LogicaDoGame.aguardarUsuario();
        LogicaDoGame.limpaConsole();

        System.out.println("""
                    Você precisa agir rápido. Mas há algo que te deixa perplexo: assim como os guardas previamente,
                    os goblins também estão tentando impedir que os cidadãos fujam para as ruas que levam à colina do castelo, onde o Rei se encontra.
                    
                    Será que os goblins estão agindo sob ordens do Rei? Ou há outro motivo sinistro por trás dessa estratégia cruel?
                    Você se encontra em um dilema. Do lado esquerdo, os goblins de fogo atacam os cidadãos, impedindo-os de escapar para o castelo.
                    Do lado direito, os guardas do reino lutam bravamente, mas estão perdendo terreno.
                    
                    (1) - Agir junto com aos guardas
                    (2) - Ajudar os cidadãos a subir o castelo
                    """);
        escolha = LogicaDoGame.lerInt("-->",2);
        LogicaDoGame.limpaConsole();
        if(escolha == 1){
            System.out.println("Você decide entrar na linha de frente junto da guarda real, contra os Goblins.");
            LogicaDoGame.aguardarUsuario();
            Inimigo goblinDeFogo = new Inimigo("Goblin de Fogo", 30, 5, 3, 4);
            LogicaDoGame.batalha(goblinDeFogo);
            System.out.println("""
                   Capitão: (Com voz rouca, mas aliviada) A você, meu bravo aventureiro, meus mais profundos agradecimentos. Sua bravura e habilidade foram essenciais para nossa sobrevivência neste antro imundo.
                   Sem você, esses goblins miseráveis teriam nos devorado vivos.
                   
                   Você: (Com humildade) Honrado em ajudar, Capitão. Fiz apenas o meu trabalho.
                   
                   Capitão: Trabalho? Seu heroísmo foi além do trabalho.
                   Você enfrentou esses monstros horríveis com coragem e determinação, protegendo seus companheiros e abrindo caminho para nossa fuga.
                   Sua bravura será para sempre lembrada por todos nós.
                   Vejo que precisa chegar ao castelo, não deveriamos deixar, mas como recompensa por sua bravura permitirei que chegue ao castelo.
                   
                   Pouco antes do capitão terminar de falar uma exploção acontece e te arremessa inconsciente no chão.
                   """);
            LogicaDoGame.aguardarUsuario();

        }

        else{
            System.out.println("Você aproveita o momento de distração da guarda para ajudar os cidadãos a se revoltarem contra os Goblins a frente e subirem para o castelo. ");
            LogicaDoGame.aguardarUsuario();
            Inimigo goblinDeFogo = new Inimigo("Goblin de Fogo", 30, 8, 4, 4);
            LogicaDoGame.batalha(goblinDeFogo);
            System.out.println("""
                        Você derrotou os Goblins. Mas um dos guardas o avista. Eles também não podiam deixar que NINGUÉM subisse ao castelo.
                        """);
            Inimigo guardaReal = new Inimigo("Guarda Real", 70, 15, 7, 5);
            LogicaDoGame.batalha(guardaReal);
            System.out.println("""
                        Você consegue derrotar o Guarda Real, mas os guardas não param de aparecer!
                        
                        Você é cercado, e é atingido pelas costas.
                        
                        Quase inconciente você é capturado.
                        """);
            LogicaDoGame.aguardarUsuario();
        }

        LogicaDoGame.limpaConsole();
        System.out.println("""
                Você concluiu o primeiro ato do jogo!
                Seu HP maximo foi aumentado para 125!""");
        jogador.maxHp = 125;
        LogicaDoGame.aguardarUsuario();
        jogador.ganharPontoAtributo();
        jogador.escolheHabilidade();
        LogicaDoGame.ato = 2;

    }

    public static void printarSegundoAto(Jogador jogador){
        LogicaDoGame.limpaConsole();
        LogicaDoGame.separarPrint(30);
        jogador.hp = jogador.maxHp;
        System.out.println("Ato 2");
        LogicaDoGame.separarPrint(30);
        System.out.println("-O quê? Onde estou? Isto é um sonho?");
        LogicaDoGame.aguardarUsuario();
        LogicaDoGame.limpaConsole();
        System.out.println("""
                Gaia: O que é real e o que é sonho, bravo guardião? A linha entre ambos é tênue e, por vezes, imperceptível.
                Diga-me, o que consideras ser a verdade?

                Você: Se isto é um sonho, parece mais vívido do que qualquer outro que já tive. Mas se é real,
                como posso estar aqui, depois de ser capturado e trancafiado pelo inimigo? É o fim... eu falhei.
                O rei seguirá explorando a natureza, e eu nada pude fazer para impedir.
                
                Gaia: A realidade que conheces é apenas uma parte de um vasto tecido de existências. O mundo espiritual
                é tão real quanto o físico, e ambos se entrelaçam.
                O que experimentas aqui pode influenciar tua realidade desperta.
                
                Você: Mas fui apanhado! Trancafiado numa cela... tudo está perdido. Eu falhei em minha missão.
                """);
        LogicaDoGame.aguardarUsuario();
        LogicaDoGame.limpaConsole();
        System.out.println("""
                Gaia: Não, guardião. Nada está perdido enquanto houver esperança. O caminho de um herói é repleto de
                desafios e, às vezes, de momentos de dúvida.
                Mas é justamente nesses momentos que a verdadeira força se revela.
                
                Você: Mas como posso continuar? Sinto-me fraco e derrotado.
                Como posso derrotar o rei e salvar Elisandria?

                Gaia: Lembra-te do motivo pelo qual empreendeste esta jornada. Os poderes que te concedi são reflexos
                de tua ligação com a natureza, derivados do respeito e cuidado que nutres por todas as formas de vida.
                No mundo espiritual, um lugar imaculado e puro, tu aprenderás a canalizá-los com ainda mais precisão
                e intensidade.
                
                Você: E como posso usar esse conhecimento para cumprir minha missão?
                """);
        LogicaDoGame.aguardarUsuario();
        LogicaDoGame.limpaConsole();
        System.out.println("""
                Gaia: Primeiro, deves enfrentar teus próprios medos e dúvidas. No mundo espiritual, encontrarás provas
                que testarão tua coragem e sabedoria. Cada lição que aprenderes aqui fortalecerá tuas habilidades
                no mundo físico.
                
                Você: Estou pronto para tentar. Mostre-me o caminho. O que devo fazer?

                Gaia: Siga a luz dentro de ti. Confia em teus instintos e ouça a voz da natureza, pois ela o guiará.
                Lembra-te, guardião, que o verdadeiro poder reside na conexão entre todas as coisas.
                Vá agora e redescubra a chama de esperança e bravura que outrora tiveste.
                
                Você: Farei o que for preciso. Pelo meu povo, pela natureza e pelo equilíbrio que deve ser restaurado.
                Estou pronto.
                """);
        LogicaDoGame.aguardarUsuario();
        LogicaDoGame.limpaConsole();
        System.out.println("""
                Gaia: Então vá, guardião, e que a luz da sabedoria o acompanhe. Teu verdadeiro desafio começa agora.
                Lembra-te, tu és a esperança de Elisandria, e a natureza caminha ao teu lado.
                
                Você, atônito, encontrava-se em um estado de transe, escutando cada palavra que Gaia lhe dizia.
                Sua voz era um murmúrio suave, ao mesmo tempo poderosa e consoladora, como o vento sussurrando
                através das árvores antigas. Não sabia há quanto tempo estava ali, mas cada segundo parecia uma
                eternidade preenchida por uma sabedoria ancestral. A figura de Gaia não era uma presença visível,
                mas uma sensação onipresente, envolvente, como se o próprio ar estivesse impregnado com sua
                essência. Um silêncio reverente caiu sobre o local, sinalizando o fim da comunhão.
                """);
        LogicaDoGame.aguardarUsuario();
        LogicaDoGame.limpaConsole();
        System.out.println("""
                Foi então, ao emergir do seu transe profundo, que você abriu os olhos para o mundo ao seu redor e
                ficou absolutamente maravilhado. Encontrava-se no coração do domínio espiritual de Gaia, um lugar
                que até então havia sido apenas um pano de fundo para o seu diálogo interno. O céu acima não era
                azul, mas um vasto mar de âmbar dourado e violeta profundo, onde nuvens de prata líquida
                flutuavam graciosamente, moldando-se em figuras caprichosas.
 
                As florestas ao redor não eram feitas de árvores comuns, mas de colossais arcos de cristal que
                sustentavam copas de folhas feitas de pura luz, cintilando em um caleidoscópio de cores
                impossíveis. Ao seu redor, rios de energia viva serpenteavam pela terra, brilhando com um fulgor
                incandescente. Seus leitos estavam pavimentados com gemas de todas as cores imagináveis, e as
                correntes ressoavam com a melodia primordial da criação, uma música que ele só agora percebia,
                cheia de harmonia e paz.
                """);
        LogicaDoGame.aguardarUsuario();
        LogicaDoGame.limpaConsole();
        System.out.println("""
                O chão de musgo emitia um calor reconfortante, e as paredes vibravam com a melodia harmoniosa da
                vida. Você se deu conta de que estava no coração de um reino onde a própria essência da Mãe
                Natureza pulsava. A imensidão e a beleza do lugar o envolveram, enchendo-o de um profundo senso
                de admiração e reverência. Você, finalmente compreendendo a magnitude do mundo espiritual,
                sentiu-se pequeno, mas ao mesmo tempo parte integrante de algo muito maior e infinitamente belo.
                Sabia, agora, que sua missão era proteger e celebrar esta maravilhosa tapeçaria da existência,
                levando consigo a sabedoria e a serenidade que Gaia lhe havia concedido.
  
                Adentrando no Mundo Espiritual, você se depara com os desafios mencionados por Gaia.
                Tamanha era a destruição causada pelas ações insustentáveis do rei no mundo desperto
                que até mesmo o Mundo Espiritual era afetado — estava definhando e perdendo seu
                esplendor. O céu, antes um mosaico de âmbar e violeta, agora se assemelha a uma tela
                cinza e opaca. As nuvens, que antes dançavam em prata líquida, agora pairam imóveis,
                como testemunhas silenciosas de uma perturbação cósmica.
                """);
        LogicaDoGame.aguardarUsuario();
        LogicaDoGame.limpaConsole();
        System.out.println("""
                Os arcos de cristal, que
                outrora sustentavam copas de folhas luminosas, agora são marcas de rachaduras e
                opacidade. Os rios de energia, antes vivos e brilhantes, transformaram-se em veios de
                trevas estagnadas, ecoando um lamento sombrio. As criaturas que vagam pelas pradarias
                não mais exibem suas formas majestosas, mas agora são sombras distorcidas, reflexos
                pálidos de sua antiga glória. A melodia primordial da criação foi substituída por um
                murmúrio desolador, como um eco distante de um tempo esquecido.

                Você avança e enfrenta inimigos sombrios que emergem das entranhas da corrupção. Cada vitória trazendo
                consigo uma pequena fagulha de luz em meio à escuridão. Cada golpe desferido é uma afirmação
                da resistência à corrupção, um brado de esperança em um mundo envolto em sombras.
                """);
        Inimigo goblinCorrompido = new Inimigo("Goblin Corrompido", 40, 25, 5, 4);
        LogicaDoGame.aguardarUsuario();
        LogicaDoGame.batalha(goblinCorrompido);
        LogicaDoGame.limpaConsole();
        System.out.println("""
                No coração da escuridão, você se depara com o chefe maligno, uma presença aterradora que desafia a
                própria existência. A batalha que se segue é um duelo de forças cósmicas, de luz contra escuridão, de
                vida contra morte. Com a força interior fortalecida pela conexão com Gaia, você enfrenta o mal com
                coragem e determinação. Cada esforço é impulsionado pela sabedoria e pela luz que emanam da Mãe Natureza.
                """);
        Inimigo dragaoCorrompido = new Inimigo("Dragão Corrompido", 100, 30, 8, 5);
        LogicaDoGame.aguardarUsuario();
        LogicaDoGame.batalha(dragaoCorrompido);
        LogicaDoGame.limpaConsole();
        System.out.println("""
                E, finalmente, com um último esforço heroico, a escuridão cede. A luz retorna, as cores ressurgem e a
                harmonia é restaurada. Sob a proteção de Gaia, o mundo espiritual se renova, brilhando novamente com
                vida e beleza. A vitória é não apenas sua, mas de toda a essência pura e eterna que Gaia representa.

                Gaia: Bravo guardião, tua coragem e determinação restauraram o equilíbrio no mundo espiritual.
                Tu venceste as sombras e trouxeste de volta a luz e a harmonia. Por isso, a natureza e eu te agradecemos
                profundamente.
                
                Você: Eu só fiz o que precisava ser feito. A luta foi difícil, mas agora compreendo a verdadeira
                essência do meu propósito. Obrigado por me guiar, Gaia. Sinto-me mais forte e determinado do que nunca.
                
                """);
        LogicaDoGame.aguardarUsuario();
        LogicaDoGame.limpaConsole();
        System.out.println("""
                Gaia: A força que demonstraste é um reflexo do teu coração puro e do amor que tens pela natureza.
                Lembra-te sempre, guardião, que o poder verdadeiro não vem da força bruta, mas da conexão que tens com
                o mundo ao teu redor. Leva contigo essa sabedoria e usa-a para proteger e preservar.
                
                Você: Prometo que não deixarei o rei continuar com suas destruições. Vou lutar pelo meu povo, pela
                natureza e por tudo que é belo e puro neste mundo.
                
                Gaia: Então vá, meu guardião. Volta ao mundo desperto com a renovada chama da esperança e da bravura.
                Sabe que a natureza estará sempre ao teu lado, e que nunca estarás sozinho. Tua missão está apenas
                começando, mas sei que tu a cumprirá com honra e dedicação.
                
                Personagem: Obrigado, Gaia. Prometo não decepcionar. Por Elisandria, pela natureza e por todos os seres
                vivos.
                
                """);
        LogicaDoGame.aguardarUsuario();
        LogicaDoGame.limpaConsole();
        System.out.println("""
                Gaia: Que a luz da sabedoria e da natureza te acompanhe sempre. Vá e cumpra teu destino.
                
                Você sente uma onda de energia fluir através de si, e a cena ao seu redor começa a desvanecer. Ao abrir
                os olhos, encontra-se novamente no mundo desperto, com um coração repleto de determinação e um espírito
                renovado. A missão agora é clara e a jornada, embora árdua, será trilhada com a certeza de que a
                natureza caminha ao seu lado.
                
                """);
        LogicaDoGame.aguardarUsuario();
        LogicaDoGame.limpaConsole();
        System.out.println("""
                Você concluiu o segunto ato do jogo!
                Você recebeu 30 gold.
                Seu HP maximo foi aumentado para 150!
                """);
        LogicaDoGame.aguardarUsuario();
        jogador.maxHp = 150;
        jogador.ganharPontoAtributo();
        jogador.escolheHabilidade();
        LogicaDoGame.ato = 3;

    }

    // Printar Ato Final da Historia, ou Ato 3 se preferir
    public static void printarTerceiroAto(Jogador jogador){
        LogicaDoGame.limpaConsole();
        LogicaDoGame.separarPrint(30);
        System.out.println("Ato 3");
        LogicaDoGame.separarPrint(30);
        System.out.println("""
                Fortalecido pela sabedoria de Gaia e pela compreensão da magnitude do desafio que enfrenta,
                você se prepara para enfrentar os perigos que o aguardam no Mundo Espiritual e, por fim, eliminar o líder
                responsável por toda a ruína da natureza de Elisandria: Rei.""");
        LogicaDoGame.aguardarUsuario();
        LogicaDoGame.descansar();
        System.out.println("""
                Você encontra um estranho mercador com itens para sua ultima jornada.
                """);
        LogicaDoGame.aguardarUsuario();
        LogicaDoGame.lojaMercante();
        LogicaDoGame.limpaConsole();
        System.out.println("""
                Você então segue em direção ao castelo do rei, orientando-se pelas nuvens roxas de magia que pairam
                no céu. Ao chegar ao castelo, se depara com grupos de inimigos em seu caminho para a entrada.
                
                """);
        LogicaDoGame.aguardarUsuario();

        //Batalha Aleatoria
        LogicaDoGame.batalhaAleatoria();
        LogicaDoGame.limpaConsole();

        System.out.println("""
                Sem sequer ter tempo para respirar, outro inimigo se aproxima por trás
                """);
        LogicaDoGame.aguardarUsuario();
        //Batalha aleatória
        LogicaDoGame.batalhaAleatoria();
        LogicaDoGame.limpaConsole();
        System.out.println("""
                Após abrir caminho apenas o suficiente para passar pela entrada principal do castelo, você segue pelo 
                complexo de corredores guiando-se pela crescente densidade da magia negra, tornando óbvio que existe um 
                ponto central de onde irradia tanto poder.
                """);
        LogicaDoGame.aguardarUsuario();
        LogicaDoGame.batalhaAleatoria();
        LogicaDoGame.limpaConsole();
        System.out.println("""
                Você: Esses inimigos não acabam nunca, parece até que estão sendo invocad...
                Interrompendo-se no meio da frase, você avista a entrada para o salão principal, de onde irradiava um
                
                brilho roxo, e fica claro que há algo de extremamente errado acontecendo porta adentro.
  
                Ao entrar no salão principal, fica boquiaberto com a cena.
                Rei Aldred, flutuando a pelo menos 10 metros acima do chão,  tentáculos de névoa roxa o circulando.
                Olhos brancos. Possuído.
                O que quer que tenha acontecido, este não é mais um homem.
                """);
        LogicaDoGame.aguardarUsuario();
        LogicaDoGame.limpaConsole();
        System.out.println("""
                Mas você não veio aqui para lamentações e se apressa em gritar para chamar a atenção do rei.
                Ele responde em uma voz que não parece uma voz, mas pelo menos 5 ao mesmo tempo, com um eco
                sobrenatural, um timbre que se imaginaria apenas em uma criatura além da nossa compreensão.
                
                Rei Eldred: O escolhido....
                
                Rei Eldred: Imaginei que alguém seria burro o suficiente para vir atrás de mim.
                
                Você: O que diabos aconteceu aqui?
                """);

        LogicaDoGame.aguardarUsuario();
        LogicaDoGame.limpaConsole();
        System.out.println("""
               Rei Eldred: Ah a eternidade... um prêmio tão grande, por um preço tão pequeno. Mist é um espírito tão
               doce, me ofereceu uma vida sem fim em troca dos recursos naturais da cidade.
               
               Você: Você sacrificou toda a saúde da cidade, promoveu tanta exploração desenfreada dos recursos, 
               toda a poluição, descarte irresponsável do lixo, em troca de mais vida para você? pessoas estão morrendo!

               Rei Eldred: Quem se importa? São só pessoas que iriam morrer um dia para serem esquecidas de 
               qualquer jeito. O que importa é que posso  viver para sempre.
                               
               Percebendo que o rei é um caso perdido e que a única forma de libertar a cidade dos descuidos 
               ambientais é eliminando o seu perpetrador, você avança contra o rei.
                """);
        Inimigo ReiAldred = new Inimigo("Rei Aldred",150,1000,18,9);
        LogicaDoGame.batalha(ReiAldred);

        LogicaDoGame.limpaConsole();
        System.out.println("""
                Imediatamente após a morte de Rei Aldred, sente-se uma levesa incomum no ar, ele parece mais limpo...
                Então, repentinamente, tudo some e você se encontra em um ambiente totalmente diferente.
                Você foi teletransportado.

                Você se vê no que parece ser um salão, onde o chão é de mármore branco polido, porém não existem paredes
                a vista, apenas névoa branca e... tranquilizante.
                Logo a sua frente, de pé ao envés de pairando no ar, está a figura do manto amarelo que outrora quis
                testar sua ética e te deu uma recompensa
                """);
        LogicaDoGame.aguardarUsuario();
        LogicaDoGame.limpaConsole();
        System.out.println("""
                Entidade: Sabia que poderia confiar em você para a tarefa. Sabia que você era a melhor escolha.
                Transferir poderes do reino espiritual para um mortal demandou grande sacrifício, mas que valeu a pena.
                Você salvou Elisandria, eliminando o mal pela raiz. Sem a influência negativa do rei corrupto, sem
                as praticas de exploração abusiva da natureza como um todo, o reino irá prosperar.
                Não há necessidade de voltar fisicamente para presenciar a reestruturação da cidade.
                Seus poderes são necessários em outro lugar...

                Com isso, névoa dourada e reluzente o envolve, e você entra em um sono profundo.
                Sem saber onde vai.
                Sem saber a onde está sendo levado.
                """);
        LogicaDoGame.aguardarUsuario();
        LogicaDoGame.limpaConsole();
        System.out.println("""
                Fim do jogo.
                """);
        Historia.printarFinalDoGame(jogador);
        LogicaDoGame.oJogoEstaRodando = false;
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

        System.out.println("""
        
        Esse jogo foi desenvolvido pelo grupo da APS, David, Marcelo, Airton, Parker e Carlinhos
        Para a APS de Lógica de Programação Orientada a Objetos do Prof. Veras
        Espero que você tenha gostado!""");
        LogicaDoGame.aguardarUsuario();
    }


}
