package ru.bgpu.splk.models;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "requests")
public class RepairRequest {
	public enum Status {
		CREATED,
		IN_PROGRESS,
		READY,
		CANCELLED,
		DONE
	}

	public enum Category {
		LAPTOP,
		TV,
		PC
	}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    
    private BigDecimal cost;
    private LocalDate submissionDate;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
    private Category category;
    
    RepairRequest () { }
    
    RepairRequest (User user, Category category, BigDecimal cost) {
    	this.user = user;
    	this.category = category;
    	this.cost = cost;
    	this.status = Status.CREATED;
    	this.submissionDate = LocalDate.now ();
    }

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public LocalDate getSubmissionDate() {
		return submissionDate;
	}

	public void setSubmissionDate(LocalDate submissionDate) {
		this.submissionDate = submissionDate;
	}
}
