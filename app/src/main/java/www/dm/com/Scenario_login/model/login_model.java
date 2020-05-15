package www.dm.com.Scenario_login.model;//
//  RootClass.java
//  Model Generated using http://www.jsoncafe.com/ 
//  Created on May 15, 2020

import org.json.*;
import java.util.*;
import com.google.gson.annotations.SerializedName;


public class login_model{

    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private String name;
    @SerializedName("user_collage")
    private String userCollage;
    @SerializedName("user_email")
    private String userEmail;
    @SerializedName("user_type")
    private String userType;

    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return this.id;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
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
    public void setUserType(String userType){
        this.userType = userType;
    }
    public String getUserType(){
        return this.userType;
    }

    /**
     * Instantiate the instance using the passed jsonObject to set the properties values
     */
    public login_model(JSONObject jsonObject){
        if(jsonObject == null){
            return;
        }
        id = jsonObject.optString("id");
        name = jsonObject.optString("name");
        userCollage = jsonObject.optString("user_collage");
        userEmail = jsonObject.optString("user_email");
        userType = jsonObject.optString("user_type");
    }

    /**
     * Returns all the available property values in the form of JSONObject instance where the key is the approperiate json key and the value is the value of the corresponding field
     */
    public JSONObject toJsonObject()
    {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("id", id);
            jsonObject.put("name", name);
            jsonObject.put("user_collage", userCollage);
            jsonObject.put("user_email", userEmail);
            jsonObject.put("user_type", userType);

        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return jsonObject;
    }

}