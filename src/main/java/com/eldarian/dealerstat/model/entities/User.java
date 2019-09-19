package com.eldarian.dealerstat.model.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

@Entity
@Table (name="user")
@Data
public class User extends AbstractEntity{

    public User() {
    }

    @Size(min=3, max=50)
    private String name;

    @Size(min=8, max=20)
    @NotNull
    private String password;

    @Size(min=8, max=20)
    private String email;

    @Column (name = "created_at")
    private Date createdAt;

    @Column (name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "gameObject_id")
    @JsonManagedReference
    List<GameObject> gameObjects;

    @OneToMany (mappedBy = "author")
    @LazyCollection(LazyCollectionOption.FALSE)
    @JsonManagedReference
    private List<Comment> comments;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", createdAt=" + createdAt +
                ", role=" + role +
                '}';
    }
}
