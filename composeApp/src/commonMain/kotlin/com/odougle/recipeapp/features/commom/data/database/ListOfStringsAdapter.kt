package com.odougle.recipeapp.features.commom.data.database

import app.cash.sqldelight.ColumnAdapter

val listOfStringsAdapter = object : ColumnAdapter<List<String>,String>{
    override fun decode(databaseValue: String): List<String> =
        if(databaseValue.isEmpty())
            listOf()
        else
            databaseValue.split(",")


    override fun encode(value: List<String>): String = value.joinToString(separator = ",")

}