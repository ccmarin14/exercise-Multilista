package MultiLista;

public class Estudiante {
    private String numCarne;
    private String nombre;
    private int semestre;
    private String carrera;
    
    //Constructor
    public Estudiante(String numCarne, String nombre, int semestre, String carrera) {
        this.setNumCarne(numCarne);
        this.setNombre(nombre);
        this.setSemestre(semestre);
        this.setCarrera(carrera);
    }
        
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getNumCarne() {
        return numCarne;
    }

    public void setNumCarne(String numCarne) {
        this.numCarne = numCarne;
    }
}
