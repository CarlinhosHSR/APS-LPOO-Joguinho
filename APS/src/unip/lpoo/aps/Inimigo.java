package unip.lpoo.aps;

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
        return (int) (Math.random()* ((xp + forca) / 2) + (forca - 2));
    }

    @Override
    public int defender() {
        return (int) (Math.random()* ((xpJogador + resistencia) / 3) + (resistencia - 2));
    }
}
