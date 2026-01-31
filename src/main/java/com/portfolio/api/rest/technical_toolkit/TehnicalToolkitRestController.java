package com.portfolio.api.rest.technical_toolkit;

import com.portfolio.api.rest.technical_toolkit.dto.TechnicalToolkitDTO;
import com.portfolio.api.rest.technical_toolkit.entity.TechnicalToolkit;
import com.portfolio.api.rest.technical_toolkit.service.TechnicalToolkitService;
import com.portfolio.api.utils.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Technical Toolkit", description = "Endpoints for Technical Toolkit Section")
@RequestMapping("/api/v1/technical-toolkit")
public class TehnicalToolkitRestController {
    public TechnicalToolkitService technicalToolkitService;

    @Autowired
    public TehnicalToolkitRestController(TechnicalToolkitService technicalToolkitService) {
        this.technicalToolkitService = technicalToolkitService;
    }

    @GetMapping()
    public ResponseEntity<ApiResponse<List<TechnicalToolkit>>>  findAll(){
        List<TechnicalToolkit> toolkits = technicalToolkitService.findAll();
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK.value(), "Toolkits fetched successfully", toolkits));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<Object>> save(
            @RequestBody List<TechnicalToolkitDTO> technicalToolkitDTO
            ){
            TechnicalToolkit toolkit = technicalToolkitService.save(technicalToolkitDTO);
            return ResponseEntity.created(null).body(new ApiResponse<>(HttpStatus.CREATED.value(), "Toolkits created successfully", null));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Object>> deleteById(@PathVariable int id){
        technicalToolkitService.deleteById(id);
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK.value(), "Toolkits deleted successfully", null));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<TechnicalToolkit>> findById(@PathVariable int id){
        TechnicalToolkit toolkit = technicalToolkitService.findById(id);
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK.value(), "Toolkits fetched successfully", toolkit));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ApiResponse<Object>> update(@PathVariable int id, @RequestBody TechnicalToolkitDTO toolkitDTO){
        TechnicalToolkit update = technicalToolkitService.update(toolkitDTO, id);
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK.value(), "Toolkits updated successfully", update));
    }



}
