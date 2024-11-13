package org.voltup.app.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.voltup.app.domain.ConnectorType;
import org.voltup.app.service.ConnectorTypeService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/connectors")
public class ConnectorTypeController {

    @Autowired
    private ConnectorTypeService service;

    @PostMapping
    @Operation(summary = "Create a Connector Type")
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
    public ResponseEntity<ConnectorType> create(@RequestHeader(name = "Authorization") String AuthToken, @RequestBody ConnectorType connectorType) {
        return ResponseEntity.ok(service.create(connectorType));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a Connector By Id")
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
    public ResponseEntity<ConnectorType> findById(@RequestHeader(name = "Authorization") String AuthToken, @PathVariable String id) {
        return ResponseEntity.ok(service.findById(UUID.fromString(id)));
    }

    @GetMapping
    @Operation(summary = "Get all Connectors Types")
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
    public ResponseEntity<List<ConnectorType>> findAll(@RequestHeader(name = "Authorization") String AuthToken) {
        return ResponseEntity.ok(service.findAll());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Connector Type")
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
