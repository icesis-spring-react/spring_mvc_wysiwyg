package com.example.wysiwyg_asignacion2.objects;

public class Magazine {

    private String title;
    private String isbn;
    private String type;

    public Magazine() {
    }

    public Magazine(String title, String isbn, String type) {
        this.title = title;
        this.isbn = isbn;
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
