package org.lessons.java;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProgrammEventi {
    private String titolo;
    private List<Evento> eventi;

    public ProgrammEventi(String titolo){
        this.titolo = titolo;
        this.eventi = new ArrayList<>();
    }

    public void aggiungereEvento(Evento evento){
        eventi.add(evento);
    }

    public List<Evento> getEventiByData(LocalDate data){
        List<Evento> eventiByData = new ArrayList<>();
        for (Evento evento : eventi) {
            if (evento.getData().isEqual(data)){
                eventiByData.add(evento);
            }
        }
        return  eventiByData;
    }

    public int getNumeroEventi(){
        return eventi.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(titolo).append("\n");
        for (Evento evento : eventi){
            sb.append(evento.toString()).append("\n");
        }
        return sb.toString();
    }
}
