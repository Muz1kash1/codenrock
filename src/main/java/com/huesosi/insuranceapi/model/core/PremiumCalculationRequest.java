package com.huesosi.insuranceapi.model.core;

import java.util.UUID;

public record PremiumCalculationRequest(UUID userId, UUID productId) {
}
