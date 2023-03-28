package modelo;

import java.util.LinkedList;
public class Aula extends Identificador{
    private StringBuilder sumario;
    private Professor professor;
    private LinkedList<Aluno> alunos;
    private Horario horario;

    public Aula(String nome, long numero,Horario horario){
        this(nome,numero,horario,null,new LinkedList<>());
    }

    public Aula(String nome, long numero, Horario horario, Professor professor, LinkedList<Aluno> alunos){
        super(nome, numero);
        sumario=new StringBuilder();
        setProfessor(professor);
        this.alunos= new LinkedList<>();
        if (alunos!=null) {
            for (Aluno aluno : alunos) {
                adicionar(aluno);
            }
        }
        if(horario!=null){
            this.horario=new Horario(horario.getDiaSemana(), horario.getHoraInicio(), horario.getDuracao());
        }else{
            this.horario=new Horario(DiaSemana.DOMINGO,00,00);
        }
    }
    public void adicionarLinhaSumario(String linha){
        sumario.append(linha).append("\n");
    }

    public long getNumero(){
        return numero;
    }
    public void setProfessor(Professor professor){
        //se tiver um professor atribuido
        if(professor==null||professor==this.professor){
            return;
        }
        if(this.professor != null){
            //o professor antigo vai de base
            this.professor.remover(this);
        }
        this.professor=professor;
        this.professor.adicionar(this);
    }
    public void desassociarProfessor(){
        if(this.professor==null){
            return;
        }
        Professor professorRemover=professor;
        professor=null;
        professorRemover.remover(this);
    }

    public void remover(Aluno aluno){
        if(alunos!=null&&aluno!=null){
            if(!alunos.remove(aluno)){
                return;
            }
            aluno.remover(this);
        }
    }

    public void adicionar(Aluno aluno){
        if(aluno!=null && alunos!=null){
            if(aluno==null||alunos.contains(aluno)){
                return;
            }
            alunos.add(aluno);
            aluno.adicionar(this);
        }
    }

    public String getSumario(){
        return sumario.toString();
    }

    public String getNome(){
        return(this.nome);
    }

    public Professor getProfessor(){
        return(this.professor);
    }

    public LinkedList<Aluno> getAlunos(){
        return( new LinkedList<>(alunos));
    }

    public Horario getHorario() {
        return horario;
    }
}
