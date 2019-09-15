package com.pashov.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "virtual_machines")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class VirtualMachine {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "CPU")
    private double CPU; // in MHz
    @Column(name = "memory")
    private int memory; // in MB
    @OneToOne
    private Disk disk;
    @OneToMany(mappedBy = "virtualMachine")
    private Set<Network> networks;
}