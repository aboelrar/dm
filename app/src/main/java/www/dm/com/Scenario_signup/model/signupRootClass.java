package www.dm.com.Scenario_signup.model;//
//  signupRootClass.java
//  Model Generated using http://www.jsoncafe.com/ 
//  Created on June 5, 2020

import org.json.*;
import java.util.*;
import com.google.gson.annotations.SerializedName;


public class signupRootClass{

	@SerializedName("UserData")
	private signupUserDatum userData;

	public void setUserData(signupUserDatum userData){
		this.userData = userData;
	}
	public signupUserDatum getUserData(){
		return this.userData;
	}

	/**
	 * Instantiate the instance using the passed jsonObject to set the properties values
	 */
	public signupRootClass(JSONObject jsonObject){
		if(jsonObject == null){
			return;
		}
		userData = new signupUserDatum(jsonObject.optJSONObject("UserData"));
	}

	/**
	 * Returns all the available property values in the form of JSONObject instance where the key is the approperiate json key and the value is the value of the corresponding field
	 */
	public JSONObject toJsonObject()
	{
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("userData", userData.toJsonObject());
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObject;
	}

}