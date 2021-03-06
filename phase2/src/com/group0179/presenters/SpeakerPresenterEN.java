package com.group0179.presenters;

public class SpeakerPresenterEN implements ISpeakerPresenter{
    /**
     * @return Recipient does not exist.
     */
    @Override
    public String recipientDNE() {
        return "The recipient does not exist";
    }

    /**
     * @return message sent successfully.
     */
    @Override
    public String sentSuccess() {
        return "Message sent successfully";
    }

    /**
     * @return the word message.
     */
    @Override
    public String messageWord() {
        return "Message";
    }

    /**
     * @return user not found.
     */
    @Override
    public String userNotFound() {
        return "User not found";
    }

    /**
     * @return no events availiable.
     */
    @Override
    public String noEventsAvailiable() {
        return "no events availiable";
    }

    /**
     * @return joining or leaving
     */
    @Override
    public String joinOrLeave() {
        return "Please type either j for joining or l for leaving.";
    }

    /**
     * @return invalid room number
     */
    @Override
    public String invalidRoom() {
        return "Invalid room number";
    }

    /**
     * @return no event found
     */
    @Override
    public String noEventsFound() {
        return "No events found";
    }

    /**
     * @return successfully joined the event
     */
    @Override
    public String joinEventSuccess() {
        return "Successfully joined the event";
    }

    /**
     * @return successfully left the event.
     */
    @Override
    public String leaveEventSuccess() {
        return "Successfully left the event";
    }

    /**
     * @return unable to join the event
     */
    @Override
    public String joinEventFail() {
        return "Unable to join the event";
    }

    /**
     * @return unable to leave the event.
     */
    @Override
    public String leaveEventFail() {
        return "Unable to leave the event.";
    }

    /**
     * AttendeeScene strings.
     * @return Send message
     */
    @Override
    public String sendMessage() {
        return "Send Message";
    }

    /**
     * @return Enter username of who you would like to message.
     */
    @Override
    public String enterUsername() {
        return "Enter username of who you would like to message.";
    }

    /**
     * @return Enter message content
     */
    @Override
    public String enterMsgContent() {
        return "Enter message content";
    }

    /**
     * @return Send
     */
    @Override
    public String send() {
        return "Send";
    }

    /**
     * @return View messages
     */
    @Override
    public String viewMessages() {
        return "View Messages";
    }

    /**
     * @return Enter username of who's messages they want to see.
     */
    @Override
    public String usersToSee() {
        return "Enter username of who's messages you would like to see, enter 'all' for all.";
    }

    /**
     * @return Submit
     */
    @Override
    public String submit() {
        return "Submit";
    }

    /**
     * @return View all events
     */
    @Override
    public String viewAllEvents() {
        return "View All Events";
    }

    /**
     * @return View signed up events.
     */
    @Override
    public String viewAllSignedUpevents() {
        return "View All Signed Up Events";
    }

    /**
     * @return join/leave event button
     */
    @Override
    public String joinLeaveButtonText() {
        return "Join/Leave Event";
    }

    /**
     * @return Join or leave text label.
     */
    @Override
    public String joinOrLeaveLabel() {
        return "Would you like to join or leave the event? ";
    }

    /**
     * @return Enter room number of event.
     */
    @Override
    public String enterRoomNumberLabel() {
        return "Enter room number of event:";
    }

    /**
     * @return Enter name of event.
     */
    @Override
    public String enterEventNameLabel() {
        return "Enter name of event:";
    }

    /**
     * @return Attempt join.
     */
    @Override
    public String attemptJoinButton() {
        return "Attempt Join";
    }

    /**
     * @return Logout
     */
    @Override
    public String logoutButton() {
        return "Logout";
    }

    /**
     * @return Last login info
     */
    @Override
    public String lastLogin() {
        return "Last Login:";
    }

    /**
     * @return Average login time
     */
    @Override
    public String avgLoginTime() {
        return "Average Login Time (minutes):";
    }

    /**
     * @return Total login time
     */
    @Override
    public String totalLoginTime() {
        return "Total Login Time (minutes):";
    }

    /**
     * @return Max and min login times
     */
    @Override
    public String maxMinLoginTimes() {
        return null;
    }

    @Override
    public String userStats() {return "User Stats";
    }

    @Override
    public String SpeakerPanel() {
        return "Speaker Panel";
    }

    @Override
    public String viewSpeakingEventsButton() {
        return "View Speaking Events";
    }

    @Override
    public String noSpeakingEvents() {
        return "You are not speaking at any events";
    }

    @Override
    public String eventDNE(){return "That event doesn't seem to exist";}

    @Override
    public String sendmessagetouser(){return "Send a message to a specific user";}

    @Override
    public String sendmessagetoEvent(){return "Send a message all attendees of an event";}

    /**
     * @return how many logins ago string
     */
    @Override
    public String howManyLoginsAgo() {
        return "How many logins ago";
    }

    /**
     * @return past login durations
     */
    @Override
    public String pastLoginDurations() {
        return "Past login durations";
    }
    /**
     * @return logged in times
     */
    @Override
    public String loggedInTime() {
        return "Logged in time";
    }

    /**
     * @return Last updated on login.
     */
    @Override
    public String updateInfo() {
        return "(updated on login)\n(all time in seconds)";
    }

    /**
     * @return Max login time
     */
    @Override
    public String maxLoginTime() {
        return "Longest time logged in: ";
    }

    /**
     * @return view requests
     */
    @Override
    public String viewrequestsButton() {
        return "View Requests";
    }

    /**
     * @return request
     */
    @Override
    public String requestsButton() {
        return "Requests";
    }

    /**
     * @return remove request
     */
    @Override
    public String removeRequestsButton() { return "Requests"; }

    /**
     * @return Min login time
     */
    @Override
    public String minLoginTime() {
        return "Shortest time logged in: ";
    }

    /**
     * @return a string representing no requests with this content.
     */
    @Override
    public String noRequestsWithThisContent(){return "There are no requests with this content";}

    /**
     * @return a string representing requests removed successfully.
     */
    @Override
    public String SuccessfullyRemoved(){return "Request successfully removed";}

    /**
     * @return a string representing the event doesn't contain that request.
     */
    @Override
    public String thisEventDoesNotContainThatRequest(){return "That event does not contain that request";}

    /**
     * @return a string representing enter the request content.
     */
    @Override
    public String requestContent(){return "Enter the request content";}
}
