package com.nasiatech.osofmarketplace.api.controller;

import com.nasiatech.osofmarketplace.api.dto.ToolDto;
import com.nasiatech.osofmarketplace.business.service.ToolService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/tool")
public class ToolController {
    private final ToolService toolService;

    @GetMapping
    public ResponseEntity<List<ToolDto>> getAll() {
        return ResponseEntity.ok(toolService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ToolDto> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(toolService.getById(id));
    }
}
