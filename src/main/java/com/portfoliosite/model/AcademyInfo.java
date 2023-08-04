package com.portfoliosite.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@ToString
@Document("academy")
@Data
public class AcademyInfo {

    @Id
    private String id;

    private String Nome;
    private String Descricao;
    private Integer Tipo;
    private Integer Concluido;
    private String Imagem;
    private String Linguagem;
    private String Link;
    private Date DataConclusao;
}
