package com.learning.personcrud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(
    name="person",
    uniqueConstraints = {@UniqueConstraint(
        name = "email_unique",
        columnNames = "emailAddress"
    )}
)
public class Person {
    
    @Id
    @GeneratedValue
    private Long id;
    
    @Column(
        nullable = false
    )
    private String firstName;

    @Column(
        nullable = false
    )
    private String lastName;
    
    @Column(
        nullable = false
    )
    private String emailAddress;

    private String phoneNumber;


}
