package com.rahul.compose.architecture.extension

import androidx.drawerlayout.widget.DrawerLayout

fun DrawerLayout.lock() = this.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)

fun DrawerLayout.unlock() = this.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
