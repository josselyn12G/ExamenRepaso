import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private String studentId;
    private College college;
    private List<Subject> materiasEstudiante = new ArrayList<>();

    public Student(){

    }

    public Student(String name, String studentId, College college) {
        this.name = name;
        this.studentId = studentId;
        this.college = college;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public College getCollege() {
        return college;
    }

    public void setCollege(College college) {
        this.college = college;
    }

    public List<Subject> getMateriasEstudiante() {
        return materiasEstudiante;
    }

    public void setMateriasEstudiante(List<Subject> materiasEstudiante) {
        this.materiasEstudiante = materiasEstudiante;
    }

    // Añadir estudiante
    public void add(College college) {
        String name = JOptionPane.showInputDialog(null, "Nombre");
        String id = JOptionPane.showInputDialog(null, "ID");
        Student student = new Student(name, id, college);
        college.addStudent(student); // Llamamos a college para que lo agregue a la lista.
    }

    // Eliminar estudiante.
    public void delete(College college) {
        String id = JOptionPane.showInputDialog(null, "ID del estudiante:");
        college.deleteStudent(id);
    }

    // Crear una lista de materias para los estudiantes
    public void asignarMateria(College college, Subject subject) {
        if (subject.getMaterias().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay materias disponibles. Por favor, añádalas primero.");
            return;
        }

        // Pedir el ID del estudiante
        String idEstudiante = JOptionPane.showInputDialog(null, "Ingrese el ID del estudiante:");

        // Buscar el estudiante en la lista del college
        Student estudiante = college.buscarEstudiantePorId(idEstudiante);
        if (estudiante == null) {
            JOptionPane.showMessageDialog(null, "Estudiante no encontrado.");
            return;
        }

        // Construir el menú de materias disponibles
        String menuMaterias = "Seleccione una materia:\n";
        List<Subject> materias = subject.getMaterias();
        for (int i = 0; i < materias.size(); i++) {
            Subject materia = materias.get(i);
            menuMaterias += (i + 1) + ". " + materia.getNombreMateria() + " (" + materia.getCodigoMateria() + ")\n";
        }

        // Pedir al usuario que seleccione una materia
        int opcion = Integer.parseInt(JOptionPane.showInputDialog(null, menuMaterias));
        if (opcion < 1 || opcion > materias.size()) {
            JOptionPane.showMessageDialog(null, "Opción inválida.");
            return;
        }

        // Obtener la materia seleccionada
        Subject materiaSeleccionada = materias.get(opcion - 1);

        // Asignar la materia al estudiante
        Subject m1 = new Subject(materiaSeleccionada.getNombreMateria(), materiaSeleccionada.getCodigoMateria(), estudiante.getName(), estudiante.getStudentId());
        materiasEstudiante.add(m1);
        JOptionPane.showMessageDialog(null, "Materia asignada exitosamente a " + estudiante.getName());
    }
    public void mostrarMateriasPorEstudiante(College college) {
        // Pedir el ID del estudiante
        String idEstudiante = JOptionPane.showInputDialog(null, "Ingrese el ID del estudiante:");

        // Buscar al estudiante
        Student estudiante = college.buscarEstudiantePorId(idEstudiante);

        if (estudiante == null) {
            JOptionPane.showMessageDialog(null, "Estudiante no encontrado.");
            return;
        }

        // Construir la lista de materias
        String materiasAsignadas = "Materias asignadas a " + estudiante.getName() + ":\n";
        for (Subject materia : materiasEstudiante) {
            if(materia.getIdEstudiante().equals(idEstudiante)){
                materiasAsignadas += "- " + materia.getNombreMateria() + " (" + materia.getCodigoMateria() + ")\n";
            }
        }
        // Mostrar las materias
        JOptionPane.showMessageDialog(null, materiasAsignadas);
    }



}
