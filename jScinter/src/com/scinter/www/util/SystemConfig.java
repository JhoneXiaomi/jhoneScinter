package com.scinter.www.util;

public class SystemConfig {
	
	/*tab1:系统安全选项配置*/
	private int account_case; //用户帐户区分大小写
	private String default_password;//用户默认密码
	private int default_password_validity_time;//默认密码有效期
	private int login_captcha;//登录随机验证码
	private int password_min_length;//用户密码长度控制
	private int new_password_repeat;//用户密码修改控制 新密码不能与当前密码相同
	private int new_password_uppercase;//用户密码复杂度控制 大写字符个数
	private int new_password_lowercase;//用户密码复杂度控制 小写字符个数
	private int new_password_number;//用户密码复杂度控制 数字个数
	private int new_password_email;//密码重置邮件通知
	private int session_timeout;//会话失效时间
	private int session_update_time;//用户在线状态更新间隔
	private String scinter_home_seo_title;// SEO标题
	private String scinter_home_seo_keyword;// SEO关键字
	private String scinter_home_seo_desc;// SEO内容
	
	/*tab2:系统其他选项配置*/
	private String login_bg;//登录背景图片
	private String server_upload_file_path;//图片上传保存路径
	private String scinter_website_name;//三创网站名称
	private String scinter_logo_url;//三创后台logo
	private String scinter_login_bg;//三创后台logo登录背景图
	private String smtp_server;//邮件SMTP服务器
	private String email_address;//自动发送邮件的邮箱地址
	private String email_password;//邮箱密码
	private String database_password;//数据库密码
	private int database_back_datetime;//数据库备份时间间隔 单位：天
	
	/*tab3:三创首页基本信息配置*/
	private String scinter_home_logo;// 三创首页LOGO
//	private String server_upload_file_path;//图片上传保存路径
	private String scinter_home_telePhone;// 公司电话
	private String scinter_home_portraiture;// 公司传真
	private String scinter_home_postBox;// 公司邮箱
	private String scinter_home_address;// 公司地址
	private String scinter_home_coworker;//合作品牌
	private String scinter_home_friendlyLink;// 友情链接
	private String scinter_home_turnImgs;// 首页焦点轮换图片
	private String scinter_home_decorateImgs;// 首页装修风格图片
	private String scinter_home_twoCodeImg;// 首页底部二维码上传
	private String scinter_home_shangQiao; // 首页百度商桥展示
	private String scinter_home_statistics;//百度统计（PC站）
	/*tab4:三创手机站首页基本信息配置*/
	
	private String scinter_home_M_telePhone;// 手机站的公司电话
	private String scinter_home_M_person;// 手机站的联系人
	private String scinter_home_M_postBox;// 手机站的邮箱地址

	private String scinter_home_M_address;// 手机站的公司地址
	private String scinter_home_M_twoCodeImg;//手机站底部二维码
	private String Scinter_home_M_turnImgs;//手机站轮播图
	private String scinter_home_M_logoImg;//手机站LOGO
	private String scinter_home_M_shangQiao; // 手机站百度商桥展示
    private String scinter_home_M_statistics;// 百度统计（MP 站）
	
    /*SEO 信息配置*/
    private String scinter_package_seo_title;//SEO标题 装修套餐
    private String scinter_package_seo_keyword;//SEO关键字 装修套餐
    private String scinter_package_seo_desc;//SEO描述 装修套餐
	private String scinter_cases_seoTitle_str; // SEO标题 案例列表页 
	private String scinter_cases_seoKeyword_str;// SEO 关键字 案例列表页
	private String scinter_cases_seoDesc_str; // SEO 描述 案例列表页
	private String scinter_news_seoTitle_str;// SEO标题 热门活动列表页
	private String scinter_news_seoKeyword_str;//SEO关键字 热门活动列表页
	private String scinter_news_seoDesc_str;//SEO描述 热门活动列表页
	private String scinter_designer_seoTitle_str;//SEO标题 设计师列表页
	private String scinter_designer_seoKeyword_str;//SEO关键字 设计师列表页
	private String scinter_designer_seoDesc_str;// SEO描述 设计师列表页
	private String scinter_spe_seoTitle_str;//SEO标题 说装修列表页
	private String scinter_spe_seoKeyword_str;//SEO关键字 说装修列表页
	private String scinter_spe_seoDesc_str;//SEO 描述说装修列表页
	private String scinter_diamond_seoTitle_str;//SEO标题 蓝钻工艺 
	private String scinter_diamond_seoKeyword_str;//SEO关键字 蓝钻工艺 
	private String scinter_diamond_seoDesc_str;//SEO描述 蓝钻工艺
	private String scinter_about_seoTitle_str;//SEO标题 关于三创
	private String scinter_about_seoKeyword_str;//SEO关键字关于三创
	private String scinter_about_seoDesc_str;//SEO描述 关于三创
	private String scinter_house_seo_title;//SEO标题楼盘信息
	private String scinter_house_seo_keyword;//SEO关键字楼盘信息
	private String scinter_house_seo_desc;// SEO 描述 楼盘信息
	private String scinter_home_childCompany;//分公司名称
	private String service_seoTitle_str;// 服务信息配置 
	private String service_seoKeyword_str;
	private String service_seoDesc_str;
	
	
	public String getService_seoTitle_str() {
		return service_seoTitle_str;
	}
	public void setService_seoTitle_str(String service_seoTitle_str) {
		this.service_seoTitle_str = service_seoTitle_str;
	}
	public String getService_seoKeyword_str() {
		return service_seoKeyword_str;
	}
	public void setService_seoKeyword_str(String service_seoKeyword_str) {
		this.service_seoKeyword_str = service_seoKeyword_str;
	}
	public String getService_seoDesc_str() {
		return service_seoDesc_str;
	}
	public void setService_seoDesc_str(String service_seoDesc_str) {
		this.service_seoDesc_str = service_seoDesc_str;
	}
	public String getScinter_house_seo_title() {
		return scinter_house_seo_title;
	}
	public void setScinter_house_seo_title(String scinter_house_seo_title) {
		this.scinter_house_seo_title = scinter_house_seo_title;
	}
	public String getScinter_house_seo_keyword() {
		return scinter_house_seo_keyword;
	}
	public void setScinter_house_seo_keyword(String scinter_house_seo_keyword) {
		this.scinter_house_seo_keyword = scinter_house_seo_keyword;
	}
	public String getScinter_house_seo_desc() {
		return scinter_house_seo_desc;
	}
	public void setScinter_house_seo_desc(String scinter_house_seo_desc) {
		this.scinter_house_seo_desc = scinter_house_seo_desc;
	}
	public String getScinter_home_childCompany() {
		return scinter_home_childCompany;
	}
	public void setScinter_home_childCompany(String scinter_home_childCompany) {
		this.scinter_home_childCompany = scinter_home_childCompany;
	}
	public String getScinter_package_seo_title() {
		return scinter_package_seo_title;
	}
	public void setScinter_package_seo_title(String scinter_package_seo_title) {
		this.scinter_package_seo_title = scinter_package_seo_title;
	}
	public String getScinter_package_seo_keyword() {
		return scinter_package_seo_keyword;
	}
	public void setScinter_package_seo_keyword(String scinter_package_seo_keyword) {
		this.scinter_package_seo_keyword = scinter_package_seo_keyword;
	}
	public String getScinter_package_seo_desc() {
		return scinter_package_seo_desc;
	}
	public void setScinter_package_seo_desc(String scinter_package_seo_desc) {
		this.scinter_package_seo_desc = scinter_package_seo_desc;
	}
	public String getScinter_cases_seoTitle_str() {
		return scinter_cases_seoTitle_str;
	}
	public void setScinter_cases_seoTitle_str(String scinter_cases_seoTitle_str) {
		this.scinter_cases_seoTitle_str = scinter_cases_seoTitle_str;
	}
	public String getScinter_cases_seoKeyword_str() {
		return scinter_cases_seoKeyword_str;
	}
	public void setScinter_cases_seoKeyword_str(String scinter_cases_seoKeyword_str) {
		this.scinter_cases_seoKeyword_str = scinter_cases_seoKeyword_str;
	}
	public String getScinter_cases_seoDesc_str() {
		return scinter_cases_seoDesc_str;
	}
	public void setScinter_cases_seoDesc_str(String scinter_cases_seoDesc_str) {
		this.scinter_cases_seoDesc_str = scinter_cases_seoDesc_str;
	}
	public String getScinter_news_seoTitle_str() {
		return scinter_news_seoTitle_str;
	}
	public void setScinter_news_seoTitle_str(String scinter_news_seoTitle_str) {
		this.scinter_news_seoTitle_str = scinter_news_seoTitle_str;
	}
	public String getScinter_news_seoKeyword_str() {
		return scinter_news_seoKeyword_str;
	}
	public void setScinter_news_seoKeyword_str(String scinter_news_seoKeyword_str) {
		this.scinter_news_seoKeyword_str = scinter_news_seoKeyword_str;
	}
	public String getScinter_news_seoDesc_str() {
		return scinter_news_seoDesc_str;
	}
	public void setScinter_news_seoDesc_str(String scinter_news_seoDesc_str) {
		this.scinter_news_seoDesc_str = scinter_news_seoDesc_str;
	}
	public String getScinter_designer_seoTitle_str() {
		return scinter_designer_seoTitle_str;
	}
	public void setScinter_designer_seoTitle_str(
			String scinter_designer_seoTitle_str) {
		this.scinter_designer_seoTitle_str = scinter_designer_seoTitle_str;
	}
	public String getScinter_designer_seoKeyword_str() {
		return scinter_designer_seoKeyword_str;
	}
	public void setScinter_designer_seoKeyword_str(
			String scinter_designer_seoKeyword_str) {
		this.scinter_designer_seoKeyword_str = scinter_designer_seoKeyword_str;
	}
	public String getScinter_designer_seoDesc_str() {
		return scinter_designer_seoDesc_str;
	}
	public void setScinter_designer_seoDesc_str(String scinter_designer_seoDesc_str) {
		this.scinter_designer_seoDesc_str = scinter_designer_seoDesc_str;
	}
	public String getScinter_spe_seoTitle_str() {
		return scinter_spe_seoTitle_str;
	}
	public void setScinter_spe_seoTitle_str(String scinter_spe_seoTitle_str) {
		this.scinter_spe_seoTitle_str = scinter_spe_seoTitle_str;
	}
	public String getScinter_spe_seoKeyword_str() {
		return scinter_spe_seoKeyword_str;
	}
	public void setScinter_spe_seoKeyword_str(String scinter_spe_seoKeyword_str) {
		this.scinter_spe_seoKeyword_str = scinter_spe_seoKeyword_str;
	}
	public String getScinter_spe_seoDesc_str() {
		return scinter_spe_seoDesc_str;
	}
	public void setScinter_spe_seoDesc_str(String scinter_spe_seoDesc_str) {
		this.scinter_spe_seoDesc_str = scinter_spe_seoDesc_str;
	}
	public String getScinter_diamond_seoTitle_str() {
		return scinter_diamond_seoTitle_str;
	}
	public void setScinter_diamond_seoTitle_str(String scinter_diamond_seoTitle_str) {
		this.scinter_diamond_seoTitle_str = scinter_diamond_seoTitle_str;
	}
	public String getScinter_diamond_seoKeyword_str() {
		return scinter_diamond_seoKeyword_str;
	}
	public void setScinter_diamond_seoKeyword_str(
			String scinter_diamond_seoKeyword_str) {
		this.scinter_diamond_seoKeyword_str = scinter_diamond_seoKeyword_str;
	}
	public String getScinter_diamond_seoDesc_str() {
		return scinter_diamond_seoDesc_str;
	}
	public void setScinter_diamond_seoDesc_str(String scinter_diamond_seoDesc_str) {
		this.scinter_diamond_seoDesc_str = scinter_diamond_seoDesc_str;
	}
	public String getScinter_about_seoTitle_str() {
		return scinter_about_seoTitle_str;
	}
	public void setScinter_about_seoTitle_str(String scinter_about_seoTitle_str) {
		this.scinter_about_seoTitle_str = scinter_about_seoTitle_str;
	}
	public String getScinter_about_seoKeyword_str() {
		return scinter_about_seoKeyword_str;
	}
	public void setScinter_about_seoKeyword_str(String scinter_about_seoKeyword_str) {
		this.scinter_about_seoKeyword_str = scinter_about_seoKeyword_str;
	}
	public String getScinter_about_seoDesc_str() {
		return scinter_about_seoDesc_str;
	}
	public void setScinter_about_seoDesc_str(String scinter_about_seoDesc_str) {
		this.scinter_about_seoDesc_str = scinter_about_seoDesc_str;
	}
	public String getScinter_home_seo_title() {
		return scinter_home_seo_title;
	}
	public void setScinter_home_seo_title(String scinter_home_seo_title) {
		this.scinter_home_seo_title = scinter_home_seo_title;
	}
	public String getScinter_home_seo_keyword() {
		return scinter_home_seo_keyword;
	}
	public void setScinter_home_seo_keyword(String scinter_home_seo_keyword) {
		this.scinter_home_seo_keyword = scinter_home_seo_keyword;
	}
	public String getScinter_home_seo_desc() {
		return scinter_home_seo_desc;
	}
	public void setScinter_home_seo_desc(String scinter_home_seo_desc) {
		this.scinter_home_seo_desc = scinter_home_seo_desc;
	}
	public String getScinter_home_statistics() {
		return scinter_home_statistics;
	}
	public void setScinter_home_statistics(String scinter_home_statistics) {
		this.scinter_home_statistics = scinter_home_statistics;
	}
	public String getScinter_home_M_statistics() {
		return scinter_home_M_statistics;
	}
	public void setScinter_home_M_statistics(String scinter_home_M_statistics) {
		this.scinter_home_M_statistics = scinter_home_M_statistics;
	}
	public String getScinter_home_M_shangQiao() {
		return scinter_home_M_shangQiao;
	}
	public void setScinter_home_M_shangQiao(String scinter_home_M_shangQiao) {
		this.scinter_home_M_shangQiao = scinter_home_M_shangQiao;
	}
	public String getScinter_home_shangQiao() {
		return scinter_home_shangQiao;
	}
	public void setScinter_home_shangQiao(String scinter_home_shangQiao) {
		this.scinter_home_shangQiao = scinter_home_shangQiao;
	}
	public String getScinter_home_M_logoImg() {
		return scinter_home_M_logoImg;
	}
	public void setScinter_home_M_logoImg(String scinter_home_M_logoImg) {
		this.scinter_home_M_logoImg = scinter_home_M_logoImg;
	}
	public String getScinter_home_M_twoCodeImg() {
		return scinter_home_M_twoCodeImg;
	}
	public void setScinter_home_M_twoCodeImg(String scinter_home_M_twoCodeImg) {
		this.scinter_home_M_twoCodeImg = scinter_home_M_twoCodeImg;
	}
	public String getScinter_home_M_turnImgs() {
		return Scinter_home_M_turnImgs;
	}
	public void setScinter_home_M_turnImgs(String scinter_home_M_turnImgs) {
		Scinter_home_M_turnImgs = scinter_home_M_turnImgs;
	}
	public String getScinter_home_M_telePhone() {
		return scinter_home_M_telePhone;
	}
	public void setScinter_home_M_telePhone(String scinter_home_M_telePhone) {
		this.scinter_home_M_telePhone = scinter_home_M_telePhone;
	}
	public String getScinter_home_M_person() {
		return scinter_home_M_person;
	}
	public void setScinter_home_M_person(String scinter_home_M_person) {
		this.scinter_home_M_person = scinter_home_M_person;
	}
	public String getScinter_home_M_postBox() {
		return scinter_home_M_postBox;
	}
	public void setScinter_home_M_postBox(String scinter_home_M_postBox) {
		this.scinter_home_M_postBox = scinter_home_M_postBox;
	}
	public int getAccount_case() {
		return account_case;
	}
	public void setAccount_case(int account_case) {
		this.account_case = account_case;
	}
	public String getDefault_password() {
		return default_password;
	}
	public void setDefault_password(String default_password) {
		this.default_password = default_password;
	}
	public int getDefault_password_validity_time() {
		return default_password_validity_time;
	}
	public void setDefault_password_validity_time(int default_password_validity_time) {
		this.default_password_validity_time = default_password_validity_time;
	}
	public int getLogin_captcha() {
		return login_captcha;
	}
	public void setLogin_captcha(int login_captcha) {
		this.login_captcha = login_captcha;
	}
	public int getPassword_min_length() {
		return password_min_length;
	}
	public void setPassword_min_length(int password_min_length) {
		this.password_min_length = password_min_length;
	}
	public int getNew_password_repeat() {
		return new_password_repeat;
	}
	public void setNew_password_repeat(int new_password_repeat) {
		this.new_password_repeat = new_password_repeat;
	}
	public int getNew_password_uppercase() {
		return new_password_uppercase;
	}
	public void setNew_password_uppercase(int new_password_uppercase) {
		this.new_password_uppercase = new_password_uppercase;
	}
	public int getNew_password_lowercase() {
		return new_password_lowercase;
	}
	public void setNew_password_lowercase(int new_password_lowercase) {
		this.new_password_lowercase = new_password_lowercase;
	}
	public int getNew_password_number() {
		return new_password_number;
	}
	public void setNew_password_number(int new_password_number) {
		this.new_password_number = new_password_number;
	}
	public int getNew_password_email() {
		return new_password_email;
	}
	public void setNew_password_email(int new_password_email) {
		this.new_password_email = new_password_email;
	}
	public int getSession_timeout() {
		return session_timeout;
	}
	public void setSession_timeout(int session_timeout) {
		this.session_timeout = session_timeout;
	}
	public int getSession_update_time() {
		return session_update_time;
	}
	public void setSession_update_time(int session_update_time) {
		this.session_update_time = session_update_time;
	}
	public String getLogin_bg() {
		return login_bg;
	}
	public void setLogin_bg(String login_bg) {
		this.login_bg = login_bg;
	}
	public String getServer_upload_file_path() {
		return server_upload_file_path;
	}
	public void setServer_upload_file_path(String server_upload_file_path) {
		this.server_upload_file_path = server_upload_file_path;
	}
	public String getScinter_website_name() {
		return scinter_website_name;
	}
	public void setScinter_website_name(String scinter_website_name) {
		this.scinter_website_name = scinter_website_name;
	}
	public String getScinter_logo_url() {
		return scinter_logo_url;
	}
	public void setScinter_logo_url(String scinter_logo_url) {
		this.scinter_logo_url = scinter_logo_url;
	}
	public String getScinter_login_bg() {
		return scinter_login_bg;
	}
	public void setScinter_login_bg(String scinter_login_bg) {
		this.scinter_login_bg = scinter_login_bg;
	}
	public String getSmtp_server() {
		return smtp_server;
	}
	public void setSmtp_server(String smtp_server) {
		this.smtp_server = smtp_server;
	}
	public String getEmail_address() {
		return email_address;
	}
	public void setEmail_address(String email_address) {
		this.email_address = email_address;
	}
	public String getEmail_password() {
		return email_password;
	}
	public void setEmail_password(String email_password) {
		this.email_password = email_password;
	}
	public String getDatabase_password() {
		return database_password;
	}
	public void setDatabase_password(String database_password) {
		this.database_password = database_password;
	}
	public int getDatabase_back_datetime() {
		return database_back_datetime;
	}
	public void setDatabase_back_datetime(int database_back_datetime) {
		this.database_back_datetime = database_back_datetime;
	}
	public String getScinter_home_logo() {
		return scinter_home_logo;
	}
	public void setScinter_home_logo(String scinter_home_logo) {
		this.scinter_home_logo = scinter_home_logo;
	}
	public String getScinter_home_telePhone() {
		return scinter_home_telePhone;
	}
	public void setScinter_home_telePhone(String scinter_home_telePhone) {
		this.scinter_home_telePhone = scinter_home_telePhone;
	}
	public String getScinter_home_portraiture() {
		return scinter_home_portraiture;
	}
	public void setScinter_home_portraiture(String scinter_home_portraiture) {
		this.scinter_home_portraiture = scinter_home_portraiture;
	}
	public String getScinter_home_postBox() {
		return scinter_home_postBox;
	}
	public void setScinter_home_postBox(String scinter_home_postBox) {
		this.scinter_home_postBox = scinter_home_postBox;
	}
	public String getScinter_home_address() {
		return scinter_home_address;
	}
	public void setScinter_home_address(String scinter_home_address) {
		this.scinter_home_address = scinter_home_address;
	}
	public String getScinter_home_coworker() {
		return scinter_home_coworker;
	}
	public void setScinter_home_coworker(String scinter_home_coworker) {
		this.scinter_home_coworker = scinter_home_coworker;
	}
	public String getScinter_home_friendlyLink() {
		return scinter_home_friendlyLink;
	}
	public void setScinter_home_friendlyLink(String scinter_home_friendlyLink) {
		this.scinter_home_friendlyLink = scinter_home_friendlyLink;
	}
	public String getScinter_home_turnImgs() {
		return scinter_home_turnImgs;
	}
	public void setScinter_home_turnImgs(String scinter_home_turnImgs) {
		this.scinter_home_turnImgs = scinter_home_turnImgs;
	}
	public String getScinter_home_decorateImgs() {
		return scinter_home_decorateImgs;
	}
	public void setScinter_home_decorateImgs(String scinter_home_decorateImgs) {
		this.scinter_home_decorateImgs = scinter_home_decorateImgs;
	}
	public String getScinter_home_twoCodeImg() {
		return scinter_home_twoCodeImg;
	}
	public void setScinter_home_twoCodeImg(String scinter_home_twoCodeImg) {
		this.scinter_home_twoCodeImg = scinter_home_twoCodeImg;
	}
	public String getScinter_home_M_address() {
		return scinter_home_M_address;
	}
	public void setScinter_home_M_address(String scinter_home_M_address) {
		this.scinter_home_M_address = scinter_home_M_address;
	}

}
