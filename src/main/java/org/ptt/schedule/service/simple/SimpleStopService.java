package org.ptt.schedule.service.simple;

import lombok.AllArgsConstructor;
import org.ptt.schedule.model.Stop;
import org.ptt.schedule.repository.StopRepository;
import org.ptt.schedule.service.StopService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SimpleStopService implements StopService {
    private final StopRepository stopRepository;

    @Override
    public List<Stop> findAll() {
        return stopRepository.findAll();
    }

    @Override
    public Optional<Stop> findById(Integer id) {
        return stopRepository.findById(id);
    }

    @Override
    public Stop save(Stop stop) {
        return stopRepository.save(stop);
    }

    @Override
    public Stop update(Stop stop) {
        return stopRepository.save(stop);
    }

    @Override
    public void delete(Stop stop) {
        stopRepository.delete(stop);
    }
}
