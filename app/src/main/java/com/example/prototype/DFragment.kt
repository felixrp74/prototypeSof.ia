package com.example.prototype

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.prototype.databinding.FragmentDBinding


class DFragment : Fragment() {

    private var _binding: FragmentDBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentDBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        Glide.with(this).load(R.drawable.giphy).into(binding.gifImageView);

        val videoView = binding.videoView

        //Creating MediaController
        val mediaController = MediaController( view.context )
        mediaController.setAnchorView(videoView)

        //specify the location of media file
        val uri: Uri = Uri.parse("android.resource://com.example.prototype/"+R.raw.video)

        //Setting MediaController and URI, then starting the videoView
        videoView.setMediaController(mediaController)
        videoView.setVideoURI(uri)
        videoView.requestFocus()
        videoView.start()


    }

}