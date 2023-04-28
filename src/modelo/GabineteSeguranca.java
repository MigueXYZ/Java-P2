package modelo;

import java.util.LinkedList;

public class GabineteSeguranca extends Divisao{

    private LinkedList<Seguranca> segurancas;


    GabineteSeguranca(String nome, Boolean portaAberta){
        super(nome,portaAberta);
    }

    public LinkedList<Seguranca> getSegurancas(){
        return new LinkedList<>(this.segurancas);
    }

    public void adicionarSeguranca(Seguranca seguranca){
        if(seguranca==null || this.segurancas.contains(seguranca)){
            return ;
        }
        this.segurancas.add(seguranca);
    }

    public void remover(Seguranca seguranca){
        if (this.segurancas != null && seguranca != null) {
            if (!this.segurancas.remove(seguranca)) {
                return;
            }
            seguranca.desassociarGabinete();
        }
    }
}
