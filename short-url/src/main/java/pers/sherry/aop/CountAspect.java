package pers.sherry.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * 切面:统计次数拦截器
 * 使用Redis存储访问的次数
 */
@Aspect
@Component
public class CountAspect {

    /**
     * 统计visit中短url被访问的字数
     * @param joinPoint 切点
     */
    @Before("execution(* pers.sherry.controller.ShortUrlController.visit(..)))")
    public void before(JoinPoint joinPoint) {

    }
}
