package com.handirocker21.hodgepodge.utils;

/**
 * This is a utility class to handle various cooldowns.
 * Cooldowns are based in seconds and can be started and
 * checked to determine when certain usable items, etc
 * are ready.
 * 
 * @author Ryan Hochmuth
 *
 */
public class Cooldown {
	
	private int duration = 1;
	private long startTime = -1;
	private long currentTime = -1;
	private boolean isRunning = false;
	
	/**
	 * Create a new cooldown object with the given cooldown duration (in seconds).
	 * @param duration
	 */
	public Cooldown(int duration) {
		this.duration = duration;
	}
	
	/**
	 * Starts the cooldown time. The world time that the cooldown
	 * should start at must be given.
	 * @param startTime
	 */
	public void startCooldown(long startTime) {
		this.startTime = startTime;
		this.currentTime = startTime;
		this.isRunning = true;
	}
	
	/**
	 * Update the cooldown timer. This should be done in an update
	 * function such as onUpdate, but can be done without one as long
	 * as the world time can be obtained
	 * 
	 * This function will return a boolean specifying if the cooldown
	 * is over. If the cooldown is finished, it will be stopped
	 * automatically.
	 * @param currentTime
	 * @return true if the cooldown has finished, false if not
	 */
	public boolean updateCooldown(long currentTime) {
		if (this.isRunning && this.startTime != -1) {
			this.currentTime = currentTime;
			
			if ((this.currentTime - this.startTime) >= (20 * this.duration)) {
				stopCooldown();
				return true;
			}
			else if (this.currentTime < this.startTime) {
				this.startTime = this.currentTime;
			}
		}
		
		return false;
	}
	
	/**
	 * Check if the cooldown is finished. This doesn't update the cooldown
	 * times, it just checks its current values to see if it is finished.
	 * If the cooldown is finished, it will be stopped automatically.
	 * @return true if the cooldown has finished, false if not
	 */
	public boolean checkCooldown() {
		if (this.isRunning && this.startTime != -1 && this.currentTime != -1) {
			if ((this.currentTime - this.startTime) >= (20 * this.duration)) {
				stopCooldown();
				return true;
			}
			else if (this.currentTime < this.startTime) {
				this.startTime = this.currentTime;
			}
		}
		
		return false;
	}
	
	/**
	 * End the cooldown. Stops the timer from running and resets
	 * the values.
	 */
	public void stopCooldown() {
		this.isRunning = false;
		this.startTime = -1;
		this.currentTime = -1;
	}
	
	/**
	 * Pauses the cooldown from running, but doesn't reset anything.
	 */
	public void pauseCooldown() {
		this.isRunning = false;
	}
	
	/**
	 * Resumes a paused cooldown to continue running.
	 */
	public void resumeCooldown() {
		if (this.startTime != -1 && this.currentTime != -1) {
			this.isRunning = true;
		}
	}
	
	/**
	 * Check if the cooldown is running.
	 * @return running
	 */
	public boolean isRunning() {
		return this.isRunning;
	}
}
