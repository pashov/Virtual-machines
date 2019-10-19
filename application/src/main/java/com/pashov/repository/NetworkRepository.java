package com.pashov.repository;

import com.pashov.dao.Network;
import com.pashov.dao.VirtualMachine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sun.nio.ch.Net;

import java.util.Optional;

@Repository
public interface NetworkRepository extends JpaRepository<Network, String> {
    Optional<Network> findById(int id);

    void deleteById(int id);
}
