package edu.temple.assignment7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements BookListFragment.OnItemSelectedInterface, BookDetailsFragment.OnFragmentInteractionListener {

    FragmentManager fragmentManager = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<HashMap<String,String>> BookList = generateBookList();
        BookListFragment bookListFragment = BookListFragment.newInstance(BookList);

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container1, bookListFragment);
        fragmentTransaction.addToBackStack(BookListFragment.class.getName());
        fragmentTransaction.commit();

    }

    protected ArrayList<HashMap<String, String>> generateBookList(){
        ArrayList<HashMap<String,String>> BookList = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> book1 = new HashMap<String, String>();
        book1.put("Author", "Thomas Harris");
        book1.put("Book", "Silence Of The Lambs");
        BookList.add(book1);
        HashMap<String, String> book2 = new HashMap<String, String>();
        book2.put("Author", "J.K. Rowling");
        book2.put("Book", "Harry Potter and the Sorcerer's Stone");
        BookList.add(book2);
        HashMap<String, String> book3 = new HashMap<String, String>();
        book3.put("Author", "Orson Scott Card");
        book3.put("Book", "Ender's Game");
        BookList.add(book3);
        HashMap<String, String> book4 = new HashMap<String, String>();
        book4.put("Author", "HG Wells");
        book4.put("Book", "War of the Worlds");
        BookList.add(book4);
        HashMap<String, String> book5 = new HashMap<String, String>();
        book5.put("Author", "Douglas Adams");
        book5.put("Book", "Hitchhiker's Guide to the Galaxy");
        BookList.add(book5);
        HashMap<String, String> book6 = new HashMap<String, String>();
        book6.put("Author", "Terry Brooks");
        book6.put("Book", "Sword of Shannara");
        BookList.add(book6);
        HashMap<String, String> book7 = new HashMap<String, String>();
        book7.put("Author", "Jesus");
        book7.put("Book", "The Bible");
        BookList.add(book7);
        HashMap<String, String> book8 = new HashMap<String, String>();
        book8.put("Author", "Stephen King");
        book8.put("Book", "Under the Dome");
        BookList.add(book8);
        HashMap<String, String> book9 = new HashMap<String, String>();
        book9.put("Author", "Stephen King");
        book9.put("Book", "The Shining");
        BookList.add(book9);
        HashMap<String, String> book10 = new HashMap<String, String>();
        book10.put("Author", "Stephen King");
        book10.put("Book", "The Stand");
        BookList.add(book10);
        return BookList;
    }



    @Override
    public void itemSelected(HashMap book) {
        BookDetailsFragment bookDetailsFragment = BookDetailsFragment.newInstance(book);

        if(findViewById(R.id.container2) == null) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container1, bookDetailsFragment);
            fragmentTransaction.addToBackStack(BookDetailsFragment.class.getName());
            fragmentTransaction.commit();
        }
        else{
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container2, bookDetailsFragment);
            fragmentTransaction.addToBackStack(BookDetailsFragment.class.getName());
            fragmentTransaction.commit();
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
    @Override
    public void onBackPressed() {

            if(findViewById(R.id.container2) == null) {
                ArrayList<HashMap<String, String>> BookList = generateBookList();
                BookListFragment bookListFragment = BookListFragment.newInstance(BookList);
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container1, bookListFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }

    }
}
