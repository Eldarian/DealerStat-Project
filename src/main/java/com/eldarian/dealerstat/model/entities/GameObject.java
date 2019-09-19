package com.eldarian.dealerstat.model.entities;

import lombok.Data;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Calendar;
import java.util.List;

@Entity
@Table(name = "gameObject")
@Data
public class GameObject {
    @Id
    @Column(name="gameObject_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long gameObjectId;

    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(
            name = "user_has_gameObject",
            joinColumns = @JoinColumn(name = "gameObject_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> authors;

    @Column
    private String title;

    @Column
    private String text;

    @Column
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column
    private Calendar createdAt;

    @Column
    private Calendar updatedAt;

    @OneToMany (mappedBy = "gameObject")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Comment> comments;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;

}
