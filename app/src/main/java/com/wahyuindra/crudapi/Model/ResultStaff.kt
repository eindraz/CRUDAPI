package com.wahyuindra.crudapi.Model

import com.google.gson.annotations.SerializedName
import com.wahyuindra.crudapi.Model.DataItem

data class ResultStaff (
    @field:SerializedName("pesan")
    val pesan: String? = null,
    @field:SerializedName("staff")
    val staff: List<DataItem>? = null,
    @field:SerializedName("status")
    val status: Int? = null
)