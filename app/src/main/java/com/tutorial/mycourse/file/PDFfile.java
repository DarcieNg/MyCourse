package com.tutorial.mycourse.file;

public class PDFfile {

    public String file_name, url;

    public PDFfile() {
    }

    public PDFfile(String file_name, String url) {
        this.file_name = file_name;
        this.url = url;
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
