# Undertow + and space character bug #
Usage: start with `./gradlew bootRun`

Run `curl http://localhost:8434/+/f%20oo` - the expected result will show that the `+` has been replaced by a space, as shown below

```
{
    "first" : " ",
    "second" : "f oo"
}
 ```

`curl http://localhost:8434/+/foo` or `curl http://localhost:8434/%2b/f%20oo` will not trigger the bug.

According to RFC 3986 section 3.3, a URL path can contain a `+`.

The bug seems to be related to code here: [URLUtils](https://github.com/undertow-io/undertow/blob/266b4c06f44ea54f7fec447cc40294cdfd0d35e2/core/src/main/java/io/undertow/util/URLUtils.java#L85)

We have found similar strange behaviour using other combinations, including umlaut characters.