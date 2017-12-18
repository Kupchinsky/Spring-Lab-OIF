package ru.kuzstu.openinfsystems.spring.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "feedback_message")
public class FeedbackMessage {

    @Id
    @Column(name = "feedback_message_id")
    @GeneratedValue
    private int feedbackMessageId;

    @Column(name = "sender_name", nullable = false)
    private String senderName;

    @Column(name = "sender_email", nullable = false)
    private String senderEmail;

    @Column(name = "message", nullable = false)
    private String message;

    @Column(name = "created", nullable = false)
    private Date created;

    public int getFeedbackMessageId() {
        return feedbackMessageId;
    }

    public void setFeedbackMessageId(int feedbackMessageId) {
        this.feedbackMessageId = feedbackMessageId;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getSenderEmail() {
        return senderEmail;
    }

    public void setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
