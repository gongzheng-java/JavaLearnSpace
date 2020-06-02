package webservice�ͻ���;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

/**
 * webservice�ͻ���
 * ���Կͻ��˵��÷���˷����Ľӿڣ��������������Ŀ�У���ʾ���������idea�д����ģ�
 * @Autho:  gongZheng
 * @Time:   2020��5��10�� ����5:30:44
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
	 * ��ʽ1.�����๤���ķ�ʽ,��Ҫ�õ��Է��Ľ�
	 */
	public static void client1() {
		String address="http://localhost:8080/services/CommonService?wsdl";
		
		JaxWsProxyFactoryBean jaxWsProxyFactoryBean=new JaxWsProxyFactoryBean();
		
		jaxWsProxyFactoryBean.setAddress(address);
		
		//jaxWsProxyFactoryBean.setServiceClass(serviceClass);

	}

	/**
	 * ��ʽ��:��̬����
	 */
	public static void client2() {
		// ������̬�ͻ���
		JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
		Client client = dcf.createClient("http://localhost:8080/services/CommonService?wsdl");
		// ��Ҫ����������Ҫ�����û���������
		// client.getOutInterceptors().add(new ClientLoginInterceptor(USER_NAME,
		// PASS_WORD));
		Object[] objects = new Object[0];
		try {
			// invoke("������",����1,����2,����3....);
			objects = client.invoke("sayHello", "Leftso");
			System.out.println("��������:" + objects[0]);
		} catch (java.lang.Exception e) {
			e.printStackTrace();
		}

	}

}
