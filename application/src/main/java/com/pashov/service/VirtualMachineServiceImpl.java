package com.pashov.service;

import com.pashov.exception.BusinessRuleException;
import com.pashov.dao.Disk;
import com.pashov.dao.Network;
import com.pashov.dao.VirtualMachine;
import com.pashov.repository.DiskRepository;
import com.pashov.repository.NetworkRepository;
import com.pashov.repository.VirtualMachineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class VirtualMachineServiceImpl implements VirtualMachineService {
    private final VirtualMachineRepository virtualMachineRepository;
    private final DiskRepository diskRepository;
    private final NetworkRepository networkRepository;

    @Autowired
    public VirtualMachineServiceImpl(VirtualMachineRepository virtualMachineRepository,
                                     DiskRepository diskRepository,
                                     NetworkRepository networkRepository) {
        this.virtualMachineRepository = virtualMachineRepository;
        this.diskRepository = diskRepository;
        this.networkRepository = networkRepository;
    }

    @Override
    public List<VirtualMachine> getAll() {
        return virtualMachineRepository.findAll();
    }

    @Override
    public VirtualMachine get(int id) {
        return virtualMachineRepository.findById(id)
                .orElseThrow(() -> new BusinessRuleException(String.format("No VM with id: %d exists", id)));
    }

    @Override
    public void create(VirtualMachine virtualMachine) {
        Optional<VirtualMachine> virtualMachineById = getOptional(virtualMachine.getId());
        if (virtualMachineById.isPresent()) {
            throw new BusinessRuleException(String.format("Virtual machine with id: %d already exists", virtualMachine.getId()));
        }
        virtualMachineRepository.save(virtualMachine);
    }

    private Optional<VirtualMachine> getOptional(int id) {
        return virtualMachineRepository.findById(id);
    }


    @Override
    public void update(VirtualMachine updatedVirtualMachine) {
        virtualMachineRepository.save(updatedVirtualMachine);
    }

    @Transactional
    @Override
    public void delete(int id) {
        virtualMachineRepository.deleteById(id);
    }

    @Override
    public void attachDisk(int id, Set<Disk> disks) {
        if (disks.size() < 1) {
            throw new BusinessRuleException("Minimum disks size is 1");
        }
        diskRepository.saveAll(disks);
        VirtualMachine virtualMachine = get(id);
        virtualMachine.getDisks().addAll(disks);
        virtualMachineRepository.save(virtualMachine);
    }

    @Override
    public void attachNetworks(int id, Set<Network> networks) {
        networkRepository.saveAll(networks);
        VirtualMachine virtualMachine = get(id);
        virtualMachine.getNetworks().addAll(networks);
        virtualMachineRepository.save(virtualMachine);
    }
}