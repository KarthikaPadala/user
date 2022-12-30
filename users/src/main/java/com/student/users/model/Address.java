package com.student.users.model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
@Entity
@Table(name = "address")
@NamedQuery(name = "Address.findAll", query = "SELECT a FROM Address a")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "addressLine1")
    private String addressLine1;

    @Column(name = "addressLine2")
    private String addressLine2;

    @Column(name = "city")
    private String city;
}
