package com.mjubus.server.service.mjuCalendar;

import com.mjubus.server.domain.BusCalendar;
import com.mjubus.server.domain.BusTimeTable;
import com.mjubus.server.exception.Bus.BusNotFoundException;
import com.mjubus.server.exception.BusCalenderNotFoundException;
import com.mjubus.server.repository.BusCalendarRepository;
import com.mjubus.server.util.DateHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class BusCalendarService implements BusCalendarInterface {

    @Autowired
    private BusCalendarRepository busCalendarRepository;

    @Override
    public BusCalendar findByDate(LocalDateTime date) {
        System.out.println(DateHandler.getDayOfWeek(date));
        Optional<BusCalendar> optionalBusCalendar = busCalendarRepository.findBusCalendarByDate(date.toLocalDate(), date.toLocalTime(), DateHandler.getDayOfWeek(date));
        return optionalBusCalendar.orElseThrow(() -> new BusCalenderNotFoundException(date));
    }

}

