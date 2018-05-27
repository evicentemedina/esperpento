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
            IS_USR_SUB = "is_usr_sub_comm.php?u=%s&c=%s",
            GET_SUBS_COMM = "get_subs_comm.php?c=%s",
            GET_THREADS_COMM = "get_threads_comm_recent.php?c=%s",
            SUB_COMM = "sub_comm.php?u=%s&p=%s&c=%s",
            GET_VOTE_USR_THREAD = "get_vote_usr_thread.php?u=%s&t=%s",
            GET_VOTES_THREAD = "get_votes_thread.php?t=%s",
            GET_THREAD_CONTENT = "get_thread_content.php?t=%s",
            INS_VOTE_THREAD = "ins_vote_thread.php?u=%s&p=%s&t=%s&v=%s",
            INS_THREAD = "ins_thread.php?u=%s&p=%s&comm=%s&t=%s&c=%s",
            GET_THREAD_COMMENTS = "get_thread_comments.php?t=%s";

    private static String URL = URL_DEV;

    public static InputFilter[] getInputFilters(InputFilter[] inputFilters) {
        InputFilter[] _inputFilters = new InputFilter[inputFilters.length + 1];
        System.arraycopy(inputFilters, 0, _inputFilters, 0, inputFilters.length);
        _inputFilters[inputFilters.length] = new InputFilter() {
            @Override
            public CharSequence filter(CharSequence source, int start, int end, Spanned dest,
                                       int dstart, int dend) {
                if (source != null && BLOCKED_CHARS.contains(("" + source)))
                    return "";
                else
                    return null;
            }
        };
        return _inputFilters;
    }

    private static String encode(@NonNull String... stringArray) {
        String string = URL + stringArray[0];
        Object[] stringBuilder = new Object[stringArray.length - 1];
        for (int i = 1; i < stringArray.length; i++) {
            System.out.println("---\n"+stringArray[i]);
            try {
                stringBuilder[i-1] = URLEncoder.encode(stringArray[i], ENC);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                return null;
            }
        }
        System.out.println(String.format(string, stringBuilder));
        return String.format(string, stringBuilder);
    }

    public static void toggleUrl() {
        if (URL.equals(URL_DEV)) {
            URL = URL_PROD;
        } else {
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

    public static String getUrlIsUsrSub(@NonNull String user, @NonNull String community) {
        return encode(IS_USR_SUB, user, community);
    }

    public static String getUrlGetSubsComm(@NonNull String community) {
        return encode(GET_SUBS_COMM, community);
    }

    public static String getUrlGetThreadsComm(@NonNull String community) {
        return encode(GET_THREADS_COMM, community);
    }

    public static String getUrlSubComm(@NonNull String user, @NonNull String pass,
                                       @NonNull String comm) {
        return encode(SUB_COMM, user, pass, comm);
    }

    public static String getUrlGetVoteUsrThread(@NonNull String user, int thread) {
        return encode(GET_VOTE_USR_THREAD, user, thread+"");
    }

    public static String getUrlGetVotesThread(int thread) {
        return encode(GET_VOTES_THREAD, thread+"");
    }

    public static String getUrlGetThreadContent(int thread) {
        return encode(GET_THREAD_CONTENT, thread+"");
    }

    public static String getUrlInsVoteThread(@NonNull String user, @NonNull String pass, int thread,
                                             int vote) {
        return encode(INS_VOTE_THREAD, user, pass, thread+"", vote+"");
    }

    public static String getUrlInsThread(@NonNull String user, @NonNull String pass,
                                         @NonNull String community, @NonNull String title,
                                         @NonNull String content) {
        return encode(INS_THREAD, user, pass, community, title, content);
    }

    public static String getUrlGetThreadComments(int thread) {
        return encode(GET_THREAD_COMMENTS, thread+"");
    }
}
