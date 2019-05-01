package fr.kungfunantes.backend.model;

import lombok.Data;

@Data
public class File {
    private String fileName;
    private String fileDownloadUri;
    private String fileType;
    private long size;

    public File(String fileName, String fileDownloadUri, String fileType, long size) {
        this.fileName = fileName;
        this.fileDownloadUri = fileDownloadUri;
        this.fileType = fileType;
        this.size = size;
    }
}
