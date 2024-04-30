package unip.lpoo.aps;

public class Jogador extends Personagem{
    // Inteiros para guardar os upgrades/skills de cada "Caminho"
    public int numAtkUpgrades, numDefUpgrades;

    // Upgrades !!Experimental!!
    public String[] atkUpgrades = {"Strenth", "Power", "Might", "Godlike Strenght"};
    public String[] defUpgrades = {"Heavy Bones", "Stoneskin", "Scale Armor", "Holy Aura"};

    // Contrutor do Jogador
    public Jogador(String nome) {
        super(nome, 100, 0);
        // Colocando com nenhum upgrade inicialmente #0
        this.numAtkUpgrades = 0;
        this.numDefUpgrades = 0;
        // O Jogador escolhe quais caracteristicas quer ter ao criar um novo personagem
        escolheHabilidade();
    }

    @Override
    public int atacar() {
        return (int) (Math.random()*(xp/4 + numAtkUpgrades*3 + 3) + xp/10 + numAtkUpgrades*2 + numDefUpgrades + 1);
    }

    @Override
    public int defender() {
        return (int) (Math.random()*(xp/4 + numDefUpgrades*3 + 3) + xp/10 + numDefUpgrades*2 + numDefUpgrades + 1);
    }
    // Deixa o jogar qualquer escolher qual caracteristica quer
    public void escolheHabilidade(){
        LogicaDoGame.limpaConsole();
        LogicaDoGame.printarValor("Escolha sua caracteristica: ");
        System.out.println("(1) " + atkUpgrades[numAtkUpgrades]);
        System.out.println("(2) " + defUpgrades[numDefUpgrades]);
        // Pega a escolha do usuario
        int input = LogicaDoGame.lerInt("-> ", 2);
        LogicaDoGame.limpaConsole();

        // Lidando com ambos os cenarios
        if(input == 1){
            LogicaDoGame.printarValor("Você escolheu " + atkUpgrades[numAtkUpgrades] + "!");
            numAtkUpgrades++;
        }else{
            LogicaDoGame.printarValor("Você escolheu " + defUpgrades[numDefUpgrades] + "!");
        }
        LogicaDoGame.aguardarUsuario();
    }
}
