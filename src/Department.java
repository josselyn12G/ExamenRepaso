import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private String idDepartment;

    // Lista estática para almacenar departamentos
    private static List<Department> departments = new ArrayList<>();

    // Constructor
    public Department(){

    }

    public Department(String name, String idDepartment) {
        this.name = name;
        this.idDepartment = idDepartment;
    }

    // Metodo para agregar un departamento a la lista
    public static void addDepartment() {
        departments.add(department);
        System.out.println("Departamento agregado: " + department.name);
    }

    // Método para eliminar un departamento de la lista por ID
    public static void removeDepartment(String idDepartment) {
        for (Department department : departments) {
            if (department.idDepartment.equals(idDepartment)) {
                departments.remove(department);
                System.out.println("Departamento eliminado: " + department.name);
                return;
            }
        }
        System.out.println("Departamento no encontrado.");
    }

    // Método para mostrar todos los departamentos
    public static void showDepartments() {
        if (departments.isEmpty()) {
            System.out.println("No hay departamentos disponibles.");
        } else {
            System.out.println("Departamentos:");
            for (Department department : departments) {
                System.out.println("ID: " + department.idDepartment + ", Nombre: " + department.name);
            }
        }
    }

    // Métodos getter y setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdDepartment() {
        return idDepartment;
    }

    public void setIdDepartment(String idDepartment) {
        this.idDepartment = idDepartment;
    }
}