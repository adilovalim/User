package com.example.user.model

data class Product(
    var id: String? = null,
    var productName: String? = null,
    var count: Int? = null,
    var price: Int? = 0,
    var productImage: String? = null
)