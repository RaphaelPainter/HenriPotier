package fr.android.paintersimon.data

import fr.android.paintersimon.domain.HenriPotierService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MyRetrofit {



    private fun MyRetrofit() {}

    companion object {
        private var instance: Retrofit? = null
        fun getInstance(): Retrofit? {
            if (instance == null) {
                synchronized(MyRetrofit::class.java) {
                    if (instance == null) {
                        instance = Retrofit.Builder()
                            .baseUrl("https://henri-potier.techx.fr")
                            .addConverterFactory(GsonConverterFactory.create())
                            .build()
                    }
                }

            }
            return instance
        }

        fun createHenriPotierService(): HenriPotierService? {
            return  getInstance()?.create(HenriPotierService::class.java);
        }
    }


}