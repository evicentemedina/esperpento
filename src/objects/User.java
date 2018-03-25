package objects;

import com.sun.istack.internal.NotNull;

import java.util.Date;

public class User {
    private String name, passwd, icon;
    private Date reg_date, last_con;

    // Simple constructor
    public User(@NotNull String name, String icon) {
        this.name = name;
        this.icon = icon;
    }

    // New user constructor
    public User(@NotNull String name, @NotNull String passwd, String icon) {
        this.name = name;
        this.passwd = passwd;
        this.icon = icon;
    }

    // Full constructor
    public User(@NotNull String name, String icon, Date reg_date,
                Date last_con) {
        this.name = name;
        this.icon = icon;
        this.reg_date = reg_date;
        this.last_con = last_con;
    }

    public String getName() {
        return name;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getIcon() {
        return icon;
    }

    public Date getReg_date() {
        return reg_date;
    }

    public void setLast_con(Date last_con) {
        this.last_con = last_con;
    }

    public Date getLast_con() {
        return last_con;
    }
}
