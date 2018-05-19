package evicentemedina.esperpento.objects;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import evicentemedina.esperpento.Esperpento;

public class VolleySingleton {
    private static VolleySingleton instance = null;
    private RequestQueue requestQueue;

    private VolleySingleton() {
        requestQueue = getRequestQueue();
        requestQueue = Volley.newRequestQueue(Esperpento.getAppContext());
    }

    public static synchronized VolleySingleton getInstance() {
        if(instance == null) {
            instance = new VolleySingleton();
        }
        return instance;
    }

    public RequestQueue getRequestQueue() {
        return requestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        req.setTag("cancelable");
        getRequestQueue().add(req);
    }
}
