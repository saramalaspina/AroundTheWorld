package com.example.aroundtheworld.graphiccontroller.cli;

import com.example.aroundtheworld.appcontroller.BookingResidenceController;
import com.example.aroundtheworld.bean.ResidenceRequestBean;
import com.example.aroundtheworld.engineering.Printer;
import com.example.aroundtheworld.engineering.Session;
import com.example.aroundtheworld.engineering.ShowExceptionSupport;
import com.example.aroundtheworld.exception.CommandErrorException;
import com.example.aroundtheworld.exception.DuplicateRequestException;
import com.example.aroundtheworld.exception.MessageException;
import com.example.aroundtheworld.exception.NotFoundException;
import com.example.aroundtheworld.viewcli.BookingFormViewCLI;

public class BookResidenceCLIController implements GraphicCLIController {

    private static final String LONDON = "1";
    private static final String ROME = "2";
    private static final String PARIS = "3";
    private static final String NEW_YORK = "4";
    private static final String VALENCIA = "5";
    private static final String SINGLE = "1";
    private static final String DOUBLE = "2";

    BookingFormViewCLI bookingFormViewCLI;

    @Override
    public void start() {
        this.bookingFormViewCLI = new BookingFormViewCLI(this);
        this.bookingFormViewCLI.run();
    }

    public String executeCity(String inputLine) throws CommandErrorException {
        String city;
        switch (inputLine){
            case LONDON -> city = "London";
            case ROME -> city = "Rome";
            case PARIS -> city = "Paris";
            case NEW_YORK -> city = "New York";
            case VALENCIA -> city = "Valencia";
            default -> throw new CommandErrorException();
        }
        return city;
    }

    public String executeRoom(String inputLine) throws CommandErrorException {
        String room;

        switch (inputLine){
            case SINGLE -> room = "single";
            case DOUBLE -> room = "double";
            default -> throw new CommandErrorException();
        }
        return room;
    }

    public void sendResidenceRequest(String city, String arrival, String departure, String room) {
        try {
            int idStudent = Session.getCurrentSession().getStudentBean().getId();
            ResidenceRequestBean residenceRequestBean = new ResidenceRequestBean(city, arrival, departure, room, idStudent, 0);
            BookingResidenceController bookingResidenceController = new BookingResidenceController();
            bookingResidenceController.sendRequest(residenceRequestBean);
            bookingFormViewCLI.displayRequestSentMessage();
        }
        catch (MessageException | NotFoundException | DuplicateRequestException e){
            ShowExceptionSupport.showExceptionCLI(e.getMessage());
        }
    }

}