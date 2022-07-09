package io.github.kawaki.yast.utils

enum class ButtonViewStyles(val style: Int) {

    ROUNDED_TOP_CORNERS(0),
    ROUNDED(1),
    ROUNDED_BOTTOM_CORNERS(2);

    companion object {
        fun fromParams(style: Int): ButtonViewStyles {
            return when (style) {
                0 -> ROUNDED_TOP_CORNERS
                1 -> ROUNDED
                2 -> ROUNDED_BOTTOM_CORNERS
                else -> throw IllegalArgumentException(Constants.UNSUPPORTED_BUTTON_VIEW_STYLE)
            }
        }
    }

}