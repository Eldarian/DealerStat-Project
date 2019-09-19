package com.eldarian.dealerstat.model.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Data
public class Comment extends AbstractEntity{

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
