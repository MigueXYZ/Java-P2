package modelo;

public class Horario {
    private DiaSemana diaSemana;
    private long horaInicio;
    private long duracao;

    public Horario(DiaSemana diaSemana, long horaInicio, long duracao) {
        this.diaSemana = diaSemana;
        this.horaInicio = horaInicio;
        this.duracao = duracao;
    }

    public DiaSemana getDiaSemana() {
        return diaSemana;
    }

    public long getHoraInicio() {
        return horaInicio;
    }

    public long getDuracao() {
        return duracao;
    }

    public boolean interseta(Horario horario) {

        long horaFim = this.horaInicio + this.duracao;
        long horaFimHorario = horario.horaInicio + horario.duracao;

        return this.diaSemana == horario.diaSemana && horaFim > horario.horaInicio && horaFimHorario > this.horaInicio;
    }
}