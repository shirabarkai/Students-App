package com.example.assignments;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class StudentDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);

        int rowPosition = getRowPosition();
        Student currStudent = Model.instance().getAllStudents().get(rowPosition);
        setCurrStudentDataOnScreen(currStudent);

        Button editButton = findViewById(R.id.edit_student_edit_btn);
        editButton.setOnClickListener(View -> {
            moveToEditStudentScreen(rowPosition);
        });
    }

    public int getRowPosition(){
        Intent intent = getIntent();
        return intent.getIntExtra("position", 0);
    }

    public void moveToEditStudentScreen(int rowPosition){
        Intent editIntent = new Intent(StudentDetails.this, EditStudent.class);
        editIntent.putExtra("position", rowPosition);
        startActivity(editIntent);
    }

    public void setCurrStudentDataOnScreen(Student currStudent){
        TextView nameTv = findViewById(R.id.studentdetails_name_tv);
        TextView idTv = findViewById(R.id.studentdetails_id_tv);
        TextView phoneTv = findViewById(R.id.studentdetails_phone_tv);
        TextView addressTv = findViewById(R.id.studentdetails_address_tv);

        nameTv.setText(currStudent.getName());
        idTv.setText(currStudent.getId());
        phoneTv.setText(currStudent.getPhone());
        addressTv.setText(currStudent.getAddress());
        handleCBOnScreen(currStudent);
    }

    public void handleCBOnScreen(Student currStudent){
        CheckBox cb = findViewById(R.id.edit_student_cb);
        TextView cbTv = findViewById(R.id.edit_student_cb_tv);

        cb.setChecked(currStudent.getCb());
        cb.setEnabled(false);

        if(cb.isChecked()) {
            cbTv.setText("checked");
        } else {
            cbTv.setText("unchecked");
        }
    }
}