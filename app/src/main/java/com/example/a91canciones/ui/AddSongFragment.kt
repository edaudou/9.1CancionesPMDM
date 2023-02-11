package com.example.a91canciones.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.a91canciones.R
import com.example.a91canciones.database.Cancion
import com.example.a91canciones.databinding.FragmentAddSongBinding
import com.example.a91canciones.viewmodel.CancionViewModel

class AddSongFragment : Fragment() {

    private lateinit var binding: FragmentAddSongBinding

    // get or instantiate viewmodel (shared between activity and fragments)
    val cancionViewModel: CancionViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentAddSongBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //set listener on new song
        binding.button.setOnClickListener{
            addSong()
        }

    }
    private fun addSong(){
        if (allFieldsFilled()) {
            val newSong: Cancion = Cancion(
                binding.title.text.toString(),
                binding.artist.text.toString(),
                binding.album.text.toString(),
                binding.year.text.toString().toInt()
            )
            cancionViewModel.insertCancion(newSong)
            findNavController().navigate(R.id.action_addSongFragment_to_cancionFragment)
        }else{
            Toast.makeText(requireContext(),R.string.fillAllFields,Toast.LENGTH_SHORT).show()
        }
    }
    private fun allFieldsFilled():Boolean=
        !(binding.title.text.isNullOrBlank() || binding.artist.text.isNullOrBlank() || binding.album.text.isNullOrBlank() || binding.year.text.isNullOrBlank())
}