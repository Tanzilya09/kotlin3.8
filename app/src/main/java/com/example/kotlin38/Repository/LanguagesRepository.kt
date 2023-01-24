package com.example.kotlin38.Repository

import com.example.kotlin38.model.CatModel

class LanguagesRepository {
    private var languagesModelList = mutableListOf<CatModel>()

    fun getListOfText(): MutableList<CatModel> {
        languagesModelList.add(CatModel("https://cms-assets.tutsplus.com/uploads/users/1499/posts/29590/preview_image/kotlin.jpg",
                "Kotlin"
            )
        )
        languagesModelList.add(CatModel("https://upload.wikimedia.org/wikipedia/commons/thumb/9/99/Unofficial_JavaScript_logo_2.svg/1200px-Unofficial_JavaScript_logo_2.svg.png",
                "javaScript"
            )
        )
        languagesModelList.add(CatModel("https://upload.wikimedia.org/wikipedia/commons/thumb/1/18/ISO_C%2B%2B_Logo.svg/800px-ISO_C%2B%2B_Logo.svg.png",
                "C++"
            )
        )
        languagesModelList.add(CatModel("https://upload.wikimedia.org/wikipedia/commons/thumb/0/0a/Python.svg/800px-Python.svg.png",
                "python"
            )
        )
        languagesModelList.add(CatModel("https://play-lh.googleusercontent.com/bRNe2Qm36zr0ZbuZO5BI8uSCrL6rizeVbbI-sf4gIaKJlgk8Qj5v2ZHgK52ubGjvsg",
                "Scala"
            )
        )

        return languagesModelList
    }
}