package org.sabana.reports.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.sabana.reports.entities.PrintFormat;
import org.sabana.reports.logics.PrintFormatHelper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/report-engine/formats")
public class PrintFormatController {
    
    private PrintFormatHelper helper;

    public PrintFormatController(PrintFormatHelper helper) {
        this.helper = helper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PrintFormat> getMethodName(@PathVariable Long id) {
        return ResponseEntity.ok(helper.getReport(id));
    }
    
}
