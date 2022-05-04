package edu.upc.dsa.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class ObjetoUsuario implements Comparable<ObjetoUsuario> {
    private Objeto objeto;
    private LocalDateTime fecha;

    ObjetoUsuario(){}

    ObjetoUsuario(Objeto objeto, String fecha){
        this();
        this.objeto =objeto;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(fecha, formatter);
        this.fecha=dateTime;
    }

    public int compareTo(ObjetoUsuario g){
        return Math.toIntExact(ChronoUnit.MINUTES.between(g.getFecha(),this.fecha));

    }

    public LocalDateTime getFecha() {
        return fecha;
    }
    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
    public Objeto getObjeto(){
        return objeto;
    }

    public void setObjeto(Objeto objeto) {
        this.objeto = objeto;
    }
}
