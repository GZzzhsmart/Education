package bean;

import java.io.Serializable;

public class ProvinceVo implements Serializable{
	
		private int provinceId;  //省份id
		private String provinceName;  //省份名称
		public int getProvinceId() {
			return provinceId;
		}
		public void setProvinceId(int provinceId) {
			this.provinceId = provinceId;
		}
		public String getProvinceName() {
			return provinceName;
		}
		public void setProvinceName(String provinceName) {
			this.provinceName = provinceName;
		}
		
		
}
