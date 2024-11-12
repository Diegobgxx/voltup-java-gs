package org.voltup.app.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.voltup.app.domain.Plantation;
import org.voltup.app.service.PlantationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/plantation")
public class PlantationController {

    @Autowired
    private PlantationService service;

    @PostMapping
    @Operation(summary = "Create a Plantation")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = @Content),
            @ApiResponse(responseCode = "401", description = "Not Authorized ",
                    content = @Content),
            @ApiResponse(responseCode = "400", description = "Invalid arguments in request ",
                    content = @Content),
            @ApiResponse(responseCode = "200", description = "Ok",
                    content = @Content)
    })
    public ResponseEntity<Plantation> create(@RequestHeader(name = "Authorization") String AuthToken, @RequestBody Plantation plantation) {
        return ResponseEntity.ok(service.create(plantation));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a Plantation By Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = @Content),
            @ApiResponse(responseCode = "401", description = "Not Authorized ",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Not Found",
                    content = @Content),
            @ApiResponse(responseCode = "200", description = "Ok",
                    content = @Content)
    })
    public ResponseEntity<Plantation> findById(@RequestHeader(name = "Authorization") String AuthToken, @PathVariable String id) {
        return ResponseEntity.ok(service.findById(UUID.fromString(id)));
    }

    @GetMapping
    @Operation(summary = "Get all Plantations")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = @Content),
            @ApiResponse(responseCode = "401", description = "Not Authorized ",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Not Found",
                    content = @Content),
            @ApiResponse(responseCode = "200", description = "Ok",
                    content = @Content)
    })
    public ResponseEntity<List<Plantation>> findAll(@RequestHeader(name = "Authorization") String AuthToken) {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/farm/{farmId}")
    @Operation(summary = "Get Plantations By FarmId")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = @Content),
            @ApiResponse(responseCode = "401", description = "Not Authorized ",
                    content = @Content),
            @ApiResponse(responseCode = "200", description = "Ok",
                    content = @Content)
    })
    public ResponseEntity<List<Plantation>> findAllByFarm(@RequestHeader(name = "Authorization") String AuthToken, @PathVariable String farmId) {
        return ResponseEntity.ok(service.findAllByFarm(UUID.fromString(farmId)));
    }

    @GetMapping("/strategy/{strategyId}")
    @Operation(summary = "Get Plantations By StrategyId")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = @Content),
            @ApiResponse(responseCode = "401", description = "Not Authorized ",
                    content = @Content),
            @ApiResponse(responseCode = "200", description = "Ok",
                    content = @Content)
    })
    public ResponseEntity<List<Plantation>> findAllByStrategy(@RequestHeader(name = "Authorization") String AuthToken, @PathVariable String strategyId) {
        return ResponseEntity.ok(service.findAllByStrategy(UUID.fromString(strategyId)));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Plantation")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = @Content),
            @ApiResponse(responseCode = "401", description = "Not Authorized ",
                    content = @Content),
            @ApiResponse(responseCode = "200", description = "Ok",
                    content = @Content)
    })
    public ResponseEntity<?> deletePlantationById(@RequestHeader(name = "Authorization") String AuthToken, @PathVariable String id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

}
