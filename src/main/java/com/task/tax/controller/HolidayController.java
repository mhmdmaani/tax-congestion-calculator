package com.task.tax.controller;


import com.task.tax.model.Holiday;
import com.task.tax.service.HolidayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/holidays")
public class HolidayController {
    @Autowired
    private HolidayService holidayService;

    @GetMapping
    public List<Holiday> getAllHolidays() {
        return holidayService.getAll();
    }

    @PostMapping
    public Holiday createHoliday(@RequestBody Holiday holiday) {
        return holidayService.saveHoliday(holiday);
    }

    @DeleteMapping("/{id}")
    public void deleteHoliday(@PathVariable Long id) {
        holidayService.deleteHoliday(id);
    }
}
