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
    public RouteDTO update(RouteDTO route) {
        RouteDTO routeDTO = findById(route.getNumber());
        if (route.getStart() != null) {
            routeDTO.setStart(route.getStart());
        }
        if (route.getWeekday() != null) {
            routeDTO.setWeekday(route.getWeekday());
        }
        return routeRepository.update(route);
    }

    @Override
    public RouteDTO save(RouteDTO route) {
        return routeRepository.save(route);
    }

    @Override
    @Transactional
    public void delete(Integer number) {
        routeRepository.deleteByNumber(number);
    }
}
