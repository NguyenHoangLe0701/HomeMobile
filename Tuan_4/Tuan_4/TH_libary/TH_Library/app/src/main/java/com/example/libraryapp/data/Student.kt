package com.example.libraryapp.data

data class Student(
    val id: Int,
    val name: String,
    val borrowedBooks: List<Book> = emptyList()
)