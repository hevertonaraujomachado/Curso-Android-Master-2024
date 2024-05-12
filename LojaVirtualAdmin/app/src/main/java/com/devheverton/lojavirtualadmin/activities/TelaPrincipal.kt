package com.devheverton.lojavirtualadmin.activities

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.devheverton.lojavirtualadmin.MainActivity
import com.devheverton.lojavirtualadmin.R
import com.devheverton.lojavirtualadmin.databinding.ActivityTelaPrincipalBinding
import com.devheverton.lojavirtualadmin.fragments.PedidosFragment
import com.devheverton.lojavirtualadmin.fragments.ProdutosFragment
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth

class TelaPrincipal : AppCompatActivity() {

    private lateinit var binding: ActivityTelaPrincipalBinding
    private var clicked = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTelaPrincipalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fragmentRender(R.id.containerFragmentProdutos,ProdutosFragment())



binding.btCadastroProdutos.setOnClickListener {
    val intente = Intent(this,CadastroProdutos::class.java)
    startActivity(intente)
}
        binding.btProdutos.setOnClickListener {
            clicked = true
            if (clicked){
                binding.btProdutos.setBackgroundResource(R.drawable.bg_button_enabled)
                binding.btProdutos.setTextColor(Color.WHITE)
                binding.btPedidos.setBackgroundResource(R.drawable.bg_button_disabled)
                binding.btPedidos.setTextColor(Color.BLACK)

                binding.containerFragmentProdutos.visibility = View.VISIBLE
                binding.containerFragmentPedidos.visibility =View.INVISIBLE
                fragmentRender(R.id.containerFragmentProdutos,ProdutosFragment())
            }
        }
        binding.btPedidos.setOnClickListener {
            clicked = true
            if (clicked){
                binding.btPedidos.setBackgroundResource(R.drawable.bg_button_enabled)
                binding.btPedidos.setTextColor(Color.WHITE)
                binding.btProdutos.setBackgroundResource(R.drawable.bg_button_disabled)
                binding.btProdutos.setTextColor(Color.BLACK)

             binding.containerFragmentProdutos.visibility = View.INVISIBLE
             binding.containerFragmentPedidos.visibility =View.VISIBLE
             fragmentRender(R.id.containerFragmentPedidos,PedidosFragment())

            }
        }

        binding.txtSair.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            val  intent  = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
            Toast.makeText(this," Usuário saiu da sessão!",Toast.LENGTH_SHORT).show()
        }
    }

    private fun fragmentRender(containerId: Int, fragment: Fragment){
        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransition: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransition.add(containerId, fragment)
        fragmentTransition.commit()

    }

}