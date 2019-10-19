package com.pashov.service;

import com.pashov.dao.Network;

import java.util.List;

public interface NetworkService {
    List<Network> getAll();

    Network get(int id);

    void create(Network network);

    void update(Network network);

    void delete(int id);
}
