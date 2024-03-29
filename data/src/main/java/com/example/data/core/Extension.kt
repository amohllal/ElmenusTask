package com.example.data.core

fun String?.splitTagsToList(): ArrayList<String> {
    val result = arrayListOf<String>()

    if (this.isNullOrBlank()) {
        return result
    }
    val parts = this.split(",").map { it.trim() }

    for (part in parts) {
        if (part.isNotBlank()) {
            result.add(part)
        }
    }

    return result
}