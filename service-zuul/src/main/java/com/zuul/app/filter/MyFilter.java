package com.zuul.app.filter;





import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**
 * 路由网关过滤器
 * 可以做token验证等功能
 * @Autho:  gongZheng
 * @Time:   2020年4月15日 下午5:38:06
 * @Description:  @Component 注解是将类纳入进spring容器中管理
*/
@Component
public class MyFilter extends ZuulFilter {
	
	private static Logger log = LoggerFactory.getLogger(MyFilter.class);

	/**
	 * @return
	 */
	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	/**
	 * 测试token验证
	 * 添加下面代码后，求情没有token参数的时候哦，会被拒绝求情
	 * @return
	 */
	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		log.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
		Object accessToken = request.getParameter("token");
		//token存在的时候，直接方向
		if (accessToken != null) {
			return null;
		}
		log.warn("token is empty");
		ctx.setSendZuulResponse(false);
		ctx.setResponseStatusCode(401);
		try {
			ctx.getResponse().getWriter().write("token is empty");
		} catch (Exception e) {
		}
		return null;

	}

	/**
	 * @return
	 */
	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "pre";
	}

	/**
	 * @return
	 */
	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

}
