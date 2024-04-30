package unip.lpoo.aps;

public class Inimigo extends Personagem{

    //Variavel para guardar a quantidade atual de xp do jogador
    int xpJogador;

    //Contrutor do Inimigo
    public Inimigo(String nome, int xpJogador) {
        super(nome, (int) (Math.random()*xpJogador + xpJogador/3 + 5), (int) (Math.random()*(xpJogador/4 + 2) + 1));
        // Armazenando a variavel do xp do Jogador na xpJogador
        this.xpJogador = xpJogador;
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
