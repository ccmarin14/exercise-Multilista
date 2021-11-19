package MultiLista;

public class Dato {
    private Estudiante alumno;
    private Carrera curso;
    private ListaLigada estudiantes;

    //Constructor para estudiante
    public Dato(Estudiante alumno) {
        this.alumno = alumno;
    }
    //Constructor para curso
    public Dato(Carrera curso) {
        this.curso = curso;
    }
    //Constructor para lista de estudiantes
    public Dato(ListaLigada estudiantes) {
        this.estudiantes = estudiantes;
    }

    public Estudiante getAlumno() {
        return alumno;
    }
    public void setAlumno(Estudiante alumno) {
        this.alumno = alumno;
    }
    public Carrera getCurso() {
        return curso;
    }
    public void setCurso(Carrera curso) {
        this.curso = curso;
    }
    public ListaLigada getEstudiantes() {
        return estudiantes;
    }
    public void setEstudiantes(ListaLigada estudiantes) {
        this.estudiantes = estudiantes;
    }
}
