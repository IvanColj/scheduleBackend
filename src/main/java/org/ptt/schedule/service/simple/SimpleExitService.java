package org.ptt.schedule.service.simple;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.ptt.schedule.dto.ExitDTO;
import org.ptt.schedule.model.Exit;
import org.ptt.schedule.repository.ExitRepository;
import org.ptt.schedule.service.ExitService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SimpleExitService implements ExitService {
    private final ExitRepository exitRepository;

    @Override
    public List<ExitDTO> findAll() {
        List<Exit> exits = exitRepository.findAll();
        return exits.stream().map(exit ->
                        new ExitDTO(
                        exit.getNumber(),
                        exit.getTransport().getNumber(),
                        exit.getRoute().getNumber(),
                        exit.getDriver().getPassport()
                )).toList();
    }

    @Override
    public ExitDTO findById(Integer number) {
        Exit exit = exitRepository.findById(number).orElseThrow();
        return new ExitDTO(
                exit.getNumber(),
                exit.getTransport().getNumber(),
                exit.getRoute().getNumber(),
                exit.getDriver().getPassport()
        );
    }

    @Override
    public Exit save(Exit exit) {
        return exitRepository.save(exit);
    }

    @Override
    @Transactional
    public void delete(Integer number) {
        exitRepository.deleteByNumber(number);
    }
}
