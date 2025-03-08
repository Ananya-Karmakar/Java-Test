class Q1 {
     String fullName;
     int pointLevel;
     String assignedCategory;

    public Q1(String fullName, int pointLevel, String assignedCategory) {
        this.fullName = fullName;
        this.pointLevel = pointLevel;
        this.assignedCategory = assignedCategory;
    }

    public String getfullname() {
        return fullName;
    }

    public void setfullname(String fullName) {
        this.fullName = fullName;
    }

    public int getpointlevel() {
        return pointLevel;
    }

    public void setpointlevel(int pointLevel) {
        this.pointLevel = pointLevel;
    }

    public String getassignedcategory() {
        return assignedCategory;
    }

    public void setassignedcategory(String assignedCategory) {
        this.assignedCategory = assignedCategory;
    }


    static class Ticket {
         int ticketId;
         String name;
         String category;
         int point;
         String AssignedEmployee ="";
         boolean isCompleted = false;

        public Ticket(int ticketId, String name, String category, int point) {
            this.ticketId = ticketId;
            this.name = name;
            this.category = category;
            this.point = point;
            
        }

        public int getticketid() {
            return ticketId;
        }

        public void setticketid(int ticketId) {
            this.ticketId = ticketId;
        }

        public String getname() {
            return name;
        }

        public void setname(String name) {
            this.name = name;
        }

        public String getcategory() {
            return category;
        }

        public void setcategory(String category) {
            this.category = category;
        }

        public int getpoint() {
            return point;
        }

        public void setpoint(int point) {
            this.point = point;
        }

        public void setcompleted(boolean completed) {
            isCompleted = completed;
        }

        public boolean iscompleted() {
            return isCompleted;
        }
    }


    static class Helpdesk {
         Q1 emp1;
         Q1 emp2;
         Ticket t1;
         Ticket t2;
         Ticket t3;
         Ticket t4;
         Ticket t5;

        public void addEmployee(Q1 e, int pos) {
            if (pos == 1) {
                emp1 = e;
            } else if (pos == 2) {
                emp2 = e;
            }
        }

        public void addTicket(Ticket t, int pos) {
            if (pos == 1) {
                t1 = t;
            } else if (pos == 2) {
                t2 = t;
            } else if (pos == 3) {
                t3 = t;
            } else if (pos == 4) {
                t4 = t;
            } else if (pos == 5) {
                t5 = t;
            }
        }

        public void completeTicket(String employeeName, int ticketId) {
            Q1 employee = getEmployee(employeeName);
            if (employee != null) {
                Ticket ticket = getTicket(ticketId);
                if (ticket != null && !ticket.iscompleted()) {
                    if (employee.getpointlevel() >= ticket.getpoint()) {
                        ticket.setcompleted(true);
                        System.out.println("Ticket : " + ticketId + " marked as completed successfully by : " + employeeName );
                    } else {
                        System.out.println("Employee's point level is not sufficient to complete the ticket.");
                    }
                } else {
                    System.out.println("Ticket not found or already completed.");
                }
            } else {
                System.out.println("Employee not found.");
            }
        }

        public int getWaitingTicketCount() {
            int count = 0;
            if (t1 != null && !t1.iscompleted()) 
            {
                count++;
            }
            if (t2 != null && !t2.iscompleted()) 
            {
                count++;
            }
            if (t3 != null && !t3.iscompleted()) 
            {
                count++;
            }
            if (t4 != null && !t4.iscompleted()) 
            {
                count++;
            }
            if (t5 != null && !t5.iscompleted()) 
            {
                count++;
            }
            
            return count;
        }

        public int getCompletedTicketsTotalPoint() {
            int totalPoint = 0;
            if (t1 != null && t1.iscompleted()){
                totalPoint += t1.getpoint();
            } 
            if (t2 != null && t2.iscompleted()){
                totalPoint += t2.getpoint();
            } 
            if (t3 != null && t3.iscompleted()){
                totalPoint += t3.getpoint();
            } 
            if (t4 != null && t4.iscompleted()){
                totalPoint += t4.getpoint();
            } 
            if (t5 != null && t5.iscompleted()) {
                totalPoint += t5.getpoint();
            }
            return totalPoint;
        }

         Q1 getEmployee(String employeeName) {
            if (emp1 != null && emp1.getfullname().equals(employeeName)) {
                return emp1;
            } else if (emp2 != null && emp2.getfullname().equals(employeeName)) {
                return emp2;
            }
            return null;
        }

        Ticket getTicket(int ticketId) {
            if (t1 != null && t1.getticketid() == ticketId) {
                return t1;
            } else if (t2 != null && t2.getticketid() == ticketId) {
                return t2;
            } else if (t3 != null && t3.getticketid() == ticketId) {
                return t3;
            } else if (t4 != null && t4.getticketid() == ticketId) {
                return t4;
            } else if (t5 != null && t5.getticketid() == ticketId) {
                return t5;
            }
            return null;
        }
    }


    public static void main(String[] args) {
        Helpdesk helpDesk = new Helpdesk();
        Q1 emp1 = new Q1("Alice Brown", 5, "Software");
        Q1 emp2 = new Q1("Bob Smith", 8, "Hardware");

        helpDesk.addEmployee(emp1, 1);
        helpDesk.addEmployee(emp2, 2);

        Ticket t1 = new Ticket(101, "Software issue", "Software", 4);
        Ticket t2 = new Ticket(102, "network issue", "Network", 7);
        Ticket t3 = new Ticket(103, "System crash", "Hardware", 10);
        Ticket t4 = new Ticket(104, "printer not working", "Hardware", 3);
        Ticket t5 = new Ticket(105, "blue screen error", "Software", 2);

        helpDesk.addTicket(t1, 1);
        helpDesk.addTicket(t2, 2);
        helpDesk.addTicket(t3, 3);
        helpDesk.addTicket(t4, 4);
        helpDesk.addTicket(t5, 5);

        helpDesk.completeTicket("Alice Brown", 101);
        helpDesk.completeTicket("Bob Smith", 102);
        helpDesk.completeTicket("Alice Brown", 103);
        helpDesk.completeTicket("Bob Smith", 104);
        helpDesk.completeTicket("Alice Brown", 105);

        System.out.println("Waiting ticket count: " + helpDesk.getWaitingTicketCount());
        System.out.println("Completed tickets total point: " + helpDesk.getCompletedTicketsTotalPoint());
    }
}