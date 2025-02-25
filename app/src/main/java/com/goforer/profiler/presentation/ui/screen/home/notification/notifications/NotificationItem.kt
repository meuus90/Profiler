/*
 * Copyright (C) 2023 The Android Open Source Project by Lukoh Nam, goForer
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 2 of the License,
 * or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License along with this program.
 * If not, see <http://www.gnu.org/licenses/>.
 */

package com.goforer.profiler.presentation.ui.screen.home.notification.notifications

import android.content.res.Configuration
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImagePainter
import coil.size.Size
import com.goforer.base.ui.compose.ImageCrossFade
import com.goforer.base.ui.compose.loadImagePainter
import com.goforer.profiler.R
import com.goforer.profiler.data.model.datum.response.notification.Notification
import com.goforer.profiler.presentation.ui.theme.*

@Composable
fun NotificationItem(
    modifier: Modifier = Modifier,
    notification: Notification,
    index: Int,
    onItemClicked: (item: Notification, index: Int) -> Unit,
    onNavigateToDetailInfo: (Int) -> Unit
) {
    Surface(
        shape = MaterialTheme.shapes.small,
        modifier = modifier.padding(8.dp, 0.dp)
    ) {
        Row(
            verticalAlignment = CenterVertically,
            modifier = modifier
                .height(IntrinsicSize.Min)
                .background(ColorBgSecondary)
                .wrapContentHeight(Alignment.Top)
                .fillMaxWidth()
                .heightIn(min = 80.dp)
                .clickable {
                    onItemClicked(notification, index)
                    onNavigateToDetailInfo(notification.id)
                },
        ) {
            IconContainer {
                BoxWithConstraints {
                    val painter = loadImagePainter(
                        data = notification.sender,
                        size = Size.ORIGINAL
                    )

                    ImageCrossFade(painter = painter, durationMillis = null)
                    Image(
                        painter = painter,
                        contentDescription = "ComposeTest",
                        modifier = Modifier
                            .padding(4.dp)
                            .fillMaxSize()
                            .clip(CircleShape)
                            .border(1.dp, MaterialTheme.colorScheme.secondary, CircleShape),
                        Alignment.CenterStart,
                        contentScale = ContentScale.Crop
                    )

                    if (painter.state is AsyncImagePainter.State.Loading) {
                        val preloadPainter = loadImagePainter(
                            data = R.drawable.ic_profile_logo,
                            size = Size.ORIGINAL
                        )

                        Image(
                            painter = preloadPainter,
                            contentDescription = null,
                            modifier = Modifier
                                .size(36.dp)
                                .align(Alignment.Center),
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.width(12.dp))
            Column(modifier = Modifier
                .wrapContentWidth()
            ) {
                Row(modifier = Modifier
                    .height(IntrinsicSize.Min)
                    .wrapContentWidth()
                    .height(IntrinsicSize.Min)) {
                    Text(
                        text = "${notification.division}${"  -  "}${notification.team}" ,
                        modifier = Modifier.padding(0.dp, 6.dp, 0.dp, 0.dp),
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 14.sp,
                        fontStyle = FontStyle.Normal,
                        color = ColorText3,
                        style = MaterialTheme.typography.titleSmall
                    )
                }

                Spacer(modifier = Modifier.height(4.dp))
                Row(modifier = Modifier
                    .height(IntrinsicSize.Min)
                    .width(284.dp)
                ) {
                    Text(
                        "${notification.name}${" "}${stringResource(id = R.string.notification_posted)}${" : "}${notification.title}",
                        modifier = Modifier
                            .align(CenterVertically)
                            .padding(0.dp, 2.dp, 6.dp, 2.dp),
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Medium,
                        fontSize = 15.sp,
                        color = ColorText1,
                        fontStyle = FontStyle.Normal
                    )
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            IconContainer {
                BoxWithConstraints {
                    val painter = loadImagePainter(
                        data = when(notification.importance) {
                            0 -> R.drawable.ic_check
                            1 -> R.drawable.ic_inportant
                            2 -> R.drawable.ic_info
                            else -> R.drawable.ic_common
                        },
                        size = Size.ORIGINAL
                    )

                    Image(
                        painter = painter,
                        contentDescription = "ComposeTest",
                        modifier = Modifier
                            .padding(0.dp, 0.dp, 4.dp, 0.dp)
                            .size(32.dp),
                        Alignment.CenterStart,
                        contentScale = ContentScale.Crop
                    )
                }
            }
        }
    }
}

@Composable
private fun IconContainer(content: @Composable () -> Unit) {
    Surface(
        Modifier.size(width = 40.dp, height = 40.dp),
        CircleShape
    ) {
        content()
    }
}

@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode",
    showSystemUi = true
)
@Composable
fun MyNetworkSectionPreview() {
    ProfilerTheme {
        Surface(
            shape = MaterialTheme.shapes.small,
            modifier = Modifier.padding(8.dp, 0.dp)
        ) {
            Row(
                verticalAlignment = CenterVertically,
                modifier = Modifier
                    .background(ColorBgSecondary)
                    .wrapContentHeight(Alignment.Top)
                    .fillMaxWidth()
                    .heightIn(min = 80.dp)
                    .clickable {},
            ) {
                IconContainer {
                    Box {
                        val painter = loadImagePainter(
                            data = "https://avatars.githubusercontent.com/u/18302717?v=4",
                            size = Size.ORIGINAL
                        )

                        ImageCrossFade(painter = painter, durationMillis = null)
                        Image(
                            painter = painter,
                            contentDescription = "ComposeTest",
                            modifier = Modifier
                                .padding(4.dp)
                                .fillMaxSize()
                                .clip(CircleShape)
                                .border(1.dp, MaterialTheme.colorScheme.secondary, CircleShape),
                            Alignment.CenterStart,
                            contentScale = ContentScale.Crop
                        )

                        if (painter.state is AsyncImagePainter.State.Loading) {
                            val preloadPainter = loadImagePainter(
                                data = R.drawable.ic_profile_logo,
                                size = Size.ORIGINAL
                            )

                            Image(
                                painter = preloadPainter,
                                contentDescription = null,
                                modifier = Modifier
                                    .size(36.dp)
                                    .align(Alignment.Center),
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.width(12.dp))
                Column(
                    modifier = Modifier
                        .wrapContentWidth()
                        .wrapContentHeight()
                ) {
                    Row(modifier = Modifier.wrapContentWidth()) {
                        Text(
                            text = "${"Development"}${"  -  "}${"Android"}",
                            modifier = Modifier.padding(0.dp, 6.dp, 0.dp, 0.dp),
                            fontFamily = FontFamily.SansSerif,
                            fontSize = 14.sp,
                            fontStyle = FontStyle.Normal,
                            color = ColorText3,
                            style = MaterialTheme.typography.titleSmall
                        )
                    }

                    Spacer(modifier = Modifier.height(4.dp))
                    Row(modifier = Modifier
                        .width(284.dp)
                        .animateContentSize()) {
                        Text(
                            "${"Lukoh"}${" "}${stringResource(id = R.string.notification_posted)}${" : "}${"Coding Rules"}",
                            modifier = Modifier
                                .align(CenterVertically)
                                .padding(0.dp, 2.dp, 6.dp, 2.dp),
                            fontFamily = FontFamily.SansSerif,
                            fontWeight = FontWeight.Medium,
                            fontSize = 15.sp,
                            color = ColorText1,
                            fontStyle = FontStyle.Normal
                        )
                    }
                }
                Spacer(modifier = Modifier.weight(1f))
                IconContainer {
                    BoxWithConstraints {
                        val painter = loadImagePainter(
                            data = R.drawable.ic_common,
                            size = Size.ORIGINAL
                        )

                        Image(
                            painter = painter,
                            contentDescription = "ComposeTest",
                            modifier = Modifier
                                .padding(0.dp, 0.dp, 4.dp, 0.dp)
                                .size(32.dp),
                            Alignment.CenterStart,
                            contentScale = ContentScale.Crop
                        )
                    }
                }
            }
        }
    }
}