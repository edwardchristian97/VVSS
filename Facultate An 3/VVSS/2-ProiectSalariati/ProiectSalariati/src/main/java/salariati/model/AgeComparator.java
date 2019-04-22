package salariati.model;

import java.util.Comparator;

public class AgeComparator implements Comparator<Employee> {

    public int cnpToAge(String cnp) {
        String[] yearArray = cnp.split("");
        String yearString = "19" + yearArray[1] + yearArray[2];
        int age = 2019 - Integer.parseInt(yearString);

        return age;
    }

    @Override
    public int compare(Employee employee1, Employee employee2) {
        Integer age1 = cnpToAge(employee1.getCnp());
        Integer age2 = cnpToAge(employee2.getCnp());

        return age1.compareTo(age2);
    }
}
