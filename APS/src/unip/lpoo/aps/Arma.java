package unip.lpoo.aps;

public class Arma{
    private int danoAtaque;
    private String nomeArma, tipoArma;
    private double chanceAcerto, chanceCritico;

    public Arma(String nome, String tipo, int dano, double ChanceDeAcertar, double chanceCritico){
        this.nomeArma = nome;
        this.tipoArma = tipo;
        this.danoAtaque = dano;
        this.chanceAcerto = ChanceDeAcertar;
        this.chanceCritico = chanceCritico;
    }

    public int getDanoAtaque() {return danoAtaque;}

    public String getNomeArma() {return nomeArma;}

    public String getTipoArma() {return tipoArma;}

    public double getChanceAcerto() {return chanceAcerto;}

    public double getChanceCritico() {return chanceCritico;}
}
