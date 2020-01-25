package com.keysoft.bucktrackerjpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.keysoft.bucktrackerjpa.entity.Application;
import com.keysoft.bucktrackerjpa.service.IApplicationService;

@RestController
@RequestMapping("/tza")
public class TrackzillaController {

    @Autowired
    private IApplicationService applicationService;

    @PostMapping("/application")
    public ResponseEntity<Void> addApplication(@RequestBody Application application, UriComponentsBuilder builder) {
        boolean flag = applicationService.addApplication(application);
        if (!flag) return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/application/{id}").buildAndExpand(application.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @GetMapping("/application/{id}")
    public ResponseEntity<Application> getApplicationById(@PathVariable("id") Integer id) {
        Application app = applicationService.getApplicationById(id);
        return new ResponseEntity<Application>(app, HttpStatus.OK);

    }

    @PutMapping("/application")
    public ResponseEntity<Application> updateApplication(@RequestBody Application application) {
        applicationService.updateApplication(application);
        return new ResponseEntity<Application>(application, HttpStatus.OK);
    }

    @DeleteMapping("/application/{id}")
    public ResponseEntity<Void> deleteApplication(@PathVariable("id") Integer id) {
        applicationService.deleteApplication(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}

