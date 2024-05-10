package unip.lpoo.aps;

import static java.lang.Math.random;

public class Inimigo extends Personagem{
    //Variavel para guardar a quantidade atual de xp do jogador
    int xpJogador;


    //Contrutor do Inimigo
    public Inimigo(String nome, int maxhp, int xp, int forca, int defesa) {
        //super(nome, (int) xpInimigo + (xpInimigo / 3) + 5), (int) (Math.random()*(xpInimigo/4 + 2) + 1));
        super(nome, maxhp, xp, forca, defesa);
        // Armazenando a variavel do xp do Jogador na xpJogador
        //this.xpJogador = xpInimigo;
        this.forca = forca;
        this.resistencia = defesa;
    }

    //Ataque e defesa especifico de cada inimigo
    @Override
    public int atacar() {
        return (int) ((forca + random() * 10));
    }

    @Override
    public int defender() {
        return (int) (resistencia + random() * 10);
    }
}
