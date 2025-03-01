package com.registerphoto.register_photographer.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "photographers")
public class Photographer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Please, insert a name")
    @Size(min = 3, max = 100, message = "Your name must have between 3 or 100 characters")
    private String fullName;

    @NotBlank(message = "Please, insert a city")
    private String city;

    @NotBlank(message = "Please, insert a postal code")
    private String postalCode;

    @NotBlank(message = "Please, insert a contact")
    @Size(min = 10, message = "Contact must have at least 10 characters")
    private String contact;

    @Email(message = "Email must be validt")
    @NotBlank(message = "Please, insert a E-mail")
    private String email;

    @ElementCollection
    @CollectionTable(name = "specializations", joinColumns = @JoinColumn(name = "photographer_id"))
    @Column(name = "specialization")
    private List<String> specializations;

    private String cameras;
    private String lenses;
    private String drones;
    private String lighting;

    private String portfolio;
}
