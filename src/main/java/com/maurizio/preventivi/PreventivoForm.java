package com.maurizio.preventivi;

public class PreventivoForm {

    private String nomeCliente;
    private String descrizioneServizio;
    private Double prezzo;

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getDescrizioneServizio() {
        return descrizioneServizio;
    }

    public void setDescrizioneServizio(String descrizioneServizio) {
        this.descrizioneServizio = descrizioneServizio;
    }

    public Double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(Double prezzo) {
        this.prezzo = prezzo;
    }

    private Double iva;
private Double totale;

public Double getIva() {
    return iva;
}

public void setIva(Double iva) {
    this.iva = iva;
}

public Double getTotale() {
    return totale;
}

public void setTotale(Double totale) {
    this.totale = totale;
}
}