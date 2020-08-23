package www.dm.com.NetworkLayer;

import android.content.Context;

import com.android.volley.Request;

import org.json.JSONException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @desc Java Api Calls Contains all the Project Calls
 */

public class Apicalls {

    private APIRouter apiRouter;

    public Apicalls(Context context, NetworkInterface networkInterface) {

        apiRouter = new APIRouter(context, networkInterface);
    }

    //----------------------------------------------------------------------------------------------

    /**
     * @func User Login
     */

    public void loginUser(final String email, final String pass) {

        apiRouter.performRequest(Apiclient.LOGIN_USER.getURL(), Apiclient.LOGIN_USER.getParams(), Arrays.asList(email, pass), Request.Method.POST, 0);

    }


    //----------------------------------------------------------------------------------------------

    /**
     * @func SET SUGAR DATA
     */

    public void SET_SUAGR_DATA(String user_id, String sugar_type, String sugar_per, String pregnancy, String pharmaceutical, String sugar_since, String complications, String insulin_type, String dose1, String dose2, String dose3, String dose4, String dose5) throws JSONException {
        apiRouter.performRequest(Apiclient.SET_SUGAR_DATA.getURL(), Apiclient.SET_SUGAR_DATA.getParams(), Arrays.asList(user_id, sugar_type, sugar_per, pregnancy, pharmaceutical, sugar_since, complications, insulin_type, dose1, dose2, dose3, dose4, dose5), Request.Method.POST, 0);
    }


    //----------------------------------------------------------------------------------------------

    /**
     * @func User Registration
     */

    public void insertDoctor(final String name, final String email, final String password, final String collage, final String type) {

        apiRouter.performRequest(Apiclient.INSERT_USER.getURL(), Apiclient.INSERT_USER.getParams(), Arrays.asList(email, password, name, type, collage), Request.Method.POST, 2);

    }


    //----------------------------------------------------------------------------------------------


    //----------------------------------------------------------------------------------------------

    /**
     * @func SET DIALY DATA
     */

    public void set_dialy_data(final String user_id, String day_id, String after_breakfast, String before_lunch, String after_lunch, String before_dinner, String after_dinner, String midnight) {

        apiRouter.performRequest(Apiclient.DIALY_SET_DATA.getURL(), Apiclient.DIALY_SET_DATA.getParams(), Arrays.asList(user_id, day_id, after_breakfast
                , before_lunch, after_lunch, before_dinner, after_dinner, midnight), Request.Method.POST, 2);

    }


    //----------------------------------------------------------------------------------------------

    /**
     * @func Send Message
     */

    public void send_msg(final String consultation_id, final String message) throws JSONException {

        apiRouter.makeAdvancedRequest(Apiclient.SEND_MSG.getURL(), Request.Method.POST, Apiclient.SEND_MSG.getParams(), Arrays.asList(consultation_id, message), null);

    }


    //----------------------------------------------------------------------------------------------

    /**
     * @func Appointments
     */

    public void appointment(String doctor_id, String date) throws JSONException {

        apiRouter.makeAdvancedRequest(Apiclient.APPOIENMENTS.getURL(), Request.Method.POST, Apiclient.APPOIENMENTS.getParams(), Arrays.asList(doctor_id, date), null);

    }


    //----------------------------------------------------------------------------------------------

    /**
     * @func UPDATE_USER_INFO
     */

    public void update_personal_info(String name, String phone, String email, String password, String image_url, String patient_history) throws JSONException {

        apiRouter.makeAdvancedRequest(Apiclient.UPDATE_USER_INFO.getURL(), Request.Method.POST, Apiclient.UPDATE_USER_INFO.getParams(), Arrays.asList(name, phone, email, password, image_url, patient_history), null);

    }

    //----------------------------------------------------------------------------------------------

    /**
     * @func Make Complaint
     */

    public void make_complaint(String type_id, String message, String consultation_id) throws JSONException {

        apiRouter.makeAdvancedRequest(Apiclient.MAKE_COMPLAINT.getURL(), Request.Method.POST, Apiclient.MAKE_COMPLAINT.getParams(), Arrays.asList(type_id, message, consultation_id), null);

    }


    //----------------------------------------------------------------------------------------------


    /**
     * @func MY_CONSULTATIONS
     */

    public void my_consultations() throws JSONException {

        apiRouter.makeAdvancedRequest(Apiclient.MY_CONSULTATIONS.getURL(), Request.Method.GET, Apiclient.MY_CONSULTATIONS.getParams(), null, null);

    }


    //----------------------------------------------------------------------------------------------


    /**
     * @func CONFIRM_CONSULTATION
     */

    public void confirm_consultation(String consultation_id, String payment_status) throws JSONException {

        apiRouter.makeAdvancedRequest(Apiclient.CONFIRM_CONSULTATION.getURL(), Request.Method.POST, Apiclient.CONFIRM_CONSULTATION.getParams(), Arrays.asList(consultation_id, payment_status), null);

    }


    //----------------------------------------------------------------------------------------------

    /**
     * @func RESERVE_CONVERSATION
     */

    public void reserve_conversation(String doctor_id, String appointment_id) throws JSONException {

        apiRouter.makeAdvancedRequest(Apiclient.RESERVE_CONVERSATION.getURL(), Request.Method.POST, Apiclient.RESERVE_CONVERSATION.getParams(), Arrays.asList(doctor_id, appointment_id), null);

    }


    //----------------------------------------------------------------------------------------------

    /**
     * @func Confirm Conversation
     */

    public void confirm_conversation(final String consultation_id, final String payment_status) throws JSONException {
        apiRouter.makeAdvancedRequest(Apiclient.CONFIRM_CONVERSATION.getURL(), Request.Method.POST, Apiclient.CONFIRM_CONVERSATION.getParams(), Arrays.asList(consultation_id, payment_status), null);

    }


    //----------------------------------------------------------------------------------------------

    /**
     * @func FAQ
     */

    public void faq() throws JSONException {

        apiRouter.makeAdvancedRequest(Apiclient.FAQ.getURL(), Request.Method.GET, Apiclient.FAQ.getParams(), null, null);
    }


    //----------------------------------------------------------------------------------------------

    /**
     * @func GET MESSAGES
     */

    public void get_all_msg(final String consultation_id) throws JSONException {

        apiRouter.makeAdvancedRequest(Apiclient.GET_ALL_MSG.getURL(), Request.Method.POST, Apiclient.GET_ALL_MSG.getParams(), Arrays.asList(consultation_id), null);

    }


    //----------------------------------------------------------------------------------------------

    /**
     * @func Download Files
     */

    public void download_file(final String consultation_id) throws JSONException {
        apiRouter.makeAdvancedRequest(Apiclient.DOWNLOAD_REPORT.getURL(), Request.Method.POST, Apiclient.DOWNLOAD_REPORT.getParams(), Arrays.asList(consultation_id), null);
    }


    //----------------------------------------------------------------------------------------------


    /**
     * @func CONSULTATION_FILES
     */

    public void consultation_files(final String consultation_id) throws JSONException {

        apiRouter.makeAdvancedRequest(Apiclient.CONSULTATION_FILES.getURL(), Request.Method.POST, Apiclient.CONSULTATION_FILES.getParams(), Arrays.asList(consultation_id), null);

    }


    //----------------------------------------------------------------------------------------------

    /**
     * @func CHECK OUT
     */

    public void check_out(String amount) throws JSONException {

        apiRouter.makeAdvancedRequest(Apiclient.CHECK_OUT.getURL(), Request.Method.POST, Apiclient.CHECK_OUT.getParams(), Arrays.asList(amount), null);

    }


    //----------------------------------------------------------------------------------------------

    /**
     * @func Get Orders Data
     */

    public void Get_order_data() {


    }

    //----------------------------------------------------------------------------------------------

    /**
     * @func Submit Offer
     */

    public void Submit_Offer(final String star_id, final String order_id, final String expected_delivery_time, final String offer_value) {

        try {
            apiRouter.makeAdvancedRequest(Apiclient.SUBMIT_OFFER.getURL(), Request.Method.POST, Apiclient.SUBMIT_OFFER.getParams(), Arrays.asList(star_id, order_id, expected_delivery_time, offer_value), null);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    //----------------------------------------------------------------------------------------------

    /**
     * @func Get Offer Data
     */

    public void Get_myOrder() {


    }

    //----------------------------------------------------------------------------------------------

    /**
     * @func Set Rate
     */

    public void set_rate(String order_id, String rate, String note_id) {

        try {
            apiRouter.makeAdvancedRequest(Apiclient.SET_RATE.getURL(), Request.Method.POST, Apiclient.SET_RATE.getParams(), Arrays.asList(order_id, rate, note_id), null);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    //----------------------------------------------------------------------------------------------

    /**
     * @func Set Complaint
     */

    public void set_complaint(String order_id, String complaint_type_id, String complaint) {

//        try {
//            apiRouter.makeAdvancedRequest(Apiclient.SET_COMPLAINT.getURL(), Request.Method.POST,Apiclient.SET_COMPLAINT.getParams(),Arrays.asList(order_id,complaint_type_id,complaint),null);
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }

    }

    //----------------------------------------------------------------------------------------------

    /**
     * @func Cancel Order
     */

    public void cancel_order(String order_id) {


    }


    //----------------------------------------------------------------------------------------------

    /**
     * @func Get notifcation Data
     */

    public void Get_notifcation_data() {

    }

    //----------------------------------------------------------------------------------------------


    /**
     * @func Reject Offer
     */

    public void change_password(final String password, final String password_confirmation) {

        try {
            apiRouter.makeAdvancedRequest(Apiclient.CHANGE_PASS.getURL(), Request.Method.PATCH, Apiclient.CHANGE_PASS.getParams(), Arrays.asList(password, password_confirmation), null);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
    //----------------------------------------------------------------------------------------------

    /**
     * @func Reject Offer
     */

    public void add_phone(final String phone) {

        try {
            apiRouter.makeAdvancedRequest(Apiclient.ADD_PHONE.getURL(), Request.Method.PATCH, Apiclient.ADD_PHONE.getParams(), Collections.singletonList(phone), null);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
    //----------------------------------------------------------------------------------------------

    /**
     * @func Reject Offer
     */

    public void change_photo(final String image) {

        try {
            apiRouter.makeAdvancedRequest(Apiclient.CHANGE_PHOTO.getURL(), Request.Method.PATCH, Apiclient.CHANGE_PHOTO.getParams(), Collections.singletonList(image), null);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
    //----------------------------------------------------------------------------------------------

    /**
     * @func Get Offer Data
     */


    public void get_balance() {


    }


    //----------------------------------------------------------------------------------------------

    public void bill_amount(final String order_id, final String bill_amount) {

        try {
            apiRouter.makeAdvancedRequest(Apiclient.BILL_AMOUNT.getURL(), Request.Method.PATCH, Apiclient.BILL_AMOUNT.getParams(), Arrays.asList(order_id, bill_amount), null);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }


    //----------------------------------------------------------------------------------------------


    /**
     * @func GET PROMO CODE
     */

    public void promoCode(final String promo_code) {

        try {
            apiRouter.makeAdvancedRequest(Apiclient.ADD_PROMO_CODE.getURL(), Request.Method.POST, Apiclient.ADD_PROMO_CODE.getParams(), Arrays.asList(promo_code), null);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    //----------------------------------------------------------------------------------------------


}
