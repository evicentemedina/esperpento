package evicentemedina.esperpento;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import evicentemedina.esperpento.objects.Constants;
import evicentemedina.esperpento.objects.VolleySingleton;

public class ThreadDetailActivity extends AppCompatActivity {

    private String user, pass;
    private int threadId, vote = -1;

    private TextView tvTitle, tvUser, tvComm, tvContent, tvVotes, tvComments, tvTime;
    private ImageView ivUpvote, ivDownvote;

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

        SharedPreferences sp = getSharedPreferences("user", MODE_PRIVATE);
        user = sp.getString("user", "");
        pass = sp.getString("user", "");

        try {
            JSONObject jsonObject = new JSONObject(getIntent().getStringExtra("json"));
            threadId = jsonObject.getInt("id");
            tvTitle.setText(jsonObject.getString("title"));
            tvUser.setText(jsonObject.getString("user"));
            tvComm.setText(jsonObject.getString("community"));
            tvVotes.setText(jsonObject.getString("votes"));
            tvComments.setText(String.format("%s Comments", jsonObject.getString("comments")));
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
        } catch (JSONException e) {
            e.printStackTrace();
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
}
