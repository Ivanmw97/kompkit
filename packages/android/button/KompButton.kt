package com.kompkit.android.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Button variants available in KompKit
 */
enum class KompButtonVariant {
    PRIMARY,
    SECONDARY,
    OUTLINE,
    TEXT
}

/**
 * Button sizes available in KompKit
 */
enum class KompButtonSize {
    SMALL,
    MEDIUM,
    LARGE
}

/**
 * KompKit Button component for Android using Jetpack Compose
 *
 * @param text The text to display in the button
 * @param onClick The callback to be invoked when the button is clicked
 * @param variant The button variant (PRIMARY, SECONDARY, OUTLINE, TEXT)
 * @param size The button size (SMALL, MEDIUM, LARGE)
 * @param enabled Whether the button is enabled or disabled
 * @param modifier Additional modifier for customization
 */
@Composable
fun KompButton(
    text: String,
    onClick: () -> Unit,
    variant: KompButtonVariant = KompButtonVariant.PRIMARY,
    size: KompButtonSize = KompButtonSize.MEDIUM,
    enabled: Boolean = true,
    modifier: Modifier = Modifier
) {
    // Define colors
    val primaryColor = Color(0xFF3B82F6)
    val primaryHoverColor = Color(0xFF2563EB)
    val secondaryColor = Color(0xFFE5E7EB)
    val secondaryTextColor = Color(0xFF1F2937)
    
    // Define padding based on size
    val buttonPadding = when (size) {
        KompButtonSize.SMALL -> PaddingValues(horizontal = 12.dp, vertical = 6.dp)
        KompButtonSize.MEDIUM -> PaddingValues(horizontal = 16.dp, vertical = 8.dp)
        KompButtonSize.LARGE -> PaddingValues(horizontal = 20.dp, vertical = 10.dp)
    }
    
    // Define height based on size
    val buttonHeight = when (size) {
        KompButtonSize.SMALL -> 32.dp
        KompButtonSize.MEDIUM -> 40.dp
        KompButtonSize.LARGE -> 48.dp
    }
    
    // Define font size based on size
    val fontSize = when (size) {
        KompButtonSize.SMALL -> 14.sp
        KompButtonSize.MEDIUM -> 16.sp
        KompButtonSize.LARGE -> 18.sp
    }
    
    val buttonModifier = modifier.height(buttonHeight)
    
    when (variant) {
        KompButtonVariant.PRIMARY -> {
            Button(
                onClick = onClick,
                enabled = enabled,
                modifier = buttonModifier,
                shape = RoundedCornerShape(4.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = primaryColor,
                    contentColor = Color.White,
                    disabledBackgroundColor = primaryColor.copy(alpha = 0.6f),
                    disabledContentColor = Color.White.copy(alpha = 0.6f)
                ),
                contentPadding = buttonPadding
            ) {
                Text(
                    text = text,
                    fontSize = fontSize,
                    fontWeight = FontWeight.Medium
                )
            }
        }
        KompButtonVariant.SECONDARY -> {
            Button(
                onClick = onClick,
                enabled = enabled,
                modifier = buttonModifier,
                shape = RoundedCornerShape(4.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = secondaryColor,
                    contentColor = secondaryTextColor,
                    disabledBackgroundColor = secondaryColor.copy(alpha = 0.6f),
                    disabledContentColor = secondaryTextColor.copy(alpha = 0.6f)
                ),
                contentPadding = buttonPadding
            ) {
                Text(
                    text = text,
                    fontSize = fontSize,
                    fontWeight = FontWeight.Medium
                )
            }
        }
        KompButtonVariant.OUTLINE -> {
            OutlinedButton(
                onClick = onClick,
                enabled = enabled,
                modifier = buttonModifier,
                shape = RoundedCornerShape(4.dp),
                border = BorderStroke(1.dp, primaryColor),
                colors = ButtonDefaults.outlinedButtonColors(
                    backgroundColor = Color.Transparent,
                    contentColor = primaryColor,
                    disabledContentColor = primaryColor.copy(alpha = 0.6f)
                ),
                contentPadding = buttonPadding
            ) {
                Text(
                    text = text,
                    fontSize = fontSize,
                    fontWeight = FontWeight.Medium
                )
            }
        }
        KompButtonVariant.TEXT -> {
            TextButton(
                onClick = onClick,
                enabled = enabled,
                modifier = buttonModifier,
                shape = RoundedCornerShape(4.dp),
                colors = ButtonDefaults.textButtonColors(
                    backgroundColor = Color.Transparent,
                    contentColor = primaryColor,
                    disabledContentColor = primaryColor.copy(alpha = 0.6f)
                ),
                contentPadding = buttonPadding
            ) {
                Text(
                    text = text,
                    fontSize = fontSize,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}