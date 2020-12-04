package dao;

public class UserInfoDao {

	// USER項目
	// ユーザー番号
	private String soul_userid;
	// 名称
	private String soul_name;
	// 性別
	private String soul_sex;
	// 生年月日
	private String birthday;
	// 星座
	private String star;
	// 都市
	private String city;
	// 趣味1
	private String hobby1;
	// 趣味2
	private String hobby2;
	public String getHobby2() {
		return hobby2;
	}

	public void setHobby2(String hobby2) {
		this.hobby2 = hobby2;
	}

	public String getHobby3() {
		return hobby3;
	}

	public void setHobby3(String hobby3) {
		this.hobby3 = hobby3;
	}

	public String getHobby4() {
		return hobby4;
	}

	public void setHobby4(String hobby4) {
		this.hobby4 = hobby4;
	}

	public String getHobby5() {
		return hobby5;
	}

	public void setHobby5(String hobby5) {
		this.hobby5 = hobby5;
	}

	public String getHobby6() {
		return hobby6;
	}

	public void setHobby6(String hobby6) {
		this.hobby6 = hobby6;
	}

	// 趣味3
	private String hobby3;
	// 趣味4
	private String hobby4;
	// 趣味5
	private String hobby5;
	// 趣味6
	private String hobby6;

	// LOGIN項目
	// ログインＩＤ
	private String soul_login_mail;
	// パスワード
	private String soul_pw;

	public String getSoul_userid() {
		return soul_userid;
	}

	public void setSoul_userid(String soul_userid) {
		this.soul_userid = soul_userid;
	}

	public String getSoul_name() {
		return soul_name;
	}

	public void setSoul_name(String soul_name) {
		this.soul_name = soul_name;
	}

	public String getSoul_sex() {
		return soul_sex;
	}

	public void setSoul_sex(String soul_sex) {
		this.soul_sex = soul_sex;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getStar() {
		return star;
	}

	public void setStar(String star) {
		this.star = star;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getHobby() {
		return hobby1;
	}

	public void setHobby1(String hobby1) {
		this.hobby1 = hobby1;
	}

	public String getSoul_login_mail() {
		return soul_login_mail;
	}

	public void setSoul_login_mail(String soul_login_mail) {
		this.soul_login_mail = soul_login_mail;
	}

	public String getSoul_pw() {
		return soul_pw;
	}

	public void setSoul_pw(String soul_pw) {
		this.soul_pw = soul_pw;
	}

}