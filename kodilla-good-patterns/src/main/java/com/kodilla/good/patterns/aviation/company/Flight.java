package com.kodilla.good.patterns.aviation.company;

public class Flight {

    private final String departureFrom;
    private final String arrivalTo;

    public Flight(final String departureFrom, final String arrivalTo) {
        this.departureFrom = departureFrom;
        this.arrivalTo = arrivalTo;
    }

    public String getDepartureFrom() {
        return departureFrom;
    }

    public String getArrivalTo() {
        return arrivalTo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Flight flight = (Flight) o;

        if (departureFrom != null ? !departureFrom.equals(flight.departureFrom) : flight.departureFrom != null)
            return false;
        return arrivalTo != null ? arrivalTo.equals(flight.arrivalTo) : flight.arrivalTo == null;
    }

    @Override
    public int hashCode() {
        int result = departureFrom != null ? departureFrom.hashCode() : 0;
        result = 31 * result + (arrivalTo != null ? arrivalTo.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "departureFrom='" + departureFrom + '\'' +
                ", arrivalTo='" + arrivalTo + '\'' +
                '}';
    }
}
