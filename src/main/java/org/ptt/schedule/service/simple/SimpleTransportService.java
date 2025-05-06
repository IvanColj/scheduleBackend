package org.ptt.schedule.service.simple;

import lombok.AllArgsConstructor;
import org.ptt.schedule.dto.TransportDTO;
import org.ptt.schedule.logic.Schedule;
import org.ptt.schedule.logic.StopSchedule;
import org.ptt.schedule.logic.TimeSchedule;
import org.ptt.schedule.model.Transport;
import org.ptt.schedule.repository.TransportRepository;
import org.ptt.schedule.service.TransportService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalTime;
import java.util.*;

@Service
@AllArgsConstructor
public class SimpleTransportService implements TransportService {
    private TransportRepository transportRepository;

    @Override
    public List<Transport> findAll() {
        return transportRepository.findAll();
    }

    @Override
    public List<Transport> findByType(String type) {
        return transportRepository.findByType(type);
    }

    @Override
    public TransportDTO findByNumber(String number) {
        Transport transport = transportRepository.findByNumber(number).orElseThrow();
        return new TransportDTO(
                transport.getNumber(),
                transport.getType(),
                transport.getModel(),
                transport.getBoardNumber()
        );
    }

    @Override
    public List<Schedule> findBySchedule(String board_number) {
        return transportRepository.findBySchedule(board_number);
    }

    @Override
    public List<Schedule> findScheduleByTime(String boardNumber, LocalTime time) {
        return transportRepository.findScheduleByTime(boardNumber, time);
    }

    public List<TimeSchedule> findScheduleTime(String boardNumber, LocalTime time) {
        List<Schedule> schedules = transportRepository.findScheduleByTime(boardNumber, time);
        List<TimeSchedule> timeSchedules = new ArrayList<>();
        LocalTime endTime = null;
        LocalTime timeArrive;
        int count = 0;
        for (Schedule schedule : schedules) {
            TimeSchedule timeSchedule = new TimeSchedule();
            timeSchedule.setNumber(schedule.getRoute());
            timeSchedule.setStopStart(schedule.getInitial());
            timeSchedule.setStopEnd(schedule.getUltimate());
            timeSchedule.setStartTime(time);
            timeSchedule.setWeekday(schedule.getWeekdayOrWeekend());
            if (count == 0) {
                timeSchedule.setTime(time);
                if (timeSchedule.getWeekday()){
                    endTime = time.plusSeconds(schedule.getWeekday().toSecondOfDay());
                }
                else {
                    endTime = time.plusSeconds(schedule.getWeekend().toSecondOfDay());
                }
            }
            else {
                if (timeSchedule.getWeekday()) {
                    timeArrive = timeSchedules.get(count - 1).getTime().plusSeconds(schedules.get(count - 1).getWeekday().toSecondOfDay());
                    timeSchedule.setTime(timeArrive);
                    if (schedule == schedules.get(schedules.size() - 1)) {
                        timeArrive = timeArrive.plusSeconds(schedule.getWeekday().toSecondOfDay());
                    }
                }
                else {
                    timeArrive = timeSchedules.get(count - 1).getTime().plusSeconds(schedules.get(count - 1).getWeekend().toSecondOfDay());
                    timeSchedule.setTime(timeArrive);
                    if (schedule == schedules.get(schedules.size() - 1)) {
                        timeArrive = timeArrive.plusSeconds(schedule.getWeekend().toSecondOfDay());
                    }
                }
                endTime = timeArrive;
            }

            timeSchedules.add(timeSchedule);
            count++;
        }

        for (TimeSchedule timeSchedule : timeSchedules) {
            timeSchedule.setEndTime(endTime);
        }
        return timeSchedules;
    }

    @Override
    public List<String> findAllTypes() {
        return transportRepository.findByTypes();
    }

    @Override
    public List<LocalTime> findAllStarts(String board_number) {
        return transportRepository.findAllStarts(board_number);
    }

    public Map<Integer, List<StopSchedule>> findBySchedules(String board_number) {
        List<Schedule> schedulesRoute = transportRepository.findBySchedule(board_number);
        Map<Integer, List<StopSchedule>> stopSchedules = new HashMap<>();
        long count = 0;
        int counter = 1;
        Schedule last = null;
        LocalTime result;
        for (Schedule schedule : schedulesRoute) {
            if (stopSchedules.containsKey(schedule.getRoute())) {
                List<StopSchedule> stopScheduleList = stopSchedules.get(schedule.getRoute());
                StopSchedule stopScheduleNew = new StopSchedule();
                stopScheduleNew.setStop(schedule.getInitial());
                LocalTime initial = stopScheduleList.get(stopScheduleList.size() - 1).getTime();
                if (last.getWeekdayOrWeekend()) {
                    result = last.getWeekday().plusSeconds(initial.toSecondOfDay());
                }
                else {
                    result = last.getWeekend().plusSeconds(initial.toSecondOfDay());
                }
                stopScheduleNew.setTime(result);
                stopScheduleNew.setWeekday(schedule.getWeekdayOrWeekend());
                stopScheduleList.add(stopScheduleNew);
                counter++;
                if (counter == count) {
                    insertToListSchedule(schedule, stopScheduleList);
                }
            } else {
                count = schedulesRoute.stream()
                        .filter(dto -> Objects.equals(dto.getRoute(), schedule.getRoute()))
                        .count();
                List<StopSchedule> stopScheduleList = new ArrayList<>();
                StopSchedule stopScheduleNew = new StopSchedule();
                stopScheduleNew.setStop(schedule.getInitial());
                stopScheduleNew.setTime(schedule.getStart());
                stopScheduleNew.setWeekday(schedule.getWeekdayOrWeekend());
                stopScheduleList.add(stopScheduleNew);
                stopSchedules.put(schedule.getRoute(), stopScheduleList);
                counter = 1;
                if (count == 1) {
                    insertToListSchedule(schedule, stopScheduleList);
                }
            }
            last = schedule;
        }
        return stopSchedules;
    }

    private void insertToListSchedule(Schedule schedule, List<StopSchedule> stopScheduleList) {
        StopSchedule stopScheduleLast = new StopSchedule();
        stopScheduleLast.setStop(schedule.getUltimate());
        LocalTime initialLast = stopScheduleList.get(stopScheduleList.size() - 1).getTime();
        LocalTime resultLast;
        if (schedule.getWeekdayOrWeekend()) {
            resultLast = schedule.getWeekday().plusSeconds(initialLast.toSecondOfDay());
        }
        else {
            resultLast = schedule.getWeekend().plusSeconds(initialLast.toSecondOfDay());
        }
        stopScheduleLast.setTime(resultLast);
        stopScheduleList.add(stopScheduleLast);
    }

    @Override
    public Transport save(TransportDTO transport) {
        Transport transportToSave = new Transport();
        transportToSave.setNumber(transport.getNumber());
        transportToSave.setType(transport.getType());
        transportToSave.setModel(transport.getModel());
        transportToSave.setBoardNumber(transport.getBoardNumber());
        return transportRepository.save(transportToSave);
    }

    @Override
    public Transport update(TransportDTO transport) {
        Transport newTransport = new Transport();
        if (transport.getType() != null) {
            newTransport.setType(transport.getType());
        }
        if (transport.getModel() != null) {
            newTransport.setModel(transport.getModel());
        }
        if (transport.getBoardNumber() != null) {
            newTransport.setBoardNumber(transport.getBoardNumber());
        }
        return transportRepository.save(newTransport);
    }

    @Override
    @Transactional
    public void delete(Transport transport) {
        transportRepository.delete(transport);
    }
}
