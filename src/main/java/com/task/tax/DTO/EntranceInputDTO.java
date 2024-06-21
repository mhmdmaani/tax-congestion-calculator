package com.task.tax.DTO;

import java.time.LocalDateTime;

public class EntranceInputDTO {
    private Long id;

    private Long carId;
    private LocalDateTime entranceDateTime;
    private Long cityId;

    public Long getCarId() {
        return carId;
    }
    public  void setCarId(Long carId) {
        this.carId = carId;
    }
    public LocalDateTime getEntranceDateTime() {
        return entranceDateTime;
    }
    public void setEntranceDateTime(LocalDateTime entranceDateTime) {
        this.entranceDateTime = entranceDateTime;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public EntranceInputDTO() {
    }

    public EntranceInputDTO(Long carId, LocalDateTime entranceDateTime) {
        this.carId = carId;
        this.entranceDateTime = entranceDateTime;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }
}
