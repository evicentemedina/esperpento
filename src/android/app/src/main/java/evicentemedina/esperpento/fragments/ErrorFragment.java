package evicentemedina.esperpento.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import evicentemedina.esperpento.R;

public class ErrorFragment extends Fragment {

    public ErrorFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_error, container, false);
        Bundle args = getArguments();
        if(args != null){
            TextView textView = view.findViewById(R.id.frag_error_tv);
            textView.setText(String.format("%s\n\n%s", getString(R.string.an_error_occurred),
                    args.getString("args")));
        }
        return view;
    }

}
