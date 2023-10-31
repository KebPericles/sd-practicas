import java.rmi.server.UnicastRemoteObject;

public class ServidorCalculadora extends UnicastRemoteObject implements ServicioCalculadora {
        public ServidorCalculadora() throws java.rmi.RemoteException {
                super();
        }

        public double sumar(double a, double b) throws java.rmi.RemoteException {
                return a + b;
        }

        public double restar(double a, double b) throws java.rmi.RemoteException {
                return a - b;
        }

        public double multiplicar(double a, double b) throws java.rmi.RemoteException {
                return a * b;
        }

        public double dividir(double a, double b) throws java.rmi.RemoteException {
                return a / b;
        }
}
