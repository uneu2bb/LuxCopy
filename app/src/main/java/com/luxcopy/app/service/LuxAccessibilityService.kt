package com.luxcopy.app.service

import android.accessibilityservice.AccessibilityService
import android.view.accessibility.AccessibilityEvent
import android.view.accessibility.AccessibilityNodeInfo
import android.util.Log

/**
 * Core service that reads the current screen content.
 * This is the heart of LuxCopy — same principle as Universal Copy.
 */
class LuxAccessibilityService : AccessibilityService() {

    companion object {
        private const val TAG = "LuxAccessibility"
        var instance: LuxAccessibilityService? = null
            private set
    }

    override fun onServiceConnected() {
        super.onServiceConnected()
        instance = this
        Log.d(TAG, "LuxCopy Accessibility Service connected")
    }

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        // We only act when the user triggers copy mode.
        // Continuous listening is avoided for performance & privacy.
    }

    override fun onInterrupt() {
        Log.d(TAG, "Service interrupted")
    }

    override fun onDestroy() {
        instance = null
        super.onDestroy()
    }

    /**
     * Collects all visible text nodes from the current active window.
     * Returns a list of TextNode with text + bounds.
     */
    fun extractAllTextNodes(): List<TextNode> {
        val root = rootInActiveWindow ?: return emptyList()
        val result = mutableListOf<TextNode>()
        collectTextNodes(root, result)
        root.recycle()
        return result
    }

    private fun collectTextNodes(node: AccessibilityNodeInfo, out: MutableList<TextNode>) {
        try {
            val text = node.text?.toString()?.trim()
            val contentDesc = node.contentDescription?.toString()?.trim()

            val finalText = when {
                !text.isNullOrBlank() -> text
                !contentDesc.isNullOrBlank() -> contentDesc
                else -> null
            }

            if (!finalText.isNullOrBlank() && finalText.length > 1) {
                val bounds = android.graphics.Rect()
                node.getBoundsInScreen(bounds)
                out.add(
                    TextNode(
                        text = finalText,
                        bounds = bounds,
                        isClickable = node.isClickable,
                        className = node.className?.toString()
                    )
                )
            }

            for (i in 0 until node.childCount) {
                val child = node.getChild(i) ?: continue
                collectTextNodes(child, out)
                child.recycle()
            }
        } catch (e: Exception) {
            Log.w(TAG, "Error collecting node", e)
        }
    }

    data class TextNode(
        val text: String,
        val bounds: android.graphics.Rect,
        val isClickable: Boolean = false,
        val className: String? = null
    )
}
