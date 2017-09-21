package com.common;

import java.awt.image.BufferedImage;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import com.system.dao.SUserDAO;
import com.system.action.SFunctionGroupAction;
import com.system.bean.SUserBean;




public class RegisterAction  extends BaseActionSupport{

	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private String password_confirm;
	private String phone;
	private String vcode;
	private SUserBean suserbean;
	protected HttpSession session = null;
	
	public String register(){
		String result="input";
		session = request.getSession();
          System.out.println("vcode:"+vcode);
          System.out.println("sessionv:"+session.getAttribute("vcode"));
		if(username!=null&&password!=null&&password_confirm!=null&&phone!=null){
			if(password.equals(password_confirm)){
				SUserDAO dao = new SUserDAO();
				SUserBean user=dao.hasRegisterUser(username);
				if(user ==null){
					SUserBean user2=dao.hasRegisterPhone(phone);
					
					if(user2==null){
						suserbean = new SUserBean();
						suserbean.setPassword(password);
						suserbean.setPhone(phone);
						suserbean.setType(2l);
						suserbean.setUsername(username);
						long time = new Date().getTime()/1000;	   
						suserbean.setCreatetime(time);
						boolean result2 = dao.insert(suserbean); 
						if(result2){
							showMessage="注册成功";	
						}else{
							showMessage="注册失败";	
						}
						result="success";
					}else{
						showMessage="手机号已被注册";
					}

				}else{
					showMessage="用户名已被注册";
				}
			}else{
				showMessage="两次密码不一致";
			}
		}else{
			showMessage="填写的内容为空";
		}
		return result;
	}
	
	
	
	public String getVcode() {
		return vcode;
	}



	public void setVcode(String vcode) {
		this.vcode = vcode;
	}



	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



	public String getPassword_confirm() {
		return password_confirm;
	}



	public void setPassword_confirm(String password_confirm) {
		this.password_confirm = password_confirm;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	/**
	 * 获取图形验证码
	 * ajax请求
	 */
	public void getVCode(){
		session = request.getSession();
		response.setContentType("image/jpeg") ;
		try {
			BufferedImage bufferedImage = ValidateImage.getImg(session);
	        //将内存的图片通过浏览器输出流输出成jpg图片  
	        ImageIO.write(bufferedImage, "jpg", response.getOutputStream()); 
		} 
		catch (Exception e)
		{
			
		}
	}
	
}
