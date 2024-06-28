package AlquilerYRecursos;

import java.util.Date;
import TiposDeVehiculos.Vehiculo;

public class Alquiler {
    private Cliente cliente;
    private Vehiculo vehiculo;
    private Sucursal sucursalInicio;
    private Sucursal sucursalFin;
    private Date fechaInicio;
    private Date fechaFin;
    private double kilometrosRecorridos;

    //Constante porque el precio no cambia
    private static final double COSTO_POR_KM = 50.0;

    public Alquiler(Cliente cliente, Vehiculo vehiculo, Sucursal sucursalInicio, Sucursal sucursalFin, Date fechaInicio, Date fechaFin, double kilometrosRecorridos) {
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.sucursalInicio = sucursalInicio;
        this.sucursalFin = sucursalFin;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.kilometrosRecorridos = kilometrosRecorridos;
        vehiculo.incrementarKilometraje(kilometrosRecorridos);
    }

    public double calcularCostoTotal()
    {
        long diasRentado = (fechaFin.getTime() - fechaInicio.getTime()) / (1000 * 60 * 60 * 24);
        double costoDias = diasRentado * vehiculo.getTarifaPorDia();
        double costoKilometros = kilometrosRecorridos * COSTO_POR_KM;
        return costoDias + costoKilometros;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public Sucursal getSucursalInicio() {
        return sucursalInicio;
    }

    public Sucursal getSucursalFin() {
        return sucursalFin;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public double getKilometrosRecorridos() {
        return kilometrosRecorridos;
    }

    @Override
    public String toString() {
        return "Alquiler{" +
                "cliente=" + cliente +
                ", vehiculo=" + vehiculo +
                ", sucursalInicio=" + sucursalInicio +
                ", sucursalFin=" + sucursalFin +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                ", kilometrosRecorridos=" + kilometrosRecorridos +
                '}';
    }
}
