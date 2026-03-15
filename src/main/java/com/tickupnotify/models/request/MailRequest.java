package com.tickupnotify.models.request;

import com.tickupnotify.models.AttachmentBase64;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MailRequest {

    private String object;
    
    private String content;
    
    private String[] recipients;
    
    private List<AttachmentBase64> attachments = new ArrayList<>();

    public MailRequest() {
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String[] getRecipients() {
        return recipients;
    }

    public void setRecipients(String[] recipients) {
        this.recipients = recipients;
    }

    public List<AttachmentBase64> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<AttachmentBase64> attachments) {
        this.attachments = attachments;
    }

    @Override
    public String toString() {
        return "MailRequest{" +
                "object='" + object + '\'' +
                ", content='" + content + '\'' +
                ", recipients=" + Arrays.toString(recipients) +
                ", attachments=" + attachments +
                '}';
    }
}
