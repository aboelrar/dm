package www.dm.com.Scenario_signup.model;//
//  signupUserDatum.java
//  Model Generated using http://www.jsoncafe.com/ 
//  Created on June 5, 2020

import org.json.*;
import java.util.*;
import com.google.gson.annotations.SerializedName;


public class signupUserDatum{

	@SerializedName("user_collage")
	private String userCollage;
	@SerializedName("user_email")
	private String userEmail;
	@SerializedName("user_id")
	private String userId;
	@SerializedName("user_name")
	private String userName;
	@SerializedName("user_password")
	private String userPassword;
	@SerializedName("user_type")
	private String userType;

	public void setUserCollage(String userCollage){
		this.userCollage = userCollage;
	}
	public String getUserCollage(){
		return this.userCollage;
	}
	public void setUserEmail(String userEmail){
		this.userEmail = userEmail;
	}
	public String getUserEmail(){
		return this.userEmail;
	}
	public void setUserId(String userId){
		this.userId = userId;
	}
	public String getUserId(){
		return this.userId;
	}
	public void setUserName(String userName){
		this.userName = userName;
	}
	public String getUserName(){
		return this.userName;
	}
	public void setUserPassword(String userPassword){
		this.userPassword = userPassword;
	}
	public String getUserPassword(){
		return this.userPassword;
	}
	public void setUserType(String userType){
		this.userType = userType;
	}
	public String getUserType(){
		return this.userType;
	}

	/**
	 * Instantiate the instance using the passed jsonObject to set the properties values
	 */
	public signupUserDatum(JSONObject jsonObject){
		if(jsonObject == null){
			return;
		}
		userCollage = jsonObject.optString("user_collage");
		userEmail = jsonObject.optString("user_email");
		userId = jsonObject.optString("user_id");
		userName = jsonObject.optString("user_name");
		userPassword = jsonObject.optString("user_password");
		userType = jsonObject.optString("user_type");
	}

	/**
	 * Returns all the available property values in the form of JSONObject instance where the key is the approperiate json key and the value is the value of the corresponding field
	 */
	public JSONObject toJsonObject()
	{
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("user_collage", userCollage);
			jsonObject.put("user_email", userEmail);
			jsonObject.put("user_id", userId);
			jsonObject.put("user_name", userName);
			jsonObject.put("user_password", userPassword);
			jsonObject.put("user_type", userType);
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObject;
	}

}