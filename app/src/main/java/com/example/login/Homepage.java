package com.example.login;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Homepage#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Homepage extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private EditText first;
    private EditText second;
    private EditText third;
    private EditText fourth;
    private EditText fifth;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    public void addproject(){
        String firstt,secondd,thirdd,fourthh,fifthh;
        first=getView().findViewById(R.id.firstthingneed);
        second=getView().findViewById(R.id.secondthingneed);
        third=getView().findViewById(R.id.thirdthingdneed);
        fourth=getView().findViewById(R.id.fourthingneed);
        fifth=getView().findViewById(R.id.firstthingneed);

       firstt =first.getText().toString();
        secondd=second.getText().toString();
        thirdd =third.getText().toString();
        fifthh=fourth.getText().toString();
        fourthh =fourth.getText().toString();

       addlist project=new addlist(firstt,secondd,thirdd,fourthh,fifthh);
        adddatetofirstore(project);
    }
    private void adddatetofirstore(addlist project) {

        try{
            db.collection("projects")
                    .add(project).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {
                            Toast.makeText(getContext(), "DATA SAVED", Toast.LENGTH_SHORT).show();
                            //go to projects
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {

                            Toast.makeText(getContext(), "somthing failed", Toast.LENGTH_SHORT).show();
                            //try to save
                            Log.e("", e.getMessage());
                        }});}
        catch (Exception ex){

            Log.e("",ex.getMessage());
        }
    }



    public Homepage() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Homepage.
     */
    // TODO: Rename and change types and number of parameters
    public static Homepage newInstance(String param1, String param2) {
        Homepage fragment = new Homepage();
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
        return inflater.inflate(R.layout.fragment_homepage, container, false);
    }
}