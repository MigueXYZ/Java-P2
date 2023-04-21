package modelo;

import java.util.LinkedList;

public abstract class Pessoa extends Identificador {
    protected LinkedList<Aula> aulas;

    public Pessoa(String nome, long numero) {
        super(nome, numero);
        aulas = new LinkedList<>();
    }

    public void preencherSumario(Aula aula) {
        if (!aulas.contains(aula)) {
            return;
        }
        escreverSumario(aula);
    }

    protected abstract void escreverSumario(Aula aula);

    protected void assinarSumario(Aula aula) {
        aula.adicionarLinhaSumario(nome);
    }

    public void adicionar(Aula aula) {
        if (aula == null || aulas.contains(aula)) {
            return;
        }
        aulas.add(aula);
        associar(aula);
    }

    protected abstract void associar(Aula aula);

    public void remover(Aula aula) {
        //caso nÃ£o consiga remover
        if (!aulas.remove(aula)) {
            return;
        }
        desassociar(aula);

    }

    protected abstract void desassociar(Aula aula);

    public LinkedList<Aula> getAulas() {
        return new LinkedList<>(aulas);
    }

    public LinkedList<Aula> getAulas(Horario horario) {
        LinkedList<Aula> aulasADevolver = new LinkedList<>();
        if (horario == null) {
            return aulasADevolver;
        }
        for (Aula aula : aulas) {
            Horario horarioAula = aula.getHorario();
            if (horarioAula.getDiaSemana() == horario.getDiaSemana() && horario.interseta(horarioAula) == true) {
                aulasADevolver.add(aula);
            }
        }
        return aulasADevolver;
    }
}