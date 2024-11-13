package org.voltup.app.ai;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.voltup.app.domain.Station;
import org.voltup.app.domain.Vehicle;
import org.voltup.app.service.StationService;
import org.voltup.app.service.VehicleService;

import java.util.List;
import java.util.UUID;
import java.util.function.Function;

@Configuration
public class ChatTools {

    private final StationService stationService;
    private final VehicleService vehicleService;

    public ChatTools(StationService stationService, VehicleService vehicleService) {
        this.stationService = stationService;
        this.vehicleService = vehicleService;
    }

    @Bean
    @Description("Busca lista de veiculos por usuario id")
    public Function<VehicleRequest, List<Vehicle>> findVehicles() {
        return request -> vehicleService.findByUserId(UUID.fromString(request.userId()));
    }


    @Bean
    @Description("Busca lista de Estações de Carregamento por  tipo de conector")
    public Function<StationRequest, List<Station>> findChargingStation() {
        return request -> stationService.findAllByConnectorType(UUID.fromString(request.connectorTypeId()));
    }

    public record StationRequest(String connectorTypeId) {
    }

    public record VehicleRequest(String userId) {
    }


}