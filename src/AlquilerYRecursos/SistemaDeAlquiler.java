package AlquilerYRecursos;
import TiposDeVehiculos.Camioneta;
import TiposDeVehiculos.CuatroPuertas;
import TiposDeVehiculos.DosPuertas;
import TiposDeVehiculos.Vehiculo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SistemaDeAlquiler
{
    private List<Alquiler> alquileres;
    private List<Vehiculo> vehiculos;
    private List<Cliente> clientes;
    private List<Sucursal> sucursales;

    public SistemaDeAlquiler() {
        alquileres = new ArrayList<>();
        vehiculos = new ArrayList<>();
        clientes = new ArrayList<>();
        sucursales = new ArrayList<>();
    }

    public void agregarVehiculo(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
    }

    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void agregarSucursal(Sucursal sucursal) {
        sucursales.add(sucursal);
    }

    public boolean generarNuevoAlquiler(String dniCliente, String codigoInternoVehiculo, String ciudadInicio, String ciudadFin, Date fechaInicio, Date fechaFin, double kilometrosRecorridos)
    {
        Cliente cliente = buscarClientePorDni(dniCliente);
        Vehiculo vehiculo = buscarVehiculoPorCodigo(codigoInternoVehiculo);
        Sucursal sucursalInicio = buscarSucursalPorCiudad(ciudadInicio);
        Sucursal sucursalFin = buscarSucursalPorCiudad(ciudadFin);

        if (cliente == null || vehiculo == null || sucursalInicio == null || sucursalFin == null || !cliente.isTieneRegistroConducir())
        {
            return false;
        }

        Alquiler nuevoAlquiler = new Alquiler(cliente, vehiculo, sucursalInicio, sucursalFin, fechaInicio, fechaFin, kilometrosRecorridos);
        alquileres.add(nuevoAlquiler);
        return true;
    }

    private Cliente buscarClientePorDni(String dni)
    {
        for (Cliente cliente : clientes)
        {
            if (cliente.getDni().equals(dni))
            {
                return cliente;
            }
        }
        return null;
    }

    private Vehiculo buscarVehiculoPorCodigo(String codigoInterno)
    {
        for (Vehiculo vehiculo : vehiculos)
        {
            if (vehiculo.getCodigoInterno().equals(codigoInterno))
            {
                return vehiculo;
            }
        }
        return null;
    }

    private Sucursal buscarSucursalPorCiudad(String ciudad)
    {
        for (Sucursal sucursal : sucursales)
        {
            if (sucursal.getCiudad().equals(ciudad))
            {
                return sucursal;
            }
        }
        return null;
    }


    public void contarAlquileresPorTipo()
    {
        int dosPuertasCount = 0;
        int cuatroPuertasCount = 0;
        int camionetaCount = 0;

        for (Alquiler alquiler : alquileres)
        {
            if (alquiler.getVehiculo() instanceof DosPuertas)
            {
                dosPuertasCount++;
            } else if (alquiler.getVehiculo() instanceof CuatroPuertas)
            {
                cuatroPuertasCount++;
            } else if (alquiler.getVehiculo() instanceof Camioneta)
            {
                camionetaCount++;
            }
        }

        System.out.println("Cantidad de alquileres por tipo de vehículo:");
        System.out.println("Dos Puertas: " + dosPuertasCount);
        System.out.println("Cuatro Puertas: " + cuatroPuertasCount);
        System.out.println("Camioneta: " + camionetaCount);
    }

    public void mostrarAlquilerMayorCosto()
    {
        if (alquileres.isEmpty())
        {
            System.out.println("No hay alquileres registrados.");
            return;
        }

        Alquiler alquilerMayorCosto = alquileres.get(0);
        for (Alquiler alquiler : alquileres) {
            if (alquiler.calcularCostoTotal() > alquilerMayorCosto.calcularCostoTotal())
            {
                alquilerMayorCosto = alquiler;
            }
        }

        System.out.println("Mayor alquiler:");
        System.out.println("Cliente: " + alquilerMayorCosto.getCliente().getNombreCompleto());
        System.out.println("Vehiculo: " + alquilerMayorCosto.getVehiculo().getModelo());
        System.out.println("Sucursal de inicio: " + alquilerMayorCosto.getSucursalInicio().getCiudad());
        System.out.println("Sucursal de fin: " + alquilerMayorCosto.getSucursalFin().getCiudad());
        System.out.println("Fecha de inicio: " + alquilerMayorCosto.getFechaInicio());
        System.out.println("Fecha de fin: " + alquilerMayorCosto.getFechaFin());
        System.out.println("Kilometros recorridos: " + alquilerMayorCosto.getKilometrosRecorridos());
        System.out.println("Costo total: $" + alquilerMayorCosto.calcularCostoTotal());
    }


}
