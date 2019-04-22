package salariati.controller;

import java.util.List;

import salariati.enumeration.DidacticFunction;
import salariati.model.Employee;
import salariati.repository.interfaces.EmployeeRepositoryInterface;

public class EmployeeController {

    private EmployeeRepositoryInterface employeeRepository;

    public EmployeeController(EmployeeRepositoryInterface employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public boolean addEmployee(Employee employee) {
        return employeeRepository.addEmployee(employee);
    }

    public List<Employee> getEmployeesList() {
        return employeeRepository.getEmployeeList();
    }

    public void modifyEmployee(Employee oldEmployee, Employee newEmployee) {
        employeeRepository.modifyEmployee(oldEmployee, newEmployee);
    }

    public boolean modifyDidacticFunction(String cnp, String didacticFunction) {
        return employeeRepository.updateDidacticFunction(cnp, didacticFunction);
    }

    public boolean getEmployeesCriteria(String criteria) {
        return employeeRepository.getEmployeeByCriteria(criteria);
    }

    public void deleteEmployee(Employee employee) {
        employeeRepository.deleteEmployee(employee);
    }

}
