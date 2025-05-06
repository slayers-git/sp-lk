package ru.bgpu.splk.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ru.bgpu.splk.models.RepairRequest;
import ru.bgpu.splk.services.RepairRequestService;

import java.util.List;

@RestController
@RequestMapping("/repair")
public class RepairRequestController {
    @Autowired private RepairRequestService repairRequestService;

    @GetMapping
    public List<RepairRequest> index() {
        return repairRequestService.listRequests();
    }
    
    @PostMapping("create")
    public ResponseEntity<RepairRequest> createRequest(@RequestBody RepairRequest request) {
        RepairRequest createdRequest = repairRequestService.createRequest(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRequest);
    }

}