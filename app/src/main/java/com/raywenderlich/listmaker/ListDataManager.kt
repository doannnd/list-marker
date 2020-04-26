package com.raywenderlich.listmaker

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

class ListDataManager(private val context: Context) {

    fun saveList(list: TaskList) {
        // init shared preference
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
            .edit()

        sharedPreferences.putStringSet(list.name, list.tasks.toHashSet())

        sharedPreferences.apply()
    }

    fun readList() : ArrayList<TaskList> {
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
        val sharePreferenceContent = sharedPreferences.all

        val tasklists = ArrayList<TaskList>()

        for (taskList in sharePreferenceContent) {
            val itemHashSet = ArrayList(taskList.value as HashSet<String>)
            val list = TaskList(taskList.key, itemHashSet)

            tasklists.add(list)
        }

        return tasklists;
    }
}