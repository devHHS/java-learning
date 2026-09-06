package p0013;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class EmployeeService {
    private final Map<Long, Employee> store;

    public EmployeeService() {
        store = new HashMap<>();
    }

    public Employee save(Employee employee) {
       store.put(employee.getId(), employee);
       return employee;
    }

    public Employee findByIdOrThrow(Long id) {
        if (!store.containsKey(id)) {
            throw new EmployeeNotFoundException(String.format("Employee with id %d does not exist", id));
        }
        return store.get(id);
    }

    public void validateDepartment(String department) throws  InvalidEmployeeDataException {
        if (Objects.isNull(department)) {
            throw new InvalidEmployeeDataException("Department cannot be null");
        } else if (department.isBlank()) {
            throw new InvalidEmployeeDataException("Department cannot be blank");
        }

    }

}
