package p0015;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeAnalytics {

    // active == true인 Employee만 골라(filter), 이름만 뽑아서(map) List<String>으로 모음(collect).
    public static List<String> activeEmployeeNames(List<Employee> employees) {
        return employees.stream()
            .filter(Employee::isActive)
            .map(Employee::getName)
            .collect(Collectors.toList());
    }

    // salary 내림차순으로 정렬한 List<Employee>를 반환.
    public static List<Employee> sortedBySalaryDesc(List<Employee> employees) {
        return employees.stream()
            .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
            .collect(Collectors.toList());
    }

    // active == true인 사람들의 salary 합계를 reduce로 계산.
    public static double totalPayrollReduce(List<Employee> employees) {
        return employees.stream()
            .filter(Employee::isActive)
            .map(Employee::getSalary)
            .reduce(0.0, (acc, salary) -> acc + salary);
    }

    // 위와 같은 결과를 mapToDouble().sum()으로 계산.
    public static double totalPayrollSum(List<Employee> employees) {
        return employees.stream()
            .filter(Employee::isActive)
            .mapToDouble(Employee::getSalary)
            .sum();
    }
}
