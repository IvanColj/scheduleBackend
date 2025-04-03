package org.ptt.schedule.service.simple;

import lombok.AllArgsConstructor;
import org.ptt.schedule.model.Transport;
import org.ptt.schedule.repository.TransportRepository;
import org.ptt.schedule.service.TransportService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SimpleTransportService implements TransportService {
    private TransportRepository transportRepository;

    @Override
    public List<Transport> findAll() {
        return transportRepository.findAll();
    }

    @Override
    public List<Transport> findByType(String type) {
        return transportRepository.findByType(type);
    }

    @Override
    public Optional<Transport> findByNumber(String passport) {
        return transportRepository.findByNumber(passport);
    }

    @Override
    public Transport save(Transport transport) {
        return transportRepository.save(transport);
    }

    @Override
    public Transport update(Transport transport) {
        return transportRepository.save(transport);
    }

    @Override
    @Transactional
    public void delete(Transport transport) {
        transportRepository.delete(transport);
    }
}
