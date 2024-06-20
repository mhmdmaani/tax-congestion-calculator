package com.task.tax.service;

import com.task.tax.model.TollPrice;
import com.task.tax.repository.TollPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;


@Service
public class TollPriceService {
    @Autowired
    private TollPriceRepository tollPriceRepository;

    public List<TollPrice> getAllTollPrices() {
        return tollPriceRepository.findAll();
    }

    public TollPrice getTollPriceById(Long id) {
        return tollPriceRepository.findById(id).orElse(null);
    }

    public TollPrice saveTollPrice(TollPrice tollPrice) {
        return tollPriceRepository.save(tollPrice);
    }

    public void deleteTollPrice(Long id) {
        tollPriceRepository.deleteById(id);
    }

    public Optional<TollPrice> getCurrentTollPrice(LocalTime time) {
        return tollPriceRepository.findByFromTimeLessThanEqualAndToTimeGreaterThanEqual(time, time);
    }
}
