package com.tickupnotify.controller;

import com.tickupnotify.apiException.ResponseApi;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.tickupnotify.models.request.MailRequest;
import com.tickupnotify.services.MailService;

@Tag(name = "Email Management", description = "API pour l'envoi d'emails")
@RestController
@RequestMapping("/api/v1")
public class MailController {

    private final MailService mailService;

    public MailController(MailService mailService) {
        this.mailService = mailService;
    }

    @Operation(summary = "Envoyer un email", description = "Permet d'envoyer un email avec des pièces jointes optionnelles")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Email envoyé avec succès",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ResponseApi.class))),
            @ApiResponse(responseCode = "500", description = "Échec de l'envoi de l'email",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ResponseApi.class)))
    })
    @PostMapping("/email/send")
    public ResponseEntity<ResponseApi<Boolean>> sendMail(
            @Parameter(description = "Détails de l'email à envoyer", required = true)
            @RequestBody MailRequest mailRequest) {

        Boolean result = mailService.envoyerMail(mailRequest);

        if (result) {
            return ResponseEntity.ok(
                    new ResponseApi<>("Email envoyé avec succès", HttpStatus.OK.value(), result)
            );
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ResponseApi<>("Échec de l'envoi de l'email",
                        HttpStatus.INTERNAL_SERVER_ERROR.value(),
                        false));
    }
}
