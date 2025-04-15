package org.ptt.schedule.service.simple;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.ptt.schedule.dto.ExitDTO;
import org.ptt.schedule.model.Exit;
import org.ptt.schedule.repository.DriverRepository;
import org.ptt.schedule.repository.ExitRepository;
import org.ptt.schedule.repository.RouteRepository;
import org.ptt.schedule.repository.TransportRepository;
import org.ptt.schedule.service.ExitService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SimpleExitService implements ExitService {

    private final ExitRepository exitRepository;
    private final DriverRepository driverRepository;
    private final RouteRepository routeRepository;
    private final TransportRepository transportRepository;

    @Override
    public List<ExitDTO> findAll() {
        return exitRepository.findAll().stream().map(this::toDto).toList();
    }

    @Override
    public ExitDTO findById(Integer number) {
        Exit exit = exitRepository.findById(number).orElseThrow();
        return toDto(exit);
    }

    @Override
    public Exit update(ExitDTO exitDTO) {
        Exit existing = exitRepository.findById(exitDTO.getNumber()).orElseThrow();

        return getExit(exitDTO, existing);
    }

    private Exit getExit(ExitDTO exitDTO, Exit existing) {
        existing.setDriver(driverRepository.findByPassport(exitDTO.getDriver())
                .orElseThrow());
        existing.setRoute(routeRepository.findById(exitDTO.getRoute())
                .orElseThrow());
        existing.setTransport(transportRepository.findByNumber(exitDTO.getTransport())
                .orElseThrow());

        return exitRepository.save(existing);
    }

    @Override
    public Exit save(ExitDTO exitDTO) {
        Exit newExit = new Exit();

        return getExit(exitDTO, newExit);
    }

    @Override
    @Transactional
    public void delete(Integer number) {
        exitRepository.deleteByNumber(number);
    }

    private ExitDTO toDto(Exit exit) {
        return new ExitDTO(
                exit.getNumber(),
                exit.getTransport().getNumber(),
                exit.getRoute().getNumber(),
                exit.getDriver().getPassport()
        );
    }
}
