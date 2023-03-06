package com.example.armanhw2

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var addedHws = 0
    private val gradesCalculator: GradeCalculator = GradeCalculator()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //todo: add TextView to see added Homeworks
        val resultText: TextView = findViewById(R.id.result)
        val hws: TextView = findViewById(R.id.hws)
        val calculateButton: Button = findViewById(R.id.btnCalculate)
        val finalProject: EditText = findViewById(R.id.FinalProject)
        val groupPresentation: EditText = findViewById(R.id.GroupPresentation)
        val participation: EditText = findViewById(R.id.Participation)
        val midterm2: EditText = findViewById(R.id.Midterm2)
        val midterm1: EditText = findViewById(R.id.Midterm1)
        val homework: EditText = findViewById(R.id.homework)
        val addHomeworkButton: Button = findViewById(R.id.btnAddHomework)
        val resetHomeworkButton: Button = findViewById(R.id.btnResetHomework)

        calculateButton.setOnClickListener {

            gradesCalculator.setFinalProject(finalProject.text.toString())
            gradesCalculator.setGroupPresentation(groupPresentation.text.toString())
            gradesCalculator.setParticipation(participation.text.toString())
            gradesCalculator.setMidtermExam2(midterm2.text.toString())
            gradesCalculator.setMidtermExam1(midterm1.text.toString())
            resultText.text = gradesCalculator.calculateGrade()

        }

        addHomeworkButton.setOnClickListener {
            if (addedHws < 5) {
                val inputGrade = homework.text.toString().toIntOrNull()
                if (inputGrade != null) {
                    gradesCalculator.updateHomeworkGrades(inputGrade)
                    hws.text = hws.text.toString() + inputGrade
                }
            }
            if (++addedHws == 5) {
                addHomeworkButton.isEnabled = false
            } else {
                hws.text = hws.text.toString() + " | "
            }
        }

        resetHomeworkButton.setOnClickListener {
            gradesCalculator.resetHomeworkGrades()
            hws.text = "Homeworks: "
            addedHws = 0
            addHomeworkButton.isEnabled = true
        }
    }
}