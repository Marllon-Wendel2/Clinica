create table consults(

    id bigint not null auto_increment,
    doctor_id bigint not null,
    patient_id bigint not null,
    data datetime not null,

    primary key(id),
    constraint fk_consults_doctor_id foreign key(doctor_id) references doctors(id),
    constraint fk_consults_patient_id foreign key(patient_id) references patient(id)

);