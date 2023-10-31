import java.rmi.Naming;

public class ClienteRMI {
        private interface DoSomething {

                double doSomething(double a, double b) throws java.rmi.RemoteException;
        }

        public static void main(String[] args) {
                try {
                        ServicioCalculadora servicio = (ServicioCalculadora) Naming
                                        .lookup("rmi://localhost/Calculadora");
                        System.out.println("Conectado al servidor");

                        int opcion = 0;

                        while ((opcion = menu()) != 0) {
                                DoSomething miOperacion;
                                switch (opcion) {
                                        case 1:
                                                miOperacion = (a, b) -> servicio.sumar(a, b);
                                                break;
                                        case 2:
                                                miOperacion = (a, b) -> servicio.restar(a, b);
                                                break;
                                        case 3:
                                                miOperacion = (a, b) -> servicio.multiplicar(a, b);
                                                break;
                                        case 4:
                                                miOperacion = (a, b) -> servicio.dividir(a, b);
                                                break;
                                        default:
                                                miOperacion = null;
                                                break;
                                }

                                if (miOperacion == null) {
                                        continue;
                                }

                                System.out.println("Introduce el primer numero");
                                double a = Double.parseDouble(System.console().readLine());

                                System.out.println("Introduce el segundo numero");
                                double b = Double.parseDouble(System.console().readLine());

                                double resultado = miOperacion.doSomething(a, b);

                                imprimirResultado(resultado);
                        }

                } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                        e.printStackTrace();
                }
        }

        private static int menu() {
                System.out.println("1. Sumar");
                System.out.println("2. Restar");
                System.out.println("3. Multiplicar");
                System.out.println("4. Dividir");
                System.out.println("0. Salir");

                int opcion = 0;

                try {
                        opcion = Integer.parseInt(System.console().readLine());
                } catch (NumberFormatException e) {
                        System.out.println("Introduce solo numeros");
                }

                return opcion;
        }

        private static void imprimirResultado(double resultado) {
                System.out.println("----------------------------------");
                System.out.println("El resultado es: " + resultado);
                System.out.println("----------------------------------");
                System.out.println("");
        }
}