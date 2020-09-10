package com.example.quizzapp

object Constants {
    fun getQuestions():ArrayList<Question>{
        val questionList = ArrayList<Question>()
        val q1 = Question(
            1,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_argentina,
            "India",
            "Argentina",
            "Australia",
            "Austria",
            2)
        questionList.add(q1)
        val q2 = Question(
            2,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_australia,
            "India",
            "Argentina",
            "Australia",
            "Austria",
            3)
        questionList.add(q2)

        val q3 = Question(
            3,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_india,
            "India",
            "Argentina",
            "Australia",
            "Austria",
            1)
        questionList.add(q3)

        val q4 = Question(
            4,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_belgium,
            "India",
            "Belgium",
            "Algeria",
            "Austria",
            2)
        questionList.add(q4)

        val q5 = Question(
            5,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_brazil,
            "France",
            "Argentina",
            "Danemark",
            "Brazil",
            2)
        questionList.add(q5)
        return questionList
    }
}