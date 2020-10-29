package kg.nurik.mytester.ViewPager

interface PagerListener {

    fun selectAnswer(answer: Boolean, position: Int)
    fun selectAnswerForQuestions(points: Int, position: Int)

}