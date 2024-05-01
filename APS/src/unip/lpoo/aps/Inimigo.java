package unip.lpoo.aps;

public class Inimigo extends Personagem{

    //Variavel para guardar a quantidade atual de xp do jogador
    int xpJogador;

    //Contrutor do Inimigo
    public Inimigo(String nome, int xpInimigo) {
        super(nome, (int) (Math.random()*xpInimigo + xpInimigo/3 + 5), (int) (Math.random()*(xpInimigo/4 + 2) + 1));
        // Armazenando a variavel do xp do Jogador na xpJogador
        this.xpJogador = xpInimigo;
    }

    //Ataque e defesa especifico de cada inimigo
    @Override
    public int atacar() {
        return (int) (Math.random()*(xpJogador/4 + 1) + xp/4 + 3);
    }

    @Override
    public int defender() {
        return (int) (Math.random()*(xpJogador/4 + 1) + xp/4 + 3);
    }
}
