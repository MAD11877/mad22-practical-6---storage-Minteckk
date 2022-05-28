package sg.edu.np.mad.practical2;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AlertDialog.Builder;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NameAdapter extends RecyclerView.Adapter<NameViewHolder> {
    ArrayList<users> data;
    Context context;
    ListActivity activity;

    public NameAdapter(ArrayList<users> data,Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public NameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = null;
        if(viewType == 0) {
            item = LayoutInflater.from(parent.getContext()).inflate(R.layout.name_list, null, false);
        }
        else {
            item = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_name_seven, null, false);
        }
        return new NameViewHolder(item);
    }


    @Override
    public int getItemViewType(int position) {
        String username = data.get(position).Name;
        if(Character.toString(username.charAt(username.length()-1)).equals("7")) {
            return 1;
        }
        else {
            return 0;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull NameViewHolder holder, int position) {
         String name = data.get(position).Name;
         holder.name.setText(name);
         String desc = data.get(position).Description;
         holder.desc.setText(desc);
         Boolean follow = data.get(position).Followed;

        holder.profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Builder builder = new Builder(context);
                builder.setTitle("Profile");
                builder.setCancelable(false);
                builder.setMessage(name);
                builder.setPositiveButton("View", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(context, MainActivity.class);

                        intent.putExtra("name", name);
                        intent.putExtra("Description", desc);
                        intent.putExtra("number", holder.getAdapterPosition());
                        intent.putExtra("Follow", follow);
                        context.startActivity(intent);
                    }
                });
                builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();

            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
