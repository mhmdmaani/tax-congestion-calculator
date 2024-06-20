package com.task.tax.controller;


import com.task.tax.model.TollPrice;
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

    @GetMapping
    public List<TollPrice> getAllTollPrices() {
        return tollPriceService.getAllTollPrices();
    }

    @GetMapping("/{id}")
    public TollPrice getTollPriceById(@PathVariable Long id) {
        return tollPriceService.getTollPriceById(id);
    }

    @PostMapping
    public TollPrice createTollPrice(@RequestBody TollPrice tollPrice) {
        return tollPriceService.saveTollPrice(tollPrice);
    }

    @PutMapping("/{id}")
    public TollPrice updateTollPrice(@PathVariable Long id, @RequestBody TollPrice tollPrice) {
        TollPrice existingTollPrice = tollPriceService.getTollPriceById(id);
        if (existingTollPrice != null) {
            existingTollPrice.setFromTime(tollPrice.getFromTime());
            existingTollPrice.setToTime(tollPrice.getToTime());
            existingTollPrice.setPrice(tollPrice.getPrice());
            return tollPriceService.saveTollPrice(existingTollPrice);
        } else {
            return null; // Or throw an exception
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
