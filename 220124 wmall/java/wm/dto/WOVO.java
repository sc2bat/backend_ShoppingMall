package wm.dto;

import java.sql.Timestamp;

public class WOVO {
	private Integer odseq;
	private Integer oseq;
	private Timestamp indate;
	private String id;
	private String mname;
	private String zip_num;
	private String address;
	private String phone;
	private Integer pseq;
	private String pname;
	private Integer price_s;
	private Integer quantity;
	private String result;
	public Integer getOdseq() {
		return odseq;
	}
	public void setOdseq(Integer odseq) {
		this.odseq = odseq;
	}
	public Integer getOseq() {
		return oseq;
	}
	public void setOseq(Integer oseq) {
		this.oseq = oseq;
	}
	public Timestamp getIndate() {
		return indate;
	}
	public void setIndate(Timestamp indate) {
		this.indate = indate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getZip_num() {
		return zip_num;
	}
	public void setZip_num(String zip_num) {
		this.zip_num = zip_num;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer getPseq() {
		return pseq;
	}
	public void setPseq(Integer pseq) {
		this.pseq = pseq;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public Integer getPrice_s() {
		return price_s;
	}
	public void setPrice_s(Integer price_s) {
		this.price_s = price_s;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
}
