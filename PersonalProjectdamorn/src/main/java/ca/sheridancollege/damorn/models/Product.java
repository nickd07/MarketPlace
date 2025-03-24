package ca.sheridancollege.damorn.models;

import java.time.LocalDateTime;

public class Product {
    private Long id;
    private String title;
    private String description;
    private double startingPrice;
    private double currentBid;
    private Long sellerId;
    private LocalDateTime auctionEnd;

    private String image1;
    private String image2;
    private String image3;
    private String image4;
    private String image5;

    public Product() {}

    public Product(Long id, String title, String description, double startingPrice,
                   double currentBid, Long sellerId, LocalDateTime auctionEnd,
                   String image1, String image2, String image3, String image4, String image5) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.startingPrice = startingPrice;
        this.currentBid = currentBid;
        this.sellerId = sellerId;
        this.auctionEnd = auctionEnd;
        this.image1 = image1;
        this.image2 = image2;
        this.image3 = image3;
        this.image4 = image4;
        this.image5 = image5;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public double getStartingPrice() { return startingPrice; }
    public void setStartingPrice(double startingPrice) { this.startingPrice = startingPrice; }

    public double getCurrentBid() { return currentBid; }
    public void setCurrentBid(double currentBid) { this.currentBid = currentBid; }

    public Long getSellerId() { return sellerId; }
    public void setSellerId(Long sellerId) { this.sellerId = sellerId; }

    public LocalDateTime getAuctionEnd() { return auctionEnd; }
    public void setAuctionEnd(LocalDateTime auctionEnd) { this.auctionEnd = auctionEnd; }

    public String getImage1() { return image1; }
    public void setImage1(String image1) { this.image1 = image1; }

    public String getImage2() { return image2; }
    public void setImage2(String image2) { this.image2 = image2; }

    public String getImage3() { return image3; }
    public void setImage3(String image3) { this.image3 = image3; }

    public String getImage4() { return image4; }
    public void setImage4(String image4) { this.image4 = image4; }

    public String getImage5() { return image5; }
    public void setImage5(String image5) { this.image5 = image5; }
}
