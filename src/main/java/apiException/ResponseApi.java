package apiException;

import java.io.Serializable;
import java.util.Date;

/**
 * Réponse de l'API Rest
 *
 * @author Luc
 */
public class ResponseApi<B> implements Serializable {

    private static final long serialVersionUID = 1678596161217027130L;

    private String message; // Le message de retour
    private int status; // Le satus
    private Object body; // Le contenu de le réponse
    private Date timestamp; // La date et l'heure

    public ResponseApi() {
        this.timestamp = new Date();
    }

    public ResponseApi(String message) {
        this.message = message;
        this.timestamp = new Date();
    }

    public ResponseApi(String message, int status, Object body) {
        this.message = message;
        this.status = status;
        this.body = body;
        this.timestamp = new Date();
    }

    // Getters and Setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
