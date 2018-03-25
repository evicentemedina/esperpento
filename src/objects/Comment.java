package objects;

import com.sun.istack.internal.NotNull;

import java.util.Date;

public class Comment {
    private int id, upvotes, downvotes, parent, thread;
    private String content, user;
    private Date time, last_edited;

    // New comment constructor
    public Comment(@NotNull String content, int parent, int thread,
                   @NotNull String user) {
        this.content = content;
        this.parent = parent;
        this.thread = thread;
        this.user = user;
    }

    // Full constructor
    public Comment(int id, int thread, @NotNull String user,
                   @NotNull String content, @NotNull Date time, int parent,
                   Date last_edited, int upvotes, int downvotes) {
        this.id = id;
        this.thread = thread;
        this.user = user;
        this.content = content;
        this.time = time;
        this.parent = parent;
        this.last_edited = last_edited;
        this.upvotes = upvotes;
        this.downvotes = downvotes;
    }

    public int getId() {
        return id;
    }

    public void setContent(@NotNull String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public Date getTime() {
        return time;
    }

    public int getUpvotes() {
        return upvotes;
    }

    public int getDownvotes() {
        return downvotes;
    }

    public void setLast_edited(Date last_edited) {
        this.last_edited = last_edited;
    }

    public Date getLast_edited() {
        return last_edited;
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
