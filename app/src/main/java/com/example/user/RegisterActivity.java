package com.example.user;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {

    //private TextInputLayout textInputLayoutFirstname, textInputLayoutLastname, textInputLayoutEmail, textInputLayoutMobile,
            //textInputLayoutPassword;

    /*private TextInputLayout textInputLayoutLastname;
    private TextInputLayout textInputLayoutEmail;
    private TextInputLayout textInputLayoutMobile;
    private TextInputLayout textInputLayoutPassword;
    private TextInputLayout textInputLayoutConfirmPassword;
*/

    TextInputEditText username, firstName, lastName, email, mobile, password;
    Button register;

    /*private TextInputEditText editTextLastname;
    private TextInputEditText editTextEmail;
    private TextInputEditText editTextMobile;
    private TextInputEditText EditTextPassword;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        username = findViewById(R.id.editTextUsername);
        firstName = findViewById(R.id.editTextFirstName);
        lastName = findViewById(R.id.editTextLastName);
        email = findViewById(R.id.editTextEmail);
        mobile = findViewById(R.id.editTextMobile);
        password = findViewById(R.id.editTextPswd);


        register = findViewById(R.id.RegButton);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String txtuser = username.getText().toString();
                String txtfirst = firstName.getText().toString();
                String txtlast = lastName.getText().toString();
                String txtemail = email.getText().toString();
                String txtmobile = mobile.getText().toString();
                String txtpswd = password.getText().toString();
                if (TextUtils.isEmpty(txtuser) || TextUtils.isEmpty(txtfirst) | TextUtils.isEmpty(txtlast)
                    || TextUtils.isEmpty(txtemail) || TextUtils.isEmpty(txtmobile) || TextUtils.isEmpty(txtpswd))
                {
                    Toast.makeText(RegisterActivity.this, "All fields required", Toast.LENGTH_SHORT).show();
                }
                else{
                    registerNewUser(txtuser, txtfirst, txtlast, txtemail, txtmobile, txtpswd);
                    Toast.makeText(RegisterActivity.this, "Success", Toast.LENGTH_SHORT).show();

                }

            }
        });

    }

    public void registerNewUser (final String username, final String firstName, final String lastName, final String email, final String mobile, final String password ) {
        final ProgressDialog progressDialog = new ProgressDialog(RegisterActivity.this);
        progressDialog.setCancelable(false);
        progressDialog.setIndeterminate(false);
        progressDialog.setTitle("Register New User");
        progressDialog.show();
        String httpURL = "http://10.0.2.2/loginregister/register.php"; //emulator IPadd
        StringRequest request = new StringRequest(Request.Method.POST, httpURL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.equals("Successfully Registered")) {
                    progressDialog.dismiss();
                    Toast.makeText(RegisterActivity.this, response, Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(RegisterActivity.this, MainActivity.class));
                    finish();
                }
                else {
                    progressDialog.dismiss();
                    Toast.makeText(RegisterActivity.this, response, Toast.LENGTH_SHORT).show();
                }
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();
                Toast.makeText(RegisterActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
            }

        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> param = new HashMap<>();
                param.put("username", username);
                param.put("firstname", firstName);
                param.put("lastname", lastName);
                param.put("email", email);
                param.put("mobile", mobile);
                param.put("password", password);
                return param;
            }
        };
        request.setRetryPolicy(new DefaultRetryPolicy(3000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        SingletonClass.getInstance(RegisterActivity.this).addToRequestQueue(request);


        }

    }

/*$firstName = "Sajia";
$lastName = "Tas";
$email = "1716573@brunel.ac.uk";
$mobile = "080010";
$password = "test12345";*/