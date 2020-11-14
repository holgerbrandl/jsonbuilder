package com.systema.analytics.es.misc

import org.json.JSONArray
import org.json.JSONObject
import java.util.*


//Source: https://stackoverflow.com/questions/41861449/kotlin-dsl-for-creating-json-objects-without-creating-garbage


fun json(build: JsonObjectBuilder.() -> Unit): JSONObject {
    return JsonObjectBuilder().json(build)
}

class JsonObjectBuilder {
    private val deque: Deque<JSONObject> = ArrayDeque()

    fun json(build: JsonObjectBuilder.() -> Unit): JSONObject {
        deque.push(JSONObject())
        this.build()
        return deque.pop()
    }

    infix fun <T> String.to(value: T) {
        // wrap value into json block if it is a lambda
        val wrapped = when (value) {
            is Function0<*> -> json { value.invoke() }
            is Array<*> -> JSONArray().apply { value.forEach { put(it) } }
            else -> value
        }

        deque.peek().put(this, wrapped)
    }

//    infix fun <T> String?.to(value: T) {
//        if (this == null) {
//            val wrapped = when (value) {
//                is Array<*> -> deque.peek().put(this, JSONArray().apply { value.forEach { put(it) } })
//                else -> TODO("not support. Please file an issue if you that this is an error of API")
//            }
//
//        } else {
//            // wrap value into json block if it is a lambda
//            val wrapped = when (value) {
//                is Function0<*> -> json { value.invoke() }
//                is Array<*> -> JSONArray().apply { value.forEach { put(it) } }
//                else -> value
//            }
//
//            deque.peek().put(this, wrapped)
//
//        }
//    }
}
