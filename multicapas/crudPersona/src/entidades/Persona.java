
package entidades;

public class Persona {
    
    private String ocupacion;
    private String nombre;
    private String apellido;
    private String telefono;
    private String tipodedocumento;
    private String numerodedocumento;
    private String ciudad;

    public Persona() {
    }

    public Persona( String ocupacion, String nombre, String apellido, String telefono, String tipodedocumento, String numerodedocumento, String ciudad) {
  
        this.ocupacion = ocupacion;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.tipodedocumento = tipodedocumento;
        this.numerodedocumento = numerodedocumento;
        this.ciudad = ciudad;
       
    }


    public String getocupacion() {
        return ocupacion;
    }

    public void setDni(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public String gettipodedocumento() {
        return tipodedocumento;
    }

    public void settipodedocumento(String tipodedocumento) {
        this.tipodedocumento = tipodedocumento;
    }
    
    public String getnumerodedocumento() {
        return numerodedocumento;
    }

    public void setnumerodedocumento(String numerodedocumento) {
        this.numerodedocumento = numerodedocumento;
    }
    public String getciudad() {
        return ciudad;
    }

    public void setciudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setocupacion(String ocupacion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
