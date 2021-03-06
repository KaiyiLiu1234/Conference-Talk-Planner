package com.group0179.controllers;

import com.group0179.presenters.AttendeePresenter;
import com.group0179.Definitions;
import com.group0179.InputFilter;
import com.group0179.use_cases.MessageManager;
import com.group0179.use_cases.RoomManager;
import com.group0179.use_cases.UserManager;

import java.util.*;

public class AttendeePanel implements IController {
    private final UserManager userMan;
    private final MessageManager msgMan;
    private final RoomManager roomMan;
    private final InputFilter inputFilter;
    private final AttendeePresenter ap;
    private final Scanner input = new Scanner(System.in);


    /**
     * Allows attendees to do attendee things.
     * @param userMan the user manager use case class
     * @param msgMan the user manager use case class
     * @param roomMan the user manager use case class
     */
    public AttendeePanel (UserManager userMan, MessageManager msgMan, RoomManager roomMan, InputFilter inputFilter) {
        this.userMan = userMan;
        this.msgMan = msgMan;
        this.roomMan = roomMan;
        this.inputFilter = inputFilter;
        this.ap = new AttendeePresenter(userMan, msgMan);
    }

    @Override
    public int run() {
        // common info used by the switch cases
        UUID currUserID = this.userMan.getCurrentUser();
        ArrayList<UUID> allUserIds = new ArrayList<>(this.userMan.getAttendeeUUIDs());
        allUserIds.addAll(this.userMan.getOrganizerUUIDs());
        allUserIds.addAll(this.userMan.getSpeakerUUIDs());

        this.ap.displayWelcomeMsg();
        String decision = input.nextLine().toLowerCase();

        // while the input isn't Logout or Quit app, keep it in AttendeePanel
        while (!(decision.equals("logout") || decision.equals("quit"))){
            switch (decision) {
                case "commands":
                    displayCommands();
                    break;

                case "message":
                    // if the user wants to go back, nextMove won't be null and we'll go back
                    // otherwise, stay in the AttendeePanel loop
                    Integer nextMove= Message(currUserID);
                    if (nextMove != null){return nextMove;}
                    break;

                case "view messages":
                    nextMove= viewMessages(allUserIds, currUserID);
                    if (nextMove != null){return nextMove;}
                    break;

                case "view all events":
                    viewAllEvents();
                    break;

                case "view signed up events":
                    viewSignedUpEvents(currUserID);
                    break;

                case "join event":
                    nextMove= joinLeaveEvent(currUserID, this.userMan, "joining");
                    if (nextMove != null){return nextMove;}
                    break;

                case "leave event":
                    nextMove= joinLeaveEvent(currUserID, this.userMan, "leaving");
                    if (nextMove != null){return nextMove;}
                    break;

                default:
                    ap.displayInvalidCommandError();
            }
            decision = input.nextLine().toLowerCase();
        }

        // Go back to LoginSystem or quits app if user types the command for either
        if (decision.equals("logout")){return Definitions.BACK;}
        return Definitions.QUIT;
    }

    /**
     * Prints a list of commands that the user can input
     */
    private void displayCommands(){
        // displays all possible commands
        this.ap.displayCommands();
    }
    /**
     * @param currUserID The current user's userid
     * @return Returns an Integer if user wants to exit, null otherwise
     */
    private Integer Message(UUID currUserID){
        this.ap.dmPrompt();
        String response = input.nextLine().toLowerCase();
        if (response.equals("back")){return Definitions.REMAIN_IN_STATE;}
        //keep asking for input until the input is an existing username or 'back'
        while (!userExists(response)) {
            this.ap.displayUserDoesNotExistError();
            response = input.nextLine();
            if (response.equals("back")){return Definitions.REMAIN_IN_STATE;}
        }

        this.ap.typeMsgPrompt();
        String message = input.nextLine();
        UUID recipient = this.userMan.getUserID(response);
        this.msgMan.sendMessage(this.userMan, currUserID, recipient, message);
        this.ap.msgSentPrompt();
        return null;
    }

    /**
     * Prints the messages from a specific user or all users who sent him at least one message.
     * @param allUserIds The UUIDs of all users
     * @param currUserID The UUID of the current user
     * @return Returns an Integer if user wants to exit, null otherwise
     *
     * TODO: Check fixes for UM
     */
    private Integer viewMessages(ArrayList<UUID> allUserIds, UUID currUserID){
        this.ap.whosMsgPrompt();
        String response = input.nextLine().toLowerCase();
        // keep asking for input until it == 'all' or it == existing user name
        while (!response.equals("all") && !userExists(response)) {
            response = input.nextLine();
            if (response.equals("back")){return Definitions.REMAIN_IN_STATE;}
        }
        // if want all messages, get a list of messages from each user and
        // write the sender name and message contents if user received at least 1 message from them
        if (response.equals("all")){
            this.ap.displayMsgs(allUserIds, currUserID);
            return null;
        }
        // if user wants message from specific user
        UUID recipient = this.userMan.getUserID(response);
        List<String> msgContent = this.msgMan.getMessageContentsFromUser(this.userMan, currUserID, recipient);
        this.ap.displaySpecificUserMsg(msgContent);

        return null;
    }

    /**
     * Prints all existing events
     */
    private void viewAllEvents(){
        this.ap.displayAllEvents(roomMan.stringEventInfoAll());
    }

    /**
     * Prints all events the user signed up for
     * @param currUserID The current users UUID
     */
    private void viewSignedUpEvents(UUID currUserID){
        this.ap.displayAttendingEvents(roomMan.stringEventInfoAttending(currUserID));
    }

    /**
     * Asks user for an event name and prints whether it successfully signed up/signed out.
     * @param currUserID The current users UUID
     * @param userMan The userManager class
     * @param joinOrLeave A string either "joining" or "leaving" depending on what the user wants to do.
     * @return Returns an integer if user wants to go back out of the command, null otherwise
     */
    private Integer joinLeaveEvent(UUID currUserID, UserManager userMan, String joinOrLeave){
        // keeps asking user to input room number until valid number or user wants to cancel
        // if user wants to cancel, it'll return -1 and we will go back to attendee panel
        this.ap.joinLeaveEventOrRoomPrompt(joinOrLeave, "room");
        int inputRoomNum = this.inputFilter.inputRoom();
        if (inputRoomNum==-1){return Definitions.REMAIN_IN_STATE;}

        // keeps asking user to input event number until valid number or user wants to cancel
        // if user wants to cancel, it'll return -1 and we will go back to attendee panel
        this.ap.joinLeaveEventOrRoomPrompt(joinOrLeave, "event");
        int inputEventNum = this.inputFilter.inputEventNumber(inputRoomNum);
        if (inputEventNum==-1){return Definitions.REMAIN_IN_STATE;}

        //Signs user up to event in room
        if (joinOrLeave.equals("joining") && this.roomMan.addEventAttendee(currUserID, inputRoomNum, inputEventNum, userMan)){
            this.ap.displayJoinLeaveSuccess(joinOrLeave);
        } else if (joinOrLeave.equals("leaving") && this.roomMan.removeEventAttendee(currUserID, inputRoomNum, inputEventNum, userMan)){
            this.ap.displayJoinLeaveSuccess(joinOrLeave);
        } else {
            this.ap.displayJoinLeaveError(joinOrLeave);
            return Definitions.REMAIN_IN_STATE;
        }

        return null;
    }

    /**
     * Takes a username and returns true iff username is from an existing user
     * also prints a message telling user if username does not exist.
     * @param username the given username as a string
     * @return Whether the username is from an existing user
     */
    private boolean userExists(String username) {
        if (this.userMan.getUsernames().contains(username)) {
            return true;
        }
        ap.displayUserDoesNotExistError();
        return false;
    }
}
