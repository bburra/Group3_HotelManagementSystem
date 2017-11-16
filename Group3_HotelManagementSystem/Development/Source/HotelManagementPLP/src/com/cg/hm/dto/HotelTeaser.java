package com.cg.hm.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Hotel Teaser Table
 * 
 * @author rohitaku
 *
 */
@Entity
@Table(name = "hotel_teaser")
public class HotelTeaser {
	/**
	 * Comment
	 */
	@Id
	@Column(name = "comm")
	private String comment;

	/**
	 * Default Constructor
	 */
	public HotelTeaser() {
		super();
	}

	/**
	 * Parameterized Constructor
	 * 
	 * @param comment
	 */
	public HotelTeaser(String comment) {
		super();
		this.comment = comment;
	}

	/**
	 * Gets Value of Comment
	 * 
	 * @return
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * Sets Value of Comment
	 * 
	 * @param comment
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * Displays Details of Hotel Teaser Object
	 */
	@Override
	public String toString() {
		return "HotelTeaser [comment=" + comment + "]";
	}
}
