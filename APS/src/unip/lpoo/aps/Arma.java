package unip.lpoo.aps;

public class Arma{
    private int danoAtaque;
    private String nomeArma, tipoArma;
    private double chanceAcerto, chanceCritico;

    public Arma(String nome, String tipo, int dano){
        this.nomeArma = nome;
        this.tipoArma = tipo;
        this.danoAtaque = dano;
    }

    public int getDanoAtaque() {return danoAtaque;}

    public String getNomeArma() {return nomeArma;}

    public String getTipoArma() {return tipoArma;}

}
