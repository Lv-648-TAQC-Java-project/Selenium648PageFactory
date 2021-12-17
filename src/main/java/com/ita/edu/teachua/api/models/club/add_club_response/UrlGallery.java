package com.ita.edu.teachua.api.models.club.add_club_response;

public class UrlGallery {
    private Integer id;
    private String url;
    private Club club;

    public UrlGallery() {
    }

    public UrlGallery(Integer id, String url, Club club) {
        this.id = id;
        this.url = url;
        this.club = club;
    }

    public Integer getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public Club getClub() {
        return club;
    }
}
