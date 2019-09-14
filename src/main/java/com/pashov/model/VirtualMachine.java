package com.pashov.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class VirtualMachine {
    private String id;
    private String name;
    private double CPU; // in MHz
    private int memory; // in MB
    private Disk disk;
    private List<Network> networks;
}