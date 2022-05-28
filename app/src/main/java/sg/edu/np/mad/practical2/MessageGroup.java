package sg.edu.np.mad.practical2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.app.FragmentManager;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.widget.FrameLayout;

public class MessageGroup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_group);

        Button groupButton = findViewById(R.id.button3);
        groupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                Group1Fragment fragment1 = Group1Fragment.newInstance("Group ","1");
                ft.replace(R.id.Frame, fragment1);
                ft.commit();
            }
        });
        Button group2Button = findViewById(R.id.button4);
        group2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft2 = getSupportFragmentManager().beginTransaction();
                Group2Fragment fragment2 = Group2Fragment.newInstance("Group ", "2");
                ft2.replace(R.id.Frame, fragment2);
                ft2.commit();
            }
        });
    }

}