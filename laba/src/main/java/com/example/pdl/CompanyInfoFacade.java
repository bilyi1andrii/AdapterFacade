package com.example.pdl;

import java.io.IOException;

public class CompanyInfoFacade {
    public static Company getCompanyDetails(String website) throws IOException {
        Company companyFromPDL = PDLReader.getCompanyInfo(website);
        Company companyFromWebScraping = WebScrapingService
        .getCompanyInfo(website);
        Company companyFromBrandfetch = BrandfetchService
        .getCompanyInfo(website);

        String name = getValue(
                companyFromPDL.getName(),
                companyFromWebScraping.getName(),
                companyFromBrandfetch.getName()
        );

        String description = getValue(
                companyFromPDL.getDescription(),
                companyFromWebScraping.getDescription(),
                companyFromBrandfetch.getDescription()
        );

        String logo = getValue(
                companyFromPDL.getLogo(),
                companyFromWebScraping.getLogo(),
                companyFromBrandfetch.getLogo()
        );

        return new Company(name, description, logo);
    }

    private static String getValue(String primary,
    String secondary, String tertiary) {
        if (primary != null) {
            return primary;
        } else if (secondary != null) {
            return secondary;
        } else {
            return tertiary;
        }
    }
}
