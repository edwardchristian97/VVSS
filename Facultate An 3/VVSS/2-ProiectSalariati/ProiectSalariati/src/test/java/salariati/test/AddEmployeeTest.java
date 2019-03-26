package salariati.test;

import static org.junit.Assert.*;

import salariati.model.Employee;

import org.junit.Before;
import org.junit.Test;

import salariati.repository.interfaces.EmployeeRepositoryInterface;
import salariati.repository.mock.EmployeeMock;
import salariati.validator.EmployeeValidator;
import salariati.controller.EmployeeController;
import salariati.enumeration.DidacticFunction;

public class AddEmployeeTest {

    private EmployeeRepositoryInterface employeeRepository;
    private EmployeeController controller;
    private EmployeeValidator employeeValidator;

    @Before
    public void setUp() {
        employeeRepository = new EmployeeMock();
        controller = new EmployeeController(employeeRepository);
        employeeValidator = new EmployeeValidator();
    }

    @Test
    public void testRepositoryMock() {
        assertFalse(controller.getEmployeesList().isEmpty());
        assertEquals(6, controller.getEmployeesList().size());
    }

    @Test
    public void testValidLastName() {
        //Valid lastName, length = 13
        Employee newEmployee = new Employee("ValidLastName", "FirstName", "1910509055057", DidacticFunction.ASISTENT, 3000);
        assertTrue(employeeValidator.isValid(newEmployee));

        //Valid lastName, length = MAX - 1
        newEmployee = new Employee("ohknmbjmxvvjiloeazgbpofdxjlynvbtbldiwnpqewbboalxunsxfiftnshpfrjvygbyefrvqgcoslvoruzefqkukpelypyuwwrnkzcgvawcjfnfpsqwuvguxhxpjgnzovfwypmxizncyolpuwmufonjhjkrxikunlldidmbqgjrxnihuwxzsoljjrwuldmgsrxknfpmjpprmzeyftgzupkrmbfaxqojrmvlahyjbdenasgpghlwfvyrnnxqj", "FirstName", "1910509055057", DidacticFunction.ASISTENT, 3000);
        assertTrue(employeeValidator.isValid(newEmployee));

        //Valid lastName, length = MAX
        newEmployee = new Employee("ohknbmbjmxvjiloeazgbpofdxjlynvbtbldiwnpqewbboalxunsxfiftnshpfrjvygbyefrvqgcoslvoruzefqkukpelypyuwwrnkzcgvawcjfnfpsqwuvguxhxpjgnzovfwypmxizncyolpuwmufonjhjkrxikunlldidmbqgjrxnihuwxzsoljjrwuldmgsrxknfpmjpprmzeyftgzupkrmbfaxqojrmvlahyjbdenasgpghlwfvyrnnxqjs", "FirstName", "1910509055057", DidacticFunction.ASISTENT, 3000);
        assertTrue(employeeValidator.isValid(newEmployee));
    }

    @Test
    public void testNonValidLastName() {
        //Nonvalid lastName, length = MAX + 1
        Employee newEmployee = new Employee("ohknbmbjmxvvjiloeazhjjhgbpofdxjlynvbtbldiwnpqewbboalxunsxfiftnshpfrjvygbyefrvqgcoslvoruzefqkukpelypyuwwrnkzcgvawcjfnfpsqwuvguxhxpjgnzovfwypmxizncyolpuwmufonjhjkrxikunlldidmbqgjrxnihuwxzsoljjrwuldmgsrxknfpmjpprmzeyftgzupkrmbfaxqojrmvlahyjbdenasgpghlwfvyrnnxqjfg", "FirstName", "1910509055057", DidacticFunction.ASISTENT, 3000);
        assertTrue(employeeValidator.isValid(newEmployee));

        //Nonvalid lastName, length = 0 (> 2)
        newEmployee = new Employee("", "FirstName", "1910509055057", DidacticFunction.ASISTENT, 3000);
        assertTrue(employeeValidator.isValid(newEmployee));
    }

    @Test
    public void testValidSalary() {
        //Valid salary
        Employee newEmployee = new Employee("lastName", "FirstName", "1910509055057", DidacticFunction.ASISTENT, 3000);
        assertTrue(employeeValidator.isValid(newEmployee));

        //Valid salary = MAX - 1
        newEmployee = new Employee("lastName", "FirstName", "1910509055057", DidacticFunction.ASISTENT, Integer.MAX_VALUE - 1);
        assertTrue(employeeValidator.isValid(newEmployee));

        //Valid salary = MAX
        newEmployee = new Employee("lastName", "FirstName", "1910509055057", DidacticFunction.ASISTENT, Integer.MAX_VALUE);
        assertTrue(employeeValidator.isValid(newEmployee));
    }

    @Test
    public void testNonValidSalary() {
        //Nonvalid salary < 2080
        Employee newEmployee = new Employee("lastName", "FirstName", "1910509055057", DidacticFunction.ASISTENT, 2079);
        assertTrue(employeeValidator.isValid(newEmployee));

        //Nonvalid salary > MAX
        newEmployee = new Employee("lastName", "FirstName", "1910509055057", DidacticFunction.ASISTENT, Integer.MAX_VALUE + 1);
        assertTrue(employeeValidator.isValid(newEmployee));


    }

}
