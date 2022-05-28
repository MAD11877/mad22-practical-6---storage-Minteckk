package sg.edu.np.mad.practical2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;

import java.util.ArrayList;


public class SQLAdapter extends SQLiteOpenHelper {

    public static final String TABLE_USERS = "Users";
    public static final String COLUMN_NAME = "Name";
    public static final String COLUMN_DESCRIPTION = "Description";
    public static final String COLUMN_ID = "Id";
    public static final String COLUMN_FOLLOWED = "Followed";

    public SQLAdapter(Context context)
    {
        super(context, "users.db", null, 21);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE = "CREATE TABLE Users " + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "NAME TEXT," + "DESCRIPTION TEXT,"  + "FOLLOWED TEXT)";

        db.execSQL(CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        onCreate(db);
    }


    public void addNewUser(users user) {
        ContentValues values = insertUser(user);
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_USERS, null,values);
        db.close();

    }

    @NonNull
    private ContentValues insertUser(users user)
    {
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, user.getName());
        values.put(COLUMN_DESCRIPTION, user.getDesc());
        values.put(COLUMN_FOLLOWED, user.getFollowStatus());
        return values;
    }

    public ArrayList<users> getUsers()
    {
        ArrayList<users> user1 = new ArrayList<>();
        String query = "SELECT * FROM " + TABLE_USERS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        while(cursor.moveToNext())
        {
            users User = new users();
            User.Id = cursor.getInt(0);
            User.Name = cursor.getString(1);
            User.Description = cursor.getString(2);
            User.Followed = FollowStatusTF(cursor.getInt(3));
            user1.add(User);
        }
        return user1;
    }

    public void updateUser(users user) {
        Integer following = followStatus01(user.Followed);
        String UPDATE = "UPDATE USERS SET Followed = \"" + following + "\" WHERE ID = \"" + user.Id + "\"";
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(UPDATE);
        db.close();
    }

    public int followStatus01(Boolean f)
    {
        if(f == false)
        {
            return 0;
        }
        else {
            return 1;
        }
    }

    public boolean FollowStatusTF(Integer a)
    {
        if(a == 0)
        {
            return false;
        }
        else  {
            return true;
        }
    }
}
