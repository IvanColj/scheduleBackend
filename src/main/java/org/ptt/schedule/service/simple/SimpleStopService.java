package org.ptt.schedule.service.simple;

import lombok.AllArgsConstructor;
import org.ptt.schedule.dto.StopDTO;
import org.ptt.schedule.logic.StopStartEnd;
import org.ptt.schedule.model.Stop;
import org.ptt.schedule.repository.StopRepository;
import org.ptt.schedule.service.StopService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
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
    public List<StopStartEnd> getStopStartEnd(String address) {
        return stopRepository.getStopStartEnd(URLDecoder.decode(address, StandardCharsets.UTF_8));
    }

    @Override
    public Stop save(StopDTO stop) {
        Stop newStop = new Stop();
        newStop.setId(stop.getNumber());
        newStop.setName(stop.getName());
        newStop.setAddress(stop.getAddress());
        return stopRepository.save(newStop);
    }

    @Override
    public Stop update(StopDTO stop) {
        Stop oldStop = stopRepository.findById(stop.getNumber()).orElseThrow();
        if (stop.getName() != null) {
            oldStop.setName(stop.getName());
        }
        if (stop.getAddress() != null) {
            oldStop.setAddress(stop.getAddress());
        }
        return stopRepository.save(oldStop);
    }

    @Override
    @Transactional
    public void delete(Integer number) {
        stopRepository.delete(number);
    }
}
