package com.eldarian.dealerstat.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.util.List;

@Entity
@Table (name="user")
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class User extends AbstractEntity{

    public User() {
    }

    @Size(min=3, max=50)
    @Column(unique = true)
    @NotNull
    private String name;

    @Size(min=8, max=20)
    @NotNull
    private String password;

    private String email;

    @Column (name = "created_at")
    private Date createdAt;

    @Column (name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany
    @LazyCollection(LazyCollectionOption.TRUE)
    @JoinColumn(name = "gameObject_id")
    List<GameObject> gameObjects;

    @OneToMany (mappedBy = "author")
    @LazyCollection(LazyCollectionOption.TRUE)
    private List<Comment> comments;
}
