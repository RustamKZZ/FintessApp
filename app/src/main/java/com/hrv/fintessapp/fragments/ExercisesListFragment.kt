package com.hrv.fintessapp.fragments

import android.os.Bundle
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
import com.hrv.fintessapp.utils.MainViewModel


class ExercisesListFragment : Fragment() {
    private lateinit var binding: ExercisesListFragmentBinding
    private lateinit var adapter: ExerciseAdapter
    private val model: com.hrv.fintessapp.utils.MainViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        binding = ExercisesListFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        model.mutableListExercise.observe(viewLifecycleOwner){
            adapter.submitList(it)

        }

    }
    private fun init() = with (binding){
        adapter = ExerciseAdapter()
        rcView.layoutManager = LinearLayoutManager(activity)
        rcView.adapter = adapter
    }

    companion object {
        @JvmStatic
        fun newInstance() = ExercisesListFragment()
    }
}