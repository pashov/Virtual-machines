package com.pashov.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "networks")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Network {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "data")
    private String data;
}