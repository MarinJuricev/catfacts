package com.marinj.catfacts

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}