package com.jnetai.phdresearch.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Index

@Entity(tableName = "papers", indices = [Index("title")])
data class Paper(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val title: String,
    val authors: String = "",
    val year: Int = 2024,
    val journal: String = "",
    val doi: String = "",
    val abstractText: String = "",
    val tags: String = "",
    val status: String = "To Read",
    val rating: Int = 0,
    val notes: String = "",
    val createdAt: Long = System.currentTimeMillis()
)

@Entity(tableName = "citations", indices = [Index("paperId")])
data class Citation(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val paperId: Long,
    val citedTitle: String,
    val citedAuthors: String = "",
    val citedYear: Int = 0,
    val context: String = "",
    val createdAt: Long = System.currentTimeMillis()
)

@Entity(tableName = "experiments", indices = [Index("date")])
data class Experiment(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val title: String,
    val date: String = "",
    val hypothesis: String = "",
    val method: String = "",
    val results: String = "",
    val conclusion: String = "",
    val status: String = "Planned",
    val createdAt: Long = System.currentTimeMillis()
)