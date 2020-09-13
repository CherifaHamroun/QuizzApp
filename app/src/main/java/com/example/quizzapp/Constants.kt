package com.example.quizzapp

object Constants {
    const val username : String = ""
    const val totalQuestions = ""
    const val CORRECT_ANSWERS = ""
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
            4)
        questionList.add(q5)
        val q6 = Question(
            6,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_fiji,
            "India",
            "Fiji",
            "Algeria",
            "Brazil",
            2)
        questionList.add(q6)
        val q7 = Question(
            7,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_germany,
            "Germany",
            "France",
            "Bengladesh",
            "Canada",
            1)
        questionList.add(q7)
        val q8 = Question(
            8,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_kuwait,
            "India",
            "Fiji",
            "Kuweit",
            "Brazil",
            3)
        questionList.add(q8)
        val q9 = Question(
            9,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_new_zealand,
            "USA",
            "Malaysia",
            "New Zealand",
            "Brazil",
            3)
        questionList.add(q9)
        val q10 = Question(
            10,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_denmark,
            "India",
            "fiji",
            "Algeria",
            "Denmark",
            4)
        questionList.add(q10)
        return questionList
    }
}