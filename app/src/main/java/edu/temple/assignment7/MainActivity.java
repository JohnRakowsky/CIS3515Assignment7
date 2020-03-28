package edu.temple.assignment7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<HashMap> BookList = generateBookList();



    }

    protected ArrayList<HashMap> generateBookList(){
        ArrayList<HashMap> BookList = new ArrayList<HashMap>();
        HashMap<String, String> book1 = new HashMap<String, String>();
        book1.put("Silence of the Lambs", "Thomas Harris");
        BookList.add(book1);
        HashMap<String, String> book2 = new HashMap<String, String>();
        book2.put("Harry Potter and the Philosopher's Stone", "J.K. Rowling");
        BookList.add(book2);
        HashMap<String, String> book3 = new HashMap<String, String>();
        book3.put("Ender's Game", "Orson Scott Card");
        BookList.add(book3);
        HashMap<String, String> book4 = new HashMap<String, String>();
        book4.put("War of the Worlds", "HG Wells");
        BookList.add(book4);
        HashMap<String, String> book5 = new HashMap<String, String>();
        book5.put("Hitchhiker's Guide to the Galaxy", "Douglas Adams");
        BookList.add(book5);
        HashMap<String, String> book6 = new HashMap<String, String>();
        book6.put("Sword of Shannara", "Terry Brooks");
        BookList.add(book6);
        HashMap<String, String> book7 = new HashMap<String, String>();
        book7.put("The Bible", "Jesus");
        BookList.add(book7);
        HashMap<String, String> book8 = new HashMap<String, String>();
        book8.put("Under the Dome", "Stephen King");
        BookList.add(book8);
        HashMap<String, String> book9 = new HashMap<String, String>();
        book9.put("The Shining", "Stephen King");
        BookList.add(book9);
        HashMap<String, String> book10 = new HashMap<String, String>();
        book10.put("The Stand", "Stephen King");
        BookList.add(book10);
        return BookList;
    }


}
