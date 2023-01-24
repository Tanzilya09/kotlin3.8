package com.example.kotlin38.Repository

import com.example.kotlin38.model.CatModel


class CinemaRepositiry {
    private var cinemaModelList = mutableListOf<CatModel>()

    fun getListOfCinema(): MutableList<CatModel> {


        cinemaModelList.add(CatModel("https://api.time.com/wp-content/uploads/2014/07/301386_full1.jpg","Harry Potter")
        )

        cinemaModelList.add(CatModel(
                "https://m.media-amazon.com/images/M/MV5BMTc5MDE2ODcwNV5BMl" +
                        "5BanBnXkFtZTgwMzI2NzQ2NzM@._V1_FMjpg_UX1000_.jpg", "Avengers"
            )
        )
        cinemaModelList.add(CatModel(
                "https://lumiere-a.akamaihd.net/v1/images/p_blackpanther_" +
                        "19754_4ac13f07.jpeg?region=0%2C0%2C540%2C810", "black panther"
            )
        )
        cinemaModelList.add(CatModel(
                "https://www.ixbt.com/img/n1/news/2022/5/5/0c3c20a8d851" +
                        "4501524a0859461f391572ea6e61_large.jpg", "Spider Man"
            )
        )
        cinemaModelList.add(CatModel(
                "https://media.timeout.com/images/105899643/750/422/image.jpg",
                "Merlin Monro"
            )
        )
        cinemaModelList.add(CatModel(
                "https://imageio.forbes.com/specials-images/imageserve/5d8e81f66de3150009a55ea8/" +
                        "Official-poster-for-Warner-s--Joker-/960x0.jpg?format=jpg&width=960",
                "Joker"
            )
        )
        cinemaModelList.add(CatModel(
                "https://m.media-amazon.com/images/M/MV5BM2ZmMjEyZmYtOGM4YS00YTNhLWE3ZDMtNzQxM2RhNjBlODIyXk" +
                        "EyXkFqcGdeQXVyMTUzMTg2ODkz._V1_FMjpg_UX1000_.jpg", "Wednesday"))
        return cinemaModelList
    }
}