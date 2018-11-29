package com.pixelart.week5daily4flikrapi.di

import com.pixelart.week5daily4flikrapi.remotes.RemoteHelper
import com.pixelart.week5daily4flikrapi.ui.MainActivity
import dagger.Component

@Component(modules = [RemoteHelper::class])
interface ApplicationComponent {

    fun inject(mainActivity: MainActivity)
}