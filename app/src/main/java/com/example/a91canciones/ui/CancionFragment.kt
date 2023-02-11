package com.example.a91canciones.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.a91canciones.R
import com.example.a91canciones.database.Cancion
import com.example.a91canciones.databinding.FragmentCancionBinding
import com.example.a91canciones.viewmodel.CancionViewModel

class CancionFragment : Fragment() {
    lateinit var binding: FragmentCancionBinding

    val cancionViewModel:CancionViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= DataBindingUtil.inflate<FragmentCancionBinding>(inflater,
            R.layout.fragment_cancion,container,false)
        // Inflate the layout for this fragment
        return binding.root}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val cancionObserver=Observer<List<Cancion>>{
            updateDisplayText(it)
        }
        cancionViewModel.mAllSongs.observe(viewLifecycleOwner, cancionObserver)
        updateDisplayText(cancionViewModel.mAllSongs.value)

        binding.fab.setOnClickListener{
            findNavController().navigate(R.id.action_cancionFragment_to_addSongFragment)
        }


    }
    private fun updateDisplayText(canciones: List<Cancion>?) {
        var displayText = ""
        if (canciones != null) {
            for (cancion in canciones) {
                displayText += "${cancion.title}  ${cancion.artist} - ${cancion.album} - ${cancion.year}\n\n"       }
        }
        binding.canciones.text = displayText
    }
}