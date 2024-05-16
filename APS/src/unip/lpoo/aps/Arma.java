package unip.lpoo.aps;

public class Arma{
    private final int danoAtaque;
    private final String nomeArma;
    private final String tipoArma;

    public Arma(String nome, String tipo, int dano){
        this.nomeArma = nome;
        this.tipoArma = tipo;
        this.danoAtaque = dano;
    }

    public int getDanoAtaque() {return danoAtaque;}

    public String getNomeArma() {return nomeArma;}

    public String getTipoArma() {return tipoArma;}

}
