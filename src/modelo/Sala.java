package modelo;

import java.util.LinkedList;

public class Sala {
    private String nome;
    private LinkedList<Aula> aulas;
    private Boolean portaAberta;

    Sala(String nome,Boolean portaAberta){
        this.nome=nome;
        this.portaAberta=portaAberta;
    }

    public String getNome(){
        return(this.nome);
    }


    public LinkedList<Aula> getAulas(){
        return new LinkedList<>(this.aulas);
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

    public boolean isPortaAberta(){
        return portaAberta;
    }

    public void abrir(){
        portaAberta=true;
    }
    public void fechar(){
        portaAberta=false;
    }

    public void adicionar(Aula aula) {
        if (aula == null || aulas.contains(aula)) {
            return;
        }
        aulas.add(aula);
        associar(aula);
    }

    private void associar(Aula aula) {
        aula.setSala(this);
    }

    public void remover(Aula aula){
        if(!aulas.remove(aula)){
            desassociar(aula);
        }
    }

    private void desassociar(Aula aula) {
        aula.desassociarSala();
    }
}
