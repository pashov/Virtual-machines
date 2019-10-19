package com.pashov.web;

import com.pashov.dao.Disk;
import com.pashov.dao.Network;
import com.pashov.service.NetworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/network")
public class NetworkController {
    @Autowired
    private NetworkService networkService;

    @GetMapping(value = "", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(OK)
    public List<Network> getAll() {
        return networkService.getAll();
    }

    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(OK)
    public Network get(@PathVariable int id) {
        return networkService.get(id);
    }

    @PostMapping("")
    @ResponseStatus(CREATED)
    public void create(@RequestBody Network network) {
        networkService.create(network);
    }

    @PutMapping("")
    @ResponseStatus(NO_CONTENT)
    public void update(@RequestBody Network network) {
        networkService.update(network);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable int id) {
        networkService.delete(id);
    }
}