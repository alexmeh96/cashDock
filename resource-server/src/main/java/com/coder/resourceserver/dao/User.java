package com.coder.resourceserver.dao;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Data
@Entity
@Table(	name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "email")
        })
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 20)
    private String username;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotBlank
    @Size(max = 120)
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "category_id", referencedColumnName = "id")
//    private Category category;

//    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
//    @OneToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private Set<Category> categories = new HashSet<>();

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Category> categories;

    public User() {
    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }


}