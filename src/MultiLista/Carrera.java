package MultiLista;

public class Carrera {
    private int idCarrera;
    private String nombreCarrera;

    public Carrera(int idCarrera,String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
        this.idCarrera = idCarrera;
    }

    public int getIdCarrera() {
        return idCarrera;
    }
    public void setIdCarrera(int idCarrera) {
        this.idCarrera = idCarrera;
    }
    public String getNombreCarrera() {
        return nombreCarrera;
    }
    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }
}
