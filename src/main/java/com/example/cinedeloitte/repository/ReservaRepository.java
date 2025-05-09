package com.example.cinedeloitte.repository;

import com.example.cinedeloitte.model.entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.OffsetDateTime;
import java.util.List;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    List<Reserva> findByStartInAfter(OffsetDateTime dateTime);

    List<Reserva> findBySalaId(Long salaId);

    @Query("""
        SELECT CASE WHEN COUNT(r) > 0 THEN true ELSE false END
        FROM Reserva r
        WHERE r.sala.id = :salaId
          AND r.startIn < :endIn
          AND r.endIn > :startIn
    """)
    boolean existsBySalaIdAndPeriodOverlap(
            @Param("salaId") Long salaId,
            @Param("startIn") OffsetDateTime startIn,
            @Param("endIn") OffsetDateTime endIn
    );
}
