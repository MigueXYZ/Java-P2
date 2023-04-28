package modelo;

import java.util.LinkedList;

public class GabineteProfessor extends Divisao{
    private LinkedList<Professor> professores;

    GabineteProfessor(String nome,Boolean portaAberta){
        super(nome, portaAberta);
        professores = new LinkedList<>();
    }

    public LinkedList<Professor> getProfessores(){
        return new LinkedList<>(this.professores);
    }

    public void remover(Professor professor) {
        if (this.professores != null && professor != null) {
            if (!this.professores.remove(professor)) {
                return;
            }
            professor.removerGabinete(this);
        }
    }
    public void adicionar(Professor professor) {
        if (professor != null && this.professores != null) {
            if (this.professores.contains(professor)) {
                return;
            }
            this.professores.add(professor);
            professor.setGabinete(this);
        }
    }
    public void desassociar(Professor professor) {
        this.professores.remove(professor);
    }
}
