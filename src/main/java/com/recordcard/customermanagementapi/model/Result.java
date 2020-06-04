package com.recordcard.customermanagementapi.model;

import java.util.List;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Range;

@Entity
public class Result {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "result_id")
	private Long resultId;
	@ManyToOne
	@JoinColumn(name = "student_id", nullable = false)
	@NotBlank
	private Student student;
	@JoinTable(name = "result_subject")
	@OneToMany(fetch = FetchType.EAGER)
	private List<Subject> subjects;
	@Column(name = "total_score")
	@Range(min = 0, max = 100)
	private Double totalScore;
	@Column(name = "subject_final_grade")
	private Character achievedGrade;
	@ManyToOne
	@JoinColumn(name = "grade_class")
	@NotBlank
	private GradeClass gradeClass;
	
	public Result () {}

	public Result(@NotBlank Student student, List<Subject> subjects, Double totalScore, Character achievedGrade,
			@NotBlank GradeClass gradeClass) {
		super();
		this.student = student;
		this.subjects = subjects;
		this.totalScore = totalScore;
		this.achievedGrade = achievedGrade;
		this.gradeClass = gradeClass;
	}

	public Result(@NotBlank Student student, Double totalScore, Character achievedGrade,
			@NotBlank GradeClass gradeClass) {
		super();
		this.student = student;
		this.totalScore = totalScore;
		this.achievedGrade = achievedGrade;
		this.gradeClass = gradeClass;
	}

	public Long getResultId() {
		return resultId;
	}

	public void setResultId(Long resultId) {
		this.resultId = resultId;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	public Double getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(Double totalScore) {
		this.totalScore = totalScore;
	}

	public Character getAchievedGrade() {
		return achievedGrade;
	}

	public void setAchievedGrade(Character achievedGrade) {
		this.achievedGrade = achievedGrade;
	}

	public GradeClass getGradeClass() {
		return gradeClass;
	}

	public void setGradeClass(GradeClass gradeClass) {
		this.gradeClass = gradeClass;
	}

	@Override
	public String toString() {
		return "Result [resultId=" + resultId + ", student=" + student + ", subjects=" + subjects + ", totalScore="
				+ totalScore + ", achievedGrade=" + achievedGrade + ", gradeClass=" + gradeClass + "]";
	}
	
	
	
	
}
