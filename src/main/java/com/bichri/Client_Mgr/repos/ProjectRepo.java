package com.bichri.Client_Mgr.repos;

import com.bichri.Client_Mgr.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProjectRepo extends JpaRepository<Project, Long> {

    @Query(value = "select p.name, p.duration, p.startDate, p.endDate, p.projectStatus, c.name from Project p join Client c on c.id = p.client.id")
    List<Project> viewAllProjects();
}
