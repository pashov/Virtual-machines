package com.pashov.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "disks")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Disk {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "size")
    private int size; // in GB
}