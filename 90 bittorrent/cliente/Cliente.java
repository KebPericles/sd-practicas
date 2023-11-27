package cliente;

/**
 * Cliente
 */
public class Cliente {

        public static void main(String[] args) {
                System.out.println("Iniciando Cliente...");

                System.out.println("Leyendo archivos compartidos...");
                System.out.println("Creando lista de archivos compartidos...");

                System.out.println("Leyendo trackers de los archivos compartidos...");
                System.out.println("Creando lista de trackers de los archivos compartidos...");
                System.out.println("Anunciandose a los trackers...");

                System.out.println("Filtrando lista de archivos con piezas incompletas...");
                System.out.println("Solicitando lista de peers de los archivos incompletos a los trackers...");
                System.out.println("Seleccionando peers de la lista de peers de los archivos incompletos...");
                System.out.println("Conectando con los peers...");
                System.out.println("Solicitando piezas a los peers...");

                menu();
        }

        private static int menu() {
                
        }
}