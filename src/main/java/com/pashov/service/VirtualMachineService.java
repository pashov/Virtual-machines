package com.pashov.service;

import com.pashov.model.Disk;
import com.pashov.model.Network;
import com.pashov.model.VirtualMachine;

import java.util.List;

public interface VirtualMachineService {
    List<VirtualMachine> getAll();

    VirtualMachine get(String id);

    void create(VirtualMachine virtualMachine);

    void update(String id, VirtualMachine updatedVirtualMachine);

    void delete(String id);

    void attachDisk(String id, Disk disk);

    void attachNetworks(String id, List<Network> networks);
}