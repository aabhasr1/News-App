package `in`.zipgo.aabhasjindal.newsapp.di.module

import dagger.Module

//import com.squareup.picasso.OkHttp3Downloader;
//import com.squareup.picasso.Picasso;

@Module(includes = [NetworkLayer::class])
class PicassoModule//    @Provides
//    public Picasso getPicasso(Context context, OkHttp3Downloader okHttp3Downloader) {
//        return new Picasso.Builder(context)
//                .downloader(okHttp3Downloader)
//                .build();
//    }
//    @Provides
//
//    public OkHttp3Downloader getOkHttp3Downloader(OkHttpClient okHttpClient) {
//        return new OkHttp3Downloader(okHttpClient);
//    }
