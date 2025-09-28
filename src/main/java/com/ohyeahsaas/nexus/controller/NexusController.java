package com.ohyeahsaas.nexus.controller;

import com.ohyeahsaas.nexus.dto.HealthResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;

@RestController
@RequestMapping("/api/v1")
@Slf4j
public class NexusController {

    @Operation(summary = "Ping the service", description = "Simple liveness check")
    @ApiResponse(responseCode = "200",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = HealthResponse.class)))
    @GetMapping("/ping")
    public ResponseEntity<HealthResponse> ping(
            @RequestHeader(value = "X-Trace-Id", required = false) String traceId) {
        log.info("Pinged with trace id: {}", traceId);
        HealthResponse body = HealthResponse.builder()
                .status("UP")
                .service("Nexus")
                .time(OffsetDateTime.now().toString())
                .traceId(traceId == null ? "n/a" : traceId)
                .build();

        return ResponseEntity.ok(body);
    }
}
