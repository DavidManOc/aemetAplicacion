package com.example.aemetaplicacion.vistas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.aemetaplicacion.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Toast;

public class registroActivity extends AppCompatActivity {
    //-----------------------------------------
    private EditText edt_nombre;
    private EditText edt_apellidos;
    private EditText edt_municipio;
    private EditText edt_email;
    private EditText edt_password;
    //-----------------------------------------
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        FirebaseApp.initializeApp(this);

        mAuth = FirebaseAuth.getInstance();

        edt_nombre = (EditText) findViewById(R.id.edt_nombre_registro);
        edt_apellidos = (EditText) findViewById(R.id.edt_apellido_registro);
        edt_municipio = (EditText) findViewById(R.id.edt_municipio_registro);
        edt_email = (EditText) findViewById(R.id.edt_email_registro);
        edt_password = (EditText) findViewById(R.id.edt_password_registro);

    }
    //--------------------------
    public void onStart(){
        super.onStart();

        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            currentUser.reload();
        }
    }
    //--------------------------
    public void registrar(View view) {

        String nombreUsuario = String.valueOf(edt_nombre.getText());
        //------------------------
        String nombre = edt_nombre.getText().toString();
        String apellido = edt_apellidos.getText().toString();
        String municipio = edt_municipio.getText().toString();
        String email = edt_email.getText().toString();
        String pass = edt_password.getText().toString();
        //----------------------
        if (nombre.equals("")) {
            edt_nombre.setError("Debes escribir el nombre");
            return;
        }
        if (apellido.equals("")) {
            edt_apellidos.setError("Debes escribir el apellido");
            return;
        }
        if (municipio.equals("")) {
            edt_municipio.setError("Debes escribir el telefono");
            return;
        }
        if (email.equals("")) {
            edt_nombre.setError("Debes escribir el email");
            return;
        }
        if (pass.equals("")) {
            edt_nombre.setError("Debes escribir una contraseña");
            return;
        }
        if (pass.length() < 6){
            edt_password.setError("La contraseña debe contener más de 6 caracteres");
            return;
        }
        //---------------------------------------------
            mAuth.createUserWithEmailAndPassword(email, pass)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Log.i("firebasedb", "createUserWithEmail:success");
                                Toast.makeText(registroActivity.this, "Usuario creado correctamente", Toast.LENGTH_SHORT).show();
                                FirebaseUser user = mAuth.getCurrentUser();
                                edt_nombre.setText("");
                                edt_apellidos.setText("");
                                edt_municipio.setText("");
                                edt_email.setText("");
                                edt_password.setText("");
                            } else {
                                Log.i("firebasedb", "createUserWithEmail:failure", task.getException());
                                Toast.makeText(registroActivity.this, "Fallo al crear el usuario", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });



    }
//----------------------------------------------------------------------------
    public void registro_A_login(View view) {
        Intent intent = new Intent(this, loginActivity.class);
        startActivity(intent);
    }
}

