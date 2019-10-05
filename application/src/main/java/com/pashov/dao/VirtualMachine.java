package com.pashov.dao;

import lombok.*;

import javax.persistence.*;
import java.util.Collections;
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
    @OneToMany
    @JoinColumn(name = "virtual_machine_id")
    private Set<Disk> disks = Collections.emptySet();
    @OneToMany
    @JoinColumn(name = "virtual_machine_id")
    private Set<Network> networks = Collections.emptySet();
}