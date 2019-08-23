package com.globant.training.recyclerviewzba.adapters

import com.globant.training.recyclerviewzba.model.Item

interface AdapterEvents {
    fun onItemClicked(item: Item)
}