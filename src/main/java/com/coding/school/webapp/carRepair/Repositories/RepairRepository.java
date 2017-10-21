package com.coding.school.webapp.carRepair.Repositories;

import com.coding.school.webapp.carRepair.Domain.Repair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.naming.AuthenticationException;
import java.sql.Timestamp;

@Repository
public interface RepairRepository extends JpaRepository<Repair, Long> {

    Repair findByCost(Double cost);

    Repair findByStage(Repair.RepairStage stage);

    Repair findByOperations(String operations);

    Repair findByType(Repair.RepairType type);

    Repair findByDateTime (Timestamp dateTime);

}
