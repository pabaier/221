 public class HW4Tests {
    public static class ConstructorTest extends TemplateMethod {
        
        public ConstructorTest() {
            super("Constructor Test");
        }

        public int[] testMethod() {
            // {score, out of}
            // correct answer generates 100 + max score
            int[] result = {0,5};
            System.out.print("\t\tConstructing...");
            try {
                Appointment a = new Appointment(new CalendarDate(2016, 2, 2), new Employee("John"));
                result[0] = 100 + result[1];
            }
            catch(Exception e) {
                result[0] = 404;
            }
            return result;
        }
    }

    public static class GetEmployeeTest extends TemplateMethod {

        public GetEmployeeTest() {
            super("getEmployee()");
        }

        public int[] testMethod() {
            // {score, out of}
            // correct answer generates 100 + max score
            int[] result = {0,5};

            AppointmentKey key = new AppointmentKey(new CalendarDate(2016, 2, 2),  new Employee("John"));
            try {
                Appointment student = new Appointment(key.getDate(), key.getEmployee());
                System.out.print("\t\t" + key.getEmployee() + " | " + student.getEmployee());
                if(student.getEmployee() == key.getEmployee())
                    result[0] = 100 + result[1];
                else
                    result[0] = (int)(result[1] /  2.0 + 0.5);
            }
            catch(Exception e) {
                result[0] = 404;
            }
            return result;
        }
    }

    public static class ToStringAptTest extends TemplateMethod {

        public ToStringAptTest() {
            super("toString()");
        }

        public int[] testMethod() {
            // {score, out of}
            // correct answer generates 100 + max score
            int[] result = {0,5};

            AppointmentKey key = new AppointmentKey(new CalendarDate(1762, 9, 12),  new Employee("Yekaterina Alekseyevna"));
            try {
                Appointment student = new Appointment(key.getDate(), key.getEmployee());
                String studentAnswer = student.toString().toUpperCase();
                System.out.print("\t\t" + key + " | " + student);
                if(studentAnswer.contains(key.getDate().toString().toUpperCase()) &&
                studentAnswer.contains(key.getEmployee().getName().toUpperCase())) {
                    result[0] = 100 + result[1];
                }
                else if(studentAnswer.contains(key.getDate().toString().toUpperCase())) {
                    result[0] = (int)(result[1] /  2.0 + 0.5);
                }
                else if(studentAnswer.contains(key.getEmployee().getName().toUpperCase())) {
                    result[0] = (int)(result[1] /  2.0 + 0.5);
                }
            }
            catch(Exception e) {
                result[0] = 404;
            }

            return result;
        }
    }

    public static class GetDateTest extends TemplateMethod {

        public GetDateTest() {
            super("getDate()");
        }

        public int[] testMethod() {
            // {score, out of}
            // correct answer generates 100 + max score
            int[] result = {0,5};

            AppointmentKey key = new AppointmentKey(new CalendarDate(2016, 2, 2),  new Employee("John"));
            try {
                Appointment student = new Appointment(key.getDate(), key.getEmployee());
                System.out.print("\t\t" + key.getDate() + " | " + student.getDate());

                if(student.getDate() == key.getDate())
                    result[0] = 100 + result[1];
                else
                    result[0] = (int)(result[1] / 2.0 + 0.5);
            }
            catch(Exception e) {
                result[0] = 404;
            }

            return result;
        }
    }
 }