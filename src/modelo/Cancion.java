/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author alejandroo
 */
public class Cancion {

    private String nombreCancion;
    private String estilo;
    private String artistaCancion;
    private String album;
    private String archivoCancion;

    public Cancion() {
    }

    public Cancion(String nombreCancion, String estilo, String artistaCancion, String album, String archivoCancion) {

        this.nombreCancion = nombreCancion;
        this.estilo = estilo;
        this.artistaCancion = artistaCancion;
        this.album = album;
        this.archivoCancion = archivoCancion;
    }

    public String getNombreCancion() {
        return nombreCancion;
    }

    public void setNombreCancion(String nombreCancion) {
        this.nombreCancion = nombreCancion;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public String getArtistaCancion() {
        return artistaCancion;
    }

    public void setArtistaCancion(String artistaCancion) {
        this.artistaCancion = artistaCancion;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getArchivoCancion() {
        return archivoCancion;
    }

    public void setArchivoCancion(String archivoCancion) {
        this.archivoCancion = archivoCancion;
    }

}
