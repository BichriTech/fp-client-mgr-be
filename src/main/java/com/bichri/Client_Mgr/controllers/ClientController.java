package com.bichri.Client_Mgr.controllers;

import com.bichri.Client_Mgr.dtos_vo.ClientDto;
import com.bichri.Client_Mgr.dtos_vo.MeetingDto;
import com.bichri.Client_Mgr.dtos_vo.ProjectDto;
import com.bichri.Client_Mgr.services.ClientService;
import com.bichri.Client_Mgr.vos.ClientVo;
import com.bichri.Client_Mgr.vos.MeetingVo;
import com.bichri.Client_Mgr.vos.ProjectVo;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/client-mgr/api")
@AllArgsConstructor
@CrossOrigin("*")
public class ClientController {
    private final ClientService clientService;

    @PostMapping("/clients/save")
    public ResponseEntity<ClientDto> saveClient(@RequestBody ClientDto client) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/client-mgr/api/clients/save").toString());
        return ResponseEntity.created(uri).body(clientService.saveClient(client));
    }

    @PutMapping("/clients/update/{id}")
    public ResponseEntity<ClientDto> updateClient(@PathVariable("id") Long clientId, @RequestBody ClientDto client) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/client-mgr/api/clients/update").toString());
        return ResponseEntity.created(uri).body(clientService.updateClient(clientId, client));
    }

    @DeleteMapping("/clients/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable("id") Long clientId) {
        clientService.deleteClient(clientId);
        return ResponseEntity.ok().body("Client deleted successfully");
    }

    @GetMapping("/clients")
    public ResponseEntity<List<ClientVo>> getAllClients() {
        return ResponseEntity.ok(clientService.getAllClients());
    }

    @GetMapping("/clients/{id}")
    public ResponseEntity<ClientVo> gettingClientById(@PathVariable("id") Long clientId) {
        return ResponseEntity.ok(clientService.getClientById(clientId));
    }
    @PostMapping("/meetings/save")
    public ResponseEntity<MeetingDto> saveMeeting(@RequestBody MeetingVo meeting) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/client-mgr/api/meetings/save").toString());
        return ResponseEntity.created(uri).body(clientService.saveMeeting(meeting));
    }

    @PutMapping("/meetings/update/{id}")
    public ResponseEntity<MeetingDto> updateMeeting(@PathVariable("id") Long meetingId, @RequestBody MeetingVo meeting) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/client-mgr/api/meetings/update").toString());
        return ResponseEntity.created(uri).body(clientService.updateMeeting(meetingId, meeting));
    }

    @DeleteMapping("/meetings/{id}")
    public ResponseEntity<String> deleteMeeting(@PathVariable("id") Long meetingId) {
        clientService.deleteMeeting(meetingId);
        return ResponseEntity.ok().body("Meeting deleted successfully");
    }

    @GetMapping("/meetings")
    public ResponseEntity<List<MeetingDto>> getAllMeetings() {
        return ResponseEntity.ok(clientService.getAllMeetings());
    }

    @GetMapping("/meetings/{id}")
    public ResponseEntity<MeetingDto> gettingMeetingById(@PathVariable("id") Long meetingId) {
        return ResponseEntity.ok(clientService.getMeetingById(meetingId));

    }

    @PostMapping("/projects/save")
    public ResponseEntity<ProjectDto> saveProject(@RequestBody ProjectVo project) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("client-mgr/api/projects/save").toString());
        return ResponseEntity.created(uri).body(clientService.saveProject(project));
    }

    @PutMapping("/projects/update/{id}")
    public ResponseEntity<ProjectDto> updateProject(@PathVariable("id") Long projectId, @RequestBody ProjectVo project) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("client-mgr/api/projects/save").toString());
        return ResponseEntity.created(uri).body(clientService.updateProject(projectId, project));
    }

    @DeleteMapping("/projects/{id}")
    public ResponseEntity<String> deleteProject(@PathVariable("id") Long projectId) {
        clientService.deleteProject(projectId);
        return ResponseEntity.ok().body("Project deleted successfully");
    }

    @GetMapping("/projects")
    public ResponseEntity<List<ProjectDto>> gettingAllProjects() {
        return ResponseEntity.ok(clientService.getAllProjects());
    }

    @GetMapping("/projects/{id}")
    public ResponseEntity<ProjectDto> getProjectById(@PathVariable("id") Long projectId) {
        return ResponseEntity.ok(clientService.getProjectById(projectId));
    }

}
