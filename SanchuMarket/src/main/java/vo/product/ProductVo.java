package vo.product;

public class ProductVo {
	
	int p_idx; // ��ǰ��ȣ
	int u_idx; // ȸ����ȣ
	int c_idx; // ī�װ���ȣ
	
	String p_name; // ��ǰ��
	String p_date; // ��ǰ�����
	int p_price; // ��ǰ����
	
	String p_condition; // ��ǰ����
	String p_exp; // ��ǰ����
	String p_location; // �ŷ�����
	
	int p_click; // ��ȸ��
	
	String p_status; // �ŷ�����
	public ProductVo() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public int getP_idx() {
		return p_idx;
	}
	public void setP_idx(int p_idx) {
		this.p_idx = p_idx;
	}
	public int getU_idx() {
		return u_idx;
	}
	public void setU_idx(int u_idx) {
		this.u_idx = u_idx;
	}
	public int getC_idx() {
		return c_idx;
	}
	public void setC_idx(int c_idx) {
		this.c_idx = c_idx;
	}
	public int getP_price() {
		return p_price;
	}
	public void setP_price(int p_price) {
		this.p_price = p_price;
	}
	public int getP_click() {
		return p_click;
	}
	public void setP_click(int p_click) {
		this.p_click = p_click;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public String getP_condition() {
		return p_condition;
	}
	public void setP_condition(String p_condition) {
		this.p_condition = p_condition;
	}
	public String getP_exp() {
		return p_exp;
	}
	public void setP_exp(String p_exp) {
		this.p_exp = p_exp;
	}
	public String getP_status() {
		return p_status;
	}
	public void setP_status(String p_status) {
		this.p_status = p_status;
	}
	public String getP_date() {
		return p_date;
	}
	public void setP_date(String p_date) {
		this.p_date = p_date;
	}
	
	
}
