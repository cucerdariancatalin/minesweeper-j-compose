/*
 * Copyright 2022 Jaya Surya Thotapalli
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.jayasuryat.minesweeperjc.data

import com.jayasuryat.minesweeperengine.model.block.GridSize
import com.jayasuryat.minesweeperengine.model.grid.Grid
import com.jayasuryat.uigame.data.source.SavedGameFetcher
import com.jayasuryat.uigame.logic.EmptyGridGenerator
import com.jayasuryat.uigame.logic.InitialGridProvider

class InitialGridProviderImpl(
    private val savedGameFetcher: SavedGameFetcher,
    private val emptyGridGenerator: EmptyGridGenerator,
) : InitialGridProvider {

    override suspend fun getInitialGridFor(
        rows: Int,
        columns: Int,
        totalMines: Int,
    ): Grid {

        return savedGameFetcher.getSavedGame(
            rows = rows,
            columns = columns,
            totalMines = totalMines,
        ) ?: getEmptyGridFor(
            rows = rows,
            columns = columns,
            totalMines = totalMines,
        )
    }

    private fun getEmptyGridFor(
        rows: Int,
        columns: Int,
        totalMines: Int,
    ): Grid {

        val gridSize = GridSize(
            rows = rows,
            columns = columns,
        )

        return emptyGridGenerator.generateEmptyGrid(
            gridSize = gridSize,
            mineCount = totalMines,
        )
    }
}
