/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Cancion;
import modelo.Usuario;
import vista.YourMusicApp;

/**
 *
 * @author alejandroo
 */
public class Registro {

    //agregar a BD
    public boolean agregarUsuario(Usuario usua) {

        try {
            Conexion conexion1 = new Conexion();
            Connection cnx = conexion1.obtenerConexion();

            String query = "INSERT INTO Usuario(nombreUsuario, email) VALUES (?,?)";
            PreparedStatement stmt = cnx.prepareStatement(query);

            stmt.setString(1, usua.getNombreUsuario());
            stmt.setString(2, usua.getEmail());

            stmt.executeUpdate(); //insert
            stmt.close();
            cnx.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Error SQL al agregar Usuario" + e.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("Error al agregar Usuario" + e.getMessage());
            return false;
        }
    }
public boolean eliminarUsuario(String email) {
        
        try {
            Conexion conexion1 = new Conexion();
            Connection cnx = conexion1.obtenerConexion();

            String query = "DELETE FROM Usuario WHERE email = ?";
            PreparedStatement stmt = cnx.prepareStatement(query);

            stmt.setString(1, email);

            stmt.executeUpdate(); 
            stmt.close();
            cnx.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Error SQL al borra Usuario" + e.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("Error al borra Usuario" + e.getMessage());
            return false;
        }
        
   }
    public List<Usuario> buscarTodosUsuarios() {
        List<Usuario> lista = new ArrayList<>();

        try {
            Conexion conexion1 = new Conexion();
            Connection cnx = conexion1.obtenerConexion();

            String query = "SELECT nombreUsuario, email FROM Usuario order by nombreUsuario";
            PreparedStatement stmt = cnx.prepareStatement(query);

            ResultSet rs = stmt.executeQuery();//select

            while (rs.next()) {
                Usuario user = new Usuario();

                user.setNombreUsuario(rs.getString("nombreUsuario"));
                user.setEmail(rs.getString("email"));
                

                lista.add(user);
            }
            rs.close();
            stmt.close();
            cnx.close();
        } catch (SQLException e) {
            System.out.println("Error SQL al listar Usuarios " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error al listar Usuarios " + e.getMessage());
        }
        return lista;
    }
    //Buscar Usuario email
    public List<Usuario> buscarUsuarioEmail(String email) {
        List<Usuario> lista = new ArrayList<>();

        try {
            Conexion conexion2 = new Conexion();
            Connection cnx = conexion2.obtenerConexion();

            String query = "SELECT email FROM Usuario WHERE email = ? order by nombreUsuario";
            PreparedStatement stmt = cnx.prepareStatement(query);

            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();//select

            if (rs.next()) {
                Usuario user = new Usuario();

                user.setEmail(rs.getString("email"));

                lista.add(user);
            }
            rs.close();
            stmt.close();
            cnx.close();
        } catch (SQLException e) {
            System.out.println("Error SQL al buscar email de Usuario " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error al buscar email de Usuario " + e.getMessage());
        }
        return lista;
    }

    //Buscar Nombre Usuario
    public List<Usuario> buscarNombreUsuario(String nombreUsuario) {
        List<Usuario> lista = new ArrayList<>();

        try {
            Conexion conexion2 = new Conexion();
            Connection cnx = conexion2.obtenerConexion();

            String query = "SELECT nombreUsuario FROM Usuario WHERE nombreUsuario = ? order by nombreUsuario";
            PreparedStatement stmt = cnx.prepareStatement(query);

            stmt.setString(1, nombreUsuario);
            ResultSet rs = stmt.executeQuery();//select

            if (rs.next()) {
                Usuario user = new Usuario();

                user.setNombreUsuario(rs.getString("nombreUsuario"));

                lista.add(user);
            }
            rs.close();
            stmt.close();
            cnx.close();
        } catch (SQLException e) {
            System.out.println("Error SQL al buscar nombre de Usuario " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error al buscar nombre de Usuario " + e.getMessage());
        }
        return lista;
    }

    
    //Agregar en DB
    public boolean agregarCancion(Cancion canci) {

        try {
            Conexion conexion1 = new Conexion();
            Connection cnx = conexion1.obtenerConexion();

            String query = "INSERT INTO Cancion(nombreCancion, estilo, artistaCancion, album, archivoCancion) VALUES (?,?,?,?,?)";
            PreparedStatement stmt = cnx.prepareStatement(query);

            stmt.setString(1, canci.getNombreCancion());
            stmt.setString(2, canci.getEstilo());
            stmt.setString(3, canci.getArtistaCancion());
            stmt.setString(4, canci.getAlbum());
            stmt.setString(5, canci.getArchivoCancion());

            stmt.executeUpdate(); //insert
            stmt.close();
            cnx.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Error SQL al agregar Cancion" + e.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("Error al agregar Cancion" + e.getMessage());
            return false;
        }
    }

    //listar todos
    public List<Cancion> buscarTodasCanciones() {
        List<Cancion> lista = new ArrayList<>();

        try {
            Conexion conexion1 = new Conexion();
            Connection cnx = conexion1.obtenerConexion();

            String query = "SELECT nombreCancion, estilo, artistaCancion, album, archivoCancion FROM Cancion order by nombreCancion";
            PreparedStatement stmt = cnx.prepareStatement(query);

            ResultSet rs = stmt.executeQuery();//select

            while (rs.next()) {
                Cancion can = new Cancion();

                can.setNombreCancion(rs.getString("nombreCancion"));
                can.setEstilo(rs.getString("estilo"));
                can.setArtistaCancion(rs.getString("artistaCancion"));
                can.setAlbum(rs.getString("album"));
                can.setArchivoCancion(rs.getString("archivoCancion"));

                lista.add(can);
            }
            rs.close();
            stmt.close();
            cnx.close();
        } catch (SQLException e) {
            System.out.println("Error SQL al listar Canciones " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error al listar Canciones " + e.getMessage());
        }
        return lista;
    }

    //listar filtro
    public List<Cancion> buscarCancionesEstilo(String estilo) {
        List<Cancion> lista = new ArrayList<>();

        try {
            Conexion conexion1 = new Conexion();
            Connection cnx = conexion1.obtenerConexion();

            String query = "SELECT nombreCancion, estilo, artistaCancion, album, archivoCancion FROM Cancion WHERE estilo = ? order by nombreCancion";
            PreparedStatement stmt = cnx.prepareStatement(query);

            stmt.setString(1, estilo);
            ResultSet rs = stmt.executeQuery();//select

            while (rs.next()) {
                Cancion can = new Cancion();

                can.setNombreCancion(rs.getString("nombreCancion"));
                can.setEstilo(rs.getString("estilo"));
                can.setArtistaCancion(rs.getString("artistaCancion"));
                can.setAlbum(rs.getString("album"));
                can.setArchivoCancion(rs.getString("archivoCancion"));

                lista.add(can);
            }
            rs.close();
            stmt.close();
            cnx.close();
        } catch (SQLException e) {
            System.out.println("Error SQL al listar Canciones " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error al listar Canciones " + e.getMessage());
        }
        return lista;
    }

    //Buscar NombreCancion
    public List<Cancion> buscarNombreCancion(String cancion) {
        List<Cancion> lista = new ArrayList<>();

        try {
            Conexion conexion2 = new Conexion();
            Connection cnx = conexion2.obtenerConexion();

            String query = "SELECT nombreCancion FROM Cancion WHERE nombreCancion = ? order by nombreCancion";
            PreparedStatement stmt = cnx.prepareStatement(query);

            stmt.setString(1, cancion);
            ResultSet rs = stmt.executeQuery();//select

            if (rs.next()) {
                Cancion can = new Cancion();

                can.setNombreCancion(rs.getString("nombreCancion"));

                lista.add(can);
            }
            rs.close();
            stmt.close();
            cnx.close();
        } catch (SQLException e) {
            System.out.println("Error SQL al buscar nombre de la cancion" + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error al buscar nombre de la cancion " + e.getMessage());
        }
        return lista;
    }

    public List<Cancion> buscarArtistaCancion(String artist) {
        List<Cancion> lista = new ArrayList<>();

        try {
            Conexion conexion2 = new Conexion();
            Connection cnx = conexion2.obtenerConexion();

            String query = "SELECT artistaCancion FROM Cancion WHERE artistaCancion = ? order by nombreCancion";
            PreparedStatement stmt = cnx.prepareStatement(query);

            stmt.setString(1, artist);
            ResultSet rs = stmt.executeQuery();//select

            if (rs.next()) {
                Cancion can = new Cancion();

                can.setArtistaCancion(rs.getString("artistaCancion"));

                lista.add(can);
            }
            rs.close();
            stmt.close();
            cnx.close();
        } catch (SQLException e) {
            System.out.println("Error SQL al buscar nombre del artista" + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error al buscar nombre del artista" + e.getMessage());
        }
        return lista;
    }

    //Eliminar Canción
    public boolean eliminarCancion(String canci) {

        try {
            Conexion conexion1 = new Conexion();
            Connection cnx = conexion1.obtenerConexion();

            String query = "DELETE FROM Cancion WHERE nombreCancion = ?";
            PreparedStatement stmt = cnx.prepareStatement(query);

            stmt.setString(1, canci);

            stmt.executeUpdate(); //insert
            stmt.close();
            cnx.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Error SQL al borra Cancion" + e.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("Error al borra Cancion" + e.getMessage());
            return false;
        }

    }

    //Archivo audio
    public List<Cancion> buscarArchivoCancion(String archivo) {
        List<Cancion> lista = new ArrayList<>();

        try {
            Conexion conexion2 = new Conexion();
            Connection cnx = conexion2.obtenerConexion();

            String query = "SELECT archivoCancion FROM Cancion WHERE archivocancion = ? order by nombreCancion";
            PreparedStatement stmt = cnx.prepareStatement(query);

            stmt.setString(1, archivo);
            ResultSet rs = stmt.executeQuery();//select

            if (rs.next()) {
                Cancion can = new Cancion();

                can.setArchivoCancion(rs.getString("archivoCancion"));

                lista.add(can);
            }
            rs.close();
            stmt.close();
            cnx.close();
        } catch (SQLException e) {
            System.out.println("Error SQL al buscar archivo de la cancion" + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error al buscar archivo de la cancion " + e.getMessage());
        }
        return lista;
    }
}
