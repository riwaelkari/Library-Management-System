package project332;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents rules specific to a faculty for managing resources like books, meeting rooms,
 * and electronic resources.
 * 
 * This class provides a flexible framework for configuring borrowing durations, 
 * maximum renewals, penalties for late returns, and rules for reserving and using 
 * library resources. The default rules can be customized to meet the needs of 
 * specific faculties.
 */
public class FacultyRules {
    // Borrowing rules for books
    private Map<String, Integer> borrowDuration; // Duration in days per user type (e.g., "Student": 3, "Professor": 7)
    private Map<String, Integer> maxRenewals; // Maximum renewals allowed per user type for books
    private int latePenaltyDays; // Penalty days for late returns

    // Meeting room reservation rules
    private int maxReservationDuration; // Maximum duration in hours
    private boolean studentsAllowedToReserve; // Can students reserve meeting rooms?
    private boolean professorsAllowedToReserve; // Can professors reserve meeting rooms?

    // Electronic resource usage rules
    private int maxUsageDuration; // Maximum usage duration in hours
    private boolean studentsAllowedToUse; // Can students use electronic resources?
    private boolean professorsAllowedToUse; // Can professors use electronic resources?
    private Map<String, Integer> maxRenewalsER; // Maximum renewals allowed per user type for books
    private int waitingPeriodToUseAgain;

    

    // Constructor
    /**
     * Constructs a FacultyRules object with default rule configurations.
     */
    public FacultyRules() {
        this.borrowDuration = new HashMap<>();
        this.maxRenewals = new HashMap<>();
        this.latePenaltyDays = 0;
        this.maxReservationDuration = 1; // Default: 1 hour
        this.studentsAllowedToReserve = true;
        this.professorsAllowedToReserve = true;
        this.maxUsageDuration = 1; // Default: 1 hour
        this.studentsAllowedToUse = true;
        this.professorsAllowedToUse = false;
        this.waitingPeriodToUseAgain = 3; //default 3 hours
    }

    public int getWaitingPeriodToUseAgain() {
		return waitingPeriodToUseAgain;
	}

	public void setWaitingPeriodToUseAgain(int waitingPeriodToUseAgain) {
		this.waitingPeriodToUseAgain = waitingPeriodToUseAgain;
	}

	// Getters and Setters
    public int getBorrowDuration(String userType) {
        return borrowDuration.getOrDefault(userType, 0);
    }

    public void setBorrowDuration(String userType, int duration) {
        borrowDuration.put(userType, duration);
    }

    public int getMaxRenewals(String userType) {
        return maxRenewals.getOrDefault(userType, 0);
    }
    public int getMaxRenewalsER(String userType) {
        return maxRenewalsER.getOrDefault(userType, 0);
    }

    public void setMaxRenewals(String userType, int renewals) {
        maxRenewals.put(userType, renewals);
    }
    
    
    public void setMaxRenewalsER(String userType, int renewals) {
        maxRenewalsER.put(userType, renewals);
    }


    public int getLatePenaltyDays() {
        return latePenaltyDays;
    }

    public void setLatePenaltyDays(int days) {
        this.latePenaltyDays = days;
    }

    public int getMaxReservationDuration() {
        return maxReservationDuration;
    }

    public void setMaxReservationDuration(int hours) {
        this.maxReservationDuration = hours;
    }

    public boolean isStudentsAllowedToReserve() {
        return studentsAllowedToReserve;
    }

    public void setStudentsAllowedToReserve(boolean allowed) {
        this.studentsAllowedToReserve = allowed;
    }

    public boolean isProfessorsAllowedToReserve() {
        return professorsAllowedToReserve;
    }

    public void setProfessorsAllowedToReserve(boolean allowed) {
        this.professorsAllowedToReserve = allowed;
    }

    public int getMaxUsageDuration() {
        return maxUsageDuration;
    }

    public void setMaxUsageDuration(int hours) {
        this.maxUsageDuration = hours;
    }

    public boolean isStudentsAllowedToUse() {
        return studentsAllowedToUse;
    }

    public void setStudentsAllowedToUse(boolean allowed) {
        this.studentsAllowedToUse = allowed;
    }

    public boolean isProfessorsAllowedToUse() {
        return professorsAllowedToUse;
    }

    public void setProfessorsAllowedToUse(boolean allowed) {
        this.professorsAllowedToUse = allowed;
    }
}
