import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class College {
    // Declaración de atributos.
    private String name;
    private String address;
    private String phone;
    private String collegeID;

    private List<Student> students = new ArrayList<>(); // Crear una lista de estudiantes.

    // Creación de constructor
    public College(){

    }

    public College(String name, String address, String phone, String collegeID) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.collegeID = collegeID;
    }
    // Getters y setters


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCollegeID() {
        return collegeID;
    }

    public void setCollegeID(String collegeID) {
        this.collegeID = collegeID;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }


    // Métodos propios

    public void addStudent(Student student){

        // Añadir el estudiante a la lista si no está ya en ella
        if(!students.contains(student)){
            students.add(student);
            JOptionPane.showMessageDialog(null, "Estudiante agregado correctamente.");
        }else{
            JOptionPane.showMessageDialog(null, "El estudiante ya existe en el college.");
        }
    }

    public void deleteStudent(String id){
        for(Student std: students){ // La variable std representará el objeto individual de la colección durante cada iteración del bucle.
            if(std.getStudentId().equals(id)){
                JOptionPane.showMessageDialog(null,"Encontrado!");
                JOptionPane.showMessageDialog(null,"Nombre: " +std.getName() + "ID: " +std.getStudentId());
                students.remove(std);
                JOptionPane.showMessageDialog(null,"Eliminado");
                break;
            }
        }
    }

    public void showStudents(){
        // Verificar si hay estudiantes en el college
        if (students.isEmpty()) {
            System.out.println("No hay estudiantes en este colegio.");
            return;
        }

        // Imprimir la cabecera de la tabla
        System.out.printf("%-20s %-15s %-25s %-30s %-20s %-20s %-15s %-15s\n",
                "Nombre Estudiante", "ID Estudiante", "Nombre Colegio", "Dirección Colegio",
                "Teléfono Colegio", "ID Colegio", "Estado Colegio", "Estado Estudiante");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");

        // Iterar sobre la lista de estudiantes
        for (Student std : students) {
            // Obtener los detalles del estudiante
            String studentName = std.getName();
            String studentId = std.getStudentId();

            // Inicializar los detalles del college si existe
            String collegeName = "No asignado";
            String collegeAddress = "No asignado";
            String collegePhone = "No asignado";
            String collegeId = "No asignado";
            String collegeStatus = "No asignado";

            // Si el estudiante está asignado a un colegio, obtener los detalles del college
            if (std.getCollege() != null) {
                College college = std.getCollege();
                collegeName = college.getName();
                collegeAddress = college.getAddress();
                collegePhone = college.getPhone();
                collegeId = college.getCollegeID();
            }

            // Mostrar la información del estudiante y del colegio en formato tabulado
            System.out.printf("%-20s %-15s %-25s %-30s %-20s %-20s %-15s\n",
                    studentName, studentId, collegeName, collegeAddress,
                    collegePhone, collegeId, "Activo");
        }
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
    }
    public Student buscarEstudiantePorId(String id) {
        for (Student estudiante : students) {
            if (estudiante.getStudentId().equals(id)) {
                return estudiante; // Retorna el estudiante si encuentra una coincidencia
            }
        }
        return null; // Retorna null si no encuentra ningún estudiante con el ID proporcionado
    }
}
