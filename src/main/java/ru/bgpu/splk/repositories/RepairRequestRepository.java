package ru.bgpu.splk.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import ru.bgpu.splk.models.RepairRequest;
import ru.bgpu.splk.models.User;

public interface RepairRequestRepository extends CrudRepository<RepairRequest, Long> {
    public List<RepairRequest> findAll();
}