package com.app.web.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "tbl_user")
@Data
public class User {

    @Id
    @SequenceGenerator(name = "user_seq", sequenceName = "user_seq", allocationSize = 1, initialValue = 2)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "user_seq")
    @Column(columnDefinition = "bigint unsigned")
    private long id;

    @Column(length = 25, nullable = false, unique = true)
    private String loginId;

    @Column(length = 100, nullable = false)
    private String loginPwd;

    @Column(length = 50, nullable = false)
    private String email;

    @Column(length = 50, nullable = false)
    private String firstName;

    @Column(length = 50)
    private String middleName;

    @Column(length = 50, nullable = false)
    private String lastName;

    @Column(length = 20, nullable = false)
    private String phoneNumber;

    @Column(nullable = false, columnDefinition = "int unsigned")
    private int roles;

    @Column(length = 50, nullable = false)
    private String permissions;

    @Column
    private boolean enabled;

    @Column
    private boolean locked;

}
