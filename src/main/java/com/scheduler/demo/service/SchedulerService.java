package com.scheduler.demo.service;


import com.github.javafaker.Faker;
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.jobrunr.scheduling.JobScheduler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.UUID;

@Service
public class SchedulerService {

    private final Logger log = LoggerFactory.getLogger(SchedulerService.class);

    @Inject
    private JobScheduler jobScheduler;

    @Scheduled(cron = "0 */5 * ? * *", zone = "Africa/Lagos") // run this every 5 minutes
    @SchedulerLock(name = "generateUserInvoiceAndNotifyUserByEmail", lockAtMostFor = "4m")
    public void generateInvoiceAndSendEmail(){
        Faker faker = new Faker();
        log.info("Job processing INITIATED");

        for (int i = 0; i < 1000 ; i++){
           String message =  faker.hitchhikersGuideToTheGalaxy().marvinQuote();
           UUID userId = UUID.randomUUID();
           jobScheduler.enqueue(userId, () -> sendEmail(userId, message));
        }
    }


    public void sendEmail(UUID userId, String message) throws InterruptedException {
        Thread.sleep(10000); // simulate time consuming task
        log.info("Processing job for user: {} with message {},", userId, message);
    }
}
