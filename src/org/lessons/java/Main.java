package org.lessons.java;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Inserisci il titolo dell'evento: ");
        String titolo = scanner.nextLine();

        System.out.print("Inserisci la data dell'evento (formato: dd/MM/yyyy): ");
        String dataString = scanner.nextLine();
        LocalDate data = LocalDate.parse(dataString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        int postiTotali = 100;

        try {
            // Creazione evento
            Evento evento = new Evento(titolo, data, postiTotali);
            System.out.println("Evento creato: " + evento);

            // Prenoto
            System.out.print("Desideri effettuare delle prenotazioni? Sì/No: ");
            String sceltaPrenotazioni = scanner.nextLine();

            if (sceltaPrenotazioni.equalsIgnoreCase("Si")) {
                System.out.print("Inserisci il numero di prenotazioni da effettuare: ");
                int numPrenotazioni = scanner.nextInt();

                for (int i = 0; i < numPrenotazioni; i++) {
                    evento.prenota();
                    System.out.println("Prenotazione effettuata.");
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
                    evento.disdici();
                    System.out.println("Disdetta effettuata.");
                }
            }
            System.out.println("Posti prenotati: " + evento.getPostiPrenotati());
            System.out.println("Posti disponibili: " + (evento.getPostiTotali() - evento.getPostiPrenotati()));
        } catch (Exception e) {
            System.out.println("Si è verificato un errore: " + e.getMessage());
        }
    }
}
