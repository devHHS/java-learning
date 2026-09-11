package p0015;

import java.util.Arrays;
import java.util.List;

public class Runner {
    public static void main(String[] args) {

        Employee employee1 = new Employee(1L, "Kim", "IT", 5000000, true);
        Employee employee2 = new Employee(2L, "Lee", "HR", 4200000, false);
        Employee employee3 = new Employee(3L, "Park", "IT", 6100000, true);
        Employee employee4 = new Employee(4L, "Choi", "Finance", 3800000, true);
        Employee employee5 = new Employee(5L, "Jung", "HR", 4700000, false);

        List<Employee> employees = Arrays.asList(employee1, employee2, employee3, employee4, employee5);

        System.out.println(EmployeeAnalytics.activeEmployeeNames(employees));

        System.out.println(EmployeeAnalytics.sortedBySalaryDesc(employees));

        System.out.println(EmployeeAnalytics.totalPayrollReduce(employees));
        System.out.println(EmployeeAnalytics.totalPayrollSum(employees));
    }
}
