package com.lovestoblog.vitornatal.eletronicraffle.repository;

import com.lovestoblog.vitornatal.eletronicraffle.model.RaffleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RaffleRepository extends JpaRepository<RaffleModel, Long> {
    @Query("SELECT r FROM RaffleModel r WHERE r.winnerTicket IS NULL AND r.date = CURRENT_DATE")
    List<RaffleModel> findAllUnwonRafflesToday();
}
