package edu.temple.assignment7;

import java.io.Serializable;

public class Book implements Serializable {

    public int id;
    public String title;
    public String author;
    public String coverURL;

    public Book(int ID, String Title, String Author, String CoverURL){
        id = ID;
        title = Title;
        author = Author;
        coverURL = CoverURL;
    }

    public String getTitle(){
        return title;
    }

    public String getAuthor(){
        return author;
    }

    public String getCoverURL(){
        return coverURL;
    }
}
