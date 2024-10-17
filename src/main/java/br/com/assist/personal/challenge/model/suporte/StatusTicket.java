package br.com.assist.personal.challenge.model.suporte;

public enum StatusTicket {

    EM_ANALISE("Em Analise"), EM_ANDAMENTO("Em Andamento"),
    AGUARDANDO_CLIENTE("Aguardando Cliente"), FINALIZADO("Finalizado"), FECHADO("Fechado");

    private String label;
    StatusTicket(String label){
        this.label = label;
    }
    public String getLabel(){
        return label;
    }

}
