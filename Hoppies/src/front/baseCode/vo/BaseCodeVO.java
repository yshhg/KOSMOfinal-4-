package front.baseCode.vo;

import java.util.Date;

import org.apache.log4j.Logger;

import front.mem.vo.MemberVO;

public class BaseCodeVO {
	private static Logger logger = Logger.getLogger(BaseCodeVO.class);
	
	private int seq;
	private String code;
	private String code_nm;
	private String code_nm_en;
	private String parnts_seq;
	private String use_at;
	private Date regist_dt;
	private Date update_dt;
	
	public BaseCodeVO() {}
	
	public BaseCodeVO(int seq, String code, String code_nm
						, String code_nm_en, String parnts_seq
						, String use_at, Date regist_dt, Date update_dt) {
		this.seq = seq;
		this.code = code;
		this.code_nm = code_nm;
		this.code_nm_en = code_nm_en;
		this.parnts_seq = parnts_seq;
		this.use_at = use_at;
		this.regist_dt = regist_dt;
		this.update_dt = update_dt;
	}
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCode_nm() {
		return code_nm;
	}
	public void setCode_nm(String code_nm) {
		this.code_nm = code_nm;
	}
	public String getCode_nm_en() {
		return code_nm_en;
	}
	public void setCode_nm_en(String code_nm_en) {
		this.code_nm_en = code_nm_en;
	}
	public String getParnts_seq() {
		return parnts_seq;
	}
	public void setParnts_seq(String parnts_seq) {
		this.parnts_seq = parnts_seq;
	}
	public String getUse_at() {
		return use_at;
	}
	public void setUse_at(String use_at) {
		this.use_at = use_at;
	}
	public Date getRegist_dt() {
		return regist_dt;
	}
	public void setRegist_dt(Date regist_dt) {
		this.regist_dt = regist_dt;
	}
	public Date getUpdate_dt() {
		return update_dt;
	}
	public void setUpdate_dt(Date update_dt) {
		this.update_dt = update_dt;
	}
	
}
