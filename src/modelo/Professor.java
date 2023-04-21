package modelo;

import java.util.LinkedList;

public class Professor extends Pessoa {
    private GabineteProfessor gabineteProfessor;
    private LinkedList<Horario> horarios;
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
    public LinkedList<Horario> getHorarios(){
        return new LinkedList<>(this.horarios);
    }
    public void removerGabinete(GabineteProfessor gabineteProfessor) {
    }
}