package com.example.assignments;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class AddStudent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_student);

        EditText nameEt = findViewById(R.id.edit_student_name_et);
        EditText idEt = findViewById(R.id.edit_student_id_et);
        CheckBox cb = findViewById(R.id.edit_student_cb);
        TextView cbTv = findViewById(R.id.edit_student_cb_tv);
        EditText phoneEt = findViewById(R.id.edit_student_phone_et);
        EditText addressEt = findViewById(R.id.edit_student_address_et);

        handleCBOnScreen(cb, cbTv);

        onCancel();
        onSave(nameEt, idEt, cb, phoneEt, addressEt);
    }

    public void onSave(EditText nameEt, EditText idEt, CheckBox cb, EditText phoneEt, EditText addressEt) {
        Button saveButton = findViewById(R.id.edit_student_save_btn);
        saveButton.setOnClickListener(View -> {

            Student newStudent = new Student(nameEt.getText().toString(),
                    idEt.getText().toString(), cb.isChecked(),
                    "", phoneEt.getText().toString(),
                    addressEt.getText().toString());

            Model.instance().addStudent(newStudent);
            moveToStudentListScreen();
        });
    }

    public void onCancel() {
        Button cancelButton = findViewById(R.id.edit_student_cancel_btn);
        cancelButton.setOnClickListener(View -> {
            moveToStudentListScreen();
        });
    }

    public void moveToStudentListScreen(){
        Intent editIntent = new Intent(AddStudent.this, StudentListActivity.class);
        startActivity(editIntent);
    }

    public void handleCBOnScreen(CheckBox cb, TextView cbTv) {
        if(cb.isChecked()) {
            cbTv.setText("checked");
        } else {
            cbTv.setText("unchecked");
        }

        cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
              @Override
              public void onCheckedChanged(
                      CompoundButton buttonView,
                      boolean isChecked) {
                  if(cb.isChecked()) {
                      cbTv.setText("checked");
                  } else {
                      cbTv.setText("unchecked");
                  }
              }
          }
        );
    }
}