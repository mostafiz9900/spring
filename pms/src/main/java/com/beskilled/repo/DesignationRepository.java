package com.beskilled.repo;

import com.beskilled.entity.Designation;
import com.beskilled.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DesignationRepository extends JpaRepository<Designation, Long> {
Designation findByOrganization(Organization organization);
}
