package TiposDeVehiculos;

public abstract class Vehiculo {
    private String modelo;
    private double kilometraje;
    private Integer año;
    private String codigoInterno;
    private double tarifaPorDia;

    public Vehiculo(String modelo, double kilometraje, Integer año, String codigoInterno, double tarifaPorDia)
    {
        this.modelo = modelo;
        this.kilometraje = kilometraje;
        this.año = año;
        this.codigoInterno = codigoInterno;
        this.tarifaPorDia = tarifaPorDia;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setAño(Integer año) {
        this.año = año;
    }

    public void setCodigoInterno(String codigoInterno) {
        this.codigoInterno = codigoInterno;
    }

    public void setTarifaPorDia(double tarifaPorDia) {
        this.tarifaPorDia = tarifaPorDia;
    }

    public String getModelo() {
        return modelo;
    }

    public double getKilometraje() {
        return kilometraje;
    }

    public int getAño() {
        return año;
    }

    public String getCodigoInterno() {
        return codigoInterno;
    }

    public double getTarifaPorDia() {
        return tarifaPorDia;
    }


    public void incrementarKilometraje(double kilometros)
    {
        this.kilometraje += kilometros;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "modelo='" + modelo + '\'' +
                ", kilometraje=" + kilometraje +
                ", año=" + año +
                ", codigoInterno='" + codigoInterno + '\'' +
                ", tarifaPorDia=" + tarifaPorDia +
                '}';
    }
}






