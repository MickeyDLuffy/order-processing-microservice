package com.melita.caresystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InstallationDetail {
    private Integer customerId;
    private String installationAddress;
    private String preferredInstallationDate;
}
