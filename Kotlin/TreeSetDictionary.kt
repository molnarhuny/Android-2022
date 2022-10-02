import java.io.File
import java.util.TreeSet

object TreeSetDictionary : IDictionary {

    var words = TreeSet<String>();

    init {
        // IDictionary.FILE_NAME --> hivatkozas az interface egy tagjara
        File(IDictionary.FILE_NAME).forEachLine { add(it) }
    }

    override fun add(word: String): Boolean {
        if (!find(word)) {
            words.add(word)
            return true
        }
        return false
    }

    override fun find(word: String): Boolean {
        if (words.contains(word))
            return true;
        return false;

    }

    override fun size(): Int {
        return words.size;
    }
}