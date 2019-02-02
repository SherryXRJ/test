package pers.sherry.dubbo.impl;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;
import pers.sherry.dubbo.api.CommonService;
import pers.sherry.dubbo.entry.User;

import java.util.Arrays;
import java.util.List;

/**
 * Dubbo 接口提供者
 */
@Component
@Service
public class CommonServiceImpl implements CommonService{

    @Override
    public List<User> getUsers() {
        return Arrays.asList(new User(1, "Tom"), new User(2, "Jerry"));
    }

}
