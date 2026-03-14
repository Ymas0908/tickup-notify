package controller;

import apiException.ResponseApi;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import models.request.MailRequest;
import services.MailService;

@RestController
@RequestMapping("/api/v1")
public class MailController {

    private final MailService mailService;

    public MailController(MailService mailService) {
        this.mailService = mailService;
    }

    @PostMapping("/email/send")
    public ResponseEntity<ResponseApi<Boolean>> sendMail(@RequestBody MailRequest mailRequest) {
        Boolean result = mailService.envoyerMail(mailRequest);
        if (result) {
            return ResponseEntity.ok(new ResponseApi<>("Email envoyé avec succès", HttpStatus.OK.value(), result));
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseApi<>("Échec de l'envoi de l'email", HttpStatus.INTERNAL_SERVER_ERROR.value(), false));
        }
    }
}
