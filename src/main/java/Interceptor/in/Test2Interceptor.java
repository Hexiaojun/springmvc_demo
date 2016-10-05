package Interceptor.in;

import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;

/**
 * Created by chenglei on 2016/10/5.
 * <p>
 * spring mvc拦截器实现方法二
 * 实现WebRequestInterceptor接口
 */
public class Test2Interceptor implements WebRequestInterceptor {

    @Override
    public void preHandle(WebRequest request) throws Exception {
        /**
         * 没有返回值
         * 请求可以被拦截，但是不能被中断
         */
        System.out.println("执行到了preHandle2");
    }

    @Override
    public void postHandle(WebRequest request, ModelMap model) throws Exception {
        System.out.println("执行到了postHandle2");
    }

    @Override
    public void afterCompletion(WebRequest request, Exception ex) throws Exception {
        System.out.println("执行到了afterCompletion2");
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
