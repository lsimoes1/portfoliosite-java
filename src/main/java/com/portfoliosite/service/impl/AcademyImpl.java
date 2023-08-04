package com.portfoliosite.service.impl;

import com.portfoliosite.model.AcademyInfo;
import com.portfoliosite.repository.AcademyRepository;
import com.portfoliosite.service.abs.PortfoliosSiteInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.List;

@Service
public class AcademyImpl<T> implements PortfoliosSiteInterface<List<AcademyInfo>> {

    @Autowired
    private AcademyRepository academyRepository;

    @Override
    public List<AcademyInfo> GetFromDataBase() {
            return academyRepository.findAll();
    }
}
