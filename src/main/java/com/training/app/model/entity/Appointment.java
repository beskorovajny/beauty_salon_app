package com.training.app.model.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The type Appointment.
 */
public class Appointment {

    /**
     * The enum Status.
     */
    public enum Status {
        /**
         * Need status.
         */
        NEED("need"),
        /**
         * Confirmed status.
         */
        CONFIRMED("confirmed"),
        /**
         * Cancelled status.
         */
        CANCELLED("cancelled"),
        /**
         * Done status.
         */
        DONE("done");

        private final String statusName;

        Status(String statusName) {
            this.statusName = statusName;
        }

        /**
         * Gets status name.
         *
         * @return the status name
         */
        public String getStatusName() {
            return statusName;
        }
    }


    private int id;
    private LocalDateTime actionDateTime;
    private BigDecimal price;
    private Status status;
    private int estimate;
    private List<User> users = new ArrayList<>();
    private List<Service> serviceList = new ArrayList<>();


    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Gets action date time.
     *
     * @return the action date time
     */
    public LocalDateTime getActionDateTime() {
        return actionDateTime;
    }

    /**
     * Gets price.
     *
     * @return the price
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Gets status.
     *
     * @return the status
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Gets users.
     *
     * @return the users
     */
    public List<User> getUsers() {
        return users;
    }

    /**
     * Gets services.
     *
     * @return the services
     */
    public List<Service> getServices() {
        return serviceList;
    }

    /**
     * Gets estimate.
     *
     * @return the estimate
     */
    public int getEstimate() {
        return estimate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Appointment)) {
            return false;
        }

        Appointment that = (Appointment) o;

        if (getId() != that.getId()) {
            return false;
        }
        if (getActionDateTime() != null ? !getActionDateTime().equals(that.getActionDateTime()) : that.getActionDateTime() != null) {
            return false;
        }
        if (getPrice() != null ? !getPrice().equals(that.getPrice()) : that.getPrice() != null) {
            return false;
        }
        if (getStatus() != that.getStatus()) {
            return false;
        }
        if (getUsers() != null ? !getUsers().equals(that.getUsers()) : that.getUsers() != null) {
            return false;
        }
        return Objects.equals(serviceList, that.serviceList);
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getActionDateTime() != null ? getActionDateTime().hashCode() : 0);
        result = 31 * result + (getPrice() != null ? getPrice().hashCode() : 0);
        result = 31 * result + (getStatus() != null ? getStatus().hashCode() : 0);
        result = 31 * result + (getUsers() != null ? getUsers().hashCode() : 0);
        result = 31 * result + (serviceList != null ? serviceList.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", actionDateTime=" + actionDateTime +
                ", price=" + price +
                ", status=" + status +
                ", estimate=" + estimate +
                ", users=" + users +
                ", serviceList=" + serviceList +
                '}';
    }

    /**
     * New builder appointment builder.
     *
     * @return the appointment builder
     */
    public static AppointmentBuilder newBuilder() {
        return new Appointment().new AppointmentBuilder();
    }

    /**
     * The type Appointment builder.
     */
    public class AppointmentBuilder {

        private AppointmentBuilder() {
        }

        /**
         * Sets id.
         *
         * @param id the id
         * @return the id
         */
        public AppointmentBuilder setId(int id) {
            Appointment.this.id = id;
            return this;
        }

        /**
         * Sets users.
         *
         * @param users the users
         * @return the users
         */
        public AppointmentBuilder setUsers(List<User> users) {
            Appointment.this.users = users;
            return this;
        }

        /**
         * Sets action date time.
         *
         * @param actionDateTime the action date time
         * @return the action date time
         */
        public AppointmentBuilder setActionDateTime(LocalDateTime actionDateTime) {
            Appointment.this.actionDateTime = actionDateTime;
            return this;
        }

        /**
         * Sets price.
         *
         * @param price the price
         * @return the price
         */
        public AppointmentBuilder setPrice(BigDecimal price) {
            Appointment.this.price = price;
            return this;
        }

        /**
         * Sets estimate.
         *
         * @param estimate the estimate
         * @return the estimate
         */
        public AppointmentBuilder setEstimate(int estimate) {
            if (estimate >= 0 && estimate <= 10) {
                Appointment.this.estimate = estimate;
            }
            return this;
        }


        /**
         * Sets status.
         *
         * @param status the status
         * @return the status
         */
        public AppointmentBuilder setStatus(Appointment.Status status) {
            Appointment.this.status = status;
            return this;
        }

        /**
         * Sets services.
         *
         * @param serviceList the service list
         * @return the services
         */
        public AppointmentBuilder setServices(List<Service> serviceList) {
            Appointment.this.serviceList = serviceList;
            return this;
        }

        /**
         * Build appointment.
         *
         * @return the appointment
         */
        public Appointment build() {
            return Appointment.this;
        }
    }

}
