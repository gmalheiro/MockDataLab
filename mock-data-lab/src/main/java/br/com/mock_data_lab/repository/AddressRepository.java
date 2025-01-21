package br.com.mock_data_lab.repository;

import br.com.mock_data_lab.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {
    Address findAddressByStreetAddress(String streetAddress);
}
