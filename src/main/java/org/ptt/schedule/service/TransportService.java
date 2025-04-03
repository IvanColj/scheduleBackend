package org.ptt.schedule.service;

import org.ptt.schedule.model.Transport;

import java.util.List;
import java.util.Optional;

public interface TransportService {
    List<Transport> findAll();
    List<Transport> findByType(String type);
    Optional<Transport> findByNumber(String number);

    Transport save(Transport transport);
    Transport update(Transport transport);
    void delete(Transport transport);
}
