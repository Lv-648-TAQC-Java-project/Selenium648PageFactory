package com.ita.edu.teachua.api.models.feedback;


import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Feedback {
    private Integer id;
    private Float rate;
    private String text;
    private Integer userId;
    private Integer clubId;
}