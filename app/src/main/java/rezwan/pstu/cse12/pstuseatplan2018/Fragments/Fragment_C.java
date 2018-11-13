package rezwan.pstu.cse12.pstuseatplan2018.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import rezwan.pstu.cse12.pstuseatplan2018.R;

public class Fragment_C extends Fragment {


    public Fragment_C() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_fragment_c, container, false);
        return rootView;
    }
}
