package org.ptt.schedule.service.simple;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.ptt.schedule.dto.StageDTO;
import org.ptt.schedule.model.Stage;
import org.ptt.schedule.repository.StageRepository;
import org.ptt.schedule.service.StageService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SimpleStageService implements StageService {
        private final StageRepository stageRepository;

    @Override
    public List<StageDTO> findAll() {
        List<Stage> stages = stageRepository.findAll();
        return stages.stream().map(stage -> new StageDTO(
                stage.getNumber(),
                stage.getInitial().getId(),
                stage.getUltimate().getId(),
                stage.getWeekday(),
                stage.getWeekdayJam(),
                stage.getWeekend(),
                stage.getWeekendJam()
        )).toList();
    }

    @Override
    public StageDTO findById(Integer number) {
        Stage stage = stageRepository.findById(number).orElseThrow();
        return new StageDTO(
                stage.getNumber(),
                stage.getInitial().getId(),
                stage.getUltimate().getId(),
                stage.getWeekday(),
                stage.getWeekdayJam(),
                stage.getWeekend(),
                stage.getWeekendJam()
        );
    }

    @Override
    public Stage update(Stage stage) {
        return stageRepository.save(stage);
    }

    @Override
    public Stage save(Stage stage) {
        return stageRepository.save(stage);
    }

    @Override
    @Transactional
    public void delete(Integer number) {
        stageRepository.deleteByNumber(number);
    }
}
