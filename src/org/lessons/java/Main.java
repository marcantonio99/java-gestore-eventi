package org.lessons.java;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

            Date dataEvento = formatter.parse("23/06/2023");
            Evento concerto = new Evento("Concerto", dataEvento, 100);

            concerto.prenota();
            concerto.prenota();
            System.out.println("Posti prenotati: " + concerto.getPostiPrenotati());
            concerto.disdici();
            System.out.println("Posti prenotati" + concerto.getPostiPrenotati());

            System.out.println(concerto.toString());
        }catch (ParseException e){
            System.out.println("Errore nella formattazione della data");
        }catch (IllegalArgumentException | IllegalStateException e){
            System.out.println("Errore: " + e.getMessage());
        }
    }
}
