package ivan.kompkit.playground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kompkit.android.button.KompButton
import com.kompkit.android.button.KompButtonSize
import com.kompkit.android.button.KompButtonVariant

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(modifier = Modifier.fillMaxSize().padding(16.dp)) {
                    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                        KompButton("Primary", {}, variant = KompButtonVariant.PRIMARY)
                        KompButton("Secondary", {}, variant = KompButtonVariant.SECONDARY)
                        KompButton("Outline", {}, variant = KompButtonVariant.OUTLINE)
                        KompButton("Text", {}, variant = KompButtonVariant.TEXT)
                        KompButton("Large", {}, size = KompButtonSize.LARGE)
                    }
                }
            }
        }
    }
}