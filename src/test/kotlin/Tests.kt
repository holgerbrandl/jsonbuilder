import com.github.holgerbrandl.jsonbuilder.json
import io.kotest.matchers.shouldBe
import org.json.JSONArray
import org.junit.Ignore
import org.junit.Test


class BuilderTests {

    @Test
    @Ignore("blocked by https://github.com/stleary/JSON-java/issues/571")
    fun `it should preserver order`() {
        json {
            "name" to 1
            "type" to 1
            "queue" to 1
            "component" to 1
        }.toString(3).apply {
            println()
            toString() shouldBe """
                {
                   "name": 1,
                   "type": 1,
                   "queue": 1
                   "component": 1,
                }
            """.trimIndent()
        }
    }

    // https://github.com/holgerbrandl/jsonbuilder/issues/1
    @Test
    fun `it should support root arrays`() {
        JSONArray(listOf(
                json { "foo" to "bar" },
                json { "foo" to "bar" }
        )).println()
    }

}

internal fun Any.println() {
    println(toString())
}