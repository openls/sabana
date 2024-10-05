package org.sabana.core.controller;

import org.springframework.web.bind.annotation.RestController;

import org.sabana.core.entity.ApplicationVersion;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/version")
public class VersionController {
    private final ApplicationVersion appVersion;
    
    public VersionController(ApplicationVersion appVersion) {
        this.appVersion = appVersion;
    }

    @GetMapping
    public ResponseEntity<ApplicationVersion> getVersion() {
        return ResponseEntity.ok(appVersion);
    }
}
