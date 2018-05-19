package evicentemedina.esperpento.objects;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public final class Constants {
    private static final String ENC = "UTF-8";

    private static final String URL_DEV = "http://192.168.1.2/esperpento/";
    private static final String URL_PROD = "http://esperpento.ddns.net/esperpento/";
    private static String URL = URL_DEV;

    private static final String LOGIN = "login.php";
    private static final String SIGNIN = "signin.php";
    private static final String ALL_COMM = "get_comm_all.php";

    public static void toggleUrl() {
        if(URL.equals(URL_DEV)){
            URL = URL_PROD;
        }else{
            URL = URL_DEV;
        }
    }

    public static String getUrlLogin(String user, String pass) {
        try{
            return String.format(
                    URL+LOGIN+"?u=%s&p=%s",
                    URLEncoder.encode(user, ENC),
                    URLEncoder.encode(pass, ENC)
            );
        }catch(UnsupportedEncodingException e){
            e.printStackTrace();
            return null;
        }
    }

    public static String getUrlSignIn(String user, String pass) {
        try{
            return String.format(
                    URL+SIGNIN+"?u=%s&p=%s",
                    URLEncoder.encode(user, ENC),
                    URLEncoder.encode(pass, ENC)
            );
        }catch(UnsupportedEncodingException e){
            e.printStackTrace();
            return null;
        }
    }

    public static String getUrlAllComm() {
        return URL+ALL_COMM;
    }
}
