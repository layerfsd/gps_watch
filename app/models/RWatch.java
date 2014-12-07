package models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import play.data.validation.MaxSize;
import play.data.validation.Phone;
import play.data.validation.Required;
import play.db.jpa.Blob;
import play.db.jpa.Model;

@Table(name = "rwatch")
@Entity
public class RWatch extends Model {

	@MaxSize(30)
	public String imei;
	
	public String mac;
	
	public String m_number;
	
	@Phone
	public String guardian_number1;
	
	@Phone
	public String guardian_number2;
	
	@Phone
	public String guardian_number3;
	
	@Phone
	public String guardian_number4;
	
	public String nickname;
	
	public String serialNumber;
	
	public String channel;
	
	public Date bindDate;
	
	//M28 M26
	@ManyToOne(optional = false, cascade = CascadeType.ALL)
	public Production production;
	
	@Required
	@ManyToOne(fetch=FetchType.LAZY,cascade=javax.persistence.CascadeType.REFRESH, optional = true)
	public Customer c;
	
	public String toString(){
		return production.p_name;
	}
}