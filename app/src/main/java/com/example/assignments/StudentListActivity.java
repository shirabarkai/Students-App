package com.example.assignments;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import java.util.List;

public class StudentListActivity extends AppCompatActivity {
    List<Student> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);

        data = Model.instance().getAllStudents();
        RecyclerView studentList = findViewById(R.id.studentlist_list);
        studentList.setHasFixedSize(true);

        studentList.setLayoutManager(new LinearLayoutManager(this));
        studentRecyclerAdapter adapter = new studentRecyclerAdapter();
        studentList.setAdapter(adapter);

        Button addStudentButton = findViewById(R.id.studentList_add_student_btn);
        addStudentButton.setOnClickListener(View -> {
            Intent editIntent = new Intent(StudentListActivity.this, AddStudent.class);
            startActivity(editIntent);
        });

        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int pos) {
                Intent intent = new Intent(StudentListActivity.this, StudentDetails.class);
                intent.putExtra("position", pos);
                startActivity(intent);
            }
        });


    }

    class StudentViewHolder extends RecyclerView.ViewHolder {
        TextView nameTv;
        TextView idTv;
        CheckBox cb;

        public StudentViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);
            nameTv = itemView.findViewById(R.id.studentlistrow_name_tv);
            idTv = itemView.findViewById(R.id.studentlistrow_id_tv);
            cb = itemView.findViewById(R.id.studentlistrow_cb);
            cb.setEnabled(false);

            cb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = (int)cb.getTag();
                    Student st = data.get(pos);
                    st.setCb(cb.isChecked());
                }
            });

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                   int pos = getAdapterPosition();
                   listener.onItemClick(pos);
                }
            });
        }

        public void bind(Student st, int pos) {
            nameTv.setText(st.getName());
            idTv.setText(st.getId());
            cb.setChecked(st.getCb());
            cb.setTag(pos);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int pos);
    }

    class studentRecyclerAdapter extends RecyclerView.Adapter<StudentViewHolder> {
        OnItemClickListener listener;

        void setOnItemClickListener(OnItemClickListener listener) {
            this.listener = listener;
        }


        @NonNull
        @Override
        public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = getLayoutInflater().inflate(R.layout.student_list_row,parent, false);
            return new StudentViewHolder(view, listener);
        }

        @Override
        public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
            Student st = data.get(position);
            holder.bind(st, position);
        }

        @Override
        public int getItemCount() {
            return data.size();
        }
    }
}