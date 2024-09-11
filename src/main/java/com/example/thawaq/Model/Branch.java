package com.example.thawaq.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.AssertFalse;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "name should not be empty")
    @Size(max = 50,message = "name should be less than 51")
    @Column(columnDefinition = "VARCHAR(50) NOT NULL")
    private String name;

    @AssertTrue
    @Column(columnDefinition = "BOOLEAN NOT NULL")
    private boolean Closed;

    @ManyToOne
    @JsonIgnore
    private Store store;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "address")
    @PrimaryKeyJoinColumn
    private Address address;

}
