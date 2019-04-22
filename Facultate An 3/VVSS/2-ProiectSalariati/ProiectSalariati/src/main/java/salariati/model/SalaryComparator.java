package salariati.model;

import java.util.Comparator;

public class SalaryComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee employee1, Employee employee2) {
        Integer salary1 = employee1.getSalary();
        Integer salary2 = employee2.getSalary();

        return salary1.compareTo(salary2);

    }
}
