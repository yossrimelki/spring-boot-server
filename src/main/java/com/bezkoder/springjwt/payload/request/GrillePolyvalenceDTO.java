package com.bezkoder.springjwt.payload.request;

public class GrillePolyvalenceDTO {
    private Long id;
        

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private Long userId;
    private Long metierId;
    private int niveau;
    private String filePath;

    public GrillePolyvalenceDTO() {
        // Default constructor
    }
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getMetierId() {
        return metierId;
    }

    public void setMetierId(Long metierId) {
        this.metierId = metierId;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public GrillePolyvalenceDTO(Long userId, Long metierId, int niveau, String filePath) {
        this.userId = userId;
        this.metierId = metierId;
        this.niveau = niveau;
        this.filePath = filePath;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
