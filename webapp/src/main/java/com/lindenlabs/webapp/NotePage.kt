package com.lindenlabs.webapp

class NotePage(private val presenter: Presenter) : View {
    private val cardBuilder = CardBuilder()
    private val loader by lazy { document.getElementById("loader") as HTMLDivElement }
    private val content by lazy { document.getElementById("content") as HTMLDivElement }
    override fun showLoader() = loader.setVisible(true)
    override fun hideLoader() = loader.setVisible(false)

    fun show() {
        presenter.attach(this)
        initButtonListener(document.getElementById("add_new_book_btn") as HTMLButtonElement)
    }

    private fun initButtonListener(button: HTMLButtonElement) {
        button.addEventListener("click", {
            val fTitle = document.getElementById("fTitle") as HTMLInputElement
//            val fAuthor = document.getElementById("fAuthor") as HTMLInputElement
//            val fGenre = document.getElementById("fContent") as HTMLInputElement

            val title = fTitle.value.also { fTitle.value = "" }
//            val author = fAuthor.value.also { fAuthor.value = "" }
//            val genre = fGenre.value.also { fGenre.value = "" }

//            println("Submitting $title $author $genre")

            val book = Book(title, "free", "", "", "https://image.flaticon.com/icons/png/512/130/130304.png")
            appendBook(book)
        })
    }

    override fun showNotes(books: List<Note>) = notes.forEach(::appendBook)

    private fun appendBook(note: Note) {
        println(note.title)
        val card = cardBuilder.build(note)
        content.appendChild(card)
    }
}


private fun HTMLElement.setVisible(visible: Boolean) =
    if (visible) {
        this.style.visibility = "visible"
    } else {
        style.visibility = "hidden"
    }
