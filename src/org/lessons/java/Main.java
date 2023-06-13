package org.lessons.java;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            Scanner scanner = new Scanner(System.in);

            System.out.print("Inserisci il nome dell'evento: ");
            String titolo = scanner.nextLine();

            System.out.print("Inserisci la data dell'evento (formato dd/MM/yyyy): ");
            String dataString = scanner.nextLine();
            LocalDate dataEvento = LocalDate.parse(dataString, formatter);

            Evento evento = new Evento(titolo, dataEvento, 100);
            System.out.println("Evento registrato!");

            // Prenoto
            System.out.print("Desideri effettuare delle prenotazioni? Sì/No: ");
            String sceltaPrenotazione = scanner.nextLine();

            if (sceltaPrenotazione.equalsIgnoreCase("Sì")) {
                System.out.print("Inserisci il numero di prenotazioni che desideri fare: ");
                int numeroPrenotazioni = scanner.nextInt();

                for (int i = 0; i < numeroPrenotazioni; i++) {
                    try {
                        evento.prenota();
                        System.out.println("Prenotazione registrata.");
                    } catch (IllegalStateException e) {
                        System.out.println("Impossibile effettuare la prenotazione: " + e.getMessage());
                        break;
                    }
                }
            }
            System.out.println("Posti prenotati: " + evento.getPostiPrenotati());
            System.out.println("Posti disponibili: " + (evento.getPostiTotali() - evento.getPostiPrenotati()));

            // Disdico
            System.out.print("Desideri disdire una prenotazione? Sì/No: ");
            String sceltaDisdetta = scanner.nextLine();

            if (sceltaDisdetta.equalsIgnoreCase("Sì")) {
                System.out.print("Inserisci il numero di disdette: ");
                int numeroDisdette = scanner.nextInt();

                for (int i = 0; i < numeroDisdette; i++) {
                    try {
                        evento.disdici();
                        System.out.println("Disdetta effettuata.");
                    } catch (IllegalStateException e) {
                        System.out.println("Impossibile disdire: " + e.getMessage());
                        break;
                    }
                }
            }
            System.out.println("Posti prenotati: " + evento.getPostiPrenotati());
            System.out.println("Posti disponibili: " + (evento.getPostiTotali() - evento.getPostiPrenotati()));

            scanner.close();
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("Errore: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Input non valido.");
        }
    }
}
