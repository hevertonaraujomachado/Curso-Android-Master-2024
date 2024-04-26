package com.devheverton.agendadecontatos

import android.os.Bundle
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity
import com.devheverton.agendadecontatos.dao.UsuarioDao
import com.devheverton.agendadecontatos.databinding.ActivityAtualizarBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class Atualizar : AppCompatActivity() {

    private lateinit var binding: ActivityAtualizarBinding
    private lateinit var usuarioDao: UsuarioDao
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAtualizarBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val nomeRecuperado = intent.extras?.getString("nome")
        val sobrennomeRecuperado = intent.extras?.getString("sobrenome")
        val idadeRecuperado = intent.extras?.getString("idade")
        val celularRecuperado = intent.extras?.getString("celular")
        val uid = intent.extras!!.getInt("uid")

        binding.editNome.setText(nomeRecuperado)
        binding.editSobrenome.setText(sobrennomeRecuperado)
        binding.editIdade.setText(idadeRecuperado)
        binding.editCelular.setText(celularRecuperado)


        binding.btAtualizar.setOnClickListener {

            CoroutineScope(Dispatchers.IO).launch {
                val nome = binding.editNome.text.toString()
                val sobrenome = binding.editSobrenome.text.toString()
                val idade = binding.editIdade.text.toString()
                val celular = binding.editCelular.text.toString()
                val mensagem: Boolean

                if (nome.isEmpty() || sobrenome.isEmpty() || idade.isEmpty() || celular.isEmpty()) {
                    mensagem = false
                } else {
                    mensagem = true
                    atualizarContato(uid,nome,sobrenome, idade, celular)


                }
                withContext(Dispatchers.Main){
                    if (mensagem){
                        Toast.makeText(this@Atualizar,"Sucesso ao atualizar o usuário",Toast.LENGTH_SHORT).show()
                        finish()
                    }else{
                        Toast.makeText(this@Atualizar,"Preencha todos os campos!",Toast.LENGTH_SHORT).show()
                    }
                }


            }

        }




    }

    private fun atualizarContato(uid: Int, nome:String, sobrenome:String, idade: String, celular:String) {
        usuarioDao = AppDatabase.getInstance(this).usuarioDao()
        usuarioDao.atualizar(uid,nome,sobrenome,idade,celular)
    }
}