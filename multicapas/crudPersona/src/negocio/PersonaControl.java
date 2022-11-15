
package negocio;

import datos.PersonaDAO;
import entidades.Persona;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class PersonaControl {
    
    PersonaDAO datos;
    Persona persona;
    
    DefaultTableModel modelo;
    
    public PersonaControl(){
        datos = new PersonaDAO();
        persona = new Persona();
    }
    
    public String insertar(String ocupacion, String nombre, String apellido, String telefono, String tipodedocumento, String numerodedocumento, String ciudad){
        
        persona.setocupacion(ocupacion);
        persona.setNombre(nombre);
        persona.setApellido(apellido);
        persona.setTelefono(telefono);
        persona.settipodedocumento(tipodedocumento);
        persona.setnumerodedocumento(numerodedocumento);
        persona.setciudad(ciudad);
        
        if (datos.insertar(persona)) {
            return "OK";
        }else{
            return "Ocurrio un error en el registro";
        }
    }
    
    public DefaultTableModel mostrar(){
        List<Persona> lista = new ArrayList<>();
        
        lista.addAll(datos.listar());
        
        String[] title = {"ocupacion", "Nombre", "Apellido", "Telefono", "tipodedocumento", "numerodedocumento", "ciudad"};
        modelo = new DefaultTableModel(null, title);
        
        String[] registro = new String[6];
        
        lista.stream().map(item -> {
            registro[1] = item.getocupacion();
            return item;
        }).map(item -> {
            registro[2] = item.getNombre();
            return item;
        }).map(item -> {
            registro[3] = item.getApellido();
            return item;
        }).map(item -> {
            registro[4] = item.getTelefono();
            return item;
        }).map(item -> {
            registro[5] = item.gettipodedocumento();
            return item;
        }).map(item -> {
            registro[6] = item.getnumerodedocumento();
            return item;
        }).map(item -> {
            registro[4] = item.getciudad();
            return item;
        }).forEachOrdered(_item -> {
            modelo.addRow(registro);
        });
        
        return modelo;
        
    }
    
    public Persona buscar(String Nombre){
        persona = datos.buscar(Nombre);
        return persona;
    }
    
    public String actualizar(Persona persona){
        if (datos.actualizar(persona)) {
            return "OK";
        }else{
            return "Ocurrio un error al actualizar";
        }
    }
    
    public String eliminar(String Nombre){
        if (datos.eliminar(Nombre)) {
            return "OK";
        }else{
            return "Ocurrio un error al eliminar";
        }
    }
    
}
