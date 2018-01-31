package com.example.joaovitor.shared.model;

/**
 * Created by joaovitor on 31/08/17.
 */

public class APIThumbnail {
    private String path;
    private String extension;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getUrl() {
        return getPath() + "." + getExtension();
    }
}
