package com.ita.edu.teachua.api.models.question;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Question {
    private Integer id;
    private String title;
    private String text;

}