package com.luxcopy.app

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.luxcopy.app.ui.theme.LuxCopyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LuxCopyTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LuxCopyHomeScreen()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LuxCopyHomeScreen() {
    val context = LocalContext.current
    var isServiceEnabled by remember { mutableStateOf(false) }

    // Simple check (in real app use a more reliable method)
    LaunchedEffect(Unit) {
        // Placeholder — real check should query Settings.Secure
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "LuxCopy",
                        fontWeight = FontWeight.Bold,
                        fontSize = 22.sp
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            // Hero card
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            ) {
                Column(modifier = Modifier.padding(20.dp)) {
                    Text(
                        "Premium Text Copier",
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(Modifier.height(8.dp))
                    Text(
                        "Copy text from any app • Extract from images • Smart actions",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }

            // Enable service button
            Button(
                onClick = {
                    val intent = Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS)
                    context.startActivity(intent)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = MaterialTheme.shapes.large
            ) {
                Icon(Icons.Default.Accessibility, contentDescription = null)
                Spacer(Modifier.width(12.dp))
                Text("Enable Accessibility Service", fontSize = 16.sp)
            }

            Text(
                "Required once. LuxCopy uses the official Accessibility API only when you trigger copy mode.",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            HorizontalDivider()

            // Features list
            Text("Premium Features", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.SemiBold)

            FeatureItem(Icons.Default.ContentCopy, "Universal Copy Mode", "Copy from Instagram, YouTube, WhatsApp, PDFs…")
            FeatureItem(Icons.Default.DocumentScanner, "Scanner Mode (OCR)", "Extract text from any image offline")
            FeatureItem(Icons.Default.AutoAwesome, "Smart Entities", "Emails, phones, addresses, hashtags detected")
            FeatureItem(Icons.Default.History, "Clipboard History", "Searchable history with folders")
            FeatureItem(Icons.Default.DarkMode, "Beautiful Themes", "Dynamic color + pure AMOLED black")
        }
    }
}

@Composable
fun FeatureItem(icon: androidx.compose.ui.graphics.vector.ImageVector, title: String, subtitle: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Icon(
            icon,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier.size(28.dp)
        )
        Spacer(Modifier.width(16.dp))
        Column {
            Text(title, fontWeight = FontWeight.Medium)
            Text(subtitle, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
        }
    }
}
