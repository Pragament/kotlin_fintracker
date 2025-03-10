/*
 *   Copyright 2025 Benoit Letondor
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */
package com.benoitletondor.FinanceTrackerapp.view.main.subviews

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsBottomHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.benoitletondor.FinanceTrackerapp.R

@Composable
fun FABMenuOverlay(
    onAddRecurringEntryPressed: () -> Unit,
    onAddEntryPressed: () -> Unit,
    onTapOutsideCTAs: () -> Unit,
    onUpiQrEntryPressed: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(R.color.menu_background_overlay_color))
            .padding(bottom = 90.dp, end = 16.dp)
            .clickable(
                onClick = onTapOutsideCTAs,
                indication = null,
                interactionSource = null,
            ),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.End,
    ) {
        Row(
            modifier = Modifier.clickable(onClick = onAddRecurringEntryPressed),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                modifier = Modifier
                    .clip(RoundedCornerShape(6.dp))
                    .background(color = Color.Black)
                    .padding(horizontal = 10.dp, vertical = 5.dp),
                text = stringResource(R.string.fab_add_monthly_expense),
                color = Color.White,
                fontSize = 15.sp,
            )

            Spacer(modifier = Modifier.width(10.dp))

            FloatingActionButton(
                onClick = onAddRecurringEntryPressed,
                containerColor = colorResource(R.color.fab_add_monthly_expense),
                contentColor = colorResource(R.color.white),
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_autorenew_white),
                    contentDescription = stringResource(R.string.fab_add_monthly_expense),
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.clickable(onClick = onAddEntryPressed),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                modifier = Modifier
                    .clip(RoundedCornerShape(6.dp))
                    .background(color = Color.Black)
                    .padding(horizontal = 10.dp, vertical = 5.dp),
                text = stringResource(R.string.fab_add_expense),
                color = Color.White,
                fontSize = 15.sp,
            )

            Spacer(modifier = Modifier.width(10.dp))

            FloatingActionButton(
                onClick = onAddEntryPressed,
                containerColor = colorResource(R.color.fab_add_expense),
                contentColor = colorResource(R.color.white),
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_baseline_add_24),
                    contentDescription = stringResource(R.string.fab_add_expense),
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.clickable(onClick = onUpiQrEntryPressed),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                modifier = Modifier
                    .clip(RoundedCornerShape(6.dp))
                    .background(color = Color.Black)
                    .padding(horizontal = 10.dp, vertical = 5.dp),
                text = stringResource(R.string.upi_qr_scanner),
                color = Color.White,
                fontSize = 15.sp,
            )

            Spacer(modifier = Modifier.width(10.dp))

            FloatingActionButton(
                onClick = onUpiQrEntryPressed,
                containerColor = colorResource(R.color.white),
              //  contentColor = colorResource(R.color.white),
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_qr),
                    contentDescription = stringResource(R.string.upi_qr_scanner),
                    modifier = Modifier.width(30.dp),
                )
            }
        }

        Spacer(modifier = Modifier.windowInsetsBottomHeight(WindowInsets.systemBars))
    }
}
