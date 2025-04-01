package com.bichri.Client_Mgr.services;

import com.bichri.Client_Mgr.dtos_vo.ClientDto;
import com.bichri.Client_Mgr.dtos_vo.MeetingDto;
import com.bichri.Client_Mgr.dtos_vo.ProjectDto;
import com.bichri.Client_Mgr.vos.ClientVo;
import com.bichri.Client_Mgr.vos.MeetingVo;
import com.bichri.Client_Mgr.vos.ProjectVo;

import java.util.List;

public interface ClientService {
    ClientDto saveClient (ClientDto client);
    ClientDto updateClient (Long clientId, ClientDto updatedClient);
    void deleteClient (Long clientId);
    List<ClientVo> getAllClients();

    ClientVo getClientById(Long clientId);

    ProjectDto saveProject (ProjectVo project);
    ProjectDto updateProject (Long projectId, ProjectVo updatedProject);
    void deleteProject (Long projectId);

    ProjectDto getProjectById(Long projectId);

    List<ProjectDto> getAllProjects();

    MeetingDto saveMeeting(MeetingVo meeting);
    MeetingDto updateMeeting(Long meetingId, MeetingVo meeting);
    void deleteMeeting(Long meetingId);
    List<MeetingDto> getAllMeetings();

    MeetingDto getMeetingById(Long meetingId);
}
