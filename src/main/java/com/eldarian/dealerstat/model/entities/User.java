package com.eldarian.dealerstat.model.entities;

import lombok.Data;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Calendar;
import java.util.List;

@Entity
@Table (name="user")
@Data
public class User {

    public User() {
    }

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    @Size(min=3, max=50)
    private String name;

    @Size(min=8, max=20)
    @NotNull
    private String password;

    @Size(min=8, max=20)
    private String email;

    @Column (name = "created_at")
    private Calendar createdAt;

    @Column (name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;

    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(
            name = "user_has_gameObject",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "gameObject_id"))
    List<GameObject> gameObjects;

    @OneToMany (mappedBy = "author")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Comment> comments;

    @Override
    public String toString() {
        return "User{" +
                "id=" + userId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", createdAt=" + createdAt +
                ", role=" + role +
                '}';
    }
}
