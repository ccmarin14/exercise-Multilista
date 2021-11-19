package MultiLista;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Main {
    static int eleccion;
    static int idCarrera = 1;
    static ListaLigada estudiantes = new ListaLigada();
    static ListaLigada carreras = new ListaLigada();
    static Estudiante alumno;
    static Carrera curso;
    static boolean existe = false;
    
    public static void main(String[] args) {     
        do {
            menuPrincipal();
            switch (eleccion){
                case 1:
                    if (carreras.listaVacia()) {
                        JOptionPane.showMessageDialog(null,"La lista de carreras no tiene datos, antes de insertar un estudiante debe crear una carrera, por favor seleccionar la opción de administración de carreras");
                    } else {
                        do {
                            menuEstudiantes();
                            switch (eleccion){
                                case 1:
                                    crearEstudiantes();
                                    carreras.reiniciarLista();
                                break;
                                case 2:
                                    mostrar(listar("e"));
                                break;
                                case 3:
                                    JOptionPane.showMessageDialog(null,"Regresando al menú anterior");
                                break;
                                default:
                                    JOptionPane.showMessageDialog(null,"Opción incorrecta");
                                    menuEstudiantes();
                                break;
                            }
                        } while (eleccion != 3);
                        eleccion = 0;
                    }
                break;
                case 2:
                    do {
                        menuCarreras();
                        switch (eleccion){
                            case 1:
                                crearCarreras();
                            break;
                            case 2:
                                if (carreras.listaVacia()) {
                                    JOptionPane.showMessageDialog(null,"La lista de carreras no tiene datos, por favor seleccionar la opción de crear carreras");
                                } else {
                                    mostrar(listar("c"));
                                }
                            break;
                            case 3:
                                JOptionPane.showMessageDialog(null,"Regresando al menú anterior");
                            break;
                            default:
                                JOptionPane.showMessageDialog(null,"Opción incorrecta");
                                menuCarreras();
                            break;
                        }
                    } while (eleccion != 3);
                    eleccion = 0;
                break;
                case 3:
                    JOptionPane.showMessageDialog(null,"Hasta pronto!");
                break;
                default:
                    JOptionPane.showMessageDialog(null,"Opción incorrecta");
                    menuPrincipal();
                break;
            }
        } while (eleccion != 3);
    }
    
    static void menuPrincipal() {
        eleccion = Integer.parseInt(JOptionPane.showInputDialog("Por favor inserte el número que corresponda a la acción que desea, luego presione Aceptar\n \n"
        + "1. Adminstrar estudiantes.\n"
        + "2. Administrar carreras\n"
        + "3. Salir"));
    }

    static void menuEstudiantes() {
        eleccion = Integer.parseInt(JOptionPane.showInputDialog("Por favor inserte el número que corresponda a la acción que desea, luego presione Aceptar\n \n"
        + "1. Crear estudiante.\n"
        + "2. Listar estudiantes.\n"
        + "3. Salir del menú de administración de estudiantes"));
    }

    static void menuCarreras() {
        eleccion = Integer.parseInt(JOptionPane.showInputDialog("Por favor inserte el número que corresponda a la acción que desea, luego presione Aceptar\n \n"
        + "1. Crear carrera.\n"
        + "2. Listar carreras.\n"
        + "3. Salir del menú administración de carreras")); 
    }

    static void crearCarreras() {
        String nombreCarrera;
        nombreCarrera = JOptionPane.showInputDialog("\nIngrese el nombre de la carrera");
        curso = new Carrera(idCarrera,nombreCarrera);
        carreras.addCarrera(curso);
        idCarrera ++;
        JOptionPane.showMessageDialog(null,"Carrera ingresada.");
    }

    static void crearEstudiantes() {
        String nombreEstudiante,numCarnet,carrera;
        int semestre;
        Nodo aux;
        nombreEstudiante = JOptionPane.showInputDialog("\nIngrese el nombre del Estudiante");
        numCarnet = JOptionPane.showInputDialog("\nIngrese el número de carné del Estudiante");
        semestre = Integer.parseInt(JOptionPane.showInputDialog("\nIngrese el semestre actual del Estudiante"));
        //Seleccionar la carrera
        aux = seleccionar(listar("c"),carreras);
        carrera = aux.getDatos().getCurso().getNombreCarrera();
        //Si la carrera no tiene estudiantes, se crea una lista de estudiantes
        if (aux.getDatos().getEstudiantes() == null) {
            ListaLigada alumnos = new ListaLigada();
            aux.getDatos().setEstudiantes(alumnos);
        }
        //Inserción de datos a un objeto alumno
        alumno = new Estudiante(numCarnet,nombreEstudiante,semestre,carrera);
        //Inserción de alumno a la lista
        aux.getDatos().getEstudiantes().addEstudiante(alumno);
        JOptionPane.showMessageDialog(null,"Estudiante ingresado.");
        if (!existe){
            existe = true;
        }
    }

    static String listar(String tipo) {
        Nodo registro = carreras.recorrerLista();
        ArrayList<String> datos = new ArrayList<String>();
        String texto = "";

        while (registro != null) {
            if (tipo == "c"){
                curso = registro.getDatos().getCurso();
                datos.add(curso.getIdCarrera() + ". " + curso.getNombreCarrera() + "\n");               
            } else {
                datos.add(("\n" + registro.getDatos().getCurso().getNombreCarrera() + "\n").toUpperCase());
                estudiantes = registro.getDatos().getEstudiantes();
                if (estudiantes != null) {
                    Nodo estudiante = estudiantes.recorrerLista();
                    while (estudiante != null) {
                        datos.add("CARNÉ: " + estudiante.getDatos().getAlumno().getNumCarne() 
                        + "  NOMBRE: " + estudiante.getDatos().getAlumno().getNombre()
                        + "  CARRERA: " + estudiante.getDatos().getAlumno().getCarrera()
                        + "  SEMESTRE: " + estudiante.getDatos().getAlumno().getSemestre() + "\n");
                        estudiante = estudiantes.recorrerLista();
                    }
                } else {
                    datos.add("La carrera no tiene estudiantes matriculados \n");
                }
            }
            registro = carreras.recorrerLista(); 
        }
        for (String parte : datos) {
            texto += parte;
        }
        estudiantes = null;
        return texto;
    }

    static Nodo seleccionar(String entrada, ListaLigada lista){
        eleccion = Integer.parseInt(JOptionPane.showInputDialog(entrada));
        Nodo registro = lista.recorrerLista();
        int idCarrera = registro.getDatos().getCurso().getIdCarrera();
        while (idCarrera != eleccion) {
            registro = lista.recorrerLista();
            idCarrera = registro.getDatos().getCurso().getIdCarrera();
        }
        return registro;
    }

    static void mostrar(String salida) {
        String texto = salida;
        JOptionPane.showMessageDialog(null,texto);
    }
}
