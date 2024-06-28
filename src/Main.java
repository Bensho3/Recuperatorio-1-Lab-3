import java.util.Calendar;
import java.util.Date;
import AlquilerYRecursos.*;
import TiposDeVehiculos.Camioneta;
import TiposDeVehiculos.CuatroPuertas;
import TiposDeVehiculos.DosPuertas;
import TiposDeVehiculos.Vehiculo;

public class Main {
    public static void main(String[] args)
    {
        SistemaDeAlquiler sistema = new SistemaDeAlquiler();

        // Crear sucursales

        Sucursal sucursal1 = new Sucursal("Mar del Plata", "Av Colon 123", "1242455212");
        Sucursal sucursal2 = new Sucursal("Usuhaia", "No se calles de Usuahia 321", "03245122525");
        sistema.agregarSucursal(sucursal1);
        sistema.agregarSucursal(sucursal2);

        // Crear vehículos

        Vehiculo vehiculo1 = new DosPuertas("Mazda Miata", 10000, 1994, "miatita", 300);

        Vehiculo vehiculo2 = new CuatroPuertas("Alfa Romeo Giulia", 23124, 2023, "giuli", 500);

        Vehiculo vehiculo3 = new Camioneta("Ford Ranger", 30000, 2018, "ranger", 700);

        sistema.agregarVehiculo(vehiculo1);
        sistema.agregarVehiculo(vehiculo2);
        sistema.agregarVehiculo(vehiculo3);

        // Crear clientes

        Cliente cliente1 = new Cliente("Fernando Alonso", "333333333", true);

        //Me cae mal y no le di el registro
        Cliente cliente2 = new Cliente("Esteban Ocon", "000000000001", false);

        sistema.agregarCliente(cliente1);
        sistema.agregarCliente(cliente2);

        // Crear fechas alquileres

        Calendar cal = Calendar.getInstance();

        cal.set(2024, Calendar.JUNE, 1);
        Date fechaInicio1 = cal.getTime();

        cal.set(2024, Calendar.JUNE, 10);
        Date fechaFin1 = cal.getTime();

        cal.set(2024, Calendar.JULY, 1);
        Date fechaInicio2 = cal.getTime();
        cal.set(2024, Calendar.JULY, 15);
        Date fechaFin2 = cal.getTime();

        // Generar algunos alquileres
        boolean alquiler1 = sistema.generarNuevoAlquiler(cliente1.getDni(), vehiculo1.getCodigoInterno(), sucursal1.getCiudad(), sucursal2.getCiudad(), fechaInicio1, fechaFin1, 100);
        boolean alquiler2 = sistema.generarNuevoAlquiler(cliente2.getDni(), vehiculo3.getCodigoInterno(), sucursal2.getCiudad(), sucursal1.getCiudad(), fechaInicio2, fechaFin2, 200);

        //Mostrar alquileres
        if (alquiler1)
        {
            System.out.println("Alquiler 1 generado exitosamente.");
        }
        else
        {
            System.out.println("Error en alquiler 1.");
        }

        if (alquiler2)
        {
            System.out.println("Alquiler 2 generado exitosamente.");
        } else
        {
            System.out.println("Error en alquiler 2.");
        }

        // Mostrar alquiler con mayor costo
        sistema.mostrarAlquilerMayorCosto();

        // Mostrar cantidad de alquileres por tipo de vehículo
        sistema.contarAlquileresPorTipo();
    }
}

