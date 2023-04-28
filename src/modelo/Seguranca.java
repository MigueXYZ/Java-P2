package modelo;

import java.util.LinkedList;

public class Seguranca extends Pessoa {
    private GabineteSeguranca gabinete;
    private LinkedList<Horario> horarioAtendimento;

    Seguranca(String nome, long numero, GabineteSeguranca gabinete){
        super(nome,numero);
        this.gabinete=gabinete;
    }

    public GabineteSeguranca getGabinete(){
        return(this.gabinete);
    }

    public LinkedList<Horario> getHorarioAtendimento(){
        return new LinkedList<>(this.horarioAtendimento);
    }

    public void abrirGabinete(){
        this.gabinete.abrir();
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



    public void setNumero(Integer numero){
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
        if (this.horarioAtendimento != null && horario != null) {
            for (Horario hora:this.horarioAtendimento){
                if(hora.interseta(horario)){
                    horarioAtendimento.remove(hora);
                }
            }
        }
    }
}
