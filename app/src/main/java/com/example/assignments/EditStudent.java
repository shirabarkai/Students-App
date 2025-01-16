package com.example.assignments;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class EditStudent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_student);


        int rowPosition = getRowPosition();
        Student currStudent = Model.instance().getAllStudents().get(rowPosition);

        EditText nameEt = findViewById(R.id.edit_student_name_et);
        EditText idEt = findViewById(R.id.edit_student_id_et);
        CheckBox cb = findViewById(R.id.edit_student_cb);
        EditText phoneEt = findViewById(R.id.edit_student_phone_et);
        EditText addressEt = findViewById(R.id.edit_student_address_et);

        handleCurrStudentDataOnScreen(currStudent, nameEt, idEt, cb, phoneEt, addressEt);

        onCancel();
        onDelete(currStudent);
        onSave(rowPosition, nameEt, idEt, cb, phoneEt, addressEt);
    }

    private void onSave(int rowPosition, EditText nameEt, EditText idEt, CheckBox cb, EditText phoneEt, EditText addressEt) {
        Button saveButton = findViewById(R.id.edit_student_save_btn);
        saveButton.setOnClickListener(View -> {

            Student newStudent = new Student(nameEt.getText().toString(),
                    idEt.getText().toString(), cb.isChecked(),
                    "", phoneEt.getText().toString(),
                    addressEt.getText().toString());

            Model.instance().updateStudentData(rowPosition, newStudent);

            moveToStudentListScreen();
        });
    }

    public void onCancel() {
        Button cancelButton = findViewById(R.id.edit_student_cancel_btn);
        cancelButton.setOnClickListener(View -> {
            moveToStudentListScreen();
        });
    }

    public void onDelete(Student currStudent) {
        Button deleteButton = findViewById(R.id.edit_student_delete_btn);
        deleteButton.setOnClickListener(View -> {
            Model.instance().removeStudent(currStudent);
            moveToStudentListScreen();
        });
    }

    public void moveToStudentListScreen(){
        Intent editIntent = new Intent(EditStudent.this, StudentListActivity.class);
        startActivity(editIntent);
    }

    public int getRowPosition(){
        Intent intent = getIntent();
        return intent.getIntExtra("position", 0);
    }

    public void handleCurrStudentDataOnScreen(Student currStudent, EditText nameEt, EditText idEt, CheckBox cb, EditText phoneEt, EditText addressEt) {
        nameEt.setText(currStudent.getName());
        idEt.setText(currStudent.getId());
        phoneEt.setText(currStudent.getPhone());
        addressEt.setText(currStudent.getAddress());

        handleCBOnScreen(currStudent, cb);
    }

    public void handleCBOnScreen(Student currStudent, CheckBox cb){
        TextView cbTv = findViewById(R.id.edit_student_cb_tv);

        cb.setChecked(currStudent.getCb());

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