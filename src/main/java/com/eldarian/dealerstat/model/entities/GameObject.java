package com.eldarian.dealerstat.model.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

@Entity
@Table(name = "gameObject")
@Data
public class GameObject extends AbstractEntity{
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
    @JsonManagedReference
    private List<Comment> comments;

    @ManyToOne
    @JoinColumn(name = "game_id")
    @JsonBackReference
    private Game game;

    @ManyToOne
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User author;

}
