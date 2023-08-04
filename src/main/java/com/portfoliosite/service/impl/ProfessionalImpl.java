package com.portfoliosite.service.impl;

import com.portfoliosite.model.AcademyInfo;
import com.portfoliosite.model.ProfessionalInfo;
import com.portfoliosite.repository.ProfessionalRepository;
import com.portfoliosite.service.abs.PortfoliosSiteInterface;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.UnsupportedEncodingException;
import java.util.List;

public class ProfessionalImpl implements PortfoliosSiteInterface<List<ProfessionalInfo>> {

    @Autowired
    ProfessionalRepository professionalRepository;

    @Override
    public List<ProfessionalInfo> GetFromDataBase() throws UnsupportedEncodingException {
        return professionalRepository.findAll();
    }
}
