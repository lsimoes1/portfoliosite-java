package com.portfoliosite.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@ToString
@Document("professional")
public class ProfessionalInfo {

    @Id
    private String Id;

    private String Company;
    private String Link;
    private String Image;
    private List<Office> Offices;
}