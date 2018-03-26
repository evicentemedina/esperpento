package evicentemedina.esperpento.objects;

import android.support.annotation.NonNull;

import java.util.Date;

public class Thread {
    private int id, votes;
    private String title, content, community, user;
    private Date time, edited;

    // New thread constructor
    public Thread(@NonNull String title, @NonNull String content,
                  @NonNull String community, @NonNull String user) {
        this.title = title;
        this.content = content;
        this.community = community;
        this.user = user;
    }

    // Full constructor
    public Thread(int id, @NonNull String title, @NonNull String content, @NonNull Date time,
                  int votes, Date edited, @NonNull String community, @NonNull String user) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.time = time;
        this.votes = votes;
        this.edited = edited;
        this.community = community;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public int getVotes() {
        return votes;
    }

    public Date getTime() {
        return time;
    }

    public void setEdited(Date edited) {
        this.edited = edited;
    }

    public Date getEdited() {
        return edited;
    }

    public String getCommunity() {
        return community;
    }

    public String getUser() {
        return user;
    }
}
