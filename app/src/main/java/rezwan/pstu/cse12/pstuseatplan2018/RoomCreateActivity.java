package rezwan.pstu.cse12.pstuseatplan2018;

import android.app.Activity;
import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import rezwan.pstu.cse12.pstuseatplan2018.data.factory.AppDatabase;
import rezwan.pstu.cse12.pstuseatplan2018.model.Student;


public class RoomCreateActivity extends AppCompatActivity {

    private AppDatabase db;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "studentdb").build();

       // final EditText etID   = findViewById(R.id.et_id);
        final EditText etStartRoll   = findViewById(R.id.et_startRoll);
        final EditText etEndRoll   = findViewById(R.id.et_endRoll);
        final EditText etFloor   = findViewById(R.id.et_floor);
        final EditText etUnit   = findViewById(R.id.et_unit);
        final EditText etBuilding = findViewById(R.id.et_building);
        final EditText etHallNumber  = findViewById(R.id.et_hall_number);
        final EditText etRoomNumber   = findViewById(R.id.et_room_number);
        final EditText etRoomName   = findViewById(R.id.et_room_name);
        Button btSubmit = findViewById(R.id.bt_submit);
        Button home = findViewById(R.id.bt_home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RoomCreateActivity.this, MainActivity.class));
                finish();
            }
        });

        final Student student = (Student) getIntent().getSerializableExtra("data");

        if(student!=null){
            //etID.setText(student.getId());
            etStartRoll.setText(student.getStart_roll());
            etEndRoll.setText(student.getEnd_roll());
            etFloor.setText(student.getFloor());
            etUnit.setText(student.getUnit());
            etHallNumber.setText(student.getHall_number());
            btSubmit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //student.setId(etID.getText().toString());
                    student.setStart_roll(Integer.valueOf(etStartRoll.getText().toString()));
                    student.setEnd_roll(Integer.valueOf(etEndRoll.getText().toString()));
                    student.setFloor(etFloor.getText().toString());
                    student.setUnit(etUnit.getText().toString());
                    student.setBuilding(etBuilding.getText().toString());
                    student.setHall_number(etHallNumber.getText().toString());
                    student.setRoom_number(etRoomNumber.getText().toString());
                    student.setRoom_name(etRoomName.getText().toString());

                    updateStudent(student);
                }
            });
        }else{
            btSubmit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Student s = new Student();
                    //s.setId(etID.getText().toString());
                    s.setStart_roll(Integer.valueOf(etStartRoll.getText().toString()));
                    s.setEnd_roll(Integer.valueOf(etEndRoll.getText().toString()));
                    s.setFloor(etFloor.getText().toString());
                    s.setUnit(etUnit.getText().toString());
                    s.setBuilding(etBuilding.getText().toString());
                    s.setHall_number(etHallNumber.getText().toString());
                    s.setRoom_number(etRoomNumber.getText().toString());
                    s.setRoom_name(etRoomName.getText().toString());
                    insertData(s);
                }
            });
        }
    }

    private void updateStudent(final Student student){
        new AsyncTask<Void, Void, Long>(){
            @Override
            protected Long doInBackground(Void... voids) {
                long status = db.studentDAO().updateStudent(student);
                return status;
            }

            @Override
            protected void onPostExecute(Long status) {
                Toast.makeText(RoomCreateActivity.this, "status row "+status, Toast.LENGTH_SHORT).show();
            }
        }.execute();
    }

    private void insertData(final Student student){

        new AsyncTask<Void, Void, Long>(){
            @Override
            protected Long doInBackground(Void... voids) {
                long status = db.studentDAO().insertStudent(student);
                return status;
            }

            @Override
            protected void onPostExecute(Long status) {
                Toast.makeText(RoomCreateActivity.this, "status row "+status, Toast.LENGTH_SHORT).show();
            }
        }.execute();
    }

    public static Intent getActIntent(Activity activity) {
        // kode untuk pengambilan Intent
        return new Intent(activity, RoomCreateActivity.class);
    }
}
