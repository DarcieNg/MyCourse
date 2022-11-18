package com.tutorial.mycourse.file;

import java.util.ArrayList;
import java.util.List;

public class FileList {

    public static List<PDFfile> list;

    public FileList() {
        this.list = new ArrayList<>();
    }

    public static List<PDFfile> getList() {
        return list;
    }

    public static void setList(List<PDFfile> list) {
        FileList.list = list;
    }

    public static void addFile(PDFfile file) {
        list.add(file);
    }
}
