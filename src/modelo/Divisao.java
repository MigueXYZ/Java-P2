package modelo;

public abstract class Divisao {
    private String nome;
    private Boolean portaAberta;

    Divisao(String nome, Boolean portaAberta){
        this.nome=nome;
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

    public String getNome(){
        return(this.nome);
    }
}
