package com.hrv.fintessapp.fragments

import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.hrv.fintessapp.R
import com.hrv.fintessapp.adapters.DayModel
import com.hrv.fintessapp.adapters.DaysAdapter
import com.hrv.fintessapp.adapters.ExerciseAdapter
import com.hrv.fintessapp.databinding.ExercisesListFragmentBinding
import com.hrv.fintessapp.databinding.FragmentDaysBinding
import com.hrv.fintessapp.databinding.WaitingFragmentBinding
import com.hrv.fintessapp.utils.MainViewModel
const val COUNT_DOWN_TIME = 11000L

class WaitingFragment : Fragment() {
    private lateinit var binding: WaitingFragmentBinding
    private lateinit var timer: CountDownTimer

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        binding = WaitingFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.pBar.max = COUNT_DOWN_TIME.toInt()

    }

    private fun StartTimer() = with (binding){
        timer = object: CountDownTimer(COUNT_DOWN_TIME, 100){
            override fun onTick(restTime: Long) {
                pBar.progress = restTime.toInt()
            }

            override fun onFinish() {
                TODO("Not yet implemented")
            }

        }.start()

    }

    override fun onDetach() {
        super.onDetach()
        timer.cancel()
    }

    companion object {
        @JvmStatic
        fun newInstance() = WaitingFragment()
    }
}