interface IDictionary {

    companion object {
        const val FILE_NAME = "file_name.txt"
    }

    fun add(word:String) : Boolean
    fun find(word: String) : Boolean
    fun size(): Int
}