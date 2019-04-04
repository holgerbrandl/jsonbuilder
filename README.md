# jsonbuilder for Kotlin

jsonbuilder is a small artefcat that serves a single purpose. It allows to create json using an idiomatic kotlin builder.

## Example

```
val myJson = json {
        "size" to 0
        "array" to arrayOf(1,2,3)
        "aggs" to {
            "num_destinations" to {
                "cardinality" to {
                    "field" to "DestCountry"
                }
            }
        }
    }
```

which will result in the following json structure:
```
{
  "size": 0,
  "array": [
    1,
    2,
    3
  ],
  "aggs": {
    "num_destinations": {
      "cardinality": {
        "field": "DestCountry"
      }
    }
  }
}
```

Both arrays and nested elements are supported without additional functions/constructs.

Installation
------------

To get started simply add it as a dependency via Jcenter:
```
compile "com.github.holgerbrandl:jsonbuilder:0.5"
```

You can also use [JitPack with Maven or Gradle](https://jitpack.io/#holgerbrandl/jsonbuilder) to build the latest snapshot as a dependency in your project.

```groovy
repositories {
    maven { url 'https://jitpack.io' }
}
dependencies {
        compile 'com.github.holgerbrandl:krangl:-SNAPSHOT'
}
```

To build and install it into your local maven cache, simply clone the repo and run
```bash
./gradlew install
```

