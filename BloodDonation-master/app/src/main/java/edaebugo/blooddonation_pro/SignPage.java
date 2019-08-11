package edaebugo.blooddonation_pro;

import android.app.Activity;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.google.android.material.chip.ChipGroup;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Random;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;

public class SignPage extends AppCompatActivity {

    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signpage);

        Spinner Spinner = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter Adapter = ArrayAdapter.createFromResource(this,
                R.array.blood, android.R.layout.simple_spinner_item);
        Spinner.setAdapter(Adapter);

        ChipGroup choiceChipGroup = findViewById(R.id.choice_chip_group);
        choiceChipGroup.setOnCheckedChangeListener(new ChipGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(ChipGroup chipGroup, @IdRes int i) {
                Log.i("ChipGroup","" + i);
            }
        });


        //데이터베이스에 데이터 입력
        /*
        UserData tmpUserdata = new UserData("a@a.com", "12345", "ASDF", "A", "01012345678");
        databaseReference.child("users").push().setValue(tmpUserdata);
        */
    }

    public static class UserData {
        private boolean isAdmin = false;
        private String id;
        private String email;
        private String password;
        private String name;
        private String bloodType;
        private String phoneNumber;

        public UserData() { }

        public UserData(String temail, String tpassword,String tname,String tbloodType,String tphoneNumber) {
            Random generator = new Random();
            isAdmin = false;
            id = "" + generator.nextInt() + generator.nextFloat(); // id를 만들어 보안적 요소  추가
            email = temail;
            password = tpassword;
            name = tname;
            bloodType = tbloodType;
            phoneNumber = tphoneNumber;
        }

        public boolean getAdmin() {
            return isAdmin;
        }

        public String getId() {
            return id;
        }

        public String getEmail() {
            return email;
        }

        public String getPassword() {
            return password;
        }

        public String getName() {
            return name;
        }

        public String getBloodType() {
            return bloodType;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }
    }
}
