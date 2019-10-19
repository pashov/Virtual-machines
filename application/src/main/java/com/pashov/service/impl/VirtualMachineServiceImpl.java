package com.pashov.service.impl;

import com.pashov.dao.Disk;
import com.pashov.dao.Network;
import com.pashov.exception.BusinessRuleException;
import com.pashov.dao.VirtualMachine;
import com.pashov.repository.DiskRepository;
import com.pashov.repository.NetworkRepository;
import com.pashov.repository.VirtualMachineRepository;
import com.pashov.service.VirtualMachineService;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.internal.util.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

@Service
@Slf4j
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
        Optional<VirtualMachine> virtualMachineById = virtualMachineRepository.findById(virtualMachine.getId());
        if (virtualMachineById.isPresent()) {
            throw new BusinessRuleException(String.format("Virtual machine with id: %d already exists", virtualMachine.getId()));
        }
        virtualMachineRepository.save(virtualMachine);
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
    public void attachDisks(int virtualMachineId, Set<Integer> diskIds) {
        if (diskIds.size() < 1) {
            throw new BusinessRuleException("Minimum disks size is 1");
        }
        VirtualMachine virtualMachine = get(virtualMachineId);
        Set<Disk> disks = virtualMachine.getDisks();
        diskIds.stream()
                .flatMap(id -> {
                    Optional<Disk> disk = diskRepository.findById(id);
                    if (disk.isPresent()) {
                        return Stream.of(disk.get());
                    } else {
                        log.error(String.format("No disk with id: %d exists", id));
                        return Stream.empty();
                    }
                })
                .forEach(disks::add);
        virtualMachineRepository.save(virtualMachine);
    }

    @Override
    public void attachNetworks(int virtualMachineId, Set<Integer> networkIds) {
        VirtualMachine virtualMachine = get(virtualMachineId);
        Set<Network> networks = virtualMachine.getNetworks();
        networkIds.stream()
                .flatMap(id -> {
                    Optional<Network> network = networkRepository.findById(id);
                    if (network.isPresent()) {
                        return Stream.of(network.get());
                    } else {
                        log.error(String.format("No network with id: %d exists", id));
                        return Stream.empty();
                    }
                })
                .forEach(networks::add);
        virtualMachineRepository.save(virtualMachine);
    }
}