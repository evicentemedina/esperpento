package evicentemedina.esperpento.objects;

import android.support.annotation.NonNull;

import java.util.Date;

public class Message {
    private int id;
    private String content, room, user;
    private Date time;

    // New message constructor
    public Message(@NonNull String content, @NonNull String room, @NonNull String user) {
        this.content = content;
        this.room = room;
        this.user = user;
    }

    // Full constructor
    public Message(int id, @NonNull String content, @NonNull Date time,
                   @NonNull String room, @NonNull String user) {
        this.id = id;
        this.content = content;
        this.time = time;
        this.room = room;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public Date getTime() {
        return time;
    }

    public String getRoom() {
        return room;
    }

    public String getUser() {
        return user;
    }
}
