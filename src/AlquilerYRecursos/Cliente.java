package AlquilerYRecursos;

public class Cliente {
    private String nombreCompleto;
    private String dni;
    private boolean tieneRegistroConducir;

    public Cliente(String nombreCompleto, String dni, boolean tieneRegistroConducir) {
        this.nombreCompleto = nombreCompleto;
        this.dni = dni;
        this.tieneRegistroConducir = tieneRegistroConducir;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public boolean isTieneRegistroConducir()
    {
        return tieneRegistroConducir;
    }

}