package br.com.mock_data_lab.factory;

import br.com.mock_data_lab.entity.Address;
import com.github.javafaker.Faker;

public class AddressFactory {
    public static Address generateMockAddress() {
        Faker faker = new Faker();
        Address address = new Address();
        address.setStreetAddress(faker.address().streetAddress());
        address.setCity(faker.address().city());
        address.setState(faker.address().state());
        address.setZipCode(faker.address().zipCode());
        address.setCountry(faker.address().country());
        return address;
    }
}
