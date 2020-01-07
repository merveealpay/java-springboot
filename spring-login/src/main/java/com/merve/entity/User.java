package com.merve.entity;

import com.sun.tools.javac.comp.Resolve;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "person")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private  String lastName;

    @Column(name = "username")
    private String username;

    @Column(name = "enabled")
    private boolean enabled;

    //Eager Loading helps you to load all your needed entities at once
    //related objects (child objects) are loaded automatically with its parent object.
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(joinColumns = JoinColumn(name = "user_id"), inverseJoinColumns = JoinColumn(name = "role_id"))
    private Collection<Role> roles;
    //Each user will have a role authority.
}
