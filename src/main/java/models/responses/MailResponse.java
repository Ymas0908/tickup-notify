package models.responses;


import java.time.LocalDateTime;

public class MailResponse {
    private String status; // "SENT", "FAILED", "PENDING"
    private String messageId; // ID unique du mail
    private LocalDateTime sentAt;
    private String destinataire;
    private String sujet;
    private String erreurDetails;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public LocalDateTime getSentAt() {
        return sentAt;
    }

    public void setSentAt(LocalDateTime sentAt) {
        this.sentAt = sentAt;
    }

    public String getDestinataire() {
        return destinataire;
    }

    public void setDestinataire(String destinataire) {
        this.destinataire = destinataire;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public String getErreurDetails() {
        return erreurDetails;
    }

    public void setErreurDetails(String erreurDetails) {
        this.erreurDetails = erreurDetails;
    }

    // Factory methods
    public static MailResponse success(String messageId, String destinataire, String sujet) {
        MailResponse response = new MailResponse();
        response.setStatus("SENT");
        response.setMessageId(messageId);
        response.setSentAt(LocalDateTime.now());
        response.setDestinataire(destinataire);
        response.setSujet(sujet);
        return response;
    }

    public static MailResponse error(String destinataire, String sujet, String erreurDetails) {
        MailResponse response = new MailResponse();
        response.setStatus("FAILED");
        response.setSentAt(LocalDateTime.now());
        response.setDestinataire(destinataire);
        response.setSujet(sujet);
        response.setErreurDetails(erreurDetails);
        return response;
    }
}