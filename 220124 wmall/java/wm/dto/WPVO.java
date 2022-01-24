package wm.dto;

import java.sql.Timestamp;

public class WPVO {
	private Integer pseq;
	private String name;
	private String kind;
	private Integer price_b;
	private Integer price_s;
	private Integer price_dc;
	private String content;
	private String image;
	private String useyn;
	private String bestyn;
	private Timestamp indate;
	public Integer getPseq() {
		return pseq;
	}
	public void setPseq(Integer pseq) {
		this.pseq = pseq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public Integer getPrice_b() {
		return price_b;
	}
	public void setPrice_b(Integer price_b) {
		this.price_b = price_b;
	}
	public Integer getPrice_s() {
		return price_s;
	}
	public void setPrice_s(Integer price_s) {
		this.price_s = price_s;
	}
	public Integer getPrice_dc() {
		return price_dc;
	}
	public void setPrice_dc(Integer price_dc) {
		this.price_dc = price_dc;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getUseyn() {
		return useyn;
	}
	public void setUseyn(String useyn) {
		this.useyn = useyn;
	}
	public String getBestyn() {
		return bestyn;
	}
	public void setBestyn(String bestyn) {
		this.bestyn = bestyn;
	}
	public Timestamp getIndate() {
		return indate;
	}
	public void setIndate(Timestamp indate) {
		this.indate = indate;
	}
	
	
}
