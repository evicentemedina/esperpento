package evicentemedina.esperpento.objects;

import android.support.annotation.NonNull;
import android.text.InputFilter;
import android.text.Spanned;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public final class Constants {
    private static final String
            ENC = "UTF-8",
            BLOCKED_CHARS = "*",
            URL_DEV = "http://192.168.1.2/esperpento/",
            URL_PROD = "http://esperpento.ddns.net/esperpento/",
            LOGIN = "login.php?u=%s&p=%s",
            SIGNIN = "signin.php?u=%s&p=%s",
            HOME = "get_threads_usr_recent.php?u=%s",
            MY_COMM = "get_comm_usr.php?u=%s",
            ALL_COMM = "get_comm_all.php",
            INS_COMM = "ins_comm.php?u=%s&p=%s&name=%s&descrip=%s",
            SUB_COMM = "sub_comm.php?u=%s&p=%s&c=%s";

    private static String URL = URL_DEV;

    public static final InputFilter[] INPUT_FILTER = {new InputFilter() {
        @Override
        public CharSequence filter(CharSequence source, int start, int end, Spanned dest,
                                   int dstart, int dend) {
            if(source != null && BLOCKED_CHARS.contains(("" + source)))
                return "";
            else
                return null;
        }
    }};

    private static String encode(@NonNull String... stringArray) {
        String string = URL + stringArray[0];
        Object[] stringBuilder = new Object[stringArray.length - 1];
        for(int i = 1; i < stringArray.length; i++){
            System.out.println("---\n"+stringArray[i]);
            try{
                stringBuilder[i-1] = URLEncoder.encode(stringArray[i], ENC);
            }catch(UnsupportedEncodingException e){
                e.printStackTrace();
                return null;
            }
        }
        System.out.println(String.format(string, stringBuilder));
        return String.format(string, stringBuilder);
    }

    public static void toggleUrl() {
        if(URL.equals(URL_DEV)){
            URL = URL_PROD;
        }else{
            URL = URL_DEV;
        }
    }

    public static String getUrlLogin(@NonNull String user, @NonNull String pass) {
        return encode(LOGIN, user, pass);
    }

    public static String getUrlSignIn(@NonNull String user, @NonNull String pass) {
        return encode(SIGNIN, user, pass);
    }

    public static String getUrlHome(@NonNull String user) {
        return encode(HOME, user);
    }

    public static String getUrlMyComm(@NonNull String user) {
        return encode(MY_COMM, user);
    }

    public static String getUrlAllComm() {
        return URL+ALL_COMM;
    }

    public static String getUrlInsComm(@NonNull String user, @NonNull String pass,
                                       @NonNull String name, String descrip) {
        if(descrip == null)
            descrip = "";
        return encode(INS_COMM, user, pass, name, descrip);
    }

    public static String getUrlSubComm(@NonNull String user, @NonNull String pass,
                                       @NonNull String comm) {
        return encode(SUB_COMM, user, pass, comm);
    }
}
