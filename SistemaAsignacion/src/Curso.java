public class Curso {
    private String nombre;
    private int codigoCurso;
    
    public Curso(String nombre, int codigoCurso) {
        this.nombre = nombre;
        this.codigoCurso = codigoCurso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(int codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    @Override
    public String toString() {
        return "Curso [nombre=" + nombre + ", codigoCurso=" + codigoCurso + "]";
    }

    
    
}
