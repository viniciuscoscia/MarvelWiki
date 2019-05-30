package com.vinicius.marvelwiki.models

class CharactersRequest (
    val code: Byte,
    val status: String,
    val copyright: String,
    val attributionText: String,
    val attributionHTML: String,
    val etag: String,
    val data: Data
)

class Data(
    val offset: Byte,
    val limit: Short,
    val total: Short,
    val count: Short,
    val results: List<Result>
)

class Result(
    val id: Int,
    val name: String,
    val description: String,
    val modified: String,
    val thumbnail: Thumbnail,
    val resourceURI: String,
    val comics: Content,
    val series: Content,
    val stories: Content,
    val events: Content,
    val urls: List<URL>
)

class Thumbnail(
    val path: String,
    val extension: String
)

class Content(
    val available: Short,
    val collectionURI: String,
    val items: List<Item>,
    val returned: Int
)

class Item(
    val resourceURI: String,
    val name: String
)

class URL(
    val type: String,
    val url: String
)