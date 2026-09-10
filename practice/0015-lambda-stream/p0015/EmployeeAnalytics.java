package p0015;

import java.util.List;

public class EmployeeAnalytics {

    // TODO: active == true인 Employee만 골라(filter), 이름만 뽑아서(map) List<String>으로 모아라(collect).
    public static List<String> activeEmployeeNames(List<Employee> employees) {
        return null;
    }

    // TODO: salary 내림차순으로 정렬한 List<Employee>를 반환해라.
    //       Comparator.comparingDouble(...)와 .reversed()를 조합해본다.
    public static List<Employee> sortedBySalaryDesc(List<Employee> employees) {
        return null;
    }

    // TODO: active == true인 사람들의 salary 합계를 reduce로 계산해라.
    public static double totalPayrollReduce(List<Employee> employees) {
        return 0;
    }

    // TODO: 위와 같은 결과를 mapToDouble().sum()으로 계산해라.
    public static double totalPayrollSum(List<Employee> employees) {
        return 0;
    }
}
