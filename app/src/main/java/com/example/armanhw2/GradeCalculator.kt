package com.example.armanhw2

class GradeCalculator {

    private var participationAndAttendance: Int = 100
    private var homeworks: ArrayList<Int> = arrayListOf()
    private var groupPresentation: Int = 100
    private var midtermExam1: Int = 100
    private var midtermExam2: Int = 100
    private var finalProject: Int = 100

    fun setParticipation(value: String) {
        this.participationAndAttendance = checkInputtedValues(value)
    }

    fun setGroupPresentation(value: String) {
        this.groupPresentation = checkInputtedValues(value)
    }

    fun setMidtermExam1(value: String) {
        this.midtermExam1 = checkInputtedValues(value)
    }

    fun setMidtermExam2(value: String) {
        this.midtermExam2 = checkInputtedValues(value)
    }

    fun setFinalProject(value: String) {
        this.finalProject = checkInputtedValues(value)
    }

    private fun checkInputtedValues(value: String): Int {
        var valueInt = 100
        if (value.isEmpty()) {
            return valueInt
        }
        valueInt = value.toInt()
        if (valueInt > 100) {
            return 100
        }
        return valueInt
    }

    fun calculateGrade(): String {
        val homeworkAverage = filledHomeworkGrades().average()
        val finalGrade =
            participationAndAttendance * 0.1 +
                    homeworkAverage * 0.2 +
                    groupPresentation * 0.1 +
                    midtermExam1 * 0.1 +
                    midtermExam2 * 0.2 +
                    finalProject * 0.3

        return "Final Grade: ${finalGrade.toInt()}"
    }

    fun updateHomeworkGrades(value: Int) {
        if (homeworks.size < 5) {
            homeworks.add(value)
        }
    }

    fun resetHomeworkGrades() {
        homeworks = arrayListOf()
    }

    private fun filledHomeworkGrades(): ArrayList<Int> {
        val filledHws = arrayListOf<Int>()
        for (i in 0 until homeworks.size) {
            filledHws.add(homeworks[i])
        }
        for (i in 0..4 - homeworks.size) {
            filledHws.add(100)
        }
        return filledHws
    }
}