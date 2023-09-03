package com.example.vidhi.ui.memeList

import com.example.vidhi.network.response.MemeData
import javax.inject.Inject

/**
 * Meme list usecase class
 *
 * @author Vidhi Dave
 */
class MemeListUseCase @Inject constructor(private val repository: MemeListRepository) {
    suspend operator fun invoke(): MemeData = repository.getAllMemes()
}