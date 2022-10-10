package com.example.springbootcrud.controller;

import com.example.springbootcrud.requests.ReadingRequest;
import com.example.springbootcrud.requests.ReportRequest;
import com.example.springbootcrud.response.ReadingResponse;
import com.example.springbootcrud.response.ReportResponse;
import com.example.springbootcrud.service.ReadingService;
import com.example.springbootcrud.service.ReportService;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ReportController {

    @Autowired
    ReportService reportService;

    @GetMapping("/readings/report")
    public ResponseEntity<ReportResponse> getReportByCityHallId(@Valid @RequestBody ReportRequest  reportRequest){
        return ResponseEntity.ok(reportService.getReportByCityHallId(reportRequest));
    }

}
