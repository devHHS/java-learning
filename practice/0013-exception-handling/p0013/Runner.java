package p0013;

public class Runner {
    public static void main(String[] args) {

        EmployeeService employeeService = new EmployeeService();

        Employee employee1 = new Employee(1L,"Kim", "IT");
        Employee employee2 = new Employee(2L,"Lee", "IT");
        employeeService.save(employee1);

        System.out.println(employeeService.findByIdOrThrow(employee1.getId()).getName());

        try {
            employeeService.findByIdOrThrow(employee2.getId());
        } catch (EmployeeNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            employeeService.validateDepartment(null);
        } catch (InvalidEmployeeDataException e) {
            System.out.println(e.getMessage());
        }


    }
}
