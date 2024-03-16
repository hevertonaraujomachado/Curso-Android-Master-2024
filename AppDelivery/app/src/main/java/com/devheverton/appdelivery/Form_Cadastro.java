package com.devheverton.appdelivery;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.FirebaseNetworkException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.UUID;

import de.hdodenhof.circleimageview.CircleImageView;

public class Form_Cadastro extends AppCompatActivity {

    private CircleImageView fotUsuario;
    private Button bt_selecionarFoto, bt_Cadastrar;
    private EditText edit_nome, edit_email, edit_senha;
    private TextView txt_menssagemErro;

    private Uri mSelecionarUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_cadastro);
        //getSupportActionBar().hide();
        IniciarComponentes();
        edit_nome.addTextChangedListener(cadastroTextWatcher);
        edit_email.addTextChangedListener(cadastroTextWatcher);
        edit_senha.addTextChangedListener(cadastroTextWatcher);

        bt_Cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CadastrarUsuario(v);
            }
        });

        bt_selecionarFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SelecionarFotoGaleria();

            }

        });

    }

    public void CadastrarUsuario(View view) {
        String email = edit_email.getText().toString();
        String senha = edit_senha.getText().toString();

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, senha).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()) {
                    SalvarDadosUsuario();
                    Snackbar snackbar = Snackbar.make(view, "Cadastro realizado com sucesso!", Snackbar.LENGTH_INDEFINITE)
                            .setAction("OK", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    finish();
                                }
                            });
                    snackbar.show();
                } else {
                    String erro;

                    try {

                        throw task.getException();
                    } catch (FirebaseAuthWeakPasswordException e) {
                        erro = "Coloque uma senha com no minimo 6 caracteres!";
                    } catch (FirebaseAuthInvalidCredentialsException e) {
                        erro = "E-mail invalido!";
                    } catch (FirebaseAuthUserCollisionException e) {
                        erro = "Esta conta já foi cadastrada!";
                    } catch (FirebaseNetworkException e) {
                        erro = "Sem conexão com a internet!";

                    } catch (Exception e) {
                        erro = "Erro ao cadastrar o usuário!";
                    }
                    txt_menssagemErro.setText(erro);

                }
            }
        });
    }

    ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        mSelecionarUri = data.getData();

                        try {
                            fotUsuario.setImageURI(mSelecionarUri);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
    );

    public void SelecionarFotoGaleria() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        activityResultLauncher.launch(intent);


    }
    public void SalvarDadosUsuario(){

        String nomeArquivo = UUID.randomUUID().toString();

        final StorageReference reference = FirebaseStorage.getInstance().getReference("/imagens/" + nomeArquivo);
        reference.putFile(mSelecionarUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
reference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
    @Override
    public void onSuccess(Uri uri) {
        Log.i("url_img", uri.toString());
    }
}).addOnFailureListener(new OnFailureListener() {
    @Override
    public void onFailure(@NonNull Exception e) {

    }
});
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });
    }


    public void IniciarComponentes() {
        fotUsuario = findViewById(R.id.fotoUsuario);
        bt_selecionarFoto = findViewById(R.id.bt_selecionarFoto);
        bt_Cadastrar = findViewById(R.id.bt_Cadastrar);
        edit_nome = findViewById(R.id.edit_nome);
        edit_email = findViewById(R.id.edit_email);
        edit_senha = findViewById(R.id.edit_senha);
        txt_menssagemErro = findViewById(R.id.txt_mensagemErro);


    }

    TextWatcher cadastroTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String nome = edit_nome.getText().toString();
            String email = edit_email.getText().toString();
            String semha = edit_senha.getText().toString();

            if (!nome.isEmpty() && !email.isEmpty() && !semha.isEmpty()) {
                bt_Cadastrar.setEnabled(true);
                bt_Cadastrar.setBackgroundColor(getResources().getColor(R.color.dark_red));
            } else {
                bt_Cadastrar.setEnabled(false);
                bt_Cadastrar.setBackgroundColor(getResources().getColor(R.color.gray));
            }
        }


        @Override
        public void afterTextChanged(Editable s) {

        }

    };
}