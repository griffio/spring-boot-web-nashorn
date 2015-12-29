## Render React template from Nashorn

0.13.3 uses JSX Transformer, not compatible with 0.14.x

### Now in 4.2.0.RELEASE

[Jira SPR-12266](https://jira.spring.io/browse/SPR-12266)

[Spring Framework SPR-12266](https://github.com/sdeleuze/spring-framework/tree/SPR-12266)

Use jdk1.8.0_25 or jdk1.8.0_6x

Fails with jdk1.8.0_45

~~~
java.lang.ArrayIndexOutOfBoundsException: 9
	at java.lang.invoke.MethodHandleImpl$ArrayAccessor.getElementL(MethodHandleImpl.java:130)
~~~

### Spring Boot with ReactJs templates with Nashorn and Kotlin beta4 (1.0.0-beta-4583)

[Nashorn Extensions](https://wiki.openjdk.java.net/display/Nashorn/Nashorn+extensions) - allow map support

~~~javascript

global = {};
console = {};
console.debug = print;
console.warn = print;
console.log = print;
function render(template, model) {
    var data = {};
    for (var k in model) {
        if (model[k] instanceof Java.type("java.lang.Iterable")) {
             data[k] = Java.from(model[k]);
        } else {
            data[k] = model[k];
        }
    }
    var element = React.createElement(eval(template), data);
    return React.renderToStaticMarkup(element);
}

function renderJsx(template, model) {
    var jsTemplate = JSXTransformer.transform(template).code;
    return render(jsTemplate, model);
}

~~~

[Notes on Spring Boot](http://docs.spring.io/spring-boot/docs/current/reference/html/howto-spring-boot-application.html)

Test with JDK 

~~~
./gradlew test
~~~

Application

~~~
./gradlew run
~~~

Route

http://localhost:8080/about.html

Rendered from

https://github.com/griffio/spring-boot-web-nashorn/blob/master/src/main/resources/templates/about.jsx

==============

### Kotlin 1.0.0-beta-4583 (Intellij 15 or higher)

* Annotations now use @
* Property syntax support
* <ClassName>::class.java reference

basic gradle (2.5) build template for Java 8

Props
~~~
guava_version=18.0
junit_version=4.11
kotlin_version=1.0.0-beta-4583
jsr305_version=1.3.9
logback_version=1.1.2
slf4j_api_version=1.7.10
spring_boot_gradle_plugin_version=1.2.5.RELEASE
testng_version=6.8.21
truth_version=0.25
~~~
