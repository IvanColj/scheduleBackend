package org.ptt.schedule.service.simple;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.ptt.schedule.dto.RouteDTO;
import org.ptt.schedule.model.Route;
import org.ptt.schedule.repository.RouteRepository;
import org.ptt.schedule.service.RouteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SimpleRouteService implements RouteService {
    private final RouteRepository routeRepository;

    @Override
    public List<RouteDTO> findAll() {
        List<Route> routes = routeRepository.findAll();
        return routes.stream().map(route -> new RouteDTO(
                route.getNumber(),
                route.getStart(),
                route.getWeekday()
        )).toList();
    }

    @Override
    public RouteDTO findById(Integer number) {
        Route route = routeRepository.findById(number).orElseThrow();
        return new RouteDTO(
                route.getNumber(),
                route.getStart(),
                route.getWeekday()
        );
    }

    @Override
    public Route update(RouteDTO route) {
        Route routeToUpdate = routeRepository.findById(route.getNumber()).orElseThrow();
        if (route.getStart() != null) {
            routeToUpdate.setStart(route.getStart());
        }
        if (route.getWeekday() != null) {
            routeToUpdate.setWeekday(route.getWeekday());
        }
        return routeRepository.save(routeToUpdate);
    }

    @Override
    public Route save(RouteDTO route) {
        Route routeToSave = routeRepository.findById(route.getNumber()).orElseThrow();
        return routeRepository.save(routeToSave);
    }

    @Override
    @Transactional
    public void delete(Integer number) {
        routeRepository.deleteByNumber(number);
    }
}
