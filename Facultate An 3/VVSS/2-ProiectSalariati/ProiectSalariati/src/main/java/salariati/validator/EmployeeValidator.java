package salariati.validator;

import salariati.enumeration.DidacticFunction;
import salariati.model.Employee;

public class EmployeeValidator {

    public EmployeeValidator() {
    }

    public boolean isValid(Employee employee) {
        boolean isLastNameValid = employee.getLastName().matches("[a-zA-Z]+") && (employee.getLastName().length() > 2);
        boolean isFirstNameValid = employee.getFirstName().matches("[a-zA-Z]+") && (employee.getFirstName().length() > 2);
        boolean isCNPValid = employee.getCnp().matches("[a-z0-9]+") && (employee.getCnp().length() == 13);
        boolean isFunctionValid = employee.getDidacticFunction().equals(DidacticFunction.ASISTENT) ||
                employee.getDidacticFunction().equals(DidacticFunction.LECTURER) ||
                employee.getDidacticFunction().equals(DidacticFunction.TEACHER) ||
                employee.getDidacticFunction().equals(DidacticFunction.CONFERENTIAR);
        boolean isSalaryValid = (employee.getSalary() > 0);

        return isLastNameValid && isFirstNameValid && isCNPValid && isFunctionValid && isSalaryValid;
    }


}
