package evicentemedina.esperpento.objects;

public final class Constants {
    private static final String URL_DEV = "http://192.168.1.2/esperpento/";
    private static final String URL_PROD = "http://esperpento.ddns.net/esperpento/";
    public static String URL = URL_DEV;

    public static void toggleUrl() {
        if(URL.equals(URL_DEV)){
            URL = URL_PROD;
        }else{
            URL = URL_DEV;
        }
    }
}
