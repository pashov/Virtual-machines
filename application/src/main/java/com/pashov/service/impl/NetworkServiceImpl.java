package com.pashov.service.impl;

import com.pashov.dao.Disk;
import com.pashov.dao.Network;
import com.pashov.exception.BusinessRuleException;
import com.pashov.repository.NetworkRepository;
import com.pashov.service.NetworkService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class NetworkServiceImpl implements NetworkService {
    private final NetworkRepository networkRepository;

    public NetworkServiceImpl(NetworkRepository networkRepository) {
        this.networkRepository = networkRepository;
    }

    @Override
    public List<Network> getAll() {
        return networkRepository.findAll();
    }

    @Override
    public Network get(int id) {
        return networkRepository.findById(id)
                .orElseThrow(() -> new BusinessRuleException(String.format("No network with id: %d exists", id)));
    }

    @Override
    public void create(Network network) {
        Optional<Network> networkById = networkRepository.findById(network.getId());
        if (networkById.isPresent()) {
            throw new BusinessRuleException(String.format("Network with id: %d already exists", network.getId()));
        }
        networkRepository.save(network);
    }

    @Override
    public void update(Network network) {
        networkRepository.save(network);
    }

    @Transactional
    @Override
    public void delete(int id) {
        networkRepository.deleteById(id);
    }
}