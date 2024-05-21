public class Estudiante{
    private String nombre;
    private int numeroEstudiante;

    public Estudiante(String nombre, int numeroEstudiante) {
        this.nombre = nombre;
        this.numeroEstudiante = numeroEstudiante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroEstudiante() {
        return numeroEstudiante;
    }

    public void setNumeroEstudiante(int numeroEstudiante) {
        this.numeroEstudiante = numeroEstudiante;
    }

    @Override
    public String toString() {
        return "Estudiante [nombre=" + nombre + ", numeroEstudiante=" + numeroEstudiante + "]";
    }

    

    
}