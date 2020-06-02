package webservice客户端;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

/**
 * webservice客户端
 * 测试客户端调用服务端发布的接口，服务端在其他项目中（此示例服务端在idea中创建的）
 * @Autho:  gongZheng
 * @Time:   2020年5月10日 下午5:30:44
 * @Description: 
*/
public class CxfClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		client2();
	}

	/**
	 * 方式1.代理类工厂的方式,需要拿到对方的接
	 */
	public static void client1() {
		String address="http://localhost:8080/services/CommonService?wsdl";
		
		JaxWsProxyFactoryBean jaxWsProxyFactoryBean=new JaxWsProxyFactoryBean();
		
		jaxWsProxyFactoryBean.setAddress(address);
		
		//jaxWsProxyFactoryBean.setServiceClass(serviceClass);

	}

	/**
	 * 方式二:动态调用
	 */
	public static void client2() {
		// 创建动态客户端
		JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
		Client client = dcf.createClient("http://localhost:8080/services/CommonService?wsdl");
		// 需要密码的情况需要加上用户名和密码
		// client.getOutInterceptors().add(new ClientLoginInterceptor(USER_NAME,
		// PASS_WORD));
		Object[] objects = new Object[0];
		try {
			// invoke("方法名",参数1,参数2,参数3....);
			objects = client.invoke("sayHello", "Leftso");
			System.out.println("返回数据:" + objects[0]);
		} catch (java.lang.Exception e) {
			e.printStackTrace();
		}

	}

}
