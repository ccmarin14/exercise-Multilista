package MultiLista;

public class ListaLigada {
    private int cantidad = 0;
    private Nodo cab, aux, actual;

    //Constructor
    public ListaLigada() {
    	cab = null;
    }

    public void addEstudiante(Estudiante alumno) {
    	Nodo nuevo = new Nodo(alumno);
        auxAdd(nuevo);
    }

    public void addCarrera(Carrera curso) {
        Nodo nuevo = new Nodo(curso);
        auxAdd(nuevo);
    }

    public void addEstudiante(ListaLigada estudiantes) {
    	Nodo nuevo = new Nodo(estudiantes);
        auxAdd(nuevo);
    }

    public void auxAdd(Nodo nuevo) {
        nuevo.setLiga(cab);
        cab = nuevo;
        actual = cab;
        cantidad ++;
    }
    
    public boolean listaVacia() {
        if (cab == null) {
            return true;
        } else {
            return false;
        }
    }

    public int size() {
        return cantidad;
    }

    public Nodo recorrerLista() {
        if (actual == null) {
            actual = cab;
            aux = null;
	    } else { 
            aux = actual;
            actual = actual.getLiga();
        }
        return aux;
    }

    public void eliminarNodo(Nodo selecion) {
        Nodo aux = cab;
        if (selecion == cab) {
            cab = cab.getLiga();
        } else {
            while (aux.getLiga() != selecion) {
                aux = aux.getLiga();
            }
            aux.setLiga(actual);
        }
        selecion.setLiga(null);
        cantidad --;
    }

    public void reiniciarLista() {
        actual = cab;
    }

}
