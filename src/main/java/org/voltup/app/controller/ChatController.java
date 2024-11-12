package org.voltup.app.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.voltup.app.ai.ChatService;
import org.voltup.app.dtos.ChatDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chat")
public class ChatController {

    @Autowired
    private ChatService service;

    @PostMapping
    @Operation(summary = "Chat with AI")
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
    public ChatDTO message(@RequestHeader(name = "Authorization") String AuthToken, @RequestBody @Valid ChatDTO chatDTO) {
        var message = service.sendToAi(chatDTO.message());
        return new ChatDTO(message);
    }
}
