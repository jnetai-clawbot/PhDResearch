package com.jnetai.phdresearch.data

import androidx.room.*
import com.jnetai.phdresearch.model.Paper
import com.jnetai.phdresearch.model.Citation
import com.jnetai.phdresearch.model.Experiment

@Dao
interface PhDResearchDao {
    @Query("SELECT * FROM papers ORDER BY createdAt DESC") suspend fun getAllPapers(): List<Paper>
    @Query("SELECT * FROM papers WHERE id = :id") suspend fun getPaper(id: Long): Paper?
    @Insert suspend fun insertPaper(paper: Paper): Long
    @Update suspend fun updatePaper(paper: Paper)
    @Delete suspend fun deletePaper(paper: Paper)

    @Query("SELECT * FROM citations WHERE paperId = :paperId") suspend fun getCitationsForPaper(paperId: Long): List<Citation>
    @Insert suspend fun insertCitation(citation: Citation): Long
    @Delete suspend fun deleteCitation(citation: Citation)

    @Query("SELECT * FROM experiments ORDER BY createdAt DESC") suspend fun getAllExperiments(): List<Experiment>
    @Query("SELECT * FROM experiments WHERE id = :id") suspend fun getExperiment(id: Long): Experiment?
    @Insert suspend fun insertExperiment(experiment: Experiment): Long
    @Update suspend fun updateExperiment(experiment: Experiment)
    @Delete suspend fun deleteExperiment(experiment: Experiment)
}