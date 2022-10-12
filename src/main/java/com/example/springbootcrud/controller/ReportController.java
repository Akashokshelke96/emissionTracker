package com.example.springbootcrud.controller;

import com.example.springbootcrud.requests.ReadingRequest;
import com.example.springbootcrud.requests.ReportRequest;
import com.example.springbootcrud.response.ReadingResponse;
import com.example.springbootcrud.response.ReportResponse;
import com.example.springbootcrud.service.ReadingService;
import com.example.springbootcrud.service.ReportService;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ReportController {

    @Autowired
    ReportService reportService;

    @RequestMapping(path = "/readings/report",method = RequestMethod.GET,produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ReportResponse> getReportByCityHallId(@Valid @RequestBody ReportRequest  reportRequest){

        return ResponseEntity.ok(reportService.getReportByCityHallId(reportRequest));
    }

    @RequestMapping(path = "/readings/report/xml",method = RequestMethod.GET,produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ReportResponse> getReportByCityHallIdXML(@Valid @RequestBody ReportRequest  reportRequest){

        return ResponseEntity.ok(reportService.getReportByCityHallId(reportRequest));
    }

}