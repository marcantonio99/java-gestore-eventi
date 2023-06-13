package org.lessons.java;
import java.time.LocalDate;

public class Evento {
    private String titolo;
    private LocalDate data;
    private int postiTotali;
    private int postiPrenotati;

    public Evento(String titolo, LocalDate data, int postiTotali) {
        if (data.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("La data dell'evento non può essere nel passato.");
        }
        if (postiTotali <= 0) {
            throw new IllegalArgumentException("Il numero di posti totali deve essere maggiore di zero.");
        }
        this.titolo = titolo;
        this.data = data;
        this.postiTotali = postiTotali;
        this.postiPrenotati = 0;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        if (data.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("La data dell'evento non può essere nel passato.");
        }
        this.data = data;
    }

    public int getPostiTotali() {
        return postiTotali;
    }

    public int getPostiPrenotati() {
        return postiPrenotati;
    }

    public void prenota() {
        if (data.isBefore(LocalDate.now())) {
            throw new IllegalStateException("L'evento è già passato. Impossibile effettuare prenotazioni.");
        }
        if (postiPrenotati >= postiTotali) {
            throw new IllegalStateException("Non ci sono più posti disponibili. Impossibile effettuare prenotazioni.");
        }
        postiPrenotati++;
    }

    public void disdici() {
        if (data.isBefore(LocalDate.now())) {
            throw new IllegalStateException("L'evento è già passato. Impossibile effettuare disdette.");
        }
        if (postiPrenotati <= 0) {
            throw new IllegalStateException("Non ci sono prenotazioni da disdire.");
        }
        postiPrenotati--;
    }

    @Override
    public String toString() {
        return data + " - " + titolo;
    }
}
