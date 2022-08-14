package com.mjubus.server.service.bus;

import com.mjubus.server.domain.Bus;
import com.mjubus.server.dto.BusResponseDto;
import com.mjubus.server.dto.BusStatusDto;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public interface BusServiceInterface {
    Bus findBusByBusId(Long id);

    BusStatusDto getBusStatusByBusId(Long id);

    List<BusResponseDto> getBusListByDate(LocalDateTime date);
}
