package com.group0179.presenters;

/**
 * Login presenter class for bridging GUI layer and Use Cases.
 * @author Zachariah Vincze
 */
public class LoginPresenterEN implements ILoginPresenter {
    /**
     * @return a string representing a user's account creation success.
     */
    @Override
    public String accountCreationSuccess() { return "Account was created successfully!"; }

    /**
     * @return a string representing a user's account creation failure.
     */
    @Override
    public String accountCreationFailure() { return "Account creation failed."; }

    /**
     * @return a string representing a user's login failure.
     */
    @Override
    public String loginFailure() { return "Unable to login with given credentials."; }

    /**
     * @return a string representing the username prompt.
     */
    @Override
    public String usernamePrompt() { return "Username:"; }

    /**
     * @return a string representing the account type prompt.
     */
    @Override
    public String accountTypePrompt() { return "Account type:"; }

    /**
     * @return a string representing the organizer account choice.
     */
    @Override
    public String organizerAccountChoice() { return "Organizer"; }

    /**
     * @return a string representing the attendee account choice.
     */
    @Override
    public String attendeeAccountChoice() { return "Attendee"; }

    /**
     * @return a string representing the speaker account choice.
     */
    @Override
    public String speakerAccountChoice() { return "Speaker"; }

    /**
     * @param username the username.
     * @return a string representing a username not found error.
     */
    @Override
    public String usernameNotFoundError(String username) {
        return "Username " + username + " does not exist.";
    }

    /**
     * @param username the username.
     * @return a string representing that a username was taken.
     */
    @Override
    public String usernameTakenError(String username) {
        return "Username " + username + " is already in use.";
    }

    /**
     * @return a string representing login
     */
    @Override
    public String loginButtonPrompt() { return "Login"; }

    /**
     * @return a string representing create account
     */
    @Override
    public String createAccountButtonPrompt() { return "Create Account"; }

    /**
     * @return a string representing attendee(VIP).
     */
    @Override
    public String vipAttendeeAccountChoice() { return "Attendee (VIP)"; }
}
