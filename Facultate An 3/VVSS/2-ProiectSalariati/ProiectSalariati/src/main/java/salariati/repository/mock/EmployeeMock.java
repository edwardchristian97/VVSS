package salariati.repository.mock;

import java.util.ArrayList;
import java.util.List;

import salariati.enumeration.DidacticFunction;

import salariati.model.Employee;
import salariati.repository.interfaces.EmployeeRepositoryInterface;
import salariati.validator.EmployeeValidator;

public class EmployeeMock implements EmployeeRepositoryInterface {

    private List<Employee> employeeList;
    private EmployeeValidator employeeValidator;

    public EmployeeMock() {

        employeeValidator = new EmployeeValidator();
        employeeList = new ArrayList<Employee>();

        Employee Ionel = new Employee("Pacuraru", "FirstName", "1234567890123", DidacticFunction.ASISTENT, 2500);
        Employee Mihai = new Employee("Dumitrescu", "FirstName", "1234567890124", DidacticFunction.LECTURER, 2500);
        Employee Ionela = new Employee("Ionescu", "FirstName", "1234567890125", DidacticFunction.CONFERENTIAR, 2500);
        Employee Mihaela = new Employee("Pacuraru", "FirstName", "1234567890126", DidacticFunction.ASISTENT, 2500);
        Employee Vasile = new Employee("Georgescu", "FirstName", "1234567890127", DidacticFunction.TEACHER, 2500);
        Employee Marin = new Employee("Puscas", "FirstName", "1234567890128", DidacticFunction.TEACHER, 2500);

        employeeList.add(Ionel);
        employeeList.add(Mihai);
        employeeList.add(Ionela);
        employeeList.add(Mihaela);
        employeeList.add(Vasile);
        employeeList.add(Marin);
    }

    @Override
    public boolean addEmployee(Employee employee) {
        if (employeeValidator.isValid(employee)) {
            employeeList.add(employee);
            return true;
        }
        return false;
    }

    @Override
    public void deleteEmployee(Employee employee) {
        // TODO Auto-generated method stub
    }

    @Override
    public void modifyEmployee(Employee oldEmployee, Employee newEmployee) {
        // TODO Auto-generated method stub
    }

    @Override
    public boolean updateDidacticFunction(String cnp, String didacticFunction) {
        DidacticFunction function;

        if (didacticFunction.equals("ASISTENT"))
            function = DidacticFunction.ASISTENT;
        else if (didacticFunction.equals("CONFERENTIAR"))
            function = DidacticFunction.CONFERENTIAR;
        else if (didacticFunction.equals("LECTURER"))
            function = DidacticFunction.LECTURER;
        else if (didacticFunction.equals("TEACHER"))
            function = DidacticFunction.TEACHER;
        else
            return false;

        for (Employee employee : employeeList)
            if (employee.getCnp().equals(cnp)) {
                employee.setDidacticFunction(function);
                return true;
            }
        return false;
    }

    @Override
    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    @Override
    public List<Employee> getEmployeeByCriteria(String criteria) {
        // TODO Auto-generated method stub
        return null;
    }

}
