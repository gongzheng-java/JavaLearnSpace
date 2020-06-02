package 测试同步程序;

import java.math.BigDecimal;
import java.util.Date;

public class RainAll {
	
	private String stcd; //测站编码
	
	private Date endTime; //时间
	
	
	private BigDecimal rn; //雨量

	public String getStcd() {
		return stcd;
	}
	

	public void setStcd(String stcd) {
		this.stcd = stcd;
	}
	

	public Date getEndTime() {
		return endTime;
	}
	

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	

	public BigDecimal getRn() {
		return rn;
	}
	

	public void setRn(BigDecimal rn) {
		this.rn = rn;
	}
	
	
	

}
