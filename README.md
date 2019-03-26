ktx
=====================
[![Release][jitpack-svg]][jitpack-link]
[![License][license-svg]][license-link]

Kotlin extension functions that complement Google's ktx library.

## Features

### ListLiveData 
Notifies observers each time the list is updated:
```kotlin
val listLiveData: ListLiveData<String> = listLiveDataOf()
```

### Collection.replaceWith() and Map.replaceWith()
Replaces a list or maps contents with the contents of another list or map:
```kotlin
val list = mutableListOf<String>("test")
val newList = listOf("new","items","in","list")
list.replaceWith(newList)
```

### Collection.contains { }
Returns true if an element matches the expression within { }:
```kotlin
list.contains { it.startsWith("t") }
```

### enumSafeValueOf()
Returns the enum entry with the specified name, returning null if nothing matches:
```kotlin
enum class DAY { MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY }
enumSafeValueOf<DAY>("TUESDAY") // REturns DAY.TUESDAY
enumSafeValueOf<DAY>("NOTADAY") // Returns null
```

### Map.filterNotNullValues()
Removes all entries with null values
```kotlin
map.filterNotNullValues()
```

### Menu.filter { }
Removes all menu items that do not match the expression with { }:
```kotlin
menu.filter { it.isChecked }
```

### String extensions
```kotlin
fun String.removeSymbols() // removes non-ASCII symbols and replaces with � (or user specified symbol)
fun String.containsAny(vararg strings: String)
fun String.capitalizeWords()
fun String.camelCaseWords()
fun String.trimTo(length: Int)
fun List<String>.containsCaseInsensitive(string: String)
fun List<String>.indexCaseInsensitive(string: String)
```

### Lazy view bindings
Note: If the view is recreated, these will point to an old reference. Thus, I do not recommend using these extensions for most situations.
```kotlin
val recyclerView by bind<RecyclerView>(R.id.recycler_view)
```


## How to use

1) Add the Jitpack repository to your project:
```groovy
          repositories {
              maven { url "https://jitpack.io" }
          }
```
2) Add a dependency on the library:
```groovy
          implementation 'com.github.percula:ktx:LATEST-VERSION'
```

[jitpack-svg]: https://jitpack.io/v/percula/ktx.svg
[jitpack-link]: https://jitpack.io/#percula/ktx
[license-svg]: https://img.shields.io/:license-mit-blue.svg?style=flat
[license-link]: https://github.com/percula/ktx/blob/master/LICENSE
