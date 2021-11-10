package com.jayasuryat.minesweeperui.composable.grid

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.jayasuryat.minesweeperui.composable.component.LogCompositions
import com.jayasuryat.minesweeperui.composable.component.ZoomableContent
import com.jayasuryat.minesweeperengine.model.grid.MineGrid as MineGridData

@Composable
public fun Minefield(
    modifier: Modifier,
    mineGrid: MineGridData,
) {

    LogCompositions(name = "inside Minefield")

    ZoomableContent { zoomModifier: Modifier ->

        LogCompositions(name = "inside ZoomableContent")

        MineGrid(
            modifier = modifier
                .then(zoomModifier),
            mineGrid = mineGrid
        )
    }
}