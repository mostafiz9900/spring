package com.beskilled.repo;

import com.beskilled.entity.Meeting;
import com.beskilled.entity.Organization;
import com.beskilled.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface MeetingRepository extends JpaRepository<Meeting, Long> {
    List<Meeting> findByUsers(Set<User> users);
    Meeting findByOrganization(Organization organization);
}
