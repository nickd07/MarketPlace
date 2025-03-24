package ca.sheridancollege.damorn.models;

import java.time.LocalDateTime;

public class Message {
    private Long id;
    private Long productId;
    private String senderName;
    private String content;
    private LocalDateTime sentTime;

    public Message() {}

    public Message(Long id, Long productId, String senderName, String content, LocalDateTime sentTime) {
        this.id = id;
        this.productId = productId;
        this.senderName = senderName;
        this.content = content;
        this.sentTime = sentTime;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getProductId() { return productId; }
    public void setProductId(Long productId) { this.productId = productId; }
    public String getSenderName() { return senderName; }
    public void setSenderName(String senderName) { this.senderName = senderName; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public LocalDateTime getSentTime() { return sentTime; }
    public void setSentTime(LocalDateTime sentTime) { this.sentTime = sentTime; }
}

