package edu.temple.assignment7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.snackbar.Snackbar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements BookListFragment.OnItemSelectedInterface, BookDetailsFragment.OnFragmentInteractionListener {

    FragmentManager fragmentManager = getSupportFragmentManager();
    EditText input;
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = findViewById(R.id.input);

        requestQueue = Volley.newRequestQueue(this);
        final ArrayList<Book> BookList = new ArrayList<Book>();


        findViewById(R.id.search).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String url = "https://kamorris.com/lab/abp/booksearch.php?search=" + input.getText();
                JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                        Request.Method.GET,
                        url,
                        null,
                        new Response.Listener<JSONArray>() {
                            @Override
                            public void onResponse(JSONArray response) {

                                try{
                                    // Loop through the array elements
                                    for(int i=0;i<response.length();i++){
                                        // Get current json object
                                        JSONObject book = response.getJSONObject(i);

                                        int id = book.getInt("book_id");
                                        String title = book.getString("title");
                                        String author = book.getString("author");
                                        String cover_url = book.getString("cover_url");
                                        Book newbook = new Book(id, title, author, cover_url);
                                        BookList.add(newbook);
                                    }
                                }catch (JSONException e){
                                    e.printStackTrace();
                                }
                            }
                        },
                        new Response.ErrorListener(){
                            @Override
                            public void onErrorResponse(VolleyError error){
                                Toast.makeText(MainActivity.this, "Something went wrong", Toast.LENGTH_SHORT);
                            }
                        }
                );

            requestQueue.add(jsonArrayRequest);
                BookListFragment bookListFragment = BookListFragment.newInstance(BookList);

                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container1, bookListFragment);
                fragmentTransaction.addToBackStack(BookListFragment.class.getName());
                fragmentTransaction.commit();

            }
        });


    }




    @Override
    public void itemSelected(Book book) {
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
                ArrayList<Book> BookList = new ArrayList<Book>();
                BookListFragment bookListFragment = BookListFragment.newInstance(BookList);
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container1, bookListFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }

    }







}
