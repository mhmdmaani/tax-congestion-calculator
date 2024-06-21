package com.task.tax.DTO;
import java.math.BigDecimal;
import java.time.LocalTime;

public class TollPriceInputDTO {
    private Long id;
    private Long cityId;
    private LocalTime fromTime;
    private LocalTime toTime;
    private BigDecimal price;


    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalTime getFromTime() {
        return fromTime;
    }

    public void setFromTime(LocalTime fromTime) {
        this.fromTime = fromTime;
    }

    public LocalTime getToTime() {
        return toTime;
    }

    public void setToTime(LocalTime toTime) {
        this.toTime = toTime;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public TollPriceInputDTO() {
    }

    public TollPriceInputDTO(Long id, Long cityId, LocalTime fromTime, LocalTime toTime, BigDecimal price) {
        this.id = id;
        this.cityId = cityId;
        this.fromTime = fromTime;
        this.toTime = toTime;
        this.price = price;
    }
}
