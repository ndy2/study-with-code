package hello.servlet.web.frontcontroller

class ModelView(
    val viewName: String,
) {
    val model = mutableMapOf<String, Any>()
}