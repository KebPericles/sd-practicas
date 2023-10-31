import java.rmi.Remote;

public interface ServicioCalculadora extends Remote {
        double sumar(double a, double b) throws java.rmi.RemoteException;
        double restar(double a, double b) throws java.rmi.RemoteException;
        double multiplicar(double a, double b) throws java.rmi.RemoteException;
        double dividir(double a, double b) throws java.rmi.RemoteException;
}
