package unip.lpoo.aps;

public abstract class Personagem {
    // Variaveis e atributos que todos os personagens tem que ter!
    public String nome;
    public int maxHp, hp, xp;

    // Contrutor de um personagem
    public Personagem(String nome, int maxHp, int xp){
        this.nome = nome;
        this.maxHp = maxHp;
        this.xp = xp;
        this.hp = maxHp;
    }

    // Métodos que todos os personagens tem que ter!
    public abstract int atacar();
    public abstract int defender();
}
