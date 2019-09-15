package com.pashov.service;

import com.pashov.model.Disk;
import com.pashov.model.Network;
import com.pashov.model.VirtualMachine;

import java.util.List;

public interface VirtualMachineService {
    List<VirtualMachine> getAll();

    VirtualMachine get(int id);

    void create(VirtualMachine virtualMachine);

    void update(VirtualMachine updatedVirtualMachine);

    void delete(int id);

    void attachDisk(int id, Disk disk);

    void attachNetworks(int id, List<Network> networks);
}