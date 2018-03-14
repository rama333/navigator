package ru.rt.navigator.view;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.rt.navigator.R;
import ru.rt.navigator.presenter.FormPresenter;

/**
 * Created by ramil on 26.11.2017.
 */

public class FormActivity extends AppCompatActivity implements ViewForm {

    @BindView(R.id.to_text_input_layout1)
    TextInputLayout textFIO;
    @BindView(R.id.editText)
    EditText editTextFIO;

    @BindView(R.id.to_text_input_layout2)
    TextInputLayout textWork;
    @BindView(R.id.editText1)
    EditText editTextWork;

    @BindView(R.id.to_text_input_layout3)
    TextInputLayout textContactMobile;
    @BindView(R.id.editText2)
    EditText editTextContactMobile;

    @BindView(R.id.to_text_input_layout4)
    TextInputLayout TextEmail;
    @BindView(R.id.editText3)
    EditText editTextEmail;

    @BindView(R.id.to_text_input_layout5)
    TextInputLayout textFIOChild;
    @BindView(R.id.editText4)
    EditText editTextFIOChild;

    @BindView(R.id.to_text_input_layout6)
    TextInputLayout textDateBirth;
    @BindView(R.id.editText5)
    EditText editTextDateBirth;

    @BindView(R.id.to_text_input_layout8)
    TextInputLayout textEditCls;
    @BindView(R.id.editText7)
    EditText editTextCls;

    @BindView(R.id.to_text_input_layout7)
    TextInputLayout textAdress;
    @BindView(R.id.editText6)
    EditText editTextAdress;

    @BindView(R.id.button)
    Button button;

    FormPresenter formPresenter;
    String ProgramTitle;
    ProgressDialog progressDialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Идет запрос");
        progressDialog.setMessage("Пожалуйста подождите ..");
        progressDialog.setCancelable(false);


        ButterKnife.bind(FormActivity.this);
        ProgramTitle = getIntent().getStringExtra("TITLE");

        formPresenter = new FormPresenter(this);
        editTextFIO.addTextChangedListener(new MyTextWatcher((editTextFIO)));
        editTextWork.addTextChangedListener(new MyTextWatcher((editTextWork)));
        editTextContactMobile.addTextChangedListener(new MyTextWatcher((editTextContactMobile)));
        editTextEmail.addTextChangedListener(new MyTextWatcher((editTextEmail)));
        editTextFIOChild.addTextChangedListener(new MyTextWatcher((editTextFIOChild)));
        editTextDateBirth.addTextChangedListener(new MyTextWatcher((editTextDateBirth)));
        editTextCls.addTextChangedListener(new MyTextWatcher((editTextCls)));
        editTextAdress.addTextChangedListener(new MyTextWatcher((editTextAdress)));






        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                submitForm();

            }
        });


    }


    private void submitForm() {

        if (!validateFIO()) {
            return;
        }

        if (!validateWork()) {
            return;
        }

        if (!validateMobile()) {
            return;
        }

        if (!validateEmail()) {
            return;
        }

        if (!validateFIOChild()) {
            return;
        }

        if (!validatedateBirth()) {
            return;
        }

        if (!validatedateCls()) {
            return;
        }

        if (!validatedateAdress()) {
            return;
        }

        formPresenter.requestForm(editTextFIO.getText().toString(),
                editTextWork.getText().toString(),
                editTextContactMobile.getText().toString(),
                editTextEmail.getText().toString(),
                ProgramTitle,
                editTextFIOChild.getText().toString(),
                editTextDateBirth.getText().toString(),
                editTextCls.getText().toString(),
                editTextAdress.getText().toString(),
                "72");

    }


    private boolean validateFIO() {
        if (editTextFIO.getText().toString().trim().isEmpty()) {
            textFIO.setError(getString(R.string.err_msg_name));
            requestFocus(editTextFIO);
            return false;
        } else {
            textFIO.setErrorEnabled(false);

        }

        return true;
    }

    private boolean validateWork() {
        if (editTextWork.getText().toString().trim().isEmpty()) {
            textWork.setError(getString(R.string.err_msg_name));
            requestFocus(editTextFIO);
            return false;
        } else {
            textWork.setErrorEnabled(false);

        }

        return true;
    }

    private boolean validateMobile() {
        if (editTextContactMobile.getText().toString().trim().isEmpty()) {
            textContactMobile.setError(getString(R.string.err_msg_name));
            requestFocus(editTextContactMobile);
            return false;
        } else {
            textContactMobile.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateEmail() {
        String email = editTextEmail.getText().toString().trim();

        if (email.isEmpty() || !isValidEmail(email)) {
            TextEmail.setError("Введите корректный Email");
            requestFocus(editTextEmail);
            return false;
        } else {
            TextEmail.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateFIOChild() {
        if (editTextFIOChild.getText().toString().trim().isEmpty()) {
            textFIOChild.setError(getString(R.string.err_msg_name));
            requestFocus(editTextFIOChild);
            return false;
        } else {
            textFIOChild.setErrorEnabled(false);

        }

        return true;
    }

    private boolean validatedateBirth() {
        if (editTextDateBirth.getText().toString().trim().isEmpty()) {
            textDateBirth.setError(getString(R.string.err_msg_name));
            requestFocus(editTextDateBirth);
            return false;
        } else {
            textDateBirth.setErrorEnabled(false);

        }

        return true;
    }

    private boolean validatedateCls() {
        if (editTextCls.getText().toString().trim().isEmpty()) {
            textEditCls.setError(getString(R.string.err_msg_name));
            requestFocus(editTextCls);
            return false;
        } else {
            textEditCls.setErrorEnabled(false);

        }

        return true;
    }

    private boolean validatedateAdress() {
        if (editTextAdress.getText().toString().trim().isEmpty()) {
            textAdress.setError(getString(R.string.err_msg_name));
            requestFocus(editTextAdress);
            return false;
        } else {
            textAdress.setErrorEnabled(false);

        }

        return true;
    }


    private static boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void showStatusRequest(String text) {
        Toast.makeText(FormActivity.this, text, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showProgressDiaolog() {
        progressDialog.show();
    }

    @Override
    public void dismiss() {
        progressDialog.dismiss();
    }

    @Override
    public void ok() {
        this.finish();
    }

    private class MyTextWatcher implements TextWatcher {

        private View view;

        private MyTextWatcher(View view) {
            this.view = view;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void afterTextChanged(Editable editable) {
            switch (view.getId()) {
                case R.id.editText:
                    validateFIO();
                    break;
                case R.id.editText1:
                    validateWork();
                    break;
                case R.id.editText2:
                    validateMobile();
                    break;
                case R.id.editText3:
                    validateEmail();
                    break;
                case R.id.editText4:
                    validateFIOChild();
                    break;
                case R.id.editText5:
                    validatedateBirth();
                    break;
                case R.id.editText6:
                    validatedateAdress();
                    break;
                case R.id.editText7:
                    validatedateCls();
                    break;

            }
        }

    }
}
