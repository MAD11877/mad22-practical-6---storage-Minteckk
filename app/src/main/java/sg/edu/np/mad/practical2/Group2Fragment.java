package sg.edu.np.mad.practical2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Group2Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Group2Fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String Fragment1;
    private String Fragment2;

    public Group2Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param group2frag1 Parameter 1.
     * @param group2frag2 Parameter 2.
     * @return A new instance of fragment Group2Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Group2Fragment newInstance(String group2frag1, String group2frag2) {
        Group2Fragment fragment = new Group2Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, group2frag1);
        args.putString(ARG_PARAM2, group2frag2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            Fragment1 = getArguments().getString(ARG_PARAM1);
            Fragment2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_group2, container, false);
    }
}