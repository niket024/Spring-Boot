package com.keysoft.bucktrackerjpa.controller;

import com.keysoft.bucktrackerjpa.entity.Application;
import com.keysoft.bucktrackerjpa.service.IApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

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
}

