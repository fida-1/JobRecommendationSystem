package org.example.controller;

import org.example.entity.ActionLog;
import org.example.service.ActionLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/actionlogs")
public class ActionLogController {

    @Autowired
    private ActionLogService actionLogService;

    @GetMapping
    public List<ActionLog> getAllLogs() {
        return actionLogService.getAllLogs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ActionLog> getLogById(@PathVariable Long id) {
        Optional<ActionLog> log = actionLogService.getLogById(id);
        return log.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ActionLog createLog(@RequestBody ActionLog log) {
        return actionLogService.createLog(log);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLog(@PathVariable Long id) {
        actionLogService.deleteLog(id);
        return ResponseEntity.noContent().build();
    }
}
