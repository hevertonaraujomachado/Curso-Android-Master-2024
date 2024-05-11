package com.devheverton.lojavirtualadmin.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.devheverton.lojavirtualadmin.R
import com.devheverton.lojavirtualadmin.databinding.FragmentPedidosBinding


class PedidosFragment : Fragment() {

private lateinit var binding: FragmentPedidosBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentPedidosBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }


}
