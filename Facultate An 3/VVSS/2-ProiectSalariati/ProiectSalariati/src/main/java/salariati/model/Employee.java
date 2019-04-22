package salariati.model;

import salariati.enumeration.DidacticFunction;
import salariati.exception.EmployeeException;
import salariati.validator.EmployeeValidator;

public class Employee {

    /**
     * The last name of the employee
     */
    private String lastName;

    /**
     * The first name of the employee
     */
    private String firstName;

    /**
     * The unique id of the employee
     */
    private String cnp;

    /**
     * The didactic didacticFunction of the employee inside the university
     */
    private DidacticFunction didacticFunction;

    /**
     * The salary of the employee
     */
    private int salary;

    /**
     * Default constructor for employee
     */
    public Employee() {
        this.lastName = "";
        this.cnp = "";
        this.didacticFunction = DidacticFunction.ASISTENT;
        this.salary = 0;
    }

    /**
     * Constructor with fields for employee
     */


    public Employee(String lastName, String firstName, String cnp, DidacticFunction didacticFunction, int salary) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.cnp = cnp;
        this.didacticFunction = didacticFunction;
        this.salary = salary;
    }

    /**
     * Getter for the employee last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Setter for the employee last name
     *
     * @param lastName the last name to be set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Getter for the employee CNP
     */
    public String getCnp() {
        return cnp;
    }

    /**
     * Setter for the employee CNP
     *
     * @param cnp the CNP to be set
     */
    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    /**
     * Getter for the employee didactic didacticFunction
     */
    public DidacticFunction getDidacticFunction() {
        return didacticFunction;
    }

    /**
     * Setter for the employee didacticFunction
     *
     * @param didacticFunction the didacticFunction to be set
     */
    public void setDidacticFunction(DidacticFunction didacticFunction) {
        this.didacticFunction = didacticFunction;
    }

    /**
     * Getter for the employee salary
     */
    public int getSalary() {
        return salary;
    }

    /**
     * Setter for the salary
     *
     * @param salary the salary to be set
     */
    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * toString didacticFunction for employee
     */
    @Override
    public String toString() {
        return lastName + "; " +
                firstName + "; " +
                cnp + "; " +
                didacticFunction + "; " +
                salary;
    }

    /**
     * Returns the Employee after parsing the given line
     *
     * @param _employee the employee given as String from the input file
     * @param line      the current line in the file
     * @return if the given line is valid returns the corresponding Employee
     * @throws EmployeeException
     */
    public static Employee getEmployeeFromString(String _employee, int line) throws EmployeeException {
        Employee employee = new Employee();

        String[] attributes = _employee.split("[;]");

        if (attributes.length != 6) {
            throw new EmployeeException("Invalid line at: " + line);
        } else {
            EmployeeValidator validator = new EmployeeValidator();
            employee.setLastName(attributes[1]);
            employee.setFirstName(attributes[2]);
            employee.setCnp(attributes[3]);

            if (attributes[4].equals("ASISTENT"))
                employee.setDidacticFunction(DidacticFunction.ASISTENT);
            if (attributes[4].equals("LECTURER"))
                employee.setDidacticFunction(DidacticFunction.LECTURER);
            if (attributes[4].equals("TEACHER"))
                employee.setDidacticFunction(DidacticFunction.TEACHER);
            if (attributes[4].equals("CONFERENTIAR"))
                employee.setDidacticFunction(DidacticFunction.CONFERENTIAR);

            employee.setSalary(Integer.parseInt(attributes[5]));

            if (!validator.isValid(employee)) {
                throw new EmployeeException("Invalid line at: " + line);
            }
        }

        return employee;
    }

}
