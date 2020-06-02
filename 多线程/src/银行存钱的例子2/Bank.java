package 银行存钱的例子2;

/**
 * 银行类 
 * @Author: gongZheng
 * @Date:   2017年11月14日   下午6:03:21 
 * @Description: 具有存钱的方法
 */
public class Bank {
	
	int sum;
	Object object =new Object();
	
	//将原来的同步代码，改成同步函数
	public synchronized void addMoney(int money){
		//synchronized (object) { 
			sum=sum+money;
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"存款，银行当前储存款："+sum);	
		//}
		
	}

}
