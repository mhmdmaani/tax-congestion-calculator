package com.task.tax.seed;

import com.task.tax.model.Car;
import com.task.tax.model.Entrance;
import com.task.tax.repository.CarRepository;
import com.task.tax.repository.EntranceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Component
@Order(5)
public class EntranceSeeder implements CommandLineRunner {

    @Autowired
    private EntranceRepository entranceRepository;

    @Autowired
    private CarRepository carRepository;

    @Override
    public void run(String... args) throws Exception {
        List<Car> cars = carRepository.findAll();

        if (entranceRepository.count() == 0) {
            List<Entrance> entrances = cars.stream()
                    .flatMap(car -> Stream.of(
                            new Entrance(null, car, LocalDateTime.of(2013, 1, 14, 21, 0)),
                            new Entrance(null, car, LocalDateTime.of(2013, 1, 15, 21, 0)),
                            new Entrance(null, car, LocalDateTime.of(2013, 2, 7, 6, 23, 27)),
                            new Entrance(null, car, LocalDateTime.of(2013, 2, 7, 15, 27)),
                            new Entrance(null, car, LocalDateTime.of(2013, 2, 8, 6, 27)),
                            new Entrance(null, car, LocalDateTime.of(2013, 2, 8, 6, 20, 27)),
                            new Entrance(null, car, LocalDateTime.of(2013, 2, 8, 14, 35)),
                            new Entrance(null, car, LocalDateTime.of(2013, 2, 8, 15, 29)),
                            new Entrance(null, car, LocalDateTime.of(2013, 2, 8, 15, 47)),
                            new Entrance(null, car, LocalDateTime.of(2013, 2, 8, 16, 1)),
                            new Entrance(null, car, LocalDateTime.of(2013, 2, 8, 16, 48)),
                            new Entrance(null, car, LocalDateTime.of(2013, 2, 8, 17, 49)),
                            new Entrance(null, car, LocalDateTime.of(2013, 2, 8, 18, 29)),
                            new Entrance(null, car, LocalDateTime.of(2013, 2, 8, 18, 35)),
                            new Entrance(null, car, LocalDateTime.of(2013, 3, 26, 14, 25)),
                            new Entrance(null, car, LocalDateTime.of(2013, 3, 28, 14, 7, 27))
                    ))
                    .toList();

            entranceRepository.saveAll(entrances);
        }
    }


    private LocalDateTime getRandomDateTimeIn2013() {
        long minDay = LocalDate.of(2013, Month.JANUARY, 1).toEpochDay();
        long maxDay = LocalDate.of(2013, Month.DECEMBER, 31).toEpochDay();
        long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay + 1);

        LocalDate randomDate = LocalDate.ofEpochDay(randomDay);
        int randomHour = ThreadLocalRandom.current().nextInt(0, 24);
        int randomMinute = ThreadLocalRandom.current().nextInt(0, 60);
        int randomSecond = ThreadLocalRandom.current().nextInt(0, 60);

        return LocalDateTime.of(randomDate, LocalTime.of(randomHour, randomMinute, randomSecond));
    }

}
