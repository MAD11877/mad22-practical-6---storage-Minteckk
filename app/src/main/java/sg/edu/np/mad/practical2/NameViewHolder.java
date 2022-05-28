package sg.edu.np.mad.practical2;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class NameViewHolder extends RecyclerView.ViewHolder {
    TextView name;
    TextView desc;
    ImageView profile;

    public NameViewHolder(View viewItem) {
        super(viewItem);
        name = viewItem.findViewById(R.id.username);
        desc = viewItem.findViewById(R.id.desc);
        profile = viewItem.findViewById(R.id.profile);
    }
}
