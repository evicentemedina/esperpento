package evicentemedina.esperpento.fragments;

import android.os.Bundle;
import android.app.Fragment;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import evicentemedina.esperpento.R;

public class ThreadsListFragment extends Fragment {

    private JSONArray items;

    public ThreadsListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view;
        Bundle args = getArguments();
        if (args != null) {
            view = inflater.inflate(R.layout.fragment_threads_list, container, false);
            try {
                items = new JSONArray(args.getString("args"));
                ListView listView = view.findViewById(R.id.frag_threads_list_lv);
                listView.setAdapter(new ListViewAdapter(items));
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        // TODO: Thread detail
                    }
                });
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            view = inflater.inflate(R.layout.fragment_empty, container, false);
        }
        FloatingActionButton fab = view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: Start create thread activity
            }
        });
        return view;
    }

    private class ListViewAdapter extends BaseAdapter {

        private JSONArray items;

        ListViewAdapter(JSONArray items) {
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
            try{
                return items.getJSONObject(position).getInt("id");
            }catch(JSONException e){
                e.printStackTrace();
                return -1;
            }
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.listview_threads, parent, false);
            }
            TextView title = convertView.findViewById(R.id.listview_threads_title),
                     time = convertView.findViewById(R.id.listview_threads_time),
                     user = convertView.findViewById(R.id.listview_threads_user),
                     comm = convertView.findViewById(R.id.listview_threads_comm);
            try {
                JSONObject item = items.getJSONObject(position);
                title.setText(item.getString("title"));
                time.setText(item.getString("time").split("[.]")[0]);
                user.setText(item.getString("user"));
                comm.setText(item.getString("community"));
            } catch(JSONException e) {
                e.printStackTrace();
            }
            return convertView;
        }
    }

}
