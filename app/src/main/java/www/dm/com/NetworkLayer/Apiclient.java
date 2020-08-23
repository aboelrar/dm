package www.dm.com.NetworkLayer;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum Apiclient {

    /**
     * @API ---> 1) URL OF API METHOD
     * <p>
     * ---> 2) ARRAY OF PARAMETERS KEYS
     */

    LOGIN_USER("authentication/signin.php", Arrays.asList("user_email", "user_password")),
    INSERT_USER("authentication/register.php", Arrays.asList("user_email", "user_password", "user_name", "user_type", "user_collage")),
    SET_SUGAR_DATA("DataCollector/SugarDataSet.php", Arrays.asList("user_id", "sugar_type", "sugar_bar", "pregnancy", "pharmaceutical", "sugar_since", "complications", "inslulintype",
            "dose1", "dose2", "dose3", "dose4", "dose5")),
    DOCTORS_DETAILS("doctor-details", Arrays.asList("doctor_id")),
    FILTER("filter-doctors", Arrays.asList("speciality_id", "degree_id", "rate")),
    SUBMIT_OFFER("submit-offer", Arrays.asList("star_id", "order_id", "expected_delivery_time", "offer_value")),
    SET_RATE("rate", Arrays.asList("order_id", "rate", "note_id")),
    DIALY_SET_DATA("DataCollector/dailyDataSet.php", Arrays.asList("user_id", "day_id", "after_breakfast", "before_lunch", "after_lunch", "before_dinner", "after_dinner", "midnight")),
    SEND_MSG("send-message", Arrays.asList("consultation_id", "message")),
    APPOIENMENTS("get-date", Arrays.asList("doctor_id", "date")),
    UPDATE_USER_INFO("update-user-info", Arrays.asList("name", "phone", "email", "password", "image_url", "medical_history")),
    GET_COMPLAINT_TYPE("get-complaint-type", null),
    MAKE_COMPLAINT("make-complaint", Arrays.asList("type_id", "complaint", "consultation_id")),
    MY_CONSULTATIONS("my-consultations", null),
    CONFIRM_CONSULTATION("confirm-consultation", Arrays.asList("consultation_id", "payment_status")),
    RESERVE_CONVERSATION("reserve-conversation", Arrays.asList("doctor_id", "appointment_id")),
    CONFIRM_CONVERSATION("confirm-reservation", Arrays.asList("consultation_id", "payment_status")),
    FAQ("faq", null),
    GET_ALL_MSG("chat-messages", Arrays.asList("consultation_id")),
    DOWNLOAD_REPORT("download-report", Arrays.asList("consultation_id")),
    CONSULTATION_FILES("consultation-files", Arrays.asList("consultation_id")),
    CHANGE_LANG("change-lang", Arrays.asList("lang")),
    ADD_PHONE("add-phone", Collections.singletonList("phone")),
    CHANGE_PASS("change-password", Arrays.asList("password", "password_confirmation")),
    CHANGE_PHOTO("update-personal-image", Collections.singletonList("image_url")),
    ADD_PROMO_CODE("add-promocode", Collections.singletonList("promo_code")),
    BILL_AMOUNT("finish-order", Arrays.asList("order_id", "bill_amount")),
    CHECK_OUT("stripe-token", Arrays.asList("amount")),
    UPDATE_INVESTOR("update_investor?", Arrays.asList("id", "Name", "Email", "Password", "Age", "Gender", "Work", "Mobile", "Images")),
    UPLOAD_CONSULTATION_FILES("upload-consultation-files", Arrays.asList("consultation_id", "images", "files"));


    //--------------------------------------

    /**
     * @BASE_URL
     */

    String BASE_URL = "http://dmapi.kareita.com/";

    private final String URL;
    private final List<String> params;


    Apiclient(String URL, List<String> params) {

        this.URL = URL;
        this.params = params;
    }

    public String getURL() {
        return BASE_URL + URL;
    }

    public List<String> getParams() {
        return params;
    }
}
