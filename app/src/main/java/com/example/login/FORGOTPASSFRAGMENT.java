package com.example.login;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FORGOTPASSFRAGMENT#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FORGOTPASSFRAGMENT extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private EditText etemail;
    private ImageButton email;
    private FirebaseAuth mAuth;

    private void instalize() {

        etemail = getView().findViewById(R.id.emailforgottext);
        email = getView().findViewById(R.id.sendemailbtn);

        mAuth = FirebaseAuth.getInstance();

        // if the user have acount //if he has no acount send toast and go to sign up
        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String emaill = etemail.getText().toString();
                if (emaill.trim().isEmpty()) {
                    Toast.makeText(getContext(), "SOMTHING FAILED ! " + "", Toast.LENGTH_SHORT).show();
                    return;}


                mAuth.sendPasswordResetEmail(emaill).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(getContext(), "Email Has send" + "", Toast.LENGTH_SHORT).show();
                        LOGINFRAFMENT LOGINFRAFMENT=new LOGINFRAFMENT();
                        FragmentManager manager=getFragmentManager();
                        manager.beginTransaction().replace(R.id.FRAME,LOGINFRAFMENT,LOGINFRAFMENT.getTag()).commit();
                    }
                });

            }


        });
    }


    public FORGOTPASSFRAGMENT() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FORGOTPASSFRAGMENT.
     */
    // TODO: Rename and change types and number of parameters
    public static FORGOTPASSFRAGMENT newInstance(String param1, String param2) {
        FORGOTPASSFRAGMENT fragment = new FORGOTPASSFRAGMENT();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_f_o_r_g_o_t_p_a_s_s_f_r_a_g_m_e_n_t, container, false);
    }
}