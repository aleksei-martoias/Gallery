package io.alekseimartoyas.webgallery.DI

import dagger.Module
import dagger.Provides
import io.alekseimartoyas.webgallery.Services.GlideService
import javax.inject.Singleton

@Module
class GlideModule {
    @Provides
    @Singleton
    fun getGlideService(): GlideService = GlideService()
}