package br.com.mock_data_lab.factory;

import br.com.mock_data_lab.entity.Company;
import com.github.javafaker.Faker;

public class CompanyFactory {
    public static Company generateMockCompany () {
        Faker faker = new Faker();
        Company company = new Company();
        company.setName(faker.company().name());
        company.setIndustry(faker.company().industry());
        company.setCatchPhrase(faker.company().catchPhrase());
        return company;
    }
}
