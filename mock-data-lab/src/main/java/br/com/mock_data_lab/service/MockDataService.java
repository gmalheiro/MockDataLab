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
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class MockDataService {

    private final PersonRepository personRepository;
    private final CompanyRepository companyRepository;
    private final AddressRepository addressRepository;
    private final Logger logger = LoggerFactory.getLogger(MockDataService.class);

    public MockDataService(PersonRepository personRepository, CompanyRepository companyRepository, AddressRepository addressRepository) {
        this.personRepository = personRepository;
        this.companyRepository = companyRepository;
        this.addressRepository = addressRepository;
    }

    @PostConstruct
    private void generateMockData() {
        for (int i = 0; i < 100; i++) {
            Address address = AddressFactory.generateMockAddress();
            Company company = CompanyFactory.generateMockCompany();
            Person person = PersonFactory.generateMockPerson(company, address);
            personRepository.save(person);
            addressRepository.save(address);
            companyRepository.save(company);
        }
    }

}
