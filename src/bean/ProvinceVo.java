package bean;

import java.io.Serializable;

public class ProvinceVo implements Serializable{
	
		private int provinceId;  //ʡ��id
		private String provinceName;  //ʡ������
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
