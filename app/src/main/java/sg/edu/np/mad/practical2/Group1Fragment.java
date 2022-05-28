package sg.edu.np.mad.practical2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Group1Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Group1Fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "Group1";
    private static final String ARG_PARAM2 = "Group2";

    // TODO: Rename and change types of parameters
    private String group1;
    private String group2;

    public Group1Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param group1frag Parameter 1.
     * @param group2frag Parameter 2.
     * @return A new instance of fragment Group1Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Group1Fragment newInstance(String group1frag, String group2frag) {
        Group1Fragment fragment = new Group1Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, group1frag);
        args.putString(ARG_PARAM2, group2frag);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            group1 = getArguments().getString(ARG_PARAM1);
            group2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_group1, container, false);
    }
}