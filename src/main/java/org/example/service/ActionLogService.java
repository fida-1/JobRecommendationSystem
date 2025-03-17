package org.example.service;

import org.example.entity.ActionLog;
import org.example.repository.ActionLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActionLogService {

    @Autowired
    private ActionLogRepository actionLogRepository;

    public List<ActionLog> getAllLogs() {
        return actionLogRepository.findAll();
    }

    public Optional<ActionLog> getLogById(Long id) {
        return actionLogRepository.findById(id);
    }

    public ActionLog createLog(ActionLog log) {
        return actionLogRepository.save(log);
    }

    public void deleteLog(Long id) {
        actionLogRepository.deleteById(id);
    }
}
