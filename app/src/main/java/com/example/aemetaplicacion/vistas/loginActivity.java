package com.example.aemetaplicacion.vistas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.aemetaplicacion.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class loginActivity extends AppCompatActivity {

    EditText edt_usuario_login = null;
    EditText edt_password_login = null;
    Button btn_iniciar_sesion = null;
    //--------------------------------------------
    ProgressBar pb_ejecutandose = null;
    int count = 0;
    //--------------------------------------------
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        FirebaseApp.initializeApp(this);

        mAuth = FirebaseAuth.getInstance();
        //-----------------------------------------
        edt_usuario_login = (EditText) findViewById(R.id.edt_usuario_login);
        edt_password_login = (EditText) findViewById(R.id.edt_password_login);
        btn_iniciar_sesion = (Button) findViewById(R.id.btn_iniciar_sesion);
        pb_ejecutandose = (ProgressBar) findViewById(R.id.pb_ejecutando);
        //--------------------------------------------------------------
        prog();

    }
    //------------METODO PARA PROGRESS BAR----------------
    public void prog(){
        final Timer t = new Timer();
        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                count++;
                pb_ejecutandose.setProgress(count);

                if(count == 100){
                    t.cancel();
                }
            }
        };

        t.schedule(tt,0, 100);

    }
    //----------------------------
    public void onStart(){
        super.onStart();

        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            currentUser.reload();
        }
    }
    //--------------------------
    boolean errores = false;
    public void iniciar_sesion_login(View view) {
        try {
            String email = String.valueOf(edt_usuario_login.getText());
            String password = String.valueOf(edt_password_login.getText());
            //------------------------------------
            //------------------------------------
            if (email.isEmpty()) {
                edt_usuario_login.setError("Debes introducir un usuario");
                return;
            }
            else if (password.isEmpty()) {
                edt_password_login.setError("Falta la contraseña");
                return;
            }
                //-----------------------------
                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (!task.isSuccessful()) {
                                    Log.i("firebasedb", "createUserWithEmail:failure", task.getException());
                                    Toast.makeText(loginActivity.this, "El usuario no existe, antes debe registrarse.", Toast.LENGTH_SHORT).show();
                                    return;

                                } else {
                                    Log.i("firebasedb", "createUserWithEmail:success");
                                    Toast.makeText(loginActivity.this, "Bienvenido.", Toast.LENGTH_SHORT).show();
                                    FirebaseUser user = mAuth.getCurrentUser();

                                    Intent intent = new Intent(loginActivity.this, pantallaUsuario.class);
                                    startActivity(intent);

                                    edt_usuario_login.setText("");
                                    edt_password_login.setText("");
                                }
                            }
                        });

                //-----------------------------

        }catch (IllegalStateException e){
            return;
        }
    }
    public void login_A_registro(View view) {
        Intent intent = new Intent(this, registroActivity.class);
        startActivity(intent);
    }

}