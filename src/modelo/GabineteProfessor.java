package modelo;

import java.util.LinkedList;

public class GabineteProfessor {
    private String nome;
    private LinkedList<Professor> professores;
    private Boolean portaAberta;

    GabineteProfessor(String nome,Boolean portaAberta){
        this.nome=nome;
        this.portaAberta=portaAberta;
    }
    public String getNome(){
        return this.nome;
    }
    public LinkedList<Professor> getProfessores(){
        return new LinkedList<>(this.professores);
    }
    public Boolean isPortaAberta(){
        return this.portaAberta;
    }
    public void abrir(){
        this.portaAberta=true;
    }
    public void fechar(){
        this.portaAberta=false;
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
