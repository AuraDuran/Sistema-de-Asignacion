import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SistemaGestion {
    private ArrayList<Estudiante> listaEstudiantes;
    private ArrayList<Curso> listaCursos;
    private Map<Estudiante,ArrayList<Curso>> mapaAsignaciones;
    
    public SistemaGestion() {
        listaEstudiantes=new ArrayList<>();
        listaCursos=new ArrayList<>();
        mapaAsignaciones= new HashMap<>();    
    }

    public String registrarEstudiante(String nombre, int numeroEstudiante) {
        for (Estudiante estudiante : listaEstudiantes) {
            if (estudiante.getNumeroEstudiante() == numeroEstudiante) {
                return "Estudiante ya registrado.";
            }
        }

        Estudiante estudiante = new Estudiante(nombre, numeroEstudiante);
        listaEstudiantes.add(estudiante);
        return "Estudiante registrado exitosamente.";
    }
    

    public String registrarCurso(String nombre, int codigoCurso) {
        for (Curso curso : listaCursos) {
            if (curso.getCodigoCurso() == codigoCurso) {
                return "Curso ya registrado.";
            }
        }

        Curso curso = new Curso(nombre, codigoCurso);
        listaCursos.add(curso);
        return "Curso registrado exitosamente.";
    }
    
    public String asignarEstudianteACurso(int numeroEstudiante, int codigoCurso) {
        Estudiante estudianteSeleccionado = null;
        for (Estudiante estudiante : listaEstudiantes) {
            if (estudiante.getNumeroEstudiante() == numeroEstudiante) {
                estudianteSeleccionado = estudiante;
                break;
            }
        }
    
        Curso cursoSeleccionado = null;
        for (Curso curso : listaCursos) {
            if (curso.getCodigoCurso() == codigoCurso) {
                cursoSeleccionado = curso;
                break;
            }
        }
    
        if (estudianteSeleccionado != null && cursoSeleccionado != null) {
            hacerAsignacion(estudianteSeleccionado, cursoSeleccionado);
            return "Estudiante asignado al curso.";
        } else {
            return "Estudiante o curso no encontrado.";
        }
    } 

    private void hacerAsignacion(Estudiante estudiante, Curso curso){
        if (mapaAsignaciones.containsKey(estudiante)) {
            ArrayList<Curso> cursosAsignadosPreviamente=mapaAsignaciones.get(estudiante);
            cursosAsignadosPreviamente.add(curso);
            
        } else {
            ArrayList<Curso> cursosAsignados=new ArrayList<>();
            cursosAsignados.add(curso);
            mapaAsignaciones.put(estudiante,cursosAsignados);            
        }
    }

    
    public String listaCursosDeEstudiante(int numeroEstudiante) {
        Estudiante estudianteSeleccionado = null;
        for (Estudiante estudiante : listaEstudiantes) {
            if (estudiante.getNumeroEstudiante() == numeroEstudiante) {
                estudianteSeleccionado = estudiante;
                break;
            }
        }

        if (estudianteSeleccionado != null) {
            ArrayList<Curso> cursosDelEstudiante = mapaAsignaciones.get(estudianteSeleccionado);
            if (cursosDelEstudiante != null && !cursosDelEstudiante.isEmpty()) {
                StringBuilder result = new StringBuilder();
                result.append("Cursos del estudiante ").append(estudianteSeleccionado.getNombre()).append(":\n");
                for (Curso curso : cursosDelEstudiante) {
                    result.append(curso.getNombre()).append("\n");
                }
                return result.toString();
            } else {
                return "No hay cursos asignados al estudiante";
            }
        } else {
            return "Estudiante no encontrado";
        }
    }

    public String listarEstudiantesConCursos() {
        StringBuilder result = new StringBuilder();
        Map<Estudiante, ArrayList<Curso>> cursosPorEstudiante = new HashMap<>();

        for (Estudiante estudiante : listaEstudiantes) {
            ArrayList<Curso> cursosDelEstudiante = mapaAsignaciones.get(estudiante);
            cursosPorEstudiante.put(estudiante, cursosDelEstudiante);
        }

        for (Map.Entry<Estudiante, ArrayList<Curso>> entry : cursosPorEstudiante.entrySet()) {
            Estudiante estudiante = entry.getKey();
            ArrayList<Curso> cursosDelEstudiante = entry.getValue();
            
            result.append("Estudiante: ").append(estudiante.getNombre()).append("\n");
            if (cursosDelEstudiante != null && !cursosDelEstudiante.isEmpty()) {
                result.append("Cursos asignados:\n");
                for (Curso curso : cursosDelEstudiante) {
                    result.append("- ").append(curso.getNombre()).append("\n");
                }
            } else {
                result.append("No hay cursos asignados.\n");
            }
            result.append("\n");
        }

        return result.toString();
    }
    
    

    

    
    
}
