import java.util.Scanner;

public class App {
    public static Scanner scanner = new Scanner(System.in);
    public static SistemaGestion sistema=new SistemaGestion();

    public static void main(String[] args) throws Exception {
        mostrarMenu();
    }


    public static void mostrarMenu(){
        int opcion=0;
        while(opcion!=5){
            System.out.println("\nMenú");
            System.out.println("1. Registrar Estudiante");
            System.out.println("2. Registrar Curso");
            System.out.println("3. Asignar estudiante a curso");
            System.out.println("4. Listar cursos de estudiante");
            System.out.println("5. Listar a todos los estudiantes con cursos.");
            System.out.println("6. Salir");
            System.out.print("\nSelecciona una opción: ");
            opcion=scanner.nextInt();
            switch (opcion) {
                case 1:
                    registrarEstudiante();
                    break;
                case 2:
                    registrarCurso();
                    break;
                case 3:
                    asignarEstudianteACurso();
                    break;
                case 4:
                    System.out.println("Numero de estudiante");
                    int numeroEstudiante = scanner.nextInt();
                    String cursosDelEstudiante = sistema.listaCursosDeEstudiante(numeroEstudiante);
                    System.out.println(cursosDelEstudiante); 
                    break;
                    case 5:
                    String estudiantesConCursos = sistema.listarEstudiantesConCursos();
                    System.out.println(estudiantesConCursos);
                    break;
                case 6:
                    System.out.println("¡Hasta Luego!");
                    return; 
                default:
                    System.out.println("Opción invalida. Intenta de nuevo");
            
            }
        }
    }

    public static void registrarEstudiante(){
        System.out.print("Nombre Estudiante: ");
        String nombre=scanner.next();
        System.out.print("Numero de Estudiante: ");
        int numeroEstudiante=scanner.nextInt();
        String mensaje = sistema.registrarEstudiante(nombre, numeroEstudiante);
        System.out.println(mensaje);
    }

    public static void registrarCurso(){

        System.out.print("Nombre del Curso: ");
        String nombre=scanner.next();
        System.out.print("Codigo de Curso: ");
        int codigoCurso=scanner.nextInt();
        String mensaje = sistema.registrarCurso(nombre, codigoCurso);
        System.out.println(mensaje);
    }

    public static void asignarEstudianteACurso(){
        System.out.print("Numero de Estudiante: ");
        int numeroEstudiante = scanner.nextInt();
        System.out.print("Codigo Curso: ");
        int codigoCurso = scanner.nextInt();
        String mensaje = sistema.asignarEstudianteACurso(numeroEstudiante, codigoCurso);
        System.out.println(mensaje);
    }

}
    
