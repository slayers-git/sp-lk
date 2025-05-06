package ru.bgpu.splk.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bgpu.splk.models.RepairRequest;
import ru.bgpu.splk.repositories.RepairRequestRepository;

@Service
public class RepairRequestService {

    @Autowired private RepairRequestRepository repairRequestRepository;

    public RepairRequest save(RepairRequest repairRequest) {
        return repairRequestRepository.save(repairRequest);
    }
    
    public List<RepairRequest> listRequests () {
    	return repairRequestRepository.findAll();
    }
    
    public RepairRequest createRequest(RepairRequest request) {
        return repairRequestRepository.save(request);
    }
}