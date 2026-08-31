package p0012;

public class Runner {
    public static void main(String[] args) {
        InMemoryRepository<Employee, Long> repository = new InMemoryRepository<>();

        Employee employee1 = new Employee(1L,"Kim", "IT");
        Employee employee2 = new Employee(2L,"Park", "Finance");
        Employee employee3 = new Employee(3L,"Lee", "Personal");

        repository.save(1L,employee1);
        repository.save(2L,employee2);
        repository.save(3L,employee3);

        Employee foundEmployee = repository.findById(1L);
        System.out.println(foundEmployee.getName());

        Employee foundEmployee2 = repository.findById(99L);
        System.out.println(foundEmployee2 == null);

        boolean deleteEmployee1 = repository.deleteById(1L);
        System.out.println(deleteEmployee1);

        int count = repository.count();
        System.out.println(count);
    }

}
