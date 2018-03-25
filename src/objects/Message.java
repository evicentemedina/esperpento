package objects;

import com.sun.istack.internal.NotNull;

import java.util.Date;

public class Message {
    private int id;
    private String content, room, user;
    private Date time;

    // New message constructor
    public Message(@NotNull String room, @NotNull String user,
                   @NotNull String content) {
        this.room = room;
        this.user = user;
        this.content = content;
    }

    // Full constructor
    public Message(int id, @NotNull String content, @NotNull Date time,
                   @NotNull String room, @NotNull String user) {
        this.id = id;
        this.content = content;
        this.time = time;
        this.room = room;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public String getRoom() {
        return room;
    }

    public String getUser() {
        return user;
    }

    public String getContent() {
        return content;
    }

    public Date getTime() {
        return time;
    }
}
