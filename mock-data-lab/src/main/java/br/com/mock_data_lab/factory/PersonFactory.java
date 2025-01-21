package br.com.mock_data_lab.factory;

import br.com.mock_data_lab.entity.Address;
import br.com.mock_data_lab.entity.Company;
import br.com.mock_data_lab.entity.Person;
import com.github.javafaker.Faker;

public class PersonFactory {
    public static Person generateMockPerson (Company company, Address address) {
        Faker faker = new Faker();
        Person person = new Person();
        person.setFullName(faker.name().fullName());
        person.setFirstName(faker.name().firstName());
        person.setLastName(faker.name().lastName());
        person.setAddress(address);
        person.setCompany(company);
        return  person;
    }
}
