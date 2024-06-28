package AlquilerYRecursos;

public class Sucursal {
    private String ciudad;
    private String direccion;
    private String telefono;

    public Sucursal(String ciudad, String direccion, String telefono) {
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

}
