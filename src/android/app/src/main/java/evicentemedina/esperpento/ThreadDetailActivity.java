package evicentemedina.esperpento;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Locale;

import evicentemedina.esperpento.objects.Constants;
import evicentemedina.esperpento.objects.VolleySingleton;

public class ThreadDetailActivity extends AppCompatActivity implements View.OnClickListener {

    private String user, pass;
    private int threadId, vote = -1;

    private TextView tvTitle, tvUser, tvComm, tvContent, tvVotes, tvComments, tvTime;
    private ImageView ivUpvote, ivDownvote;
    private ListView listView;
    private EditText etComment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_detail);
        Toolbar toolbar = findViewById(R.id.toolbar_thread_detail);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        tvTitle = findViewById(R.id.thread_detail_title);
        tvUser = findViewById(R.id.thread_detail_user);
        tvComm = findViewById(R.id.thread_detail_comm);
        tvContent = findViewById(R.id.thread_detail_content);
        tvVotes = findViewById(R.id.thread_detail_votes);
        tvComments = findViewById(R.id.thread_detail_comments);
        tvTime = findViewById(R.id.thread_detail_time);
        ivUpvote = findViewById(R.id.thread_detail_upvote);
        ivDownvote = findViewById(R.id.thread_detail_downvote);
        listView = findViewById(R.id.thread_detail_listview);
        etComment = findViewById(R.id.thread_detail_comment_write);
        ImageView ivSend = findViewById(R.id.thread_detail_comment_send);

        SharedPreferences sp = getSharedPreferences("user", MODE_PRIVATE);
        user = sp.getString("user", "");
        pass = sp.getString("pass", "");

        loadContent();

        ivUpvote.setOnClickListener(this);
        ivDownvote.setOnClickListener(this);
        ivSend.setOnClickListener(this);
    }

    private void loadContent() {
        try {
            JSONObject jsonObject = new JSONObject(getIntent().getStringExtra("json"));
            threadId = jsonObject.getInt("id");
            tvTitle.setText(jsonObject.getString("title"));
            tvUser.setText(jsonObject.getString("user"));
            tvComm.setText(jsonObject.getString("community"));
            tvVotes.setText(jsonObject.getString("votes"));
            tvComments.setText(String.format("%s %s", jsonObject.getString("comments"),
                    getString(R.string.comments)));
            tvTime.setText(jsonObject.getString("time").split("[.]")[0]);

            VolleySingleton.getInstance().addToRequestQueue(new JsonObjectRequest(
                Request.Method.GET, Constants.getUrlGetThreadContent(threadId), null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            if (response.getInt("s") == 1) {
                                tvContent.setText(response.getString("c"));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                }
            ));

            VolleySingleton.getInstance().addToRequestQueue(new JsonObjectRequest(
                Request.Method.GET, Constants.getUrlGetVoteUsrThread(user, threadId), null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            if (response.getInt("s") == 1) {
                                if (response.getString("c").equals("t"))
                                    vote = 1;
                                else if (response.getString("c").equals("f"))
                                    vote = 0;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        refreshVote();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                }
            ));

            loadComments();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void loadComments() {
        VolleySingleton.getInstance().addToRequestQueue(new JsonObjectRequest(
            Request.Method.GET, Constants.getUrlGetThreadComments(threadId, user), null,
            new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        if (response.getInt("s") == 1) {
                            listView.setAdapter(new ListViewAdapter(response.getJSONArray("c")));
                            setListViewDynamicHeight(listView);
                            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                    final ImageView upvote = view.findViewById(R.id.listview_comments_upvote);
                                    final ImageView downvote = view.findViewById(R.id.listview_comments_downvote);
                                    final TextView votes = view.findViewById(R.id.listview_comments_votes);
                                    VolleySingleton.getInstance().addToRequestQueue(new JsonObjectRequest(
                                        Request.Method.GET, Constants.getUrlInsVoteComment(user, pass, id), null,
                                        new Response.Listener<JSONObject>() {
                                            @Override
                                            public void onResponse(JSONObject response) {
                                                try {
                                                    if (response.getInt("s") == 1) {
                                                        int _votes = Integer.parseInt(votes.getText().toString());
                                                        switch (response.getInt("c")) {
                                                            case 1:
                                                                upvote.setImageDrawable(getDrawable(R.drawable.ic_arrow_upward_active));
                                                                downvote.setImageDrawable(getDrawable(R.drawable.ic_arrow_downward));
                                                                _votes++;
                                                                break;
                                                            case 0:
                                                                upvote.setImageDrawable(getDrawable(R.drawable.ic_arrow_upward));
                                                                downvote.setImageDrawable(getDrawable(R.drawable.ic_arrow_downward_active));
                                                                _votes = _votes-2;
                                                                break;
                                                            case -1:
                                                                upvote.setImageDrawable(getDrawable(R.drawable.ic_arrow_upward));
                                                                downvote.setImageDrawable(getDrawable(R.drawable.ic_arrow_downward));
                                                                _votes++;
                                                                break;
                                                        }
                                                        votes.setText(String.format(Locale.getDefault(), "%d", _votes));
                                                    }
                                                } catch (JSONException e) {
                                                    e.printStackTrace();
                                                }
                                            }
                                        }, new Response.ErrorListener() {
                                            @Override
                                            public void onErrorResponse(VolleyError error) {
                                                error.printStackTrace();
                                            }
                                        }
                                    ));
                                }
                            });
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    error.printStackTrace();
                }
            }
        ));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            case R.id.action_refresh:
                loadContent();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void refreshVote() {
        switch (vote) {
            case 1:
                ivUpvote.setImageDrawable(getDrawable(R.drawable.ic_arrow_upward_active));
                ivDownvote.setImageDrawable(getDrawable(R.drawable.ic_arrow_downward));
                break;
            case 0:
                ivUpvote.setImageDrawable(getDrawable(R.drawable.ic_arrow_upward));
                ivDownvote.setImageDrawable(getDrawable(R.drawable.ic_arrow_downward_active));
                break;
            default:
                ivUpvote.setImageDrawable(getDrawable(R.drawable.ic_arrow_upward));
                ivDownvote.setImageDrawable(getDrawable(R.drawable.ic_arrow_downward));
        }
        VolleySingleton.getInstance().addToRequestQueue(new JsonObjectRequest(
            Request.Method.GET, Constants.getUrlGetVotesThread(threadId), null,
            new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        tvVotes.setText(response.getString("s"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    error.printStackTrace();
                }
            }
        ));
    }

    private void castVote(final int _vote) {
        VolleySingleton.getInstance().addToRequestQueue(new JsonObjectRequest(
            Request.Method.GET, Constants.getUrlInsVoteThread(user, pass, threadId, _vote), null,
            new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        if (response.getInt("s") == 1) {
                            vote = _vote;
                            refreshVote();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    error.printStackTrace();
                }
            }
        ));
    }

    @Override
    public void onClick(final View v) {
        if (v.getId() == R.id.thread_detail_upvote) {
            if (vote == 1) castVote(-1);
            else castVote(1);
        } else if (v.getId() == R.id.thread_detail_downvote) {
            if (vote == 0) castVote(-1);
            else castVote(0);
        } else if (v.getId() == R.id.thread_detail_comment_send) {
            String comment = etComment.getText().toString();
            if (!comment.isEmpty()) {
                VolleySingleton.getInstance().addToRequestQueue(new JsonObjectRequest(
                    Request.Method.GET, Constants.getUrlInsComment(user, pass, threadId, comment),
                    null, new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            String msg = null;
                            try {
                                if (response.getInt("s") == 1) {
                                    etComment.setText("");
                                    loadComments();
                                } else msg = getString(R.string.error_creating_comment);
                            } catch (JSONException e) {
                                e.printStackTrace();
                                msg = getString(R.string.bad_response);
                            }
                            if (msg != null) Snackbar.make(v, msg, Snackbar.LENGTH_LONG).show();
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            error.printStackTrace();
                            String msg;
                            if (error.networkResponse != null)
                                msg = getString(R.string.error) + " " + error.networkResponse.statusCode;
                            else
                                msg = getString(R.string.connection_error);
                            Snackbar.make(v, msg, Snackbar.LENGTH_LONG).show();
                        }
                    }
                ));
            }
        }
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
            try {
                return items.getJSONObject(position);
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        public long getItemId(int position) {
            try {
                return items.getJSONObject(position).getInt("id");
            } catch (JSONException e) {
                e.printStackTrace();
                return -1;
            }
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.listview_comments, parent, false);
            }
            TextView votes = convertView.findViewById(R.id.listview_comments_votes),
                     user = convertView.findViewById(R.id.listview_comments_user),
                     time = convertView.findViewById(R.id.listview_comments_time),
                     content = convertView.findViewById(R.id.listview_comments_content);

            ImageView upvote = convertView.findViewById(R.id.listview_comments_upvote),
                      downvote = convertView.findViewById(R.id.listview_comments_downvote);

            try {
                JSONObject item = items.getJSONObject(position);
                votes.setText(item.getString("votes"));
                user.setText(item.getString("user"));
                time.setText(item.getString("time").split("[.]")[0]);
                content.setText(item.getString("content"));

                switch (item.getString("vote")) {
                    case "t":
                        upvote.setImageDrawable(getDrawable(R.drawable.ic_arrow_upward_active));
                        break;
                    case "f":
                        downvote.setImageDrawable(getDrawable(R.drawable.ic_arrow_downward_active));
                        break;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return convertView;
        }

    }

    private static void setListViewDynamicHeight(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            return;
        }
        int totalHeight = listView.getPaddingTop() + listView.getPaddingBottom();
        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(), View.MeasureSpec.AT_MOST);
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);

            if(listItem != null){
                listItem.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT));
                listItem.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
                totalHeight += listItem.getMeasuredHeight();

            }
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
        listView.requestLayout();
    }
}
