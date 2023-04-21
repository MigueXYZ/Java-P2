package modelo;

import java.util.LinkedList;

public class Seguranca {
    private String nome;
    private Long numero;
    private GabineteSeguranca gabinete;
    private LinkedList<Horario> horarioAtendimento;

    Seguranca(String nome,Long numero, GabineteSeguranca gabinete){
        this.nome=nome;
        this.numero=numero;
        this.gabinete=gabinete;
    }

    public String getNome(){
        return(this.nome);
    }

    public GabineteSeguranca getGabinete(){
        return(this.gabinete);
    }

    public LinkedList<Horario> getHorarioAtendimento(){
        return new LinkedList<>(this.horarioAtendimento);
    }

    public void abrir(GabineteSeguranca gabinete){
        gabinete.abrir();
    }

    public void abrir(GabineteProfessor gabinete){
        gabinete.abrir();
    }
    public void abrir(Sala sala){
        sala.abrir();
    }
    public void fechar(GabineteSeguranca gabinete){
        gabinete.fechar();
    }

    public void fechar(GabineteProfessor gabinete){
        gabinete.fechar();
    }

    public void fechar(Sala sala){
        sala.fechar();
    }

    public Long getNumero(){
        return(this.numero);
    }

    public void setNumero(Long numero){
        this.numero=numero;
    }

    public void setGabinete(GabineteSeguranca gabinete){
        this.gabinete=gabinete;
    }

    public void desassociarGabinete(){
        this.gabinete=null;
    }

    public void adicionar(Horario horario){
        if(horario!=null){
            for (Horario hora: this.horarioAtendimento) {
                if(horario.interseta(hora)){
                    return;
                }
            }
            this.horarioAtendimento.add(horario);
        }
    }

    public void remover(Horario horario){
        if (this.horariosAtendimento != null && horario != null) {
            for (Horario hora:this.horarioAtendimento){
                if(hora.interseta(horario)){
                    horarioAtendimento.remove(hora);
                }
            }
        }
    }
}
