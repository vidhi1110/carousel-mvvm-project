package com.example.vidhi.ui.memeList.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.vidhi.network.response.MemeData
import com.example.vidhi.ui.base.BaseViewModel
import com.example.vidhi.ui.memeList.MemeListUseCase
import kotlinx.coroutines.launch

/**
 * Meme list viewmodel class
 *
 * @author Vidhi Dave
 */
class MemeListViewModel @ViewModelInject constructor(private val useCase: MemeListUseCase) :
    BaseViewModel() {

    var memeList = MutableLiveData<MemeData>()

    /**
     * Doing API call via usecase
     */
    fun getAllMemes() {
        viewModelScope.launch {
            memeList.value = useCase.invoke()
        }
    }
}