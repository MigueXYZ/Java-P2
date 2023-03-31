package modelo;

public class Horario {
    private final DiaSemana diaSemana;
    private final long horaInicio;
    private final long duracao;

    public Horario(DiaSemana diaSemana,long horaInicio,long duracao){
        this.diaSemana=diaSemana;
        this.horaInicio=horaInicio;
        this.duracao=duracao;
    }

    public DiaSemana getDiaSemana(){
        return diaSemana;
    }

    public long getHoraInicio(){
        return horaInicio;
    }

    public long getDuracao() {
        return duracao;
    }
}
