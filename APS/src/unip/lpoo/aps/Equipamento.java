package unip.lpoo.aps;

public class Equipamento{
    private final int resistenciaDefesa;
    private final String nomeEquipamento;

    public Equipamento(String nome, int defesa){
        this.resistenciaDefesa = defesa;
        this.nomeEquipamento = nome;
    }

    public int getResistenciaDefesa() {return resistenciaDefesa;}

    public String getNomeEquipamento() {return nomeEquipamento;}
}
