package com.ale.abcapiimplementation.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RequestedNewsData {

    LocalDateTime fecha;
    String enlace;
    String enlace_foto;
    String titulo;
    String resumen;
    String contenido_foto;
    String content_type_foto;

    public RequestedNewsData(String fecha, String enlace, String enlace_foto, String titulo, String resumen) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MMM dd, yyyy");
        LocalDate localDate = LocalDate.parse(fecha, dateFormatter);
        this.fecha = localDate.atStartOfDay();
        this.enlace = "https://www.abc.com.py"+enlace;
        this.enlace_foto = "https://www.abc.com.py"+enlace_foto;
        this.titulo = titulo;
        this.resumen = resumen;
        this.contenido_foto = contenido_foto;
        this.content_type_foto = content_type_foto;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getEnlace() {
        return enlace;
    }

    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }

    public String getEnlace_foto() {
        return enlace_foto;
    }

    public void setEnlace_foto(String enlace_foto) {
        this.enlace_foto = enlace_foto;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public String getContenido_foto() {
        return contenido_foto;
    }

    public void setContenido_foto(String contenido_foto) {
        this.contenido_foto = contenido_foto;
    }

    public String getContent_type_foto() {
        return content_type_foto;
    }

    public void setContent_type_foto(String content_type_foto) {
        this.content_type_foto = content_type_foto;
    }

    @Override
    public String toString() {
        return "NewsMetaData{" +
                "fecha=" + fecha +
                ", enlace='" + enlace + '\'' +
                ", enlace_foto='" + enlace_foto + '\'' +
                ", titulo='" + titulo + '\'' +
                ", resumen='" + resumen + '\'' +
                ", contenido_foto='" + contenido_foto + '\'' +
                ", content_type_foto='" + content_type_foto + '\'' +
                '}';
    }

    public String toText() {
        return String.format(
                """
                Titulo: %s
                Fecha: %s
                Resumen: %s
                Enlace: %s
                """, titulo, fecha, resumen, enlace);
    }


    public String toHtml() {
        return String.format(
                """
                <div>
                <p><b>Titulo:</b> %s </p>
                <p><b>Fecha:</b> %s </p>
                <p><b>Resumen:</b> %s </p>
                <p><b>Enlace:</b> %s </p>
                </div>
                """, titulo, fecha, resumen, enlace);
    }
}
