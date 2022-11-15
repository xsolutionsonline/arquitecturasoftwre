package datos;

import datos.interfaces.PersonaInterface;
import entidades.Persona;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PersonaDAO implements PersonaInterface {

    PreparedStatement ps;
    ResultSet rs;

    @Override
    public boolean insertar(Persona obj) {

        boolean resp = false;

        try {
            String sql = "insert into persona(ocupacion, nombre, apellido, telefono, tipodedocumento, numerodedocumento, ciudad) values(?, ?, ?, ?, ?)";

            ps = Conexion.getConexion().prepareStatement(sql);
            ps.setString(1, obj.getocupacion());
            ps.setString(2, obj.getNombre());
            ps.setString(3, obj.getApellido());
            ps.setString(4, obj.getTelefono());
            ps.setString(5, obj.gettipodedocumento());
            ps.setString(6, obj.getnumerodedocumento());
            ps.setString(7, obj.getciudad());

            if (ps.executeUpdate() > 0) {
                resp = true;
            }
            ps.close();
            Conexion.cerrarConexion();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return resp;
    }

    @Override
    public List<Persona> listar() {

        List<Persona> registros = new ArrayList<>();

        try {
            String consulta = "select * from persona";
            ps = Conexion.getConexion().prepareStatement(consulta);

            rs = ps.executeQuery();

            while (rs.next()) {
                
                String ocupacion = rs.getString(1);
                String nombre = rs.getString(2);
                String apellido = rs.getString(3);
                String telefono = rs.getString(4);
                String tipodedocumento = rs.getString(5);
                String numerodedocumento = rs.getString(6);
                String ciudad = rs.getString(7);

                registros.add(new Persona(ocupacion, nombre, apellido, telefono, tipodedocumentacion, nuemrodedocumentacion, cedula));
            }

            rs.close();
            ps.close();
            Conexion.cerrarConexion();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return registros;
    }

    @Override
    public Persona buscar(String ocupacion) {

        Persona persona = null;

        try {
            String consulta = "select * from persona where ocupacion = ?";

            ps = Conexion.getConexion().prepareStatement(consulta);
            ps.setString(1, ocupacion);
            rs = ps.executeQuery();

            if (rs.next()) {
                
                String ocupacin = rs.getString(1);
                String nombre = rs.getString(2);
                String apellido = rs.getString(3);
                String telefono = rs.getString(4);
                String tipodedocumento = rs.getString(5);
                String numerodedocumento = rs.getString(6);
                String ciudad = rs.getString(7);
                String numerodecedula = null;
                
                persona = new Persona(ocupacion, nombre, apellido, telefono, tipodedocumento, numerodecedula, ciudad);
            }
            
            rs.close();
            ps.close();
            Conexion.cerrarConexion();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return persona;
    }

    @Override
    public boolean actualizar(Persona obj) {
       
        boolean resp = false;
        
        try {
            String update = "update persona set ocupacion =?, nombre =?, apellido = ?, telefono = ?, tipodedocumento = ?, numerodedocumento = ?, ciudad = ?";
            
            ps = Conexion.getConexion().prepareStatement(update);
            ps.setString(1, obj.getocupacion());
            ps.setString(2, obj.getNombre());
            ps.setString(3, obj.getApellido());
            ps.setString(4, obj.getTelefono());
            ps.setString(5, obj.gettipodedocumento());
            ps.setString(6, obj.getnumerodedocumento());
            ps.setString(7, obj.getciudad());
            
            
            
            if (ps.executeUpdate()>0) {
                resp = true;
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return resp;
    }

    @Override
    public boolean eliminar(String dni) {
        boolean resp = false;
        
        try {
            String delete = "delete from persona where nombre = ?";
            ps = Conexion.getConexion().prepareStatement(delete);
            ps.setString(1, nombre);
            
            
            if (ps.executeUpdate()>0) {
                resp = true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return resp;
        
    }

}
