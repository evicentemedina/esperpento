package evicentemedina.esperpento.dbObjs;

import android.support.annotation.NonNull;

public class Community {
    private String name, descrip, icon, color, bg_color, admin;

    // Full constructor
    public Community(@NonNull String name, String descrip, String icon,
                     String color, String bg_color, @NonNull String admin) {
        this.name = name;
        this.descrip = descrip;
        this.icon = icon;
        this.color = color;
        this.bg_color = bg_color;
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

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setBg_color(String bg_color) {
        this.bg_color = bg_color;
    }

    public String getBg_color() {
        return bg_color;
    }

    public String getAdmin() {
        return admin;
    }
}
