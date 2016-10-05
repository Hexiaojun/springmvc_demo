package Interceptor.in;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by chenglei on 2016/10/5.
 * <p>
 * spring mvc拦截器实现方法一
 * 实现HandlerInterceptor接口
 */
public class TestInterceptor implements HandlerInterceptor {

    /**
     * 返回值表示是否需要将被拦截
     *
     * @param request  请求
     * @param response 响应
     * @param handler  表示请求被拦截的目标(即Controller对象实例)
     * @return true继续，false请求被终止
     * @throws Exception
     */
    @Override
    public boolean preHandle(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, Object handler) throws Exception {
        System.out.println("执行到了preHandle");
        return true;
    }

    /**
     * @param request
     * @param response
     * @param handler
     * @param modelAndView 修改发往的视图
     * @throws Exception
     */
    @Override
    public void postHandle(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("执行到了postHandle");
    }

    @Override
    public void afterCompletion(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("执行到了afterCompletion");
    }

    /**
     * 当存在2个拦截器的时候
     * 执行顺序为
     执行到了preHandle
     执行到了preHandle2
     执行到了postHandle2
     执行到了postHandle
     执行到了afterCompletion2
     执行到了afterCompletion
     * 后面的顺序会和请求发出的顺序相反
     */
}
