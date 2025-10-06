package com.lovestoblog.vitornatal.eletronicraffle.repository;

import com.lovestoblog.vitornatal.eletronicraffle.model.RaffleTicketModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RaffleTicketRepository extends JpaRepository<RaffleTicketModel, Long> {
}
