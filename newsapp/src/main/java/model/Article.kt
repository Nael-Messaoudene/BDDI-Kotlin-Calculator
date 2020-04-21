package model

data class Article(val title:String, val description:String, val author:String, val urlToImage:String, val content:String, val source:Source,val url:String )


// objet qui modelise une source
data class Source(val id: String, val name: String)

data class ArticleResult( val status:String, val totalResult:Int, val articles:List<Article>)