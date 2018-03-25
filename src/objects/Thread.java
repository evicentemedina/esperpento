package objects;

import com.sun.istack.internal.NotNull;

import java.util.Date;

public class Thread {
    private int id, upvotes, downvotes;
    private String title, content, community, user;
    private Date time, last_edited;

    // New thread constructor
    public Thread(@NotNull String title, @NotNull String content,
                  @NotNull String community, @NotNull String user) {
        this.title = title;
        this.content = content;
        this.community = community;
        this.user = user;
    }

    // Full constructor
    public Thread(int id, @NotNull String title, @NotNull String content,
                  @NotNull Date time, int upvotes, int downvotes,
                  Date last_edited, @NotNull String community,
                  @NotNull String user) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.time = time;
        this.upvotes = upvotes;
        this.downvotes = downvotes;
        this.last_edited = last_edited;
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

    public int getUpvotes() {
        return upvotes;
    }

    public int getDownvotes() {
        return downvotes;
    }

    public Date getTime() {
        return time;
    }

    public void setLast_edited(Date last_edited) {
        this.last_edited = last_edited;
    }

    public Date getLast_edited() {
        return last_edited;
    }

    public String getCommunity() {
        return community;
    }

    public String getUser() {
        return user;
    }
}
