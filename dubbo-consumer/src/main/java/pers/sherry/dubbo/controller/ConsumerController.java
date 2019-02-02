package pers.sherry.dubbo.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pers.sherry.dubbo.api.CommonService;
import pers.sherry.dubbo.entry.User;

import java.util.List;

@Controller
@RequestMapping("/consumer")
public class ConsumerController {

    @Reference
    private CommonService commonService;

    @RequestMapping(value = "/getUsers")
    @ResponseBody
    public List<User> getUsers(){
        return commonService.getUsers();
    }
}
