package com.raywenderlich.listmaker

data class TaskList(val name: String,
                    val tasks: ArrayList<String> = ArrayList())