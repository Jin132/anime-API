package com.example.animeapi.view

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.animeapi.databinding.FragmentAnimeDetailBinding
import com.example.animeapi.databinding.RatingDialogBinding
import com.example.animeapi.manager.AnimeManager
import com.example.animeapi.model.Anime
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AnimeDetailFragment : Fragment() {
    lateinit var anime : Anime
    lateinit var animeManager : AnimeManager
    private var _binding: FragmentAnimeDetailBinding? = null
    private val binding get() = _binding!!

    private var _dialogBinding: RatingDialogBinding? = null
    private val dialogBinding get() = _dialogBinding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        animeManager = AnimeManager(requireContext())
        _binding = FragmentAnimeDetailBinding.inflate(inflater, container, false)
        val view = binding.root

        _dialogBinding = RatingDialogBinding.inflate(inflater, container, false)

        binding.animeTitle.text = anime.character
        binding.decription.text = anime.quote
        binding.scoreField.text = anime.animes
        Glide
            .with(view)
            .load(anime.image_url)
            .into(binding.animeImage)

        val dialogView = dialogBinding.root
        val builder = AlertDialog.Builder(dialogView.context)
            .setView(dialogView)
            .setTitle("Оценить цитату")
        val alertDialog = builder.create()

        binding.buttonHeart.setOnClickListener{
            GlobalScope.launch(Dispatchers.IO) {
                withContext(Dispatchers.IO) {
                    animeManager.likeAnime(anime)
                }
            }
        }

        binding.buttonWatched.setOnClickListener{
            GlobalScope.launch(Dispatchers.IO) {
                withContext(Dispatchers.IO) {
                    animeManager.watchAnime(anime)
                }
            }
        }

        binding.buttonRate.setOnClickListener {
            alertDialog.show()

            dialogBinding.buttonRateConfirm.setOnClickListener {
                val rating = dialogBinding.ratingBar.rating.times(2)
                alertDialog.dismiss()
            }

            dialogBinding.buttonClose.setOnClickListener {
                alertDialog.dismiss()
            }
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        _dialogBinding = null
    }
}