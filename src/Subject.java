import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Subject {
    private String nombreMateria;
    private String codigoMateria;
    private String nombreEstudiante;
    private String idEstudiante;
    private List<Subject> materias = new ArrayList<>();

    public Subject(){

    }

    public Subject(String nombreMateria, String codigoMateria, String nombreEstudiante, String idEstudiante) {
        this.nombreMateria = nombreMateria;
        this.codigoMateria = codigoMateria;
        this.nombreEstudiante = nombreEstudiante;
        this.idEstudiante = idEstudiante;
    }

    public Subject(String nombreMateria, String codigoMateria) {
        this.nombreMateria = nombreMateria;
        this.codigoMateria = codigoMateria;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public String getCodigoMateria() {
        return codigoMateria;
    }

    public void setCodigoMateria(String codigoMateria) {
        this.codigoMateria = codigoMateria;
    }

    public List<Subject> getMaterias() {
        return materias;
    }

    public void setMaterias(List<Subject> materias) {
        this.materias = materias;
    }

    public String getNombreEstudiante() {
        return nombreEstudiante;
    }

    public void setNombreEstudiante(String nombreEstudiante) {
        this.nombreEstudiante = nombreEstudiante;
    }

    public String getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(String idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public Subject crearMateria(){
        String n = JOptionPane.showInputDialog(null,"Nombre de la materia");
        String c = JOptionPane.showInputDialog(null,"Código de la materia");
        return new Subject(n,c);
    }
    public void addMateria(){
        Subject m1 = crearMateria();
        if(!materias.contains(m1)){
            materias.add(m1);
        }else{
            JOptionPane.showMessageDialog(null,"Materia ya en la lista!");
        }

    }
    public void verMaterias() {
        System.out.println("----------------------------------------------------");
        System.out.printf("%-20s | %-10s\n", "Nombre de la Materia", "Código");
        System.out.println("----------------------------------------------------");
        for (Subject m : materias) {
            System.out.printf("%-20s | %-10s\n", m.getNombreMateria(), m.getCodigoMateria());
        }
        System.out.println("----------------------------------------------------");
    }
    public void addprofe(Professor profesor){
        profesor.addProfesor(materias);
    }
    public void mostrarEstudiantesPorMateria(Student student) {
        // Pedir el ID de la materia
        String idMateria = JOptionPane.showInputDialog(null, "Ingrese el ID de la materia:");

        for (Subject s1 : student.getMateriasEstudiante()) {
            if (s1.getCodigoMateria().equals(idMateria)) {
                System.out.println("Estudiante: "+s1.getNombreEstudiante() + " ID estudiante: " +s1.getIdEstudiante());
            }
        }

    }


}
