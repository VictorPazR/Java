
package datos;

import domain.*;
import java.sql.*;
import java.util.*;


public class PersonaDAO {
    private static final String SQL_SELECT = "SELECT id_usuario,username,password FROM test.usuario";
    private static final String SQL_INSERT = "INSERT INTO usuario(username,password) VALUES(?,?)";
    private static final String SQL_UPDATE = "UPDATE test.usuario SET username=?, password=? WHERE id_usuario=?";
    private static final String SQL_DELETE = "DELETE FROM test.usuario WHERE id_usuario=?";
    public List<Persona> seleccionar(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Persona persona = null;
        List<Persona> personas = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idUsuario = rs.getInt("id_usuario");
                String username = rs.getString("username"); 
                String password = rs.getString("password");
                persona = new Persona(idUsuario, username, password);
                personas.add(persona);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(rs);
                Conexion.close(stmt);
                Conexion.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return personas;
    }
    public int insertar(Persona persona){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registro=0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, persona.getUsername());
            stmt.setString(2, persona.getPassword());
            registro = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(stmt);
                Conexion.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registro;
    }
        public int actualizar(Persona persona){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registro=0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, persona.getUsername());
            stmt.setString(2, persona.getPassword());
            stmt.setInt(3, persona.getId_usuario());
            registro = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(stmt);
                Conexion.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registro;
    }
    public int eliminar(Persona persona){
    Connection conn = null;
    PreparedStatement stmt = null;
    int registro=0;
    try {
        conn = Conexion.getConnection();
        stmt = conn.prepareStatement(SQL_DELETE);
        stmt.setInt(1, persona.getId_usuario());
        registro = stmt.executeUpdate();
    } catch (SQLException ex) {
        ex.printStackTrace(System.out);
    } finally {
        try {
            Conexion.close(stmt);
            Conexion.close(conn);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    return registro;
    }
}
