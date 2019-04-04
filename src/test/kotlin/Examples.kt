import com.systema.analytics.es.misc.json

object JsonTester {

    @JvmStatic
    fun main(args: Array<String>) {
        val myJson = json {
            "size" to 0
            "aggs" to {
                "num_destinations" to {
                    "cardinality" to {
                        "field" to "DestCountry"
                    }
                }
            }
            "array" to arrayOf(1, 2, 3)
        }


        println("json is\n${myJson.toString(2)}")
    }
}


object JsonTester2 {
    @JvmStatic
    fun main(args: Array<String>) {
        val jsonObject =
                json {
                    "name" to "ilkin"
                    "age" to 37
                    "male" to true
                    "contact" to json {
                        "city" to "istanbul"
                        "email" to "xxx@yyy.com"
                    }
                }
        println(jsonObject)


    }
}