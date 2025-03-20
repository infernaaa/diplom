package com.example.diplom_boot.repository;

import com.example.diplom_boot.model.TournamentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TournamentRepo extends JpaRepository<TournamentModel, Long> {

//    @Query("SELECT t.infoId, t.description, t.rules, t.prizeFund " +
//            "FROM TournamentInfo t " +
//            "WHERE t.tournamentId = :tournamentId")
//    List<Object[]> findInfo(@Param("tournamentId") Long tournamentId);
}
