package salariati.repository.mock;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import salariati.enumeration.DidacticFunction;

import salariati.model.AgeComparator;
import salariati.model.Employee;
import salariati.model.SalaryComparator;
import salariati.repository.interfaces.EmployeeRepositoryInterface;
import salariati.validator.EmployeeValidator;

public class EmployeeMock implements EmployeeRepositoryInterface {

    private List<Employee> employeeList;
    private EmployeeValidator employeeValidator;

    public EmployeeMock() {

        employeeValidator = new EmployeeValidator();
        employeeList = new ArrayList<Employee>();

        Employee Ionel = new Employee("Pacuraru", "FirstName", "1974567890123", DidacticFunction.ASISTENT, 2700);
        Employee Mihai = new Employee("Dumitrescu", "FirstName", "1974567890124", DidacticFunction.LECTURER, 2200);
        Employee Ionela = new Employee("Ionescu", "FirstName", "1684567890125", DidacticFunction.CONFERENTIAR, 3500);
        Employee Mihaela = new Employee("Pacuraru", "FirstName", "1754567890126", DidacticFunction.ASISTENT, 5500);
        Employee Vasile = new Employee("Georgescu", "FirstName", "1894567890127", DidacticFunction.TEACHER, 7500);
        Employee Marin = new Employee("Puscas", "FirstName", "1904567890128", DidacticFunction.TEACHER, 3900);

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
    public boolean getEmployeeByCriteria(String criteria) {

        List<Employee> employees = getEmployeeList();
        if (criteria.toLowerCase().equals("salariu")) {
            Collections.sort(employees, Collections.reverseOrder(new SalaryComparator()));
            employeeList = employees;
            return true;
        }

        if (criteria.toLowerCase().equals("cnp")) {
            Collections.sort(employees, new AgeComparator());
            employeeList = employees;
            return true;
        }
        return false;
    }

}
