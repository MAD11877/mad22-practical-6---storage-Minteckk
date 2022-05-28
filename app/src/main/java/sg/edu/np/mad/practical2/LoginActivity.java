package sg.edu.np.mad.practical2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference userRef = database.getReference("Users");
        DatabaseReference madchild = userRef.child("mad").push();
        DatabaseReference userRef2 = database.getReference("mad");
        DatabaseReference madchild2 = userRef2.child("password:").push();
        madchild2.setValue(11887);
        DatabaseReference madchild3 = userRef2.child("username:").push();
        madchild3.setValue("mad");

        Button loginpress =  findViewById(R.id.login);
        loginpress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userRef.child("password: ").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Log.w("TAG", "Failed to read value.", error.toException());
                    }
                });
                userRef.child("username:").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        snapshot.getChildren();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Log.w("TAG", "Failed to read value.", error.toException());
                    }
                });
                EditText fb_username = findViewById(R.id.fb_username);
                EditText fb_password = findViewById(R.id.fb_password);
                Integer fb_pw = Integer.valueOf(fb_password.getText().toString());
                if(fb_pw == 11877)
                {
                    Intent LoginSuccess = new Intent(LoginActivity.this, ListActivity.class);
                    startActivity(LoginSuccess);
                }
                else {
                    Toast.makeText(LoginActivity.this,"Your username or password " +
                            "is invalid or incorrect.",Toast.LENGTH_SHORT).show();
                }
            }
        });
        }
    }
