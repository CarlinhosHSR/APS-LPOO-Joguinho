package unip.lpoo.aps;

public abstract class Personagem {
    // Variaveis e atributos que todos os personagens tem que ter!
    public String nome;
    public int maxHp, hp, xp, forca, defesa;

    // Contrutor de um personagem
    public Personagem(String nome, int maxHp, int xp, int forca, int defesa){
        this.nome = nome;
        this.maxHp = maxHp;
        this.xp = xp;
        this.forca = forca;
        this.defesa = defesa;
        this.hp = maxHp;
    }

    // Métodos que todos os personagens tem que ter!
    public abstract int atacar();
    public abstract int defender();
}
