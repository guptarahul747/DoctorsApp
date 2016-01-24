package com.developer.project.activities;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.widget.AppCompatRadioButton;
import android.view.View;
import android.view.View.OnClickListener;
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

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class RegisterActivity extends _Activity implements OnClickListener {

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
        edittext_MobileNo = (EditText) findViewById(R.id.edittext_MobileNo);
        edittext_alternateNo = (EditText) findViewById(R.id.edittext_alternateNo);

        spinnerQualification = (Spinner) findViewById(R.id.spinnerQualification);

        edittext_doctorMobileNo = (EditText) findViewById(R.id.edittext_doctorMobileNo);
        edittext_hosbitalNo = (EditText) findViewById(R.id.edittext_hosbitalNo);
        edittext_hosbitalAddress = (EditText) findViewById(R.id.edittext_hosbitalAddress);

        btnAge.setOnClickListener(this);

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

    }

    private void signUpPatient() {
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

            btnAge.setText("" + getDiffYears(calendar.getTime(), date));
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
}