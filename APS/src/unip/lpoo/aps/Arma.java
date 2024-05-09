package unip.lpoo.aps;

public class Arma{
    private int danoAtaque;
    private String nomeArma, tipoArma;
    private double chanceAcerto;

    public Arma(String nome, String tipo, int dano, double ChanceDeAcertar){
        this.nomeArma = nome;
        this.tipoArma = tipo;
        this.danoAtaque = dano;
        this.chanceAcerto = ChanceDeAcertar;
    }

    public int getDanoAtaque() {return danoAtaque;}

    public String getNomeArma() {return nomeArma;}

    public String getTipoArma() {return tipoArma;}

    public double getChanceAcerto() {return chanceAcerto;}
}
