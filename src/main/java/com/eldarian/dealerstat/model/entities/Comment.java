package com.eldarian.dealerstat.model.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Data
public class Comment {

    @Id
    @Column(name = "comment_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long commentId;

    @Column
    private String message;

    @Column
    private Calendar createdAt;

    @Column
    private int rate;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User author;

    @ManyToOne
    @JoinColumn(name="gameObject_id")
    private User gameObject;

}
