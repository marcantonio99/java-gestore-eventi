package org.lessons.java;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*Scanner scanner = new Scanner(System.in);

        System.out.print("Inserisci il titolo dell'evento: ");
        String titolo = scanner.nextLine();

        System.out.print("Inserisci la data dell'evento (formato: dd/MM/yyyy): ");
        String dataString = scanner.nextLine();
        LocalDate data = LocalDate.parse(dataString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        System.out.print("Inserisci l'ora dell'evento (formato: HH:mm): ");
        String oraString = scanner.nextLine();
        LocalTime ora = LocalTime.parse(oraString, DateTimeFormatter.ofPattern("HH:mm"));

        System.out.print("Inserisci il prezzo dell'evento: ");
        String prezzoString = scanner.nextLine();
        BigDecimal prezzo = new BigDecimal(prezzoString);


        int postiTotali = 100;

        try {
            // Creazione evento
            Evento evento = new Evento(titolo, data, postiTotali);
            System.out.println("Evento creato: " + evento);

            *//*Concerto concerto = new Concerto(titolo, data, postiTotali, ora, prezzo);
            System.out.println("Concerto creato: " + concerto);*//*

            // Prenoto
            System.out.print("Desideri effettuare delle prenotazioni? Sì/No: ");
            String sceltaPrenotazioni = scanner.nextLine();

            if (sceltaPrenotazioni.equalsIgnoreCase("Si")) {
                System.out.print("Inserisci il numero di prenotazioni da effettuare: ");
                int numPrenotazioni = scanner.nextInt();

                for (int i = 0; i < numPrenotazioni; i++) {
                    try {
                        evento.prenota();
                        System.out.println("Prenotazione " + (i + 1) + " effettuata con successo!");
                    } catch (IllegalStateException e) {
                        System.out.println("Impossibile effettuare la prenotazione: " + e.getMessage());
                        break;
                    }
                }
            }

            System.out.println("Posti prenotati: " + evento.getPostiPrenotati());
            System.out.println("Posti disponibili: " + (evento.getPostiTotali() - evento.getPostiPrenotati()));

            // Disdico
            System.out.print("Desideri effettuare delle disdette? Sì/No: ");
            String sceltaDisdette = scanner.nextLine();

            if (sceltaDisdette.equalsIgnoreCase("Sì")) {
                System.out.print("Inserisci il numero di disdette da effettuare: ");
                int numDisdette = scanner.nextInt();

                for (int i = 0; i < numDisdette; i++) {
                    try {
                        evento.disdici();
                        System.out.println("Disdetta " + (i + 1) + " effettuata con successo!");
                    } catch (IllegalStateException e) {
                        System.out.println("Impossibile effettuare la disdetta: " + e.getMessage());
                        break;
                    }
                }
            }
            System.out.println("Posti prenotati: " + evento.getPostiPrenotati());
            System.out.println("Posti disponibili: " + (evento.getPostiTotali() - evento.getPostiPrenotati()));
        } catch (Exception e) {
            System.out.println("Si è verificato un errore: " + e.getMessage());
        }*/

        ProgrammEventi programma = new ProgrammEventi("Programma Eventi");

        Evento evento1 = new Evento("Concerto 1", LocalDate.of(2023, 7, 17), 150);
        Evento evento2 = new Evento("Concerto 2", LocalDate.of(2023, 7, 16), 100);
        Evento evento3 = new Evento("Concerto 3", LocalDate.of(2023, 7, 25), 130);

        programma.aggiungereEvento(evento1);
        programma.aggiungereEvento(evento2);
        programma.aggiungereEvento(evento3);

        System.out.println("Numero di eventi nel programma: " + programma.getNumeroEventi());

        LocalDate data = LocalDate.of(2023, 6, 16);
        List<Evento> eventiByData = programma.getEventiByData(data);

        System.out.println("Eventi in data " + data.toString() + ":");
        for (Evento evento : eventiByData) {
            System.out.println(evento.toString());
        }

        System.out.println(programma.toString());
    }
}
