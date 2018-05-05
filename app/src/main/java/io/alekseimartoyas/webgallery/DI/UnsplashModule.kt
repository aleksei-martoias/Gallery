package io.alekseimartoyas.webgallery.DI

import dagger.Module
import dagger.Provides
import io.alekseimartoyas.webgallery.NetworkLayer.RetrofitManager
import io.alekseimartoyas.webgallery.NetworkLayer.RetrofitManagerInputOutput
import io.alekseimartoyas.webgallery.Services.Unsplash
import javax.inject.Singleton

@Module
class UnsplashModule() {
    @Provides
    @Singleton
    fun provideUnsplash(): Unsplash = Unsplash(RetrofitManager("https://api.unsplash.com/")
            .getRetrofit(),
            "c70068d136dda98ca3dd1b38f7e93619a8ed4244133e55aec5b538eb371a52ca")
}