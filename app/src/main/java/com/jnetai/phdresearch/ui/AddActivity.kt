package com.jnetai.phdresearch.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.jnetai.phdresearch.PhDResearch
import com.jnetai.phdresearch.R
import com.jnetai.phdresearch.databinding.ActivityAddBinding
import com.jnetai.phdresearch.model.Paper
import kotlinx.coroutines.launch

class AddActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddBinding
    private val app get() = application as PhDResearch

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = "Add New Paper"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.saveButton.setOnClickListener {
            val title = binding.editTitle.text.toString().trim()
            if (title.isEmpty()) {
                Toast.makeText(this, "Title is required", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            lifecycleScope.launch {
                val item = Paper(title = title, authors = binding.editSubtitle.text.toString().trim())
            app.database.dao().insertPaper(item)
                finish()
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean { finish(); return true }
}