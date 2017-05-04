package us.codecraft.webmagic.selector;

import cn.wanghaomiao.xpath.exception.NoSuchAxisException;
import cn.wanghaomiao.xpath.exception.NoSuchFunctionException;
import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by suclogger on 16/5/4.
 */
public class JsoupXpathSelector implements Selector {

    private String xPath;

    public JsoupXpathSelector(String xPath) {
        this.xPath = xPath;
    }

    @Override
    public String select(String text) {
        if(text.startsWith("<tr")) {
            StringBuilder sb =  new StringBuilder("<table>");
            sb.append(text);
            sb.append("</table>");
            text = sb.toString();
        }
        JXDocument document  = new JXDocument(text);
        try {
            List<Object> res = document.sel(xPath);
            return StringUtils.join(res,",");
        } catch (NoSuchAxisException e) {
            e.printStackTrace();
        } catch (NoSuchFunctionException e) {
            e.printStackTrace();
        } catch (XpathSyntaxErrorException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<String> selectList(String text) {
        JXDocument document  = new JXDocument(text);
        try {
            List<Object> res = document.sel(xPath);
            List<String> result = new ArrayList<String>();
            for(Object tmp :res) {
                result.add(tmp.toString());
            }
            return result;
        } catch (NoSuchAxisException e) {
            e.printStackTrace();
        } catch (NoSuchFunctionException e) {
            e.printStackTrace();
        } catch (XpathSyntaxErrorException e) {
            e.printStackTrace();
        }
        return null;
    }
}
