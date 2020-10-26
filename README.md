# COVIDSafe
This is a repository for ELEC5619 project.

## Doctor:
### Account Management for Doctor
1. Register: the system should allow doctor to register
2. Login: common login page with option to switch role (doctor or patient)
3. View & change profile page: list the user information such as ID, name, gender, avatar, with a button available to change profile
4. Logout: a button in main pages which enables the user to logout
### Appointment Management for Doctor (Kexin Li)
1. Appointment page: a place where doctors can view the list of incoming appointment requests with details
2. Confirm Appointment: doctors can confirm an appointment.
3. Cancel Appointment: doctors can cancel an appointment.
### Monitoring for Patients’ Conditions ( Yuan Yao & Qiang Qu)
#### Dashboard (Yuan Yao)
1. Pie chart showing ratio of positive/quarantining: doctor can view a data visualisation of the analysis of the all patients based on status
2. Top five patients who got the oldest last test time: doctor can view a list of the names of required patients
3. Top five patients who has the most temperature change: doctor can view a list of the names of required patients
4. Highlight list of patients who has some new conditions: doctor can view a list of the names of required patients
5. To-do list: a supportive tool for doctor to set daily goals (one-time use)
#### Patient List (Yuan Yao): doctor can view a list of patients which shows ID, name, gender, age, state, and quarantining duration. Doctors can also add new patients or remove existing patients.
#### Patient Detail (Qiang Qu)
1. Basic information: doctor can view a list of the basic information about the patient including ID, first name, last name, gender, height, weight, phone number, full address, and emergency contact.
2. Medical details
3. Mix of line and bar chart of daily temperature: doctor can view data visualisation of temperature
4. Table of conditions: doctor can view data visualization of conditions
5. Others: doctor can view other information including last test time, isolation time, daily medication, temperature change
6. Notify a patient to make an appointment with the doctor: if the doctor thinks it is necessary to have an appointment, he/she can click a button in the page which will send a notification email to the patient.
## Patient:
### Account Management for Patient (Qiangyu Zheng）
1. Register：All patients are required to register for an account with name, gender, age, height, weight, phone number, email address, emergency contacts, and other pertinent information before they intend to be tested.
2. Login：The login feature allows patients to login the system. Patients need to provide their email address and corresponding password. After logging in, patients can make appointments and other functions.
3. View & Change profile page: All registered patients will have a personal information screen where they can check their ID and the information they have previously filled in when they registered at any time. If any information is found to be incorrectly filled in, it can be changed here.
4. Logout: Patients can logout from the website at any time.
### Appointment Management for Patient (WeiPeng Cui)
1. Request Appointment: Patients can schedule an appointment for nucleic acid testing as often as they need or schedule a meeting with their doctor if there are any unexpected circumstances that need to be confirmed in person.
2. Cancel Pending Appointment: If a previously scheduled time conflicts, the patient can actively cancel prior to the appointment and wait to schedule the next time.
### Daily check-in (Shuyao Ma)
1. Temperature: Patients are required to take the temperature every day according to the method taught at the hospital and upload it to the specified area on their own.
2. Position: Patients also need to record their current location information daily, their room number for uniform isolation and their full address for home isolation
3. Physical condition: In addition to basic information, patients are asked to answer the following questions about their health on a daily basis
 Did patients feel like vomiting the last day
 Did patients feel cold the last day
Did patients feel dizzy the last day
Did patients feel nauseous the last day
Did patients have running noses the last  day
Did patients have any shortness of breath the last day

