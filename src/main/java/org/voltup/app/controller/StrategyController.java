package org.voltup.app.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.voltup.app.domain.Strategy;
import org.voltup.app.service.StrategyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/strategy")
public class StrategyController {

    @Autowired
    private StrategyService service;

    @PostMapping
    @Operation(summary = "Create a Strategy")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = @Content),
            @ApiResponse(responseCode = "401", description = "Not Authorized",
                    content = @Content),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content),
            @ApiResponse(responseCode = "200", description = "Ok",
                    content = @Content)
    })
    public ResponseEntity<Strategy> create(@RequestHeader(name = "Authorization") String AuthToken, @RequestBody Strategy strategy) {
        return ResponseEntity.ok(service.create(strategy));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Plantations By FarmId")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = @Content),
            @ApiResponse(responseCode = "401", description = "Not Authorized",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Not Found",
                    content = @Content),
            @ApiResponse(responseCode = "200", description = "Ok",
                    content = @Content)
    })
    public ResponseEntity<Strategy> findById(@RequestHeader(name = "Authorization") String AuthToken, @PathVariable String id) {
        return ResponseEntity.ok(service.findById(UUID.fromString(id)));
    }

    @GetMapping
    @Operation(summary = "Find All Strategies")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = @Content),
            @ApiResponse(responseCode = "401", description = "Not Authorized",
                    content = @Content),
            @ApiResponse(responseCode = "200", description = "Ok",
                    content = @Content)
    })
    public ResponseEntity<List<Strategy>> findAll(@RequestHeader(name = "Authorization") String AuthToken) {
        return ResponseEntity.ok(service.findAll());
    }

}
