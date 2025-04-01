package com.bichri.Client_Mgr.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50)
    private String name;
    @Column(length = 50)
    private String company;
    @Column(length = 100)
    private String email;
    @Column(length = 50)
    private String phone;
    @Column(length = 50)
    private String location;
    @Column(length = 100)
    private String password;
    @OneToMany(mappedBy = "client")
    private Collection<Meeting> meetings;
    @OneToMany(mappedBy = "client")
    private Collection<Project> projects;

}
