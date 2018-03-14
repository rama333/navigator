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
 * Created by ramil on 06.12.2017.
 */

public class FormEventActivity extends AppCompatActivity implements ViewForm {

    @BindView(R.id.to_text_input_layout2)
    TextInputLayout textNomination;
    @BindView(R.id.editText1)
    EditText editTextNomination;

    @BindView(R.id.to_text_input_layout5)
    TextInputLayout textFIOChild;
    @BindView(R.id.editText4)
    EditText editTextFIOChild;

    @BindView(R.id.to_text_input_layout6)
    TextInputLayout textDateBirth;
    @BindView(R.id.editText5)
    EditText editTextDateBirth;

    @BindView(R.id.to_text_input_layoutGroup)
    TextInputLayout textEditGroup;
    @BindView(R.id.editGroup)
    EditText editTextGroup;

    @BindView(R.id.to_text_input_layoutName)
    TextInputLayout textEducationalName;
    @BindView(R.id.editName)
    EditText editTextEducationalName;


    @BindView(R.id.to_text_input_layout3)
    TextInputLayout textContactMobile;
    @BindView(R.id.editText2)
    EditText editTextContactMobile;


    @BindView(R.id.to_text_input_layout4)
    TextInputLayout TextEmail;
    @BindView(R.id.editText3)
    EditText editTextEmail;


    @BindView(R.id.to_text_input_layoutFIOTutor)
    TextInputLayout textFIOTutor;
    @BindView(R.id.editTextTutor)
    EditText editTextFIOTutor;

    @BindView(R.id.to_text_input_layoutMobileTutor)
    TextInputLayout textContactMobileTutor;
    @BindView(R.id.editTextMobileTutor)
    EditText editTextContactMobileTutor;


    @BindView(R.id.button)
    Button button;

    FormPresenter formPresenter;
    String ProgramTitle;

    ProgressDialog progressDialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_form);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Идет запрос");
        progressDialog.setMessage("Пожалуйста подождите ..");
        progressDialog.setCancelable(false);

        ButterKnife.bind(FormEventActivity.this);
        ProgramTitle = getIntent().getStringExtra("TITLE");

        formPresenter = new FormPresenter(this);

        editTextContactMobile.addTextChangedListener(new MyTextWatcher((editTextContactMobile)));
        editTextEmail.addTextChangedListener(new MyTextWatcher((editTextEmail)));
        editTextFIOChild.addTextChangedListener(new MyTextWatcher((editTextFIOChild)));
        editTextDateBirth.addTextChangedListener(new MyTextWatcher((editTextDateBirth)));
        editTextNomination.addTextChangedListener(new MyTextWatcher((editTextNomination)));
        editTextGroup.addTextChangedListener(new MyTextWatcher((editTextGroup)));
        editTextEducationalName.addTextChangedListener(new MyTextWatcher((editTextEducationalName)));
        editTextFIOTutor.addTextChangedListener(new MyTextWatcher((editTextFIOTutor)));
        editTextContactMobileTutor.addTextChangedListener(new MyTextWatcher((editTextContactMobileTutor)));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                submitForm();

            }
        });


    }


    private void submitForm() {

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

        if (!validateNomination()) {
            return;
        }

        if (!validateGroup()) {
            return;
        }
        if (!validateEducational()) {
            return;
        }
        if (!validateFIOTutor()) {
            return;
        }

        if (!validateMobileTutor()) {
            return;
        }


        formPresenter.requestFormEvent(editTextFIOChild.getText().toString(),
                ProgramTitle,
                editTextNomination.getText().toString(),
                editTextDateBirth.getText().toString(),
                editTextEducationalName.getText().toString(),
                editTextContactMobile.getText().toString(),
                editTextEmail.getText().toString(),
                editTextFIOTutor.getText().toString(),
                editTextContactMobileTutor.getText().toString());

    }

    private boolean validateNomination() {
        if (editTextNomination.getText().toString().trim().isEmpty()) {
            textNomination.setError(getString(R.string.err_msg_name));
            requestFocus(editTextNomination);
            return false;
        } else {
            textNomination.setErrorEnabled(false);

        }

        return true;
    }

    private boolean validateGroup() {
        if (editTextGroup.getText().toString().trim().isEmpty()) {
            textEditGroup.setError(getString(R.string.err_msg_name));
            requestFocus(editTextGroup);
            return false;
        } else {
            textEditGroup.setErrorEnabled(false);

        }

        return true;
    }

    private boolean validateEducational() {
        if (editTextEducationalName.getText().toString().trim().isEmpty()) {
            textEducationalName.setError(getString(R.string.err_msg_name));
            requestFocus(editTextEducationalName);
            return false;
        } else {
            textEducationalName.setErrorEnabled(false);

        }

        return true;
    }

    private boolean validateFIOTutor() {
        if (editTextFIOTutor.getText().toString().trim().isEmpty()) {
            textFIOTutor.setError(getString(R.string.err_msg_name));
            requestFocus(editTextFIOTutor);
            return false;
        } else {
            textFIOTutor.setErrorEnabled(false);

        }

        return true;
    }

    private boolean validateMobileTutor() {
        if (editTextContactMobileTutor.getText().toString().trim().isEmpty()) {
            textContactMobileTutor.setError(getString(R.string.err_msg_name));
            requestFocus(editTextContactMobileTutor);
            return false;
        } else {
            textContactMobileTutor.setErrorEnabled(false);
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
        Toast.makeText(FormEventActivity.this, text, Toast.LENGTH_LONG).show();
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
                case R.id.editText1:
                    validateNomination();
                    break;
                case R.id.editText4:
                    validateFIOChild();
                    break;
                case R.id.editText5:
                    validatedateBirth();
                    break;
                case R.id.editText2:
                    validateMobile();
                    break;
                case R.id.editGroup:
                    validateGroup();
                    break;
                case R.id.editName:
                    validateEducational();
                    break;
                case R.id.editText3:
                    validateEmail();
                    break;
                case R.id.editTextTutor:
                    validateFIOTutor();
                    break;
                case R.id.editTextMobileTutor:
                    validateMobileTutor();
                    break;

            }
        }

    }
}
