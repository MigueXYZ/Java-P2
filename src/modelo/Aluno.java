package modelo;

import java.util.LinkedList;
public class Aluno extends Identificador{
    private LinkedList<Aula> aulas;

    public Aluno(String nome, long numero){
        super(nome, numero);
        aulas=new LinkedList<>();
    }

    public String getNome(){
        return(this.nome);
    }

    public long getNumero(){
        return(this.numero);
    }

    public void setNumero(long numero){
        this.numero=numero;
    }
    public void preencherSumario(Aula aula){
        if(!aulas.contains(aula)){
            return;
        }
        //same thing as professor peenchersumario
        aula.adicionarLinhaSumario(nome);
    }
    public void adicionar(Aula aula){
        if(aula==null||aulas.contains(aula)){
            return;
        }
        aulas.add(aula);
        aula.adicionar(this);
    }
    public void remover(Aula aula){
        //caso não consiga remover
        if(!aulas.remove(aula)){
            return;
        }
        aula.remover(this);
    }

    public LinkedList<Aula> getAulas(){
        return(this.getAulas(null));
    }
    public LinkedList<Aula> getAulas(Horario horario){
        LinkedList<Aula> aulasADevolver=new LinkedList<>();
        Horario aux;
        for (Aula aula : aulas) {
            //percorrer cada aula deste prof
            //se o horario intersetar
            //adiciona
            if(horario!=null){
                aux=aula.getHorario();
                if(aux.getDiaSemana()==horario.getDiaSemana()){
                    if( ( ( aux.getHoraInicio()+aux.getDuracao() )>=horario.getHoraInicio() ) || ( ( horario.getHoraInicio()+horario.getDuracao() )<= aux.getHoraInicio() ) ){
                        aulasADevolver.add(aula);
                    }
                }
            }else{
                aulasADevolver.add(aula);
            }
        }
        return(aulasADevolver);
    }
}
