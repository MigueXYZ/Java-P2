package modelo;

import java.util.LinkedList;

public class Professor extends Pessoa {
    private GabineteProfessor gabineteProfessor;
    private LinkedList<Horario> horariosAtendimento;
    public Professor(String nome, long numero, GabineteProfessor gabineteProfessor) {
        super(nome, numero);
        this.gabineteProfessor=gabineteProfessor;
    }

    @Override
    protected void associar(Aula aula) {
        aula.setProfessor(this);
    }

    @Override
    protected void escreverSumario(Aula aula) {
        aula.adicionarLinhaSumario(aula.getNome());
        aula.adicionarLinhaSumario(String.valueOf(aula.getNumero()));
        assinarSumario(aula);
        for (Aluno aluno : aula.getAlunos()) {
            aluno.preencherSumario(aula);
        }
    }

    @Override
    protected void desassociar(Aula aula) {
        aula.desassociarProfessor();
    }

    public GabineteProfessor getGabineteProfessor(){
        return this.gabineteProfessor;
    }
    public LinkedList<Horario> getHorariosAtendimento(){
        return new LinkedList<>(this.horariosAtendimento);
    }


    public void removerGabinete(GabineteProfessor gabineteProfessor) {
        this.gabineteProfessor=null;
        desassociarGabinete(gabineteProfessor);
    }

    private void desassociarGabinete(GabineteProfessor gabineteProfessor) {
        gabineteProfessor.desassociar(this);
    }

    public void setGabinete(GabineteProfessor gabineteProfessor) {
        if (gabineteProfessor == null || this.gabineteProfessor==gabineteProfessor) {
            return;
        }
        this.gabineteProfessor=gabineteProfessor;
        associarGabinete(gabineteProfessor);
    }

    private void associarGabinete(GabineteProfessor gabineteProfessor) {
        gabineteProfessor.adicionar(this);
    }

    public void adicionarHorario(Horario horario){
        if(horario!=null){
            for (Horario hora: horariosAtendimento) {
                if(horario.interseta(hora)){
                    return;
                }
            }
            horariosAtendimento.add(horario);
        }
    }

    public void removerHorario(Horario horario){
        if (this.horariosAtendimento != null && horario != null) {
                for (Horario hora:this.horariosAtendimento){
                    if(hora.interseta(horario)){
                        horariosAtendimento.remove(hora);
                    }
                }
        }
    }

    public void abrirGabinete(){
        this.gabineteProfessor.abrir();
    }

    public void fecharGabinete(){
        this.gabineteProfessor.fechar();
    }

    public void abrir(Sala sala){
        sala.abrir();
    }

    public void fechar(Sala sala){
        sala.fechar();
    }
}