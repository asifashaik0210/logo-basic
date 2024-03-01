package com.logo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="name",unique = true)
    private String name;
    @Column(name="email",unique = true)
    private String email;
    @Column(name="body",unique = true)
    private String body;
    @ManyToOne
    @JoinColumn(name="post-id")
    private Post post;
}
