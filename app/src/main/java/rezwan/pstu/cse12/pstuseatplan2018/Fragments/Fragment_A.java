package rezwan.pstu.cse12.pstuseatplan2018.Fragments;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import rezwan.pstu.cse12.pstuseatplan2018.R;
import rezwan.pstu.cse12.pstuseatplan2018.RoomReadAndSearch;

public class Fragment_A extends Fragment{
    private EditText search_et;
    private Button searchBtn;
    private String searchKey;
    private ArrayList<String> result;
    private AppCompatTextView textView;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_fragment_a, container, false);
        search_et = rootView.findViewById(R.id.et_a);
        searchBtn = rootView.findViewById(R.id.bt_search);
        textView = rootView.findViewById(R.id.tv_result);

        //Toast.makeText(getActivity(), "Please, enter a roll number first.", Toast.LENGTH_SHORT).show();

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchKey = search_et.getText().toString();
                result = new ArrayList<>();
                if(searchKey.isEmpty()){
                    Toast.makeText(getActivity(), "Please, enter a roll number first.", Toast.LENGTH_SHORT).show();
                }else{
                    RoomReadAndSearch s = new RoomReadAndSearch(searchKey, getActivity());
                    result = s.searchInDatabase();

                    if(result.isEmpty()){
                        textView.setText("No data found.\nOr\n May be an invalid roll.\n" +
                                "Recommended: Enter the correct roll and search again.");
                        textView.setTextColor(Color.RED);

                    }else{
                        textView.setText("Roll: "+searchKey
                                +"\n\nUnit: "+result.get(1)
                                +"\nBuilding: "+result.get(2)
                                +"\nFloor: "+result.get(3)
                                +"\nHall Number: "+result.get(4)
                                +"\nRoom Number: "+result.get(5)
                                +"\nRoom Name: "+result.get(6));
                        textView.setTextColor(Color.BLACK);
                    }

                }
            }
        });
        return rootView;
    }
}
