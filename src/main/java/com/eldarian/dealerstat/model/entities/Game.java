package com.eldarian.dealerstat.model.entities;

import lombok.Data;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Game {
    @Id
    @Column(name = "game_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long gameId;

    @Column(unique = true)
    private String name;

    @OneToMany (mappedBy = "game")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<GameObject> gameObjects;
}
