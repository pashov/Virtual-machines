package com.pashov.service;

import com.pashov.dao.VirtualMachine;

import java.util.List;
import java.util.Set;

public interface VirtualMachineService {
    List<VirtualMachine> getAll();

    VirtualMachine get(int id);

    void create(VirtualMachine virtualMachine);

    void update(VirtualMachine updatedVirtualMachine);

    void delete(int id);

    void attachDisks(int virtualMachineId, Set<Integer> diskIds);

    void attachNetworks(int virtualMachineId, Set<Integer> networkIds);
}