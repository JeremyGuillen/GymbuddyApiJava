package com.gymbuddy.gymbuddy.Entity;

import jakarta.persistence.*;


@Entity
@Table(name = "exercises")
public class Exercises {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_exersice", nullable = false)
    private Long idExercise;

    @Column(name = "name")
    private String name;

    @Column(name = "video_url")
    private String videUrl;

    @Column()
    private String descirption;

    public Long getIdExercise() {
        return idExercise;
    }

    public void setIdExercise(Long idExercise) {
        this.idExercise = idExercise;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVideUrl() {
        return videUrl;
    }

    public void setVideUrl(String videUrl) {
        this.videUrl = videUrl;
    }

    public String getDescirption() {
        return descirption;
    }

    public void setDescirption(String descirption) {
        this.descirption = descirption;
    }


}
