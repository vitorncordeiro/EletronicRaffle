package com.lovestoblog.vitornatal.eletronicraffle.infra.security.scheduler;

import com.lovestoblog.vitornatal.eletronicraffle.service.RaffleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class RaffleScheduler {
    @Autowired
    RaffleService raffleService;

    @Scheduled(fixedRate = 3600000)
    public void checkAndRunRaffles(){
        raffleService.runDraws();
    }

}
