package com.portfoliosite.service.abs;

import java.io.UnsupportedEncodingException;

public interface PortfoliosSiteInterface<T> {
    public T GetFromDataBase() throws UnsupportedEncodingException;
}
