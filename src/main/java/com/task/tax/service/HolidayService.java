package com.task.tax.service;


import com.task.tax.model.Holiday;
import com.task.tax.repository.HolidayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HolidayService {
    @Autowired
    private HolidayRepository holidayRepository;

    public List<Holiday> getAll(){
        return holidayRepository.findAll();
    }

    public Holiday saveHoliday(Holiday h){
        return  holidayRepository.save(h);
    }

    public void deleteHoliday(Long id){
        holidayRepository.deleteById(id);
    }
}
