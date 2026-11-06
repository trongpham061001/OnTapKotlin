package com.example.androidapp

enum class BookCategory {
    TECHNOLOGY, SCIENCE, BUSINESS
}

data class Book(
    val title: String,
    val author: String,
    val category: BookCategory,
    val price: Int,
    val rating: Double,
    val isAvailable: Boolean
)

val Book.ratingCategory: String
    get() =  when{
        rating > 4.5 -> "Excellent"
        rating >= 3 && rating < 4.5 -> "Good"
        else -> "Average"
    }

fun Book.getBookInfo(): String{
    return "Title: $title, Author: $author, Category: $category, Price: $price, Rating: $rating, Available $isAvailable"
}

fun main(){
    val book1 = Book("Kotlin Programming", "John Smith", BookCategory.TECHNOLOGY, 250, 4.8, true)

    val book2 = Book("Android Development", "David Lee", BookCategory.TECHNOLOGY, 350, 4.2, true)

    val book3 = Book("Clean Code", "Robert Martin", BookCategory.TECHNOLOGY, 400, 4.9, false)

    val book4 = Book("A Brief History of Time", "Stephen Hawking", BookCategory.SCIENCE, 300, 4.7, true)

    val book5 = Book("The Selfish Gene", "Richard Dawkins", BookCategory.SCIENCE, 280, 4.3, false)

    val book6 = Book("Cosmos", "Carl Sagan", BookCategory.SCIENCE, 320, 3.8, true)

    val book7 = Book("Rich Dad Poor Dad", "Robert Kiyosaki", BookCategory.BUSINESS, 200, 4.1, true)

    val book8 = Book("Atomic Habits", "James Clear", BookCategory.BUSINESS, 180, 4.9, true)

    val book9 = Book("The Lean Startup", "Eric Ries", BookCategory.BUSINESS, 270, 3.2, false)

    val bookList = mutableListOf(
        book1, book2, book3,
        book4, book5, book6,
        book7, book8, book9
    )

    val goodBook = bookList.filter{
        it.rating >= 4 && it.isAvailable
    }

    println(goodBook)

    val groupBook = bookList.groupBy {
        it.category
    }

    groupBook.forEach { category, books ->
        println("Category: ${category}, Count: ${books.size}")
    }

    val titleBooks = bookList.map{
        it.title.uppercase()
    }
    println("Book Title")
    println("----------------------------------")
    titleBooks.forEach {
        println("Title: ${it}")
    }
    println("----------------------------------")

    val totalPrice = bookList.fold(0){ total, price ->
        total + price.price
    }

    println("Total Price: ${totalPrice}")

    val descRating = bookList.sortByDescending {
        it.rating
    }
    println("----------------------------------")
    println(descRating)
    println("----------------------------------")
}