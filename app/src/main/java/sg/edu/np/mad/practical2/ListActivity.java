package sg.edu.np.mad.practical2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Random;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        /* for recyclerview in practical 4 */
        /*
        ArrayList<users> nameList = new ArrayList<>();

        for (int i = 0; i < 20; i++) {

            int num1 = random.nextInt();
            int num2 = random.nextInt();
            int num3 = random.nextInt();

            String name = "Name" + num1;
            String desc = "Description" + num2;
            Boolean follow = false;

            if (num3 == 1) {
                follow = true;
            }

            users user = new users(name, desc, i, follow);
            nameList.add(user);

*/
            SQLAdapter db = new SQLAdapter(this);

            ArrayList<users> data = db.getUsers();
            if(data.size()==0) {
                for (int a = 0; a < 20; a++) {
                    Random random = new Random();
                    int num1 = random.nextInt();
                    int num2 = random.nextInt();
                    users NewUser = new users("Name"+num1,"Description"+num2, a,false);
                    data.add(NewUser);
                }
                for(int b = 0; b < data.size(); b++) {
                    db.addNewUser(data.get(b));
                }
            }

            RecyclerView rv = findViewById(R.id.rv);
            NameAdapter adapter = new NameAdapter(data, ListActivity.this);
            LinearLayoutManager layout = new LinearLayoutManager(this);
            rv.setLayoutManager(layout);
            rv.setAdapter(adapter);

    }
}