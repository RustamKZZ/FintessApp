package com.hrv.fintessapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.hrv.fintessapp.adapters.ExerciseModel
import com.hrv.fintessapp.databinding.ExerciseBinding
import pl.droidsonroids.gif.GifDrawable


class ExercisesFragment : Fragment() {
    private lateinit var binding: ExerciseBinding
    private var exerciseCounter = 0
    private var exList: ArrayList<ExerciseModel>? = null
    private val model: com.hrv.fintessapp.utils.MainViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ExerciseBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        model.mutableListExercise.observe(viewLifecycleOwner) {
            exList = it
            nextExercise()
        }
        binding.bNext.setOnClickListener {
            nextExercise()
        }

    }

    private fun nextExercise() {
        if (exerciseCounter < exList?.size!!) {
            val ex = exList?.get(exerciseCounter++)
            showExercise(ex)
        } else {
            Toast.makeText(activity, "Done", Toast.LENGTH_SHORT).show()

        }
    }

    private fun showExercise(exercise: ExerciseModel?) = with(binding) {
        if (exercise == null) return@with
        imMain.setImageDrawable(GifDrawable(root.context.assets, exercise.image))
        tvName.text = exercise.name

    }

    companion object {
        @JvmStatic
        fun newInstance() = ExercisesFragment()
    }
}