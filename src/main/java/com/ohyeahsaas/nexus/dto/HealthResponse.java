package com.ohyeahsaas.nexus.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@Schema(name = "HealthResponse", description = "Service status")
public class HealthResponse {

  @Schema(example = "UP")
  String status;

  @Schema(example = "Nexus")
  String service;

  @Schema(example = "2025-09-27T15:42:10-05:00")
  String time;

  @Schema(example = "abc-123")
  String traceId;
}
