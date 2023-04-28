package modelo;

public abstract class Divisao extends Descritor{
    private Boolean portaAberta;

    Divisao(String nome, Boolean portaAberta){
        super(nome);
        this.portaAberta=portaAberta;
    }

    public void abrir(){
        this.portaAberta=true;
    }

    public void fechar(){
        this.portaAberta=false;
    }

    public Boolean isPortaAberta(){
        return(this.portaAberta);
    }
}
