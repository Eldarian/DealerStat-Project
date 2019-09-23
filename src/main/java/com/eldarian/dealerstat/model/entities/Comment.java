package com.eldarian.dealerstat.model.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "comment")
@Getter
@Setter
public class Comment extends AbstractEntity{

    public Comment() {
    }

    @Column
    private String message;

    @Column
    private Calendar createdAt;

    @Column
    private int rate;

    @ManyToOne
    @JoinColumn(name="user_id")
    @JsonBackReference(value = "user-comment")
    private User author;

    @ManyToOne (cascade=CascadeType.ALL)
    @JoinColumn(name="gameObject_id")
    @JsonBackReference (value = "gameObject-comment")
    private GameObject gameObject;

}
