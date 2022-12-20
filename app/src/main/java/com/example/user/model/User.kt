package com.example.user.model

import java.io.Serializable

data class User(
    var id: String? = null,
    var name: String? = null,
    var imgUser: String? = null,
    var phoneNumber: String? = null
): Serializable
