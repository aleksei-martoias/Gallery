package io.alekseimartoyas.webgallery.DI

import dagger.Component
import io.alekseimartoyas.webgallery.Services.GlideService
import io.alekseimartoyas.webgallery.Services.Unsplash
import javax.inject.Singleton

@Singleton
@Component(modules = [GlideModule::class, UnsplashModule::class])
interface AppComponent {
    fun getUnsplash(): Unsplash
    fun getGlide(): GlideService
}