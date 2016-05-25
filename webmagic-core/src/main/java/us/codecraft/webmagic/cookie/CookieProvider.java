package us.codecraft.webmagic.cookie;

import java.util.Map;

/**
 * Created by suclogger on 16/5/6.
 */
public interface CookieProvider {
    Map<String,String> getCookie();
    void changeCookie();
    void changeCookie(boolean valid);
}
