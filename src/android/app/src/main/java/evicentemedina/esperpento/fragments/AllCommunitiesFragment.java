package evicentemedina.esperpento.fragments;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import evicentemedina.esperpento.R;
import evicentemedina.esperpento.activities.CommNewActivity;

public class AllCommunitiesFragment extends Fragment implements View.OnClickListener {

    private JSONArray items;

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
            String json = args.getString("args");
            try{
                items = new JSONArray(json);
                ListView listView = view.findViewById(R.id.frag_all_comm_lv);
                listView.setAdapter(new ListViewAdapter(items));
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        //TODO: Start here the activity for viewing a community
                        String msg = "asdf";
                        try{
                            msg = items.getJSONObject(position).getString("name");
                        }catch(JSONException e){
                            e.printStackTrace();
                        }
                        Snackbar.make(view, msg, Snackbar.LENGTH_LONG).show();
                    }
                });
            }catch(JSONException e){
                e.printStackTrace();
            }
        }else{
            view = inflater.inflate(R.layout.fragment_empty, container, false);
        }
        FloatingActionButton fab = view.findViewById(R.id.frag_all_comm_fab);
        fab.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.frag_all_comm_fab){
            startActivity(new Intent(v.getContext(), CommNewActivity.class));
        }
    }

    private class ListViewAdapter extends BaseAdapter {

        private JSONArray items;

        ListViewAdapter(JSONArray items){
            this.items = items;
        }

        @Override
        public int getCount() {
            return items.length();
        }

        @Override
        public Object getItem(int position) {
            try{
                return items.getJSONObject(position);
            }catch(JSONException e){
                e.printStackTrace();
                return null;
            }
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null){
                convertView = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.listview_communities, parent, false);
            }
            //TODO: Icon, color and background color. Number of subscribers
            //LinearLayout layout = convertView.findViewById(R.id.listview_comm_layout);
            //ImageView icon = convertView.findViewById(R.id.listview_comm_icon);
            TextView name = convertView.findViewById(R.id.listview_comm_name),
                     admin = convertView.findViewById(R.id.listview_comm_admin),
                     desc = convertView.findViewById(R.id.listview_comm_descrip);
            try{
                JSONObject item = items.getJSONObject(position);
                //layout.setBackgroundColor(item.getInt("bg_color"));
                name.setText(item.getString("name"));
                admin.setText(item.getString("admin"));
                desc.setText(item.getString("descrip"));
            }catch(JSONException e){
                e.printStackTrace();
            }
            return convertView;
        }
    }

}
