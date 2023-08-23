package grafo.aydacencia;

import java.util.ArrayList;
import java.util.Stack;

public class GrafoAdcia {
	
	int numVerts;
	static int maxVerts = 20;
	VerticeAdy [] tablAdc;
	
	public GrafoAdcia(int mx) {
		tablAdc = new VerticeAdy[mx];
		numVerts = 0;
		maxVerts = mx;
	}
	
	private Arco buscarLista(ArrayList<Arco> lista, int destino) {
        for (Arco arco : lista) {
            if (arco.destino == destino) {
                return arco;
            }
        }
        return null;
    }
	
	// Agregar la m�todo que permite agregar un nuevo v�rtice	
	/*
	 * A�ade un nuevo v�rtice a la lista directorio. Si el v�rtice ya est� en la tabla no hace nada, 
	 * devuelve control; si es nuevo, se asigna a continuaci�n del �ltimo. 
	 */
	public void nuevoVertice(String nombre) {
        if (numVerts < maxVerts) {
            VerticeAdy v = new VerticeAdy(nombre);
            v.asigVert(numVerts);
            tablAdc[numVerts++] = v;
        } else {
            System.out.println("Número máximo de vértices alcanzado");
        }
    }
	
	//Agregar m�todo que permite agregar un nuevo arco
	/*
	 * Esta operaci�n da entrada a un arco del grafo. El m�todo tiene como entrada el v�rtice origen y el 
	 * v�rtice destino. El m�todo adyacente() determina si la arista ya est� en la lista de adyacencia, 
	 * y, por �ltimo, el Arco se inserta en la lista de adyacencia del nodo origen. 
	 * La inserci�n se hace como primer nodo para que el tiempo sea constante, O(1). 
	 * Otra versi�n del m�todo recibe, directamente, los n�meros de v�rtices que forman los extremos del arco. 
	 * ara a�adir una arista en un grafo valorado, se debe asignar el factor de peso al crear el Arco.
	 */
	public void nuevoArco(int origen, int destino, double peso) {
        if (origen >= 0 && origen < numVerts && destino >= 0 && destino < numVerts) {
            if (!adyacente(origen, destino)) {
                tablAdc[origen].lad.add(new Arco(destino, peso));
            }
        } else {
            System.out.println("Vértices inválidos");
        }
    }
	
	//Agregar un m�todo que determina si dos v�rtices son adyacentes
	/*
	 * La operaci�n determina si dos v�rtices, v1 y v2, forman un arco. En definitiva, 
	 * si el v�rtice v2 est� en la lista de adyacencia de v1. 
	 * El m�todo buscarLista() devuelve la direcci�n del nodo que contiene al arco, si no est� devuelve null. 
	 */
	public boolean adyacente(int origen, int destino) {
        if (origen >= 0 && origen < numVerts && destino >= 0 && destino < numVerts) {
            return buscarLista(tablAdc[origen].lad, destino) != null;
        } else {
            System.out.println("Vértices inválidos");
            return false;
        }
    }
	
	//MEtodo de recorrido en profundidad con comentarios de cada linea sobre la complejidad y notacion O grande
    public void recorridoProfundidad(int inicio) {
        boolean[] visitados = new boolean[numVerts]; // O(V) en espacio
        Stack<Integer> pila = new Stack<>(); // O(V) en espacio
        
        pila.push(inicio);
        
        while (!pila.isEmpty()) {
            int actual = pila.pop(); 
            if (!visitados[actual]) { // Operación de tiempo constante
                visitados[actual] = true; // Operación de tiempo constante
                System.out.println("Visitando vértice: " + tablAdc[actual].nomVertice()); // Operación de tiempo constante
                
                ArrayList<Arco> listaAdy = tablAdc[actual].lad;
                for (Arco arco : listaAdy) {
                    if (!visitados[arco.destino]) {
                        pila.push(arco.destino); // Operación de tiempo constante
                    }
                }
            }
        }
    }

}
