package com.bichri.Client_Mgr.repos;

import com.bichri.Client_Mgr.entities.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeetingRepo extends JpaRepository<Meeting, Long> {
}
