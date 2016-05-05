package us.codecraft.webmagic.model.samples;

import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.model.ConsolePageModelPipeline;
import us.codecraft.webmagic.model.annotation.ExtractBy;
import us.codecraft.webmagic.model.OOSpider;
import us.codecraft.webmagic.model.annotation.HelpUrl;
import us.codecraft.webmagic.model.annotation.TargetUrl;

/**
 * @author code4crafter@gmail.com <br>
 * Date: 13-8-2 <br>
 * Time: 上午7:52 <br>
 */
@TargetUrl("http://wosyingjun.iteye.com/blog/\\d+")
@HelpUrl("http://wosyingjun.iteye.com/?page=\\d+")
public class IteyeBlog implements Blog{

    @ExtractBy("//title")
    private String title;

    @ExtractBy(value = "div#blog_content",type = ExtractBy.Type.Css, notNull = true)
    private String content;

    @Override
    public String toString() {
        return "IteyeBlog{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public static void main(String[] args) {
        OOSpider.create(Site.me().setSleepTime(5000).setUserAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_8_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.57 Safari/537.36"),
                new ConsolePageModelPipeline(),
                IteyeBlog.class).addUrl("http://wosyingjun.iteye.com/?page=1").run();
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
