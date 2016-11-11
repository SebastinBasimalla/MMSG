package com.company.sympo.mmsg;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import network.RestClient;

import static android.R.attr.typeface;
import static com.company.sympo.mmsg.R.id.toolbar;
import static com.company.sympo.mmsg.R.id.toolbarHomeText;

public class New_FeedBack extends Fragment{

    DataPassListener mCallBack;

    View view;
    private EditText input_name, input_email, input_mobile, input_subject, input_feedback;
    private TextInputLayout input_layout_fullname, input_layout_email, input_layout_mobile, input_layout_subject, input_layout_feedback;
    private Button btnSignUp;
    //Defining Variables
    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    TextView toolbarHomeText, scrollableview;
    AssetManager am;
    Typeface typeface;
    AppBarLayout  feedBackAppBarLayout;
    ProgressDialog progressDialog;


    public interface DataPassListener{

        public void passData(String data);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        // Make sure that container activity implement the callback interface
        try {
            mCallBack = (DataPassListener)context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement DataPassListener");
        }

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_new__feed_back, container, false);

       /* feedBackAppBarLayout =(AppBarLayout) view.findViewById(R.id.feedBackAppBarLayout);
        feedBackAppBarLayout.setVisibility(View.GONE);*/

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


        new SyncTask().execute(input_name.getText().toString(),input_email.getText().toString(),input_mobile.getText().toString(),input_subject.getText().toString(),input_feedback.getText().toString());

     //   Toast.makeText(getContext(), "Thank You!", Toast.LENGTH_SHORT).show();
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


    public JSONObject networkCall(String fullname,String email,String mobile,String subject,String comments) throws JSONException {

        RestClient client = new RestClient("http://smmsg.org/Beta");
        client.AddParam("action","addFeedback");
        client.AddParam("name", fullname);
        client.AddParam("mobile", mobile);
        client.AddParam("email", email);
        client.AddParam("subject", subject);
        client.AddParam("comments",comments);
       // client.AddHeader("GData-Version", "2");

        try {
            client.Execute(RestClient.RequestMethod.GET);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String response = client.getResponse();

        System.out.println("Response is "+response);

        JSONObject jsonObject = new JSONObject(response);
        String result = jsonObject.getString("result");
        String msg=jsonObject.getString("msg");


        System.out.println("Result is "+result+" msg "+msg);


        return jsonObject;
    }



    class SyncTask extends AsyncTask<String,String,JSONObject>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog=ProgressDialog.show(getActivity(),"","Loading...");

        }

        @Override
        protected void onPostExecute(JSONObject object) {
            super.onPostExecute(object);
             try {
                 String result = object.getString("result");
                 String msg = object.getString("msg");

                 if (result.equals("1")) {
                     Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();

                     //getActivity().getFragmentManager().popBackStackImmediate("MainActivity", 0);

                     progressDialog.dismiss();


                     home_content_fragment fragment = new home_content_fragment();
                     android.support.v4.app.FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                     fragmentTransaction.replace(R.id.frame, fragment);
                     fragmentTransaction.commit();

                     mCallBack.passData("Home");
                   //  getActivity().finish();




                 } else {

                     progressDialog.dismiss();
                     Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
                 }


             }
             catch(Exception e){}
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
        }


        @Override
        protected void onCancelled() {
            super.onCancelled();
        }

        @Override
        protected JSONObject doInBackground(String... params) {

          JSONObject jsonObject=null;
             try {
                 jsonObject= networkCall(params[0], params[1], params[2], params[3], params[4]);
             }
             catch (Exception e){}

            return jsonObject;
        }
    }



    /**
     * Used for setting header with font
     *
     * @param text
     */
   /* public void ToolBarTextInitilizer(String text) {

        toolbar = (Toolbar) findViewById(toolbar);
        //setSupportActionBar(toolbar);
        toolbarHomeText = (TextView) toolbar.findViewById(toolbarHomeText);
        am = getActivity().getApplicationContext().getAssets();
        //typeface= Typeface.createFromAsset(getAssets(),"PRISTINA.TTF");
        toolbarHomeText.setText(text);
        toolbarHomeText.setTypeface(typeface);

    }*/


}
