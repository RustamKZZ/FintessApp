package com.hrv.fintessapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.hrv.fintessapp.R
import com.hrv.fintessapp.databinding.DayFinishFragmentBinding
import com.hrv.fintessapp.utils.FragmentManager
import pl.droidsonroids.gif.GifDrawable


class DayFinishFragment : Fragment() {
    private lateinit var binding: DayFinishFragmentBinding
    private var ab: ActionBar? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DayFinishFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ab = (activity as AppCompatActivity).supportActionBar
        ab?.title = getString(R.string.done_ok)
        binding.imMain.setImageDrawable(GifDrawable((activity as AppCompatActivity).assets,
            "done.gif"))
        binding.bDone.setOnClickListener {
            FragmentManager.setFragment(DaysFragment.newInstance(),activity as AppCompatActivity)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = DayFinishFragment()
    }
}