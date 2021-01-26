
package hospital;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Hospital {
    ArrayList<Doctor> doctors = new ArrayList<>();
    ArrayList<Patient> patients = new ArrayList<>();
    
    Hospital(){}
    Hospital(ArrayList<Doctor> docs, ArrayList<Patient> pats){
        docs.forEach((doc) -> {
            doctors.add(doc);
        });
        pats.forEach((pat) -> {
            patients.add(pat);
        });
    }
    
    public static void main(String[] args) {
        /*    Test 
        ArrayList<Doctor> doctorsMain = new ArrayList<Doctor>();
        ArrayList<Patient> patientsMain = new ArrayList<Patient>();
        Doctor Ahmed = new Doctor("ahmed","23", "sdfssdfsdfds", "010", "sfdf");
        Doctor MOhamed = new Doctor("Mohamed", "29907140100239", "5th settlemt area 6", "01065774962", "batna");
        NormalPatient mo = new NormalPatient("Mahmoud", "51555665", "dgfffd", "255", "male", " ", "    ", "      ");
        EmergencyPatient adsf = new EmergencyPatient("Mud", "51555665", "dgfffd", "255", "male", " ", "    ", "      ", "54");
        Hospital dsfs = new Hospital(doctorsMain, patientsMain);
        dsfs.addDoctor(Ahmed);
        dsfs.addDoctor(MOhamed);
        dsfs.addNormalPatient(mo);
        dsfs.addEmergencyPatient(adsf);
        dsfs.displayDoctors();
        dsfs.displayPatients();
        dsfs.deleteDoctor(Ahmed);
        dsfs.deletePatient(mo);
        System.out.println("                                ");
        dsfs.displayDoctors();
        dsfs.displayPatients(); */
    }
    
    void addDoctor(Doctor newDoctor)
    {
        doctors.add(newDoctor);
    }
    

    void deleteDoctor(Doctor doc)
    {
        doctors.remove(doc);
    }
    void displayDoctors()
    {
        doctors.forEach((doctor) -> {
            System.out.println("Name: "+doctor.getName()+" ,ID: "+doctor.getID()+" ,Address: "+doctor.getAddress()+" ,Phone Number: "
                    +doctor.getPhoneNumber()+" ,Specialty: " + doctor.getSpecialty());
        });
    }
    
    void addPatient (Patient newPatient)
    {
        patients.add(newPatient);
    }
    void deletePatient(Patient pat)
    {
        patients.remove(pat);
    }
    void displayPatients()
    {
        patients.forEach((patient) -> {
            System.out.println("Name: "+patient.getName()+" ,ID: "+patient.getID()+" ,Address: "+patient.getAddress()+" ,Phone Number: "
                    +patient.getPhoneNumber()+" ,Gender: " + patient.getGender()+" ,Symptoms: "+patient.getSymptoms()+
                    " ,Payment Method: "+patient.getPaymentMethod()+" ,Diagnosis: "+patient.getDiagnosis()+" ,Room Number: "+patient.getRoomNumber());
        });
    }
    void makeAppointment(Doctor doctor, Patient patient, Date date){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
        String strDate = dateFormat.format(date);  
        System.out.println(patient.getName() + "has reserved an appointment with Doctor " + doctor.getName() + " in specialty " + doctor.getSpecialty() + " at " + strDate);
    }
    
}

abstract class people {
    private String name;
    private String iD;
    private String address;
    private String phoneNumber;
    
    people(){};
    people(String name,String iD,String address,String phoneNumber)
    {
        this.name = name;
        this.iD = iD;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
    
    String getName(){
        return name;
    }
    String getID(){
        return iD;
    }
    String getAddress(){
        return address;
    }
    String getPhoneNumber(){
        return phoneNumber;
    }
    
    
    void setName(String newName){
        this.name = newName;
    }
    void setID(String newID){
        this.iD = newID;
    }
    void setAddress(String newAddress){
        this.address = newAddress;
    }
    void setPhoneNumber(String newNumber){
        this.phoneNumber = newNumber;
    }
}

class Doctor extends people{
    private String specialty;
    
    Doctor(){}
    Doctor(String name,String iD,String address,String phoneNumber, String specialty){
        super(name, iD, address, phoneNumber);
        this.specialty = specialty;
    }
    
    String getSpecialty(){
        return specialty;
    }
    
    void setSpecialty(String newSpecialty){
        this.specialty = newSpecialty;
    }
}

class Patient extends people
{
    private String gender ; 
    private String symptoms ;
    private String paymentMethod ;
    private String diagnosis ;
    private String roomNumber;
    
    Patient (){}
    Patient (String name,String iD,String address,String phoneNumber,String gender,String symptoms,String paymentMethod,String diagnosis, 
            String roomNumber)
    {
        super(name, iD, address, phoneNumber);
        this.diagnosis = diagnosis;
        this.gender = gender;
        this.paymentMethod = paymentMethod;
        this.symptoms = symptoms;
        this.roomNumber = roomNumber;        
    }
    
    String getGender()
    {
        return gender;
    }
    String getSymptoms()
    {
        return symptoms;
    }
    String getPaymentMethod()
    {
        return paymentMethod;
    }
    String getDiagnosis()
    {
        return diagnosis;
    }
  
    void setGender(String newGender)
    {
        this.gender = newGender;
    }
    void setSymptoms(String newSymptoms)
    {
        this.symptoms = newSymptoms;
    }
    void setPaymentMethod(String newPaymentMethod)
    {
        this.paymentMethod = newPaymentMethod;
    }
    void setDiagnosis(String newDiagnosis)
    {
        this.diagnosis = newDiagnosis;
    }
    String getRoomNumber()
    {
        return roomNumber;
    }
    void setRoomNumber(String newRoomNumber)
    {
        this.roomNumber = newRoomNumber;
    }
}


class EmergencyPatient extends Patient
{
    EmergencyPatient(){}
    EmergencyPatient(String name,String iD,String address,String phoneNumber,String gender,String symptoms,String paymentMethod,String diagnosis,
            String roomNumber)
    {
        super(name, iD, address, phoneNumber,gender,symptoms,paymentMethod,diagnosis, roomNumber);            
    }
}
class NormalPatient extends Patient
{
    NormalPatient(){}
    NormalPatient(String name,String iD,String address,String phoneNumber,String gender,String symptoms,String paymentMethod,String diagnosis)
    {
        super(name, iD, address, phoneNumber,gender,symptoms,paymentMethod,diagnosis,"");          
    }  
}