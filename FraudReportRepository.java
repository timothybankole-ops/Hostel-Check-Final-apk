package com.hostelcheck.backend.repository;
import com.hostelcheck.backend.entity.FraudReport; import org.springframework.data.jpa.repository.JpaRepository; import java.util.*;
public interface FraudReportRepository extends JpaRepository<FraudReport,Long> {
 List<FraudReport> findAllByOrderByCreatedAtDesc();}
