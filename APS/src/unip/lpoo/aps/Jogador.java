package unip.lpoo.aps;

import static java.lang.Math.random;

public class Jogador extends Personagem implements Habilidades{
    // Inteiros para guardar os upgrades/skills de cada "Caminho"
    private int numAtkUpgrades, numDefUpgrades;

    // Criado as variaveis dos equipamentos
    private int resistenciaDefesa;
    private String nomeEquipamento;

    // Getters dos Equipamentos

    public String getNomeEquipamento() {return nomeEquipamento;}

    public int getResistenciaDefesa() {return resistenciaDefesa;}

    // Variaveis das Armas
    private String nomeArma, tipoArma;
    private int danoArma;
    private double chanceDeAcertoArma, chanceDeCriticoArma;

    // Getters das Armas
    public String getNomeArma() {return nomeArma;}
    public String getTipoArma() {return tipoArma;}
    public int getDanoArma() {return danoArma;}

    //status adicionais do usuario
    int gold, travesseiros, pocoes;

    // Upgrades !!Experimental!!
    public String[] atkUpgrades = {"Lutador", "Lutador+", "Lutador++", "Lutador+++"};
    public String[] defUpgrades = {"Casca-grossa", "Casca-grossa+", "Casca-grossa++", "Casca-grossa+++"};
    // Método que equipa a Armadura
    public void equiparArmadura(String nome, int defesa){
        this.nomeEquipamento = nome;
        this.resistenciaDefesa = defesa;
    }

    // Método que euipa a Arma
    public void equiparArma(String nome, int dano, String tipo){
        this.nomeArma = nome;
        this.danoArma = dano;
        this.tipoArma = tipo;
    }


    public int getNumAtkUpgrades() {return numAtkUpgrades;}

    public int getNumDefUpgrades() {return numDefUpgrades;}

    // Contrutor do Jogador
    public Jogador(String nome, int forca, int defesa) {
        super(nome, 100, 0, forca, defesa);
        // Colocando com nenhum upgrade inicialmente #0
        this.numAtkUpgrades = 0;
        this.numDefUpgrades = 0;
        // Colocando os status adicionais
        this.gold = 5;
        this.travesseiros = 1;
        this.pocoes = 1;
        // O Jogador escolhe quais caracteristicas quer ter ao criar um personagem
        escolheHabilidade();
    }



    @Override
    public int atacar() {
        /*double poderUpgradeAtk = 1;
        if (numAtkUpgrades == 1){
            poderUpgradeAtk = 1.25;
        } else if (numAtkUpgrades == 2) {
            poderUpgradeAtk = 1.50;
        } else if (numAtkUpgrades == 3) {
            poderUpgradeAtk = 1.75;
        } else if (numAtkUpgrades == 4) {
            poderUpgradeAtk = 2;
        }*/

        return (int) ((forca + danoArma) + (random()* 5));
        // Random * ( Range) + min
    }

    @Override
    public int defender() {
        /*double poderUpgradeDef = 1;
        if (numDefUpgrades == 1){
            poderUpgradeDef = 1.25;
        } else if (numDefUpgrades == 2) {
            poderUpgradeDef = 1.50;
        } else if (numDefUpgrades == 3) {
            poderUpgradeDef = 1.75;
        } else if (numDefUpgrades == 4) {
            poderUpgradeDef = 2;
        }*/
        return (int) ((resistencia + resistenciaDefesa) + (random() * 5));
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
            numDefUpgrades++;
        }
        LogicaDoGame.aguardarUsuario();
    }

    public void ganharPontoAtributo(){
        LogicaDoGame.limpaConsole();
        LogicaDoGame.printarValor("Você ganhou um ponto!\nOnde quer usar?\n(1) Força - Atualmente em " + forca + "\n(2)" +
                " Resistencia - Atualmente em " + resistencia);
        int input = LogicaDoGame.lerInt("-->", 2);
        LogicaDoGame.limpaConsole();

        if (input == 1){
            this.forca++;
            LogicaDoGame.printarValor("Você usou seu ponto em força!\nAgora você tem " + forca + " de força!");
            LogicaDoGame.aguardarUsuario();
        }
        if (input == 2){
            this.resistencia++;
            LogicaDoGame.printarValor("Você usou seu ponto em resistencia!\nAgora você tem " + resistencia + " de resistencia!");
            LogicaDoGame.aguardarUsuario();
        }
    }

    @Override
    public int atacarComHabilidade(int atkUpgrade) {
        return (int) 25 + (atkUpgrade * 2);
    }

    @Override
    public void defendeComHabilidade(int defUpgrade) {
        resistencia += 5 + defUpgrade;
    }

}
