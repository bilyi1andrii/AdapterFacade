package com.example.pdl;

public class WebScrapingService {
    public static Company getCompanyInfo(String website) {
        return new Company("Mocked Company Name",
        "Mocked Company Description",
        "Mocked Company Logo URL");
    }
}