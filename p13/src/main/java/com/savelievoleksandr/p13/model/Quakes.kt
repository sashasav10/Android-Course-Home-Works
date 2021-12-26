package com.savelievoleksandr.p13.model

import com.google.gson.annotations.SerializedName

data class Quakes(
    @SerializedName("features")
    val features: List<Feature>,
    @SerializedName("type")
    val type: String
)

data class Feature(
    @SerializedName("geometry")
    val geometry: Geometry,
    @SerializedName("properties")
    val properties: Properties,
    @SerializedName("type")
    val type: String
)

data class Geometry(
    @SerializedName("coordinates")
    val coordinates: List<Double>,
    @SerializedName("type")
    val type: String
)

data class Properties(
    @SerializedName("depth")
    val depth: Double,
    @SerializedName("locality")
    val locality: String,
    @SerializedName("magnitude")
    val magnitude: Double,
    @SerializedName("mmi")
    val mmi: Int,
    @SerializedName("publicID")
    val publicID: String,
    @SerializedName("quality")
    val quality: String,
    @SerializedName("time")
    val time: String
)