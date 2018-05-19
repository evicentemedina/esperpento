package evicentemedina.esperpento.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import evicentemedina.esperpento.R;

public class AllCommunitiesFragment extends Fragment {

    public AllCommunitiesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view;
        Bundle args = getArguments();
        if(args != null){
            view = inflater.inflate(R.layout.fragment_all_communities, container, false);
            TextView textView = view.findViewById(R.id.frag_all_comm_tv);
            String json = args.getString("json");
            textView.setText(json);
        }else{
            view = inflater.inflate(R.layout.fragment_empty, container, false);
        }
        return view;
    }

}
