package MultiLista;

public class Nodo {
    private Dato datos;
    private Nodo liga = null;
    private int sw = 0;

    //Constructor para estudiantes
    public Nodo(Estudiante alumno) {
        datos = new Dato(alumno);
    }
    //Constructor para carreras
    public Nodo(Carrera curso) {
        datos = new Dato(curso);
        sw = 1;
    }
    //Constructor para lista de estudiantes
    public Nodo(ListaLigada estudiantes) {
        datos = new Dato(estudiantes);

    }
    public Dato getDatos() {
        return datos;
    }
    public void setDatos(Dato datos) {
        this.datos = datos;
    }
    public Nodo getLiga() {
        return liga;
    }
    public void setLiga(Nodo liga) {
        this.liga = liga;
    }
    public int getSw() {
        return sw;
    }
    public void setSw(int sw) {
        this.sw = sw;
    }



}