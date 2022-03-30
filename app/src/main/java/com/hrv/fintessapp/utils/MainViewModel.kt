package com.hrv.fintessapp.utils

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hrv.fintessapp.adapters.ExerciseModel


class MainViewModel: ViewModel() {
    val mutableListExercise = MutableLiveData<ArrayList<ExerciseModel>>()

}