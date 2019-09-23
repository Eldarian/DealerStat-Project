package com.eldarian.dealerstat.model.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "game")
@Getter
@Setter
public class Game extends AbstractEntity{

    public Game() {
    }

    @Column(unique = true)
    private String name;

    @OneToMany (mappedBy = "game")
    @LazyCollection(LazyCollectionOption.TRUE)
    private List<GameObject> gameObjects;
}
