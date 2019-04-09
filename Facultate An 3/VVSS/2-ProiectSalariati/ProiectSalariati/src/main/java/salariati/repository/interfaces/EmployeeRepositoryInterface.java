package salariati.repository.interfaces;

import java.util.List;

import salariati.enumeration.DidacticFunction;
import salariati.model.Employee;

public interface EmployeeRepositoryInterface {

    boolean addEmployee(Employee employee);

    void deleteEmployee(Employee employee);

    void modifyEmployee(Employee oldEmployee, Employee newEmployee);

    boolean updateDidacticFunction(String cnp, String didacticFunction);

    List<Employee> getEmployeeList();

    List<Employee> getEmployeeByCriteria(String criteria);

}
