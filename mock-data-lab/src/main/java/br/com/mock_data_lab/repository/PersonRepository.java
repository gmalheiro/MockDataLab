package br.com.mock_data_lab.repository;

import br.com.mock_data_lab.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person,Long> {
    Person findByFullName(String fullName);
}
