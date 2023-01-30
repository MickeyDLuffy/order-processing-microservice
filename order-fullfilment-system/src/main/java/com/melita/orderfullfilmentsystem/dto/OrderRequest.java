package com.melita.orderfullfilmentsystem.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Data
public class OrderRequest {

    private Integer customerId;
    private InstallationDetail installationDetail;
    private List<Product> products;
    private double totalAmount;

    @Getter
    @Setter
    @ToString
    private static class InstallationDetail {
        private Integer customerId;
        private String installationAddress;
        private String preferredInstallationDate;
    }

    @Getter
    @Setter
    @ToString
    private static class Product {
        private Integer id;
        private String name;
        private double price;
        private int quantity;
        private String description;

        @JsonProperty("package")
        private ProductPackage productPackage;
    }

    @Getter
    @Setter
    @ToString
    private static class ProductPackage {
        private Integer id;
        private String name;
        private String description;
        private Integer productId;
    }
}
