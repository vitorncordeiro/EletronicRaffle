package com.lovestoblog.vitornatal.eletronicraffle.repository;

import com.lovestoblog.vitornatal.eletronicraffle.model.RaffleTicketModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RaffleTicketRepository extends JpaRepository<RaffleTicketModel, Long> {
    List<RaffleTicketModel> findByUser_Id(Long userId);
    List<RaffleTicketModel> findByRaffleModel_raffleId(Long raffleId);
}
