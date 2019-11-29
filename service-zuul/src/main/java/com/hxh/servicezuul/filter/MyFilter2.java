package com.hxh.servicezuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class MyFilter2 extends ZuulFilter {
    /*
    filterType:返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型，具体如下：
        pre：路由之前
        routing：路由之时
        post： 路由之后
        error：发送错误调用
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /*
    过滤顺序
     */
    @Override
    public int filterOrder() {
        return 1;
    }

    /*
    判断是否需要过滤，返回true表示需要过滤，返回false表示不需要过滤
     */
    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        //上个过滤器setSendZuulResponse(false)，表示该请求不转发到相应的服务中，后面的过滤器中可以调用sendZuulResponse()判断不执行过滤器
        boolean flag = ctx.sendZuulResponse();
        if(!flag){
            return false;
        }
        return request.getServletPath().contains("/api-c")? true : false;
    }

    /*
    过滤器的具体逻辑
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        //false，表示不进行路由，请求不会被转发到相应的服务
        ctx.setSendZuulResponse(false);
        ctx.setResponseStatusCode(403);
        try {
            HttpServletResponse response = ctx.getResponse();
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("您没有权限");
        } catch (IOException e) {
        }

        return null;
    }
}
