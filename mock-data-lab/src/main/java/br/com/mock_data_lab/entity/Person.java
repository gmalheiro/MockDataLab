package br.com.mock_data_lab.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private String firstName;
    private String lastName;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Company company;
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
}
