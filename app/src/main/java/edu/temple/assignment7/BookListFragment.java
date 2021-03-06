package edu.temple.assignment7;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the

 * to handle interaction events.
 * Use the {@link BookListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BookListFragment extends Fragment {

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER





    private ArrayList<HashMap<String, String>> BookList;

    private OnItemSelectedInterface mListener;

    private HashMap book;

    Context context;

    public BookListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment BookListFragment.
     */

    public static BookListFragment newInstance(ArrayList<HashMap<String,String>> bookList) {
        BookListFragment fragment = new BookListFragment();
        Bundle args = new Bundle();

        args.putSerializable("BookList", bookList);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

            BookList = (ArrayList<HashMap<String,String>>) getArguments().getSerializable("BookList");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View layout = inflater.inflate(R.layout.fragment_book_list, container, false);

        ListView bookview = layout.findViewById(R.id.list_view);
        BookListAdapter adapter = new BookListAdapter(BookList, layout.getContext());
        bookview.setAdapter(adapter);
        bookview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                book = BookList.get(position);
                ((OnItemSelectedInterface) context).itemSelected(book);
            }
        });


        // Inflate the layout for this fragment
        return layout;
    }




    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnItemSelectedInterface) {
            mListener = (OnItemSelectedInterface) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnItemSelectedInterface");
        }
        this.context = context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnItemSelectedInterface {

        void itemSelected(HashMap book);
    }
}
