package org.launchcode.demobackend.controllers;

import org.launchcode.demobackend.models.Project;
import org.launchcode.demobackend.models.data.ProjectRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600) // Bypass CORS policy issues
@RestController // Make this controller function as a REST API
@RequestMapping("/api/project") // Set the endpoint for use with fetch on front end
public class ProjectController {

    @Autowired
    ProjectRepository projectRepository;

    @PostMapping
    public ResponseEntity<?> postProject(@RequestBody Project project, @RequestHeader HttpHeaders headers) {

        projectRepository.save(project);

        int id = project.getId();
        Map<String, String> map = Collections.singletonMap("id", Integer.toString(id));
        // Returns JSON in form { 'id': project.id }
        return new ResponseEntity<>(map, HttpStatus.CREATED);

    }

}
