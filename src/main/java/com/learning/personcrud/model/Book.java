package com.learning.personcrud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

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
    name = "books"
)
public class Book {
    
    @Id
    @GeneratedValue
    private Long id;

    @Column(
        nullable = false
    )
    private String name;
    
    @Column(
        nullable = false
    )
    private String author;
    
    @Column(
        nullable = false
    )
    private String publisher;
    
    @Column(
        nullable = false
    )
    private String isbn;

}
