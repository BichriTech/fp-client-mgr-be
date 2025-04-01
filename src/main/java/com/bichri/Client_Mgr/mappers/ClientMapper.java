package com.bichri.Client_Mgr.mappers;

import com.bichri.Client_Mgr.dtos_vo.ClientDto;
import com.bichri.Client_Mgr.dtos_vo.MeetingDto;
import com.bichri.Client_Mgr.dtos_vo.ProjectDto;
import com.bichri.Client_Mgr.entities.Client;
import com.bichri.Client_Mgr.entities.Meeting;
import com.bichri.Client_Mgr.entities.Project;
import com.bichri.Client_Mgr.vos.ClientVo;
import com.bichri.Client_Mgr.vos.MeetingVo;
import com.bichri.Client_Mgr.vos.ProjectVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.Date;
import java.util.List;

@Mapper(componentModel = "spring", imports = Date.class)
public interface ClientMapper {
    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    ClientDto CLIENT_ModelToDto (Client client);
    Client CLIENT_DtoToModel (ClientDto clientDto);
    ClientVo CLIENT_ModelToVo (Client client);
    List<ClientVo> CLIENTS_ModelsToVo(List<Client> clients);

    @Mapping(target = "client", ignore = true)
    Meeting MEETING_VoToModel (MeetingVo meetingVo);
    MeetingDto MEETING_ModelToDto (Meeting meeting);
    List<MeetingDto> MEETING_ModelsToDto (List<Meeting> meetings);

    @Mapping(target = "client", ignore = true)
    Project PROJECT_VoToModel (ProjectVo projectVo);
    ProjectDto PROJECT_ModelToDto (Project project);
    List<ProjectDto> PROJECT_ModelsToDto (List<Project> projects);
    List<ProjectVo> PROJECT_ModelsToVo (List<Project> projects);
}
