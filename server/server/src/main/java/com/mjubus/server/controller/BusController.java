package com.mjubus.server.controller;


import com.mjubus.server.domain.Bus;
import com.mjubus.server.dto.BusResponseDto;
import com.mjubus.server.dto.BusStatusDto;
import com.mjubus.server.dto.BusTimeTableResponseDto;
import com.mjubus.server.dto.StationDTO;
import com.mjubus.server.service.bus.BusService;
import com.mjubus.server.service.busTimeTable.BusTimeTableService;
import com.mjubus.server.util.DateHandler;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/bus")
@Api(tags = {"버스 정보 조회 API"})
public class BusController {
    @Autowired
    private BusService busService;

    @Autowired
    private BusTimeTableService busTimeTableService;

    @GetMapping("/list")
    @ApiOperation(value = "운행중인 버스 리스트를 받는다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "정상 응답"),
            @ApiResponse(responseCode = "404", description = "요청한 type이 다른 경우")
    })
    @ResponseBody
    public List<BusResponseDto> busTimeTable() {
        return busService.getBusListByDate(DateHandler.getToday());
    }

    @GetMapping("/{busID}/timeTable")
    @ApiOperation(value = "운행중인 버스들의 시간표를 받는다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "정상 응답"),
            @ApiResponse(responseCode = "404", description = "버스 ID가 정상적이지 않은 경")
    })
    @ResponseBody
    public String busList(@PathVariable(value = "busID") Long id) {
        return "{\n" +
                "  \"id\": 100,\n" +
                "  \"name\": \"합정/영등포\",\n" +
                "  \"stations\": [\n" +
                "    {\n" +
                "      \"name\": \"합정역\",\n" +
                "      \"timeList\": [\n" +
                "        {\n" +
                "          \"deaprt_at\": \"07:10\",\n" +
                "          \"arrive_at\": \"07:10\"\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"name\": \"영등포역\",\n" +
                "      \"timeList\": [\n" +
                "        {\n" +
                "          \"depart_at\": \"07:20\",\n" +
                "          \"arrive_at\": \"07:20\"\n" +
                "        }\n" +
                "      ]\n" +
                "    }\n" +
                "  ]\n" +
                "}";
    }

    @GetMapping("/{busID}")
    @ApiOperation(value = "버스에 대한 정보를 조회한다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "정상 응답"),
            @ApiResponse(responseCode = "404", description = "버스 ID 찾지 못하는 경우")
    })
    @ResponseBody
    public Bus info(@PathVariable(value = "busID") Long id) {
        return busService.findBusByBusId(id);
    }

    @GetMapping("/{busID}/status")
    @ApiOperation(value = "버스 운행 여부를 조회한다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "정상 응답"),
            @ApiResponse(responseCode = "404", description = "버스 ID를 찾지 못하는 경우")
    })
    @ResponseBody
    public BusStatusDto status(@PathVariable(value = "busID") Long id) {
        return busService.getBusStatusByBusId(id);
    }


    @GetMapping("/{busID}/route")
    @ApiOperation(value = "버스가 경유하는 정류장을 조회한다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "정상 응답"),
    })
    @ResponseBody
    public List<StationDTO> stationList(@PathVariable(value = "busID") Long id) {
        return busService.getBusStationsByBusId(id);
    }
}
