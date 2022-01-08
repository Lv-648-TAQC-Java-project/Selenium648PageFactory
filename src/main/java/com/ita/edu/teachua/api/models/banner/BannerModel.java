package com.ita.edu.teachua.api.models.banner;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BannerModel {
    private Integer id;
    private String title;
    private String subtitle;
    private String link;
    private String picture;
    private Integer sequenceNumber;
}
