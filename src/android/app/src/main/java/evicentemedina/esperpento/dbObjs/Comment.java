package evicentemedina.esperpento.dbObjs;

import android.support.annotation.NonNull;

import java.util.Date;

public class Comment {
    private int id, votes, parent, thread;
    private String content, user;
    private Date time, edited;

    // New comment constructor
    public Comment(@NonNull String content, int parent, int thread, @NonNull String user) {
        this.content = content;
        this.parent = parent;
        this.thread = thread;
        this.user = user;
    }

    // Full constructor
    public Comment(int id, @NonNull String content, @NonNull Date time, int votes,
                   Date edited, int parent, int thread, @NonNull String user) {
        this.id = id;
        this.content = content;
        this.time = time;
        this.votes = votes;
        this.edited = edited;
        this.parent = parent;
        this.thread = thread;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setContent(@NonNull String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public Date getTime() {
        return time;
    }

    public int getVotes() {
        return votes;
    }

    public void setEdited(Date edited) {
        this.edited = edited;
    }

    public Date getEdited() {
        return edited;
    }

    public int getParent() {
        return parent;
    }

    public int getThread() {
        return thread;
    }

    public String getUser() {
        return user;
    }
}
