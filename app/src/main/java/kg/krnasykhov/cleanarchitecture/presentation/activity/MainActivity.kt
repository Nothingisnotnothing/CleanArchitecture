package kg.krnasykhov.cleanarchitecture.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kg.krnasykhov.cleanarchitecture.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}