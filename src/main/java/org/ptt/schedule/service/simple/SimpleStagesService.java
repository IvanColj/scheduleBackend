package org.ptt.schedule.service.simple;

import lombok.AllArgsConstructor;
import org.ptt.schedule.dto.StagesDTO;
import org.ptt.schedule.model.Stages;
import org.ptt.schedule.model.StagesId;
import org.ptt.schedule.repository.StagesRepository;
import org.ptt.schedule.service.StagesService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class SimpleStagesService implements StagesService {
    private final StagesRepository stagesRepository;

    @Override
    public List<StagesDTO> findAll() {
        List<Stages> all = stagesRepository.findAll();
        return all.stream().map(stages ->
                new StagesDTO(
                        stages.getId().getNumber(),
                        stages.getId().getRoute()
                )).toList();
    }

    @Override
    public List<StagesDTO> findByRoute(Integer route) {
        return stagesRepository.findByRoute(route);
    }

    @Override
    public Stages update(Stages stages) {
        return stagesRepository.save(stages);
    }

    @Override
    public Stages save(StagesDTO stages) {
        Stages newStages = new Stages();
        StagesId id = new StagesId();
        id.setRoute(stages.getRoute());
        id.setNumber(stages.getNumber());
        newStages.setId(id);
        return stagesRepository.save(newStages);
    }

    @Override
    @Transactional
    public void delete(Stages stages) {
        stagesRepository.delete(stages);
    }
}
