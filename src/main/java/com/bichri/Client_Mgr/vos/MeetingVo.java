package com.bichri.Client_Mgr.vos;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class MeetingVo {

    private String agenda;
    private Date meetDate;
    private String meetTime;
    private Long clientId;
}
