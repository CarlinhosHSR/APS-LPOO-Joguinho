package unip.lpoo.aps;

public abstract class Personagem{
    // Variaveis e atributos que todos os personagens têm que ter!
    String nome;
    int maxHp, hp, xp, forca, resistencia;

    // Contrutor de um personagem
    public Personagem(String nome, int maxHp, int xp, int forca, int resistencia){
        this.nome = nome;
        this.maxHp = maxHp;
        this.xp = xp;
        this.forca = forca;
        this.resistencia = resistencia;
        this.hp = maxHp;
    }

    // Métodos que todos os personagens têm que ter!
    public abstract int atacar();
    public abstract int defender();
}
