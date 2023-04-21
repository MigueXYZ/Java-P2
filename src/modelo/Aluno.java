package modelo;

public class Aluno extends Pessoa {


    public Aluno(String nome, long numero) {
        super(nome, numero);
    }

    @Override
    protected void escreverSumario(Aula aula) {
        assinarSumario(aula);
    }

    @Override
    protected void associar(Aula aula) {
        aula.adicionar(this);
    }

    protected void desassociar(Aula aula) {
        aula.remover(this);
    }

}