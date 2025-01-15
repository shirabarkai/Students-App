package com.example.assignments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.TextView;

public class StudentDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);

        Intent intent = getIntent();
        int rowPosition = intent.getIntExtra("position", 0);
        Student currStudent = Model.instance().getAllStudents().get(rowPosition);

        TextView nameTv = findViewById(R.id.studentdetails_name_tv);
        TextView idTv = findViewById(R.id.studentdetails_id_tv);
        CheckBox cb = findViewById(R.id.studentdetails_cb);
        TextView cbTv = findViewById(R.id.studentdetails_cb_tv);
        TextView phoneTv = findViewById(R.id.studentdetails_phone_tv);
        TextView addressTv = findViewById(R.id.studentdetails_address_tv);

        nameTv.setText(currStudent.getName());
        idTv.setText(currStudent.getId());
        cb.setChecked(currStudent.getCb());
        phoneTv.setText(currStudent.getPhone());
        addressTv.setText(currStudent.getAddress());

        if(cb.isChecked()) {
            cbTv.setText("checked");
        } else {
            cbTv.setText("unchecked");
        }
    }
}