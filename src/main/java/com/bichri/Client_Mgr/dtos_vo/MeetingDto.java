package com.bichri.Client_Mgr.dtos_vo;

import com.bichri.Client_Mgr.entities.Client;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class MeetingDto {
    private Long id;
    private String agenda;
    private Date meetDate;
    private String meetTime;
    private Client client;
}
