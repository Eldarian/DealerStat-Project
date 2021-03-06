package com.eldarian.dealerstat.model.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "gameObject")
@Getter
@Setter
public class GameObject extends AbstractEntity{

    public GameObject() {
    }

    @Column
    private String title;

    @Column
    private String text;

    @Column
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column
    private Date createdAt;

    @Column
    private Date updatedAt;

    @OneToMany (mappedBy = "gameObject")
    @LazyCollection(LazyCollectionOption.FALSE)
    @JsonManagedReference(value = "gameObject-comment")
    private List<Comment> comments;

    @ManyToOne
    @JoinColumn(name = "game_id")
    @JsonBackReference(value = "game-gameObject")
    private Game game;

    @ManyToOne
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "user_id")
    @JsonBackReference (value = "user-gameObject")
    private User owner;

}
