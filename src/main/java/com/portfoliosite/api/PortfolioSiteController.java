package com.portfoliosite.api;

import com.portfoliosite.model.AcademyInfo;
import com.portfoliosite.model.ProfessionalInfo;
import com.portfoliosite.repository.AcademyRepository;
import com.portfoliosite.repository.ProfessionalRepository;
import com.portfoliosite.service.abs.PortfoliosSiteInterface;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.util.List;

@EnableMongoRepositories
@RestController
@RequestMapping("/api/v1/portfoliosite")
public class PortfolioSiteController{

//    @Autowired
//    private AcademyRepository academyRepository;

//    @Autowired
//    private ProfessionalRepository professionalRepository;

    @Autowired
    private PortfoliosSiteInterface<AcademyInfo> academyRepository;

    @Autowired
    private PortfoliosSiteInterface<ProfessionalInfo> professionalRepository;

    @GetMapping("/academy")
    public List<AcademyInfo> getAcademyInfo() throws UnsupportedEncodingException {
        return (List<AcademyInfo>) academyRepository.GetFromDataBase();
    }

    @GetMapping("/professional")
    public List<ProfessionalInfo> getProfessionalInfo() throws UnsupportedEncodingException {
        return (List<ProfessionalInfo>) professionalRepository.GetFromDataBase();
    }
}
