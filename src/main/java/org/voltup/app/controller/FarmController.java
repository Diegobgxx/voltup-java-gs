package org.voltup.app.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.voltup.app.domain.Farm;
import org.voltup.app.service.FarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/farm")
public class FarmController {

    @Autowired
    private FarmService service;

    @PostMapping
    @Operation(summary = "Create a Farm")
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
    public ResponseEntity<Farm> create(@RequestHeader(name = "Authorization") String AuthToken, @RequestBody Farm farm) {
        return ResponseEntity.ok(service.create(farm));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Farm By Id")
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
    public ResponseEntity<Farm> findById(@RequestHeader(name = "Authorization") String AuthToken, @PathVariable String id) {
        return ResponseEntity.ok(service.findById(UUID.fromString(id)));
    }

    @GetMapping("/user/{userId}")
    @Operation(summary = "Get All Farms By UserId")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = @Content),
            @ApiResponse(responseCode = "401", description = "Not Authorized",
                    content = @Content),
            @ApiResponse(responseCode = "200", description = "Ok",
                    content = @Content)
    })
    public ResponseEntity<List<Farm>> findAllByUser(@RequestHeader(name = "Authorization") String AuthToken, @PathVariable String userId) {
        return ResponseEntity.ok(service.findAllByUser(UUID.fromString(userId)));
    }

}
