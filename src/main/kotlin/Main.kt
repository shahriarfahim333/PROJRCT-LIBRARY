class Book(val title: String, val author: String, val publicationYear: Int, var isBorrowed: Boolean = false)

class Library {
    private val books = mutableListOf<Book>()

    fun addBook(book: Book) {
        books.add(book)
    }

    fun displayBooks() {
        var isAvailable:Boolean = false
        for (book in books) {
            if (!book.isBorrowed) {
                println("${book.title} by ${book.author} (${book.publicationYear})")
                isAvailable = true
                break
            }
        }
        if (!isAvailable){
            println("Not Available book")
        }
    }

    fun searchByAuthor(author: String) {
        var isAvailable:Boolean = false
        for (book in books) {
            if (!book.isBorrowed && book.author == author) {
                println("${book.title} by ${book.author} (${book.publicationYear})")
                isAvailable = true
                break
            }
        }
        if (!isAvailable) {
            println("Not Available book")
        }

    }

    fun searchByYear(year: Int) {
        var isAvailable:Boolean = false
        for (book in books) {
            if (!book.isBorrowed && book.publicationYear == year) {
                println("${book.title} by ${book.author} (${book.publicationYear})")
                isAvailable = true
                break
            }

        }
        if (!isAvailable) {
            println("Not Available book")
        }
    }

    fun borrowBook(title: String) {
        for (book in books) {
            if (!book.isBorrowed && book.title == title) {
                book.isBorrowed = true
                println("You have successfully borrowed ${book.title}.")
                return
            }
        }
        println("Book not found or already borrowed.")
    }

    fun returnBook(title: String) {
        for (book in books) {
            if (book.title == title && book.isBorrowed) {
                book.isBorrowed = false
                println("You have successfully returned ${book.title}.")
                return
            }
        }
        println("Book not found or not borrowed.")
    }
}
fun main() {
    val library = Library()

    while (true) {
        println("\nLibrary System Menu:")
        println("1. Add Books")
        println("2. Display all books")
        println("3. Search by author")
        println("4. Search by publication year")
        println("5. Borrow a book")
        println("6. Return a book")
        println("0. Exit")

        print("Enter your choice: ")
        when (readlnOrNull()?.toIntOrNull()) {
            1 -> {
                print("Please Enter Books Title: ")
                val title = readLine() ?: ""
                print("Please Enter Books Author: ")
                val author = readLine() ?: ""
                print("Please Enter Books Published Year: ")
                val published_year = readLine() ?: ""
                library.addBook(Book(title,author,published_year.toInt()))
            }
            2 -> library.displayBooks()
            3 -> {
                print("Enter author's name: ")
                val author = readLine() ?: ""
                library.searchByAuthor(author)
            }
            4 -> {
                print("Enter publication year: ")
                val year = readLine()?.toIntOrNull() ?: 0
                library.searchByYear(year)
            }
            5 -> {
                print("Enter the title of the book you want to borrow: ")
                val titleToBorrow = readLine() ?: ""
                library.borrowBook(titleToBorrow)
            }
            6 -> {
                print("Enter the title of the book you want to return: ")
                val titleToReturn = readLine() ?: ""
                library.returnBook(titleToReturn)
            }
            0 -> {
                println("Exiting the Library System. Goodbye!")
                return
            }
            else -> println("Invalid choice. Please enter a valid option.")
        }
    }
}