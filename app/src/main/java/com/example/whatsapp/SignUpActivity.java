package com.example.whatsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.whatsapp.Models.User;
import com.example.whatsapp.databinding.ActivitySignUpBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class SignUpActivity extends AppCompatActivity {
   ActivitySignUpBinding binding;
     private FirebaseAuth auth;
     FirebaseDatabase database;
     ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //getSupportActionBar().hide();
        auth=FirebaseAuth.getInstance();// this is used to auth emil and password
        database=FirebaseDatabase.getInstance();// database ref is used to store the data from user
       progressDialog=new ProgressDialog(SignUpActivity.this);
       progressDialog.setTitle("creating Account ");
       progressDialog.setMessage("we are creating your Account");


        binding.btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.show();
                auth.createUserWithEmailAndPassword(binding.edtEmail.getText().toString(),
                        binding.edtPassword.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if (task.isSuccessful()){
                            User user=new User(binding.edtuserName.getText().toString(),
                                    binding.edtEmail.getText().toString(),
                                    binding.edtPassword.getText().toString());//here we use constructor that created for signup which use to store data in data base
                            String id= task.getResult().getUser().getUid();
                            database.getReference().child("User").child(id).setValue(user);
                            //this is id of user which is created
                            //task is our authentication task
                            //getResult is total result when user is created
                            //getUser is to get that specific user
                            //getUid is that user id

                            //here above user data is store in realtime database
                            //database.getReference gives the main node
                            // .child("User") created node that is child of main node
                            // which save id and the user=i.e data of above  user

                            Toast.makeText(SignUpActivity.this, "user created successfully", Toast.LENGTH_LONG).show();
                        }
                        else{
                            Toast.makeText(SignUpActivity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                });

            }
        });
    }}

