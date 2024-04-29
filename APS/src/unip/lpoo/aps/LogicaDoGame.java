package unip.lpoo.aps;
import java.util.Scanner;
public class LogicaDoGame {
    static Scanner leitura = new Scanner(System.in);
    static Jogador jogador;

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

    // Método para o jogo aguardar a entrada do usuario
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

        jogador = new Jogador(nome);

        // !EM TESTES! start main game loop
        // gameLoop();
    }
}
