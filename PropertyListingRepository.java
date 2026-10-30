package com.hostelcheck.backend.repository;
import com.hostelcheck.backend.entity.PropertyListing; import org.springframework.data.jpa.repository.JpaRepository; import java.util.*;
public interface PropertyListingRepository extends JpaRepository<PropertyListing,Long> {
 List<PropertyListing> findByStatusOrderByCreatedAtDesc(String status); List<PropertyListing> findByAgentIdOrderByCreatedAtDesc(Long agentId);}
