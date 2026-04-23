package com.jnetai.phdresearch

import android.app.Application
import com.jnetai.phdresearch.data.PhDResearchDatabase

class PhDResearch : Application() {
    val database by lazy { PhDResearchDatabase.getInstance(this) }
}