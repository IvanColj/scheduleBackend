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
    public ExitDTO update(ExitDTO exit) {
        Exit ex = exitRepository.findById(exit.getNumber()).orElseThrow();
        if (ex.getDriver().getPassport() != null) {
            ex.getDriver().setPassport(ex.getDriver().getPassport());
        }
        if (ex.getRoute().getNumber() != null) {
            ex.getRoute().setNumber(ex.getRoute().getNumber());
        }
        if (ex.getTransport().getNumber() != null) {
            ex.getTransport().setNumber(ex.getTransport().getNumber());
        }
        return exitRepository.update(new ExitDTO(
                ex.getNumber(),
                ex.getTransport().getNumber(),
                ex.getRoute().getNumber(),
                ex.getDriver().getPassport()
        ));
    }

    @Override
    public ExitDTO save(ExitDTO exit) {
        return exitRepository.save(exit);
    }

    @Override
    @Transactional
    public void delete(Integer number) {
        exitRepository.deleteByNumber(number);
    }
}
