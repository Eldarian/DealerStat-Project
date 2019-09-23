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
    @JsonBackReference
    private User author;

    @ManyToOne
    @JoinColumn(name="gameObject_id")
    @JsonBackReference
    private GameObject gameObject;

}
