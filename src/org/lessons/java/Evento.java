package org.lessons.java;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Evento {
    private String titolo;
    private Date data;
    private int postiTotali;
    private int postiPrenotati;

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getPostiTotali() {
        return postiTotali;
    }

    public void setPostiTotali(int postiTotali) {
        this.postiTotali = postiTotali;
    }

    public int getPostiPrenotati() {
        return postiPrenotati;
    }

    public void setPostiPrenotati(int postiPrenotati) {
        this.postiPrenotati = postiPrenotati;
    }

    public Evento(String titolo, Date data, int postiTotali, int postiPrenotati) {
        this.titolo = titolo;
        this.data = data;
        this.postiTotali = postiTotali;
        this.postiPrenotati = postiPrenotati;
        if (data.before(new Date())){
            throw new IllegalArgumentException("La data non può essere questa!");
        }
        if (postiTotali <=0){
            throw new IllegalArgumentException("Il numero dei posti prenotati non deve essere negativo!");
        }
    }

    public void prenota() throws IllegalStateException {
        if (data.before(new Date())){
            throw new IllegalStateException("L'evento è passato");
        }
        if (postiPrenotati <= 0){
            throw new IllegalStateException("Non ci sono prenotazioni per questo evento");
        }
        postiPrenotati++;
    }
}
