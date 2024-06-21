package com.task.tax.controller;


import com.task.tax.DTO.TollPriceInputDTO;
import com.task.tax.model.City;
import com.task.tax.model.TollPrice;
import com.task.tax.repository.CityRepository;
import com.task.tax.service.TollPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/toll-prices")
public class TollPriceController {
    @Autowired
    private TollPriceService tollPriceService;
    @Autowired
    private CityRepository cityRepository;

    @GetMapping
    public List<TollPrice> getAllTollPrices() {
        return tollPriceService.getAllTollPrices();
    }

    @GetMapping("/{id}")
    public TollPrice getTollPriceById(@PathVariable Long id) {
        return tollPriceService.getTollPriceById(id);
    }

    @PostMapping
    public TollPrice createTollPrice(@RequestBody TollPriceInputDTO tollPrice) {
          City city = cityRepository.findById(tollPrice.getCityId()).orElse(null);
            if (city != null) {
                TollPrice newTollPrice = new TollPrice();
                newTollPrice.setCity(city);
                newTollPrice.setFromTime(tollPrice.getFromTime());
                newTollPrice.setToTime(tollPrice.getToTime());
                newTollPrice.setPrice(tollPrice.getPrice());
                return tollPriceService.saveTollPrice(newTollPrice);
            } else {
                return null;
            }

    }

    @PutMapping("/{id}")
    public TollPrice updateTollPrice(@PathVariable Long id, @RequestBody TollPriceInputDTO tollPrice) {
        TollPrice existingTollPrice = tollPriceService.getTollPriceById(id);
        City city = cityRepository.findById(tollPrice.getCityId()).orElse(null);
        if (existingTollPrice != null && city != null) {
            existingTollPrice.setFromTime(tollPrice.getFromTime());
            existingTollPrice.setToTime(tollPrice.getToTime());
            existingTollPrice.setPrice(tollPrice.getPrice());
            existingTollPrice.setCity(city);
            return tollPriceService.saveTollPrice(existingTollPrice);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteTollPrice(@PathVariable Long id) {
        tollPriceService.deleteTollPrice(id);
    }

    @GetMapping("/current")
    public Optional<TollPrice> getCurrentTollPrice(@RequestParam("time") String time) {
        LocalTime localTime = LocalTime.parse(time);
        return tollPriceService.getCurrentTollPrice(localTime);
    }
}
