package com.example.util.simpletimetracker.feature_tag_selection.interactor

import com.example.util.simpletimetracker.core.interactor.RecordTagViewDataInteractor
import com.example.util.simpletimetracker.core.repo.ResourceRepo
import com.example.util.simpletimetracker.feature_base_adapter.ViewHolderType
import com.example.util.simpletimetracker.feature_base_adapter.hint.HintViewData
import com.example.util.simpletimetracker.feature_tag_selection.R
import javax.inject.Inject

class RecordTagSelectionViewDataInteractor @Inject constructor(
    private val resourceRepo: ResourceRepo,
    private val recordTagViewDataInteractor: RecordTagViewDataInteractor
) {

    suspend fun getViewData(typeId: Long, selectedTags: List<Long>): List<ViewHolderType> {
        val result: MutableList<ViewHolderType> = mutableListOf()

        resourceRepo.getString(R.string.record_tag_selection_hint)
            .let(::HintViewData).let(result::add)

        recordTagViewDataInteractor.getViewData(
            selectedTags = selectedTags,
            typeId = typeId
        ).let(result::addAll)

        return result
    }
}