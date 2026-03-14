package services;


import models.request.MailRequest;
import org.springframework.stereotype.Service;

@Service
public interface MailService {

//    void sendMail(String destinataire, String destinateur, String sujet, String corps);
    Boolean envoyerMail(MailRequest mRequest);

}
