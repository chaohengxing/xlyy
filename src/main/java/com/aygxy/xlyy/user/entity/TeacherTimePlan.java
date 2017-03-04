package com.aygxy.xlyy.user.entity;

import java.util.List;

public class TeacherTimePlan {

	private List<TimeTemplate> templates;
	private List<FreeTime> freeTimes;

	public TeacherTimePlan() {
	}

	public TeacherTimePlan(List<TimeTemplate> templates,
			List<FreeTime> freeTimes) {
		this.templates = templates;
		this.freeTimes = freeTimes;
	}

	/**
	 * @return the templates
	 */
	public List<TimeTemplate> getTemplates() {
		return templates;
	}

	/**
	 * @param templates
	 *            the templates to set
	 */
	public void setTemplates(List<TimeTemplate> templates) {
		this.templates = templates;
	}

	/**
	 * @return the freeTimes
	 */
	public List<FreeTime> getFreeTimes() {
		return freeTimes;
	}

	/**
	 * @param freeTimes
	 *            the freeTimes to set
	 */
	public void setFreeTimes(List<FreeTime> freeTimes) {
		this.freeTimes = freeTimes;
	}

}
