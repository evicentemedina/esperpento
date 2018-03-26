package evicentemedina.esperpento.objects;

import android.support.annotation.NonNull;

public class Chatroom {
    private String name, descrip, icon, community, admin;

    // Full constructor
    public Chatroom(@NonNull String name, String descrip, String icon,
                    @NonNull String community, @NonNull String admin) {
        this.name = name;
        this.descrip = descrip;
        this.icon = icon;
        this.community = community;
        this.admin = admin;
    }

    public String getName() {
        return name;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getIcon() {
        return icon;
    }

    public String getCommunity() {
        return community;
    }

    public String getAdmin() {
        return admin;
    }
}
