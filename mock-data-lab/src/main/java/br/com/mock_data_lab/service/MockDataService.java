package br.com.mock_data_lab.service;

import br.com.mock_data_lab.entity.Address;
import br.com.mock_data_lab.entity.Company;
import br.com.mock_data_lab.entity.Person;
import br.com.mock_data_lab.factory.AddressFactory;
import br.com.mock_data_lab.factory.CompanyFactory;
import br.com.mock_data_lab.factory.PersonFactory;
import br.com.mock_data_lab.repository.AddressRepository;
import br.com.mock_data_lab.repository.CompanyRepository;
import br.com.mock_data_lab.repository.PersonRepository;
import com.github.javafaker.Faker;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

@Service
@Transactional
public class MockDataService {

    private final PersonRepository personRepository;
    private final CompanyRepository companyRepository;
    private final AddressRepository addressRepository;
    private final Faker faker;
    private final Logger logger = LoggerFactory.getLogger(MockDataService.class);

    public MockDataService(PersonRepository personRepository, CompanyRepository companyRepository, AddressRepository addressRepository) {
        this.personRepository = personRepository;
        this.companyRepository = companyRepository;
        this.addressRepository = addressRepository;
        this.faker = new Faker();
    }

    @PostConstruct
    public void generateMockData() {
        List<Company> companies = insertCompanies();
        logger.debug("Companies were inserted");
        insertPeopleAndAddresses(companies);
        logger.debug("People were inserted");
        logger.info("Mock data created!");
    }

    private List<Company> insertCompanies() {
        List<Company> companies = companyRepository.findAll();
        if (companies.isEmpty()){
            companies = IntStream.range(0, 10).mapToObj(i -> {
                Company company = CompanyFactory.generateMockCompany();
                return companyRepository.save(company);
            }).toList();
        }
        return companies;
    }

    private List<Address> insertAddresses() {
        List<Address> addresses = addressRepository.findAll();
        if (addresses.isEmpty()) {
            addresses = IntStream.range(0,100).mapToObj(i -> {
                Address address = AddressFactory.generateMockAddress();
                return addressRepository.save(address);
            }).toList();
        }
        return addresses;
    }

    private void insertPeopleAndAddresses(List<Company>companies) {
        for (int i = 0; i < 100; i++) {
            Address address = AddressFactory.generateMockAddress();
            Person person = PersonFactory.generateMockPerson(companies.get(faker.number().numberBetween(0,companies.size())),address);
            personRepository.save(person);
            addressRepository.save(address);
        }
    }

}
