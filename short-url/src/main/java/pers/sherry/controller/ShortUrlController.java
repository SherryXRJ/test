package pers.sherry.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pers.sherry.dao.UrlDao;
import pers.sherry.util.ShortUrlUtil;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/shortUrl")
public class ShortUrlController {

    @Resource
    private UrlDao urlDao;

    /**
     * 长链接生成短链接接口
     *
     * @param longUrl        长短接
     * @param customShortUrl 自定义短链接(如果有该参数 则使用该参数)
     * @return 生成后的短链接
     */
    @RequestMapping("/long2Short/{longUrl}/{customShortUrl}")
    @ResponseBody
    public Map<String, Object> long2Short(@PathVariable(name = "longUrl") String longUrl
            , @PathVariable(name = "customShortUrl") String customShortUrl) {
        //  1.参数校验
        Optional.ofNullable(longUrl).orElseThrow(() -> new RuntimeException("长链接不能为空"));

        //  2.对短链接进行校验
        String shortUrl = !StringUtils.isEmpty(customShortUrl)
                ? customShortUrl : ShortUrlUtil.generateShortUrl(longUrl, 4);//  TODO: 暂时定为4位
        //  2.1查询短链接是否已经存在
        Integer count = Optional.ofNullable(urlDao.queryUrlCount(shortUrl, null)).orElse(0);
        if (count > 0) {
            throw new RuntimeException("该短链接已存在");
        }

        //  3.将短链接长链接存到数据库中
        urlDao.saveUrl(shortUrl, longUrl);
        return generateSuccess("生成短链接成功. 短链接: " + shortUrl + " 长链接: " + longUrl);
    }

    /**
     * //TODO: AOP + Redis 计算访问次数
     * 使用短链接访问长链接
     *
     * @return
     */
    @RequestMapping("/visit/{shortUrl}")
    public String visit(@PathVariable(name = "shortUrl") String shortUrl) {
        //  如果数据库中有长链接 则重定向

        //  如果没有则提示用户

        return null;
    }

    private Map<String, Object> generateSuccess(String msg){
        Map<String, Object> result = new HashMap<>();
        result.put("code", 200);
        result.put("msg", msg);
        return result;
    }

    /**
     * 异常处理
     */
    @ResponseBody
    @ExceptionHandler
    public Map<String, Object> handlerException(Throwable ex) {
        Map<String, Object> result = new HashMap<>();
        result.put("code", 401);
        result.put("errorMsg", ex.getMessage());
        return result;
    }

}
