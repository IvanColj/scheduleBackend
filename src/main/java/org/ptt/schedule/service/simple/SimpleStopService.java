package org.ptt.schedule.service.simple;

import lombok.AllArgsConstructor;
import org.ptt.schedule.dto.StopDTO;
import org.ptt.schedule.model.Stop;
import org.ptt.schedule.repository.StopRepository;
import org.ptt.schedule.service.StopService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class SimpleStopService implements StopService {
    private final StopRepository stopRepository;

    @Override
    public List<Stop> findAll() {
        return stopRepository.findAll();
    }

    @Override
    public StopDTO findById(Integer id) {
        Stop stop = stopRepository.findById(id).orElseThrow();
        return new StopDTO(
                stop.getId(),
                stop.getName(),
                stop.getAddress()
        );
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
    @Transactional
    public void delete(Stop stop) {
        stopRepository.delete(stop);
    }
}
