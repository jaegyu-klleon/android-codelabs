class Item

// token 요청하는 함수
fun requestToken(): String {
    return "token"
}

// api POST /post
fun createPost(token: String, item: Item): Response {
    return Response.Success
}

// 결과에 따라 POST post 처리
fun processPost(response: Response) {
    when (response) {
        is Response.Success -> {"success"}
        is Response.Failed -> {"fail"}
        is Response.Processing -> {"processing"}
    }

}

sealed class Response() {
    object Success: Response()
    object Failed: Response()
    object Processing: Response()
}

fun postItem(item: Item) {
    val token = requestToken()
    val post = createPost(token, item)
    processPost(post)
}

