package com.devheverton.appdelivery;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.FirebaseNetworkException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;

import de.hdodenhof.circleimageview.CircleImageView;

public class Form_Cadastro extends AppCompatActivity {

    private CircleImageView fotUsuario;
    private Button bt_selecionarFoto, bt_Cadastrar;
    private EditText edit_nome, edit_email, edit_senha;
    private TextView txt_menssagemErro;

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

    }

    public void CadastrarUsuario(View view) {
        String email = edit_email.getText().toString();
        String senha = edit_senha.getText().toString();

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, senha).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()) {
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
                    }catch (FirebaseAuthInvalidCredentialsException e){
                     erro = "E-mail invalido!";
                    }catch (FirebaseAuthUserCollisionException e){
                        erro = "Esta conta já foi cadastrada!";
                    }catch (FirebaseNetworkException e){
                        erro = "Sem conexão com a internet!";

                    } catch (Exception e) {
                        erro = "Erro ao cadastrar o usuário!";
                    }
                    txt_menssagemErro.setText(erro);

                    }
                }
            });
        }
        public void IniciarComponentes () {
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