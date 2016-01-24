package com.developer.project.activities;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.widget.AppCompatRadioButton;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.developer.project.R;
import com.developer.project.base._Activity;
import com.developer.project.fragment.DatePickerFragment;
import com.developer.project.utils.Methods;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class RegisterActivity extends _Activity implements OnClickListener, AdapterView.OnItemClickListener {

    private EditText mEditTextFirstName = null;
    private EditText mEditTextLastName = null;
    private EditText mEditTextPassword = null;
    private EditText mEditTextConfirmPassword = null;
    private EditText mEditTextEmail = null;
    private EditText mEditTextUserName = null;
    private EditText edittext_authentication_code = null;

    private LinearLayout llDoctor = null;
    private LinearLayout llPatient = null;

    private String mDepartmentName = "";
    private String accountType = "";
    private int iCallWebservice = -1;
    private View registration_fields_layout;
    private ArrayAdapter<String> departmentDataAdapter;
    private Spinner spinner_dept;
    private static final int VALIDATE_TEACHER = 1;
    private static final int CREATE_ACCOUNT = 2;
    private Button btnAge;
    private RadioGroup radioGrp;
    private AppCompatRadioButton radioPatient, radioDoctor;
    private Spinner spinnerBloodGrp;
    private EditText edittext_MobileNo;
    private EditText edittext_alternateNo;
    private Spinner spinnerQualification;
    private EditText edittext_doctorMobileNo, edittext_hosbitalNo, edittext_hosbitalAddress;
    private Boolean isDoctor;
    private Button signup_btn;
    private String strUserName;
    private String strFirstName;
    private String strLastName;
    private String strPassword, strConfirmPassword;
    private String strDate = null;
    private String strEmail;
    private Spinner spinnerSex;
    private String strGender;
    private String strQualification;
    private String strDoctorMobileNo;
    private String strDoctorAlternateNo, strDoctorAddress;
    private String strBloodGrp;
    private String strPatientAlternateMobileNo;
    private String strPatientMobileNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);
        initViews();
    }

    private void initViews() {

        llDoctor = (LinearLayout) findViewById(R.id.llDoctor);
        llPatient = (LinearLayout) findViewById(R.id.llPatient);

        mEditTextFirstName = (EditText) findViewById(R.id.edittext_firstname);
        mEditTextLastName = (EditText) findViewById(R.id.edittext_lastname);
        mEditTextPassword = (EditText) findViewById(R.id.edittext_password);
        mEditTextConfirmPassword = (EditText) findViewById(R.id.edittext_confirm_password);

        mEditTextEmail = (EditText) findViewById(R.id.edittext_email_id);
        mEditTextUserName = (EditText) findViewById(R.id.edittext_username);
        btnAge = (Button) findViewById(R.id.btnAge);
        radioGrp = (RadioGroup) findViewById(R.id.radioGrp);
        radioPatient = (AppCompatRadioButton) findViewById(R.id.radioPatient);
        radioDoctor = (AppCompatRadioButton) findViewById(R.id.radioDoctor);
        spinnerBloodGrp = (Spinner) findViewById(R.id.spinnerBloodGrp);
        spinnerSex = (Spinner) findViewById(R.id.spinnerSex);

        edittext_MobileNo = (EditText) findViewById(R.id.edittext_MobileNo);
        edittext_alternateNo = (EditText) findViewById(R.id.edittext_alternateNo);

        spinnerQualification = (Spinner) findViewById(R.id.spinnerQualification);

        edittext_doctorMobileNo = (EditText) findViewById(R.id.edittext_doctorMobileNo);
        edittext_hosbitalNo = (EditText) findViewById(R.id.edittext_hosbitalNo);
        edittext_hosbitalAddress = (EditText) findViewById(R.id.edittext_hosbitalAddress);

        btnAge.setOnClickListener(this);

        spinnerSex.setOnItemClickListener(this);
        radioGrp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {


                switch (checkedId) {
                    case R.id.radioPatient:

                        llPatient.setVisibility(View.VISIBLE);
                        llDoctor.setVisibility(View.GONE);
                        isDoctor = false;
                        break;
                    case R.id.radioDoctor:

                        llPatient.setVisibility(View.GONE);
                        llDoctor.setVisibility(View.VISIBLE);
                        isDoctor = true;
                        break;
                }
            }
        });

        signup_btn = (Button) findViewById(R.id.signup_btn);

        signup_btn.setOnClickListener(this);

    }

    private void signUpDoctor() {

        if (validateFields() && validateDoctor()) {


        }
    }

    private void signUpPatient() {

        if (validateFields() && validatePatient()) {

        }
    }

    private boolean validatePatient() {

        if (spinnerBloodGrp.getSelectedItemPosition() == 0){

            smallToast("Select Blood Group");
            return false;
        } else if (Methods.validateEmptyString(edittext_MobileNo,"Enter Mobile no")){

            edittext_MobileNo.requestFocus();
            return false;
        }else if (Methods.validateEmptyString(edittext_alternateNo,"Enter Alternate Mobile no")){

            edittext_alternateNo.requestFocus();
            return false;
        } else {

            strBloodGrp = (String)spinnerBloodGrp.getSelectedItem();
            strPatientMobileNo = edittext_MobileNo.getText().toString().trim();
            strPatientAlternateMobileNo = edittext_alternateNo.getText().toString().trim();
            return  true;
        }
    }

    private boolean validateDoctor() {

        if (spinnerQualification.getSelectedItemPosition() == 0) {

            smallToast("Select you are qualification");
            return false;
        } else if (Methods.validateEmptyString(edittext_doctorMobileNo, "Enter Mobile No")) {

            edittext_doctorMobileNo.requestFocus();
            return false;
        } else if (Methods.validateEmptyString(edittext_hosbitalNo, "Enter Hospital Contact No")) {

            edittext_hosbitalNo.requestFocus();
            return false;
        } else if (Methods.validateEmptyString(edittext_hosbitalAddress, "Enter Hospital Address")) {

            edittext_hosbitalAddress.requestFocus();
            return false;
        } else {

            strQualification = (String) spinnerQualification.getSelectedItem();
            strDoctorMobileNo = edittext_doctorMobileNo.getText().toString().trim();
            strDoctorAlternateNo = edittext_hosbitalNo.getText().toString().trim();
            strDoctorAddress = edittext_hosbitalAddress.getText().toString().trim();

            return true;
        }

    }

    private boolean validateFields() {

        if (!Methods.validateEmptyString(mEditTextUserName, "Enter UserName")) {

            mEditTextUserName.requestFocus();
            return false;
        } else if (!Methods.validateEmptyString(mEditTextFirstName, "Enter First Name")) {

            mEditTextFirstName.requestFocus();
            return false;

        } else if (!Methods.validateEmptyString(mEditTextLastName, "Enter Last Name")) {

            mEditTextLastName.requestFocus();
            return false;

        } else if (!Methods.validateEmptyString(mEditTextPassword, "Enter Password")) {

            mEditTextPassword.requestFocus();
            return false;

        } else if (!(mEditTextPassword.getText().toString().trim()
                .equalsIgnoreCase(mEditTextConfirmPassword.getText().toString().trim()))) {
            mEditTextConfirmPassword.setError("Password doesn't match");
            mEditTextConfirmPassword.requestFocus();
            return false;

        } else if (!Methods.isValidEmail(mEditTextEmail, "Invalid Email")) {
            return false;

        } else if (strDate == null) {

            smallToast("Select Age");
            return false;
        } else if (spinnerSex.getSelectedItemPosition() == 0) {

            smallToast("Select Gender");
            return false;
        } else if (radioGrp.getCheckedRadioButtonId() == -1) {

            smallToast("Select you are patient or doctor");
            return false;
        } else {

            strUserName = mEditTextUserName.getText().toString().trim();
            strFirstName = mEditTextFirstName.getText().toString().trim();
            strLastName = mEditTextLastName.getText().toString().trim();
            strPassword = mEditTextPassword.getText().toString().trim();
            strConfirmPassword = mEditTextConfirmPassword.getText().toString().trim();
            strEmail = mEditTextEmail.getText().toString().trim();
            strGender = (String) spinnerSex.getSelectedItem();
            return true;
        }
    }

    private void callWebservice(int iType) {
        iCallWebservice = iType;
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.signup_btn:

                if (isDoctor) {

                    signUpDoctor();
                } else {

                    signUpPatient();
                }
                break;
            case R.id.btnAge:
                showDatePicker();
                break;
        }
    }

    private void showDatePicker() {

        DatePickerFragment date = new DatePickerFragment();
        /**
         * Set Up Current Date Into dialog
         */
        Calendar calender = Calendar.getInstance();
        Bundle args = new Bundle();
        args.putInt("year", calender.get(Calendar.YEAR));
        args.putInt("month", calender.get(Calendar.MONTH));
        args.putInt("day", calender.get(Calendar.DAY_OF_MONTH));
        date.setArguments(args);
        /**
         * Set Call back to capture selected date
         */
        date.setCallBack(ondate);
        date.show(getSupportFragmentManager(), "Date Picker");
    }

    DatePickerDialog.OnDateSetListener ondate = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {

            Date date = new Date(System.currentTimeMillis());
            Calendar calendar = Calendar.getInstance();
            calendar.set(year, monthOfYear, dayOfMonth);

            strDate = "" + getDiffYears(calendar.getTime(), date);
            btnAge.setText(strDate);

        }
    };

    public static int getDiffYears(Date first, Date last) {

        Calendar a = getCalendar(first);
        Calendar b = getCalendar(last);
        int diff = b.get(Calendar.YEAR) - a.get(Calendar.YEAR);
        if (a.get(Calendar.MONTH) > b.get(Calendar.MONTH)
                || (a.get(Calendar.MONTH) == b.get(Calendar.MONTH) && a
                .get(Calendar.DATE) > b.get(Calendar.DATE))) {
            diff--;
        }
        return diff;
    }

    public static Calendar getCalendar(Date date) {

        Calendar cal = Calendar.getInstance(Locale.US);
        cal.setTime(date);
        return cal;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Spinner spinner = (Spinner) parent;

        switch (spinner.getId()) {

            case R.id.spinnerSex:

                break;
            case R.id.spinnerBloodGrp:
                break;
            case R.id.spinnerQualification:
                break;
        }
    }
}