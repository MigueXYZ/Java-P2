package modelo;


import java.util.LinkedList;
public class Professor extends Identificador {
    private LinkedList<Aula> aulas;

    public Professor(String nome, long numero){
        super(nome,numero);
        aulas=new LinkedList<>();
    }
    public void preencherSumario(Aula aula){
        //ignora caso n conheça a aula
        if(!aulas.contains(aula)){
            return;
        }
        //adiciono linha ao sumário da aula com nome da aula
        //adiciono linha ao sumário da aula com número da aula
        //adiciono linha ao sumãrio da aula com o meu nome(assinar)
        //peço a cada aluno da aula que preencha o  seu sumário
        aula.adicionarLinhaSumario(aula.getNome());
        aula.adicionarLinhaSumario(String.valueOf(aula.getNumero()));
        aula.adicionarLinhaSumario(nome);
        for (Aluno aluno : aula.getAlunos()) {
            aluno.preencherSumario(aula);
        }
    }
    public void adicionar(Aula aula){
        //se a aula for nula ou já existir então ignora
        if(aula==null||aulas.contains(aula)){
            return;
        }
        aulas.add(aula);
        aula.setProfessor(this);
    }

    public long getNumero(){
        return (this.numero);
    }

    public void setNumero(long numero){
        this.numero=numero;
    }

    public void remover(Aula aula){
        //caso não consiga remover
        if(!aulas.remove(aula)){
            return;
        }
        aula.desassociarProfessor();
    }

    public String getNome(){
        return(this.nome);
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
