# jsonbuilder for Kotlin

`jsonbuilder` is a small artifact that serves a single purpose: It allows to create json using an idiomatic [kotlin](https://kotlinlang.org/) builder DSL.

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

To get started simply add it as a dependency in your `build.gradle`:
```
compile "com.github.holgerbrandl:jsonbuilder:0.7"
```

Note: Until bintray has approved the inclusion into jcenter you'll need to add the following repo
```
maven { url "https://dl.bintray.com/holgerbrandl/github" }
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

Documentation
-------------

This `README.md`. Feel welcome to file tickets about missing pieces in the docs.


How to contribute?
------------------

Feel welcome to post ideas, suggestions and criticism to our [tracker](https://github.com/holgerbrandl/jsonbuilder/issues).

We always welcome pull requests. :-)

You could also show your spiritual support by just upvoting `jsonbuilder` here on github.



# References

* https://stackoverflow.com/questions/41861449/kotlin-dsl-for-creating-json-objects-without-creating-garbage
* https://github.com/SalomonBrys/Kotson
