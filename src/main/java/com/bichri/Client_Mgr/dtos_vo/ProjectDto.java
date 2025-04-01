package com.bichri.Client_Mgr.dtos_vo;

import com.bichri.Client_Mgr.entities.Client;
import com.bichri.Client_Mgr.enums.ProjectStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ProjectDto {

    private Long id;
    private String name;
    private int duration;
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @Enumerated(EnumType.STRING)
    private ProjectStatus projectStatus;
    private Client clientId;
}
