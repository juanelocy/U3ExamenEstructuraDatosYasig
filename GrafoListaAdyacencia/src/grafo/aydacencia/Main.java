package grafo.aydacencia;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la cantidad máxima de vértices: ");
        int maxVertices = scanner.nextInt();
        
        GrafoAdcia grafo = new GrafoAdcia(maxVertices);
        
        while (true) {
        	System.out.println("---------------------------------");
            System.out.println("1. Agregar vértice");
            System.out.println("2. Agregar arco");
            System.out.println("3. Verificar adyacencia");
            System.out.println("4. Aplicar profundidad");            
            System.out.println("5. Salir");
            System.out.println("---------------------------------");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre de la ciudad: ");
                    scanner.nextLine(); // Consumir la nueva línea pendiente
                    String nombreCiudad = scanner.nextLine();
                    grafo.nuevoVertice(nombreCiudad);
                    System.out.println("Ciudad agregada: " + nombreCiudad);
                    System.out.println("---------------------------------");
                    break;
                case 2:
                	System.out.println("AVISO: tomar en cuenta que comienza desde 0");
                    System.out.print("Ingrese el índice del vértice origen: ");
                    int origen = scanner.nextInt();
                    System.out.print("Ingrese el índice del vértice destino: ");
                    int destino = scanner.nextInt();
                    System.out.print("Ingrese el peso del arco: ");
                    double peso = scanner.nextDouble();
                    grafo.nuevoArco(origen, destino, peso);
                    System.out.println("Arco agregado de " + origen + " a " + destino + " con peso " + peso);
                    System.out.println("---------------------------------");
                    break;
                case 3:
                    System.out.print("Ingrese el índice del vértice origen: ");
                    int v1 = scanner.nextInt();
                    System.out.print("Ingrese el índice del vértice destino: ");
                    int v2 = scanner.nextInt();
                    boolean adyacente = grafo.adyacente(v1, v2);
                    System.out.println("¿Vértices " + v1 + " y " + v2 + " son adyacentes? " + adyacente);
                    System.out.println("---------------------------------");
                    break;
                case 4:
                	System.out.print("Ingrese el índice del vértice de inicio para DFS: ");
                    int inicioProfundidad = scanner.nextInt();
                    
                    System.out.println("Recorrido DFS desde el vértice " + inicioProfundidad + ":");
                    grafo.recorridoProfundidad(inicioProfundidad);
                    scanner.close();
                 
                case 5:
                	System.out.println("Saliendo...");
                    
                	System.exit(0);
                	break;
                    
                default:
                    System.out.println("Opción inválida");
                    break;
            }
        }
    }
}