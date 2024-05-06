package unip.lpoo.aps;

public class Jogador extends Personagem{
    // Inteiros para guardar os upgrades/skills de cada "Caminho"
    public int numAtkUpgrades, numDefUpgrades;

    //status adicionais do usuario
    int gold, travesseiros, pocoes;

    // Upgrades !!Experimental!!
    public String[] atkUpgrades = {"Strenth", "Power", "Might", "Godlike Strenght"};
    public String[] defUpgrades = {"Heavy Bones", "Stoneskin", "Scale Armor", "Holy Aura"};

    // Contrutor do Jogador
    public Jogador(String nome, int forca, int defesa) {
        super(nome, 100, 0, forca, defesa);
        // Colocando com nenhum upgrade inicialmente #0
        this.numAtkUpgrades = 0;
        this.numDefUpgrades = 0;
        // Colocando os status adicionais
        this.gold = 5;
        this.travesseiros = 1;
        this.pocoes = 0;
        // O Jogador escolhe quais caracteristicas quer ter ao criar um novo personagem
        escolheHabilidade();
    }

    @Override
    public int atacar() {
        double poderUpgradeAtk = 1;
        if (numAtkUpgrades == 1){
            poderUpgradeAtk = 1.25;
        } else if (numAtkUpgrades == 2) {
            poderUpgradeAtk = 1.50;
        } else if (numAtkUpgrades == 3) {
            poderUpgradeAtk = 1.75;
        } else if (numAtkUpgrades == 4) {
            poderUpgradeAtk = 2;
        }

        return (int) (Math.random()* ((xp + forca) / 2 ) * poderUpgradeAtk) + (forca - 2);
    }

    @Override
    public int defender() {
        double poderUpgradeDef = 1;
        if (numDefUpgrades == 1){
            poderUpgradeDef = 1.25;
        } else if (numDefUpgrades == 2) {
            poderUpgradeDef = 1.50;
        } else if (numDefUpgrades == 3) {
            poderUpgradeDef = 1.75;
        } else if (numDefUpgrades == 4) {
            poderUpgradeDef = 2;
        }
        return (int) (Math.random()*(((xp + defesa) / 3) * poderUpgradeDef) + (defesa - 2));
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
