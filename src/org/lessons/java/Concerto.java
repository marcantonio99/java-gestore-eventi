package org.lessons.java;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Concerto extends Evento{
    private LocalTime ora;
    private BigDecimal prezzo;

    public Concerto(String titolo, LocalDate data, int postiTotali, LocalTime ora, BigDecimal prezzo) {
        super(titolo, data, postiTotali);
        this.ora = this.ora;
        this.prezzo = this.prezzo;
    }

    public LocalTime getOra() {
        return ora;
    }

    public void setOra(LocalTime ora) {
        this.ora = ora;
    }

    public BigDecimal getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(BigDecimal prezzo) {
        this.prezzo = prezzo;
    }

    public String getDataFormattata(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return getData().format(formatter);
    }

    public String getOraFormattata(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH/mm");
        return ora.format(formatter);
    }

    public String getPrezzoFormattato(){
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.getDefault());
        symbols.setGroupingSeparator(',');
        symbols.setDecimalSeparator('.');
        DecimalFormat decimalFormat = new DecimalFormat("##,##0.00$", symbols);
        return decimalFormat.format(prezzo);
    }
    @Override
    public String toString() {
        return getDataFormattata() + " - " + getOraFormattata() + " - " + getTitolo() + " - " + getPrezzoFormattato();
    }
}
