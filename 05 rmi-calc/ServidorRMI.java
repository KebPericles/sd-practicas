import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class ServidorRMI {
        public static void main(String[] args) {
                try {
                        ServicioCalculadora servicio = new ServidorCalculadora();

                        // Registro del servicio
                        LocateRegistry.createRegistry(1099);
                        Naming.rebind("Calculadora", servicio);

                        System.out.println("Servidor listo");
                } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                        e.printStackTrace();
                }
        }
}
