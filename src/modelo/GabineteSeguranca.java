package modelo;

import java.util.LinkedList;

public class GabineteSeguranca {
    private String nome;
    private LinkedList<Seguranca> segurancas;
    private Boolean portaAberta;

    GabineteSeguranca(String nome, Boolean portaAberta){
        this.nome=nome;
        this.portaAberta=portaAberta;
    }

    public String getNome(){
        return(this.nome);
    }

    public Boolean isPortaAberta(){
        return(this.portaAberta);
    }

    public LinkedList<Seguranca> getSegurancas(){
        return new LinkedList<>(this.segurancas);
    }

    public void abrir(){
        this.portaAberta=true;
    }

    public void fechar(){
        this.portaAberta=false;
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
