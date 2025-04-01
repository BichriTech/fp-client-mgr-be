package com.bichri.Client_Mgr.services;

import com.bichri.Client_Mgr.dtos_vo.ClientDto;
import com.bichri.Client_Mgr.dtos_vo.MeetingDto;
import com.bichri.Client_Mgr.dtos_vo.ProjectDto;
import com.bichri.Client_Mgr.entities.Client;
import com.bichri.Client_Mgr.entities.Meeting;
import com.bichri.Client_Mgr.entities.Project;
import com.bichri.Client_Mgr.exceptions.ClientAPIException;
import com.bichri.Client_Mgr.mappers.ClientMapper;
import com.bichri.Client_Mgr.repos.ClientRepo;
import com.bichri.Client_Mgr.repos.MeetingRepo;
import com.bichri.Client_Mgr.repos.ProjectRepo;
import com.bichri.Client_Mgr.vos.ClientVo;
import com.bichri.Client_Mgr.vos.MeetingVo;
import com.bichri.Client_Mgr.vos.ProjectVo;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepo clientRepo;
    private final MeetingRepo meetingRepo;
    private final ProjectRepo projectRepo;
    private final ClientMapper clientMapper;

    @Override
    public ClientDto saveClient(ClientDto client) {

        if(clientRepo.findByEmail(client.getEmail()) != null) {
            throw new ClientAPIException(HttpStatus.ALREADY_REPORTED, "Client already exists");
        }
        Client savedClient = clientMapper.CLIENT_DtoToModel(client);
        clientRepo.save(savedClient);

        return clientMapper.CLIENT_ModelToDto(savedClient);
    }

    @Override
    public ClientDto updateClient(Long clientId, ClientDto updatedClient) {
        Client client = clientRepo.findById(clientId).orElseThrow(
                () -> new ClientAPIException(HttpStatus.NOT_FOUND, "Client not found"));

        client.setName(updatedClient.getName());
        client.setEmail(updatedClient.getEmail());
        client.setPassword(updatedClient.getPassword());
        client.setPhone(updatedClient.getPhone());
        client.setLocation(updatedClient.getLocation());
        client.setCompany(updatedClient.getCompany());
        clientRepo.save(client);

        return clientMapper.CLIENT_ModelToDto(client);
    }

    @Override
    public void deleteClient(Long clientId) {
        Client client = clientRepo.findById(clientId).orElseThrow(
                () -> new ClientAPIException(HttpStatus.NOT_FOUND, "Client not found"));

        clientRepo.deleteById(clientId);
    }

    @Override
    public List<ClientVo> getAllClients() {
        return clientMapper.CLIENTS_ModelsToVo(clientRepo.findAll());
    }

    @Override
    public ClientVo getClientById(Long clientId) {
        return clientMapper.CLIENT_ModelToVo(clientRepo.findById(clientId).get());
    }

    @Override
    public ProjectDto saveProject(ProjectVo project) {
        Project savedProject = clientMapper.PROJECT_VoToModel(project);
        savedProject.setClient(clientRepo.findById(project.getClientId()).get());
        projectRepo.save(savedProject);

        return clientMapper.PROJECT_ModelToDto(savedProject);
    }

    @Override
    public ProjectDto updateProject(Long projectId, ProjectVo updatedProject) {
        Project project = projectRepo.findById(projectId).orElseThrow(
                () -> new ClientAPIException(HttpStatus.NOT_FOUND, "Project not found"));

        project.setName(updatedProject.getName());
        project.setProjectStatus(updatedProject.getProjectStatus());
        project.setDuration(updatedProject.getDuration());
        project.setStartDate(updatedProject.getStartDate());
        project.setEndDate(updatedProject.getEndDate());

        projectRepo.save(project);

        return clientMapper.PROJECT_ModelToDto(project);
    }

    @Override
    public void deleteProject(Long projectId) {
        Project project = projectRepo.findById(projectId).orElseThrow(
                () -> new ClientAPIException(HttpStatus.NOT_FOUND, "Project not found")
        );
        projectRepo.deleteById(projectId);

    }

    @Override
    public ProjectDto getProjectById(Long projectId) {
        return clientMapper.PROJECT_ModelToDto(projectRepo.findById(projectId).get());
    }

    @Override
    public List<ProjectDto> getAllProjects() {

        return clientMapper.PROJECT_ModelsToDto(projectRepo.findAll());
    }

    @Override
    public MeetingDto saveMeeting(MeetingVo meeting) {
        Meeting savedMeet = clientMapper.MEETING_VoToModel(meeting);
        savedMeet.setClient(clientRepo.findById(meeting.getClientId()).get());
        meetingRepo.save(savedMeet);

        return clientMapper.MEETING_ModelToDto(savedMeet);
    }

    @Override
    public MeetingDto updateMeeting(Long meetingId, MeetingVo meeting) {
        Meeting meet = meetingRepo.findById(meetingId).orElseThrow(
                () -> new ClientAPIException(HttpStatus.NOT_FOUND, "Meeting not found")
        );
        meet.setMeetDate(meeting.getMeetDate());
        meet.setMeetTime(meeting.getMeetTime());
        //meet.setClient(clientRepo.findById(meeting.getClientId()).orElseThrow());
        meet.setAgenda(meeting.getAgenda());

        meetingRepo.save(meet);

        return clientMapper.MEETING_ModelToDto(meet);
    }

    @Override
    public void deleteMeeting(Long meetingId) {
        Meeting meet = meetingRepo.findById(meetingId).orElseThrow(
                () -> new ClientAPIException(HttpStatus.NOT_FOUND, "Meeting not found")
        );
        meetingRepo.deleteById(meetingId);

    }

    @Override
    public List<MeetingDto> getAllMeetings() {

        return clientMapper.MEETING_ModelsToDto(meetingRepo.findAll());
    }

    @Override
    public MeetingDto getMeetingById(Long meetingId){
        return clientMapper.MEETING_ModelToDto(meetingRepo.findById(meetingId).get());
    }
}
