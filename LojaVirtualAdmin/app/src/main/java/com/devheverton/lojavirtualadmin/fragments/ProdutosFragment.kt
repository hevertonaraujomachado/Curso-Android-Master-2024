package com.devheverton.lojavirtualadmin.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.devheverton.lojavirtualadmin.R
import com.devheverton.lojavirtualadmin.databinding.FragmentProdutosBinding


class ProdutosFragment : Fragment() {

    private lateinit var binding: FragmentProdutosBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        binding = FragmentProdutosBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}
