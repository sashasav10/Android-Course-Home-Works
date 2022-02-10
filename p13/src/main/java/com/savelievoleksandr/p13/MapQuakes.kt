package com.savelievoleksandr.p13

import com.savelievoleksandr.p13.model.Feature
import com.savelievoleksandr.p13.model.Geometry
import com.savelievoleksandr.p13.model.Properties
import com.savelievoleksandr.p13.model.Quakes


class MapQuakes(private val quakeDto: Quakes) {

    fun map(): Quakes {
        val features = quakeDto.features.map {
            val geometry = Geometry(
                it.geometry.coordinates,
                it.geometry.type
            )
            val properties = Properties(
                it.properties.depth,
                it.properties.locality,
                it.properties.magnitude,
                0, "", "",
                it.properties.time
            )
            Feature(
                geometry,
                properties,
                it.type
            )
        }
        return Quakes(features, quakeDto.type)
    }
}