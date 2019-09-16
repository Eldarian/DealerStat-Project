package com.eldarian.dealerstat.model.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Calendar;
import java.util.List;

@Entity
@Table (name="User")
@Data
public class User {

    public User() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(min=3, max=50)
    private String name;

    @Size(min=8, max=20)
    @NotNull
    private String password;

    @Size(min=8, max=20)
    private String email;

    @Size(min=8, max=20)
    @Column (name = "created_at")
    private Calendar createdAt;

    @Column (name = "role")
    private Role role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<GameObject> gameObjects;

    @Override
    public String toString() {
        return "User{" +
                "id=" +     id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", createdAt=" + createdAt +
                ", role=" + role +
                '}';
    }
}
