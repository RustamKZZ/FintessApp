package com.hrv.fintessapp.fragments

import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.hrv.fintessapp.databinding.DayFinishFragmentBinding
import com.hrv.fintessapp.databinding.DaysListItemBinding
import com.hrv.fintessapp.databinding.WaitingFragmentBinding
import com.hrv.fintessapp.utils.FragmentManager
import com.hrv.fintessapp.utils.TimeUtils
import pl.droidsonroids.gif.GifDrawable


class DayFinishFragment : Fragment() {
    private lateinit var binding: DayFinishFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DayFinishFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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