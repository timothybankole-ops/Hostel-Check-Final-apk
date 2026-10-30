package com.hostelcheck.backend.repository;
import com.hostelcheck.backend.entity.InspectionRequest; import org.springframework.data.jpa.repository.JpaRepository; import java.util.*;
public interface InspectionRequestRepository extends JpaRepository<InspectionRequest,Long> {
 List<InspectionRequest> findByStudentIdOrderByCreatedAtDesc(Long studentId); List<InspectionRequest> findByPropertyIdOrderByCreatedAtDesc(Long propertyId);}
