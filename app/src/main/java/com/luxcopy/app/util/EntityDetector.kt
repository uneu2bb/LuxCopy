package com.luxcopy.app.util

import android.util.Patterns
import java.util.regex.Pattern

/**
 * Smart detection of useful entities inside text.
 */
object EntityDetector {

    data class Entity(
        val type: Type,
        val value: String,
        val start: Int,
        val end: Int
    ) {
        enum class Type {
            EMAIL, PHONE, URL, HASHTAG, MENTION, ADDRESS
        }
    }

    private val hashtagPattern = Pattern.compile("#\\w+")
    private val mentionPattern = Pattern.compile("@\\w+")

    fun detect(text: String): List<Entity> {
        val results = mutableListOf<Entity>()

        // Emails
        val emailMatcher = Patterns.EMAIL_ADDRESS.matcher(text)
        while (emailMatcher.find()) {
            results.add(Entity(Entity.Type.EMAIL, emailMatcher.group(), emailMatcher.start(), emailMatcher.end()))
        }

        // Phones
        val phoneMatcher = Patterns.PHONE.matcher(text)
        while (phoneMatcher.find()) {
            results.add(Entity(Entity.Type.PHONE, phoneMatcher.group(), phoneMatcher.start(), phoneMatcher.end()))
        }

        // URLs
        val urlMatcher = Patterns.WEB_URL.matcher(text)
        while (urlMatcher.find()) {
            results.add(Entity(Entity.Type.URL, urlMatcher.group(), urlMatcher.start(), urlMatcher.end()))
        }

        // Hashtags
        val hashtagMatcher = hashtagPattern.matcher(text)
        while (hashtagMatcher.find()) {
            results.add(Entity(Entity.Type.HASHTAG, hashtagMatcher.group(), hashtagMatcher.start(), hashtagMatcher.end()))
        }

        // Mentions
        val mentionMatcher = mentionPattern.matcher(text)
        while (mentionMatcher.find()) {
            results.add(Entity(Entity.Type.MENTION, mentionMatcher.group(), mentionMatcher.start(), mentionMatcher.end()))
        }

        return results.sortedBy { it.start }
    }
}
