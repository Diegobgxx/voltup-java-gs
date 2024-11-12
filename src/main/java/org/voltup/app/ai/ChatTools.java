package org.voltup.app.ai;

import org.voltup.app.domain.Farm;
import org.voltup.app.service.FarmService;
import org.voltup.app.service.PlantationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;

import java.util.UUID;
import java.util.function.Function;

@Configuration
public class ChatTools {

    public record FarmRequest(String id){}
    public record PlantationRequest(String id){}

    private final FarmService farmService;
    private final PlantationService plantationService;

    public ChatTools(FarmService farmService, PlantationService plantationService) {
        this.farmService = farmService;
        this.plantationService = plantationService;
    }

    @Bean
    @Description("Busca uma Fazenda por id")
    public Function<FarmRequest, Farm> findFarm(){
        return request -> farmService.findById(UUID.fromString(request.id()));
    }

    @Bean
    @Description("Busca uma Plantaçãp por id")
    public Function<PlantationRequest, Plantation> findPlantation(){
        return request -> plantationService.findById(UUID.fromString(request.id()));
    }

}