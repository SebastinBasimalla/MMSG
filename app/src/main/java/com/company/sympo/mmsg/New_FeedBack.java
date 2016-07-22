package com.company.sympo.mmsg;

import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class New_FeedBack extends Fragment {


    View view;
    private EditText input_name, input_email, input_mobile, input_subject, input_feedback;
    private TextInputLayout input_layout_fullname, input_layout_email, input_layout_mobile, input_layout_subject, input_layout_feedback;
    private Button btnSignUp;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_new__feed_back, container, false);

        input_layout_fullname = (TextInputLayout) view.findViewById(R.id.input_layout_fullname);
        input_name = (EditText) view.findViewById(R.id.input_name);

        input_layout_email = (TextInputLayout) view.findViewById(R.id.input_layout_email);
        input_email = (EditText) view.findViewById(R.id.input_email);


        input_layout_mobile = (TextInputLayout) view.findViewById(R.id.input_layout_mobile);
        input_mobile = (EditText) view.findViewById(R.id.input_mobile);

        input_layout_subject = (TextInputLayout) view.findViewById(R.id.input_layout_subject);
        input_subject = (EditText) view.findViewById(R.id.input_subject);

        input_layout_feedback = (TextInputLayout) view.findViewById(R.id.input_layout_feedback);
        input_feedback = (EditText) view.findViewById(R.id.input_feedback);


        btnSignUp = (Button) view.findViewById(R.id.btn_signup);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitForm();
            }
        });
        return view;
    }

    /**
     * Validating form
     */
    private void submitForm() {
        if (!validateName()) {
            return;
        }

        if (!validateEmail()) {
            return;
        }

        if (!validatePhone()) {
            return;
        }

        if (!validateSubject()) {
            return;
        }

        if (!validateFeedBackDescription()) {
            return;
        }

        Toast.makeText(getContext(), "Thank You!", Toast.LENGTH_SHORT).show();
    }

    /**
     * validate FullName
     * @return
     */
    private boolean validateName() {
        if (input_name.getText().toString().trim().isEmpty()) {
            input_layout_fullname.setError("Please enter Full Name");
            input_name.requestFocus();
            return false;
        } else {
            input_layout_fullname.setErrorEnabled(false);
        }

        return true;
    }

    /**
     * Validate Email Address
     *
     * @return
     */
    private boolean validateEmail() {
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(input_email.getText().toString()).matches()) {
            input_layout_email.setError("Please enter Email address");
            input_email.requestFocus();
            return false;
        } else {

            input_layout_email.setErrorEnabled(false);
        }

        return true;
    }

    /**
     *  validates Phone Number
     * @return
     */
    private boolean validatePhone() {
        if (!Patterns.PHONE.matcher(input_mobile.getText().toString()).matches()) {
            input_layout_mobile.setError("Please enter Contact number");
            input_mobile.requestFocus();
            return false;
        } else {

            input_layout_mobile.setErrorEnabled(false);
        }

        return true;
    }

    /**
     *
     * Validate Subject
     * @return
     */
    private boolean validateSubject() {
        if (input_subject.getText().toString().trim().isEmpty()) {
            input_layout_subject.setError("Please enter Subject");
            input_subject.requestFocus();
            return false;
        } else {

            input_layout_subject.setErrorEnabled(false);
        }

        return true;
    }

    /**
     * Validate FeedBack Description
     *
     * @return
     */
    private boolean validateFeedBackDescription() {
        if (input_feedback.getText().toString().trim().isEmpty()) {
            input_layout_feedback.setError("Please enter FeedBack");
            input_feedback.requestFocus();
            return false;
        } else {

            input_layout_feedback.setErrorEnabled(false);
        }

        return true;
    }

}
