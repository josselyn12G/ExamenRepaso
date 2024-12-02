import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        College college = new College();
        Student student = new Student();
        Subject subject = new Subject();
        Professor professor = new Professor();
        Department department = new Department();
        do {
            // Mostrar el menú
            String menu = "------Menú--------\n" +
                    "1. Agregar estudiante.\n" +
                    "2. Eliminar estudiante.\n" +
                    "3. Mostrar estudiantes.\n" +
                    "4. Crear materia.\n" +
                    "5. Mostrar materias.\n" +
                    "6. Asignar materia a estudiante.\n" +
                    "7. Mostrar materias por estudiante.\n" +
                    "8. Mostrar estudiantes por materia.\n" +
                    "9. Agregar departamento.\n" +
                    "10. Eliminar departamento.\n" +
                    "11. Mostrar departamentos.\n" +
                    "12. Agregar profesor.\n" +
                    "13. Mostrar profesores.\n" +
                    "14. Mostrar profesores por materia.\n" +
                    "15. Mostrar profesores por departamento.\n" +
                    "16. Salir.";

            // Pedir la opción al usuario
            int opcion = Integer.parseInt(JOptionPane.showInputDialog(null, menu));

            switch (opcion) {
                case 1:
                    student.add(college);
                    break;
                case 2:
                    student.delete(college);
                    break;
                case 3:
                    college.showStudents();
                    break;
                case 4:
                    subject.addMateria();
                    break;
                case 5:
                    subject.verMaterias();
                    break;
                case 6:
                    student.asignarMateria(college,subject);
                    break;
                case 7:
                    student.mostrarMateriasPorEstudiante(college);
                    break;
                case 8:
                    subject.mostrarEstudiantesPorMateria(student);
                    break;
                case 9:
                    department.addDepartment();
                    break;
                case 10:
                    department.removeDepartment();
                    break;
                case 11:
                    department.showDepartments();
                    break;
                case 12:
                    subject.addprofe(professor);
                    break;
                case 13:
                    professor.mostrarProfesores();
                    break;
                case 14:
                    professor.mostrarProfesorPorMateria();
                    break;
                case 15:

                    break;
                case 16:
                    // Salir del programa
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida, intente nuevamente.");
                    break;
            }
        } while (true);
    }
}