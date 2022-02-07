package com.portfoliosite.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class Office {
    private String Office;
    private Date DataIn;
    private Date DateOut;
    private String Description;
}
