package com.app.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "singer_audit")
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name =  "ID")
    private Long  id;

    @Column(name =  "FIRST_NAME")
    private String firstName;

    @Column(name =  "LAST_NAME")
    private  String  lastName;

    @Temporal(TemporalType.DATE)
    @Column(name =  "BIRTH_DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
    private Date birthDate;

    @Column(name = "DEP")
    private  String dep;

    @Column(name = "SALARY")
    private  double salary;

    @Version
    @Column(name =  "VERSION")
    private int version;

    @CreatedDate
    @Column(name =  "CREATED_DATE")
    @Temporal(TemporalType.TIMESTAMP)

    private Date   createdDate;

    @CreatedBy
    @Column(name = "CREATED_BY")
    private  String createdBy;

    @LastModifiedBy
    @Column(name =  "LAST_MODIFIED_BY")
    private String lastModifiedBy;

    @LastModifiedDate
    @Column(name =  "LAST_MODIFIED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date   lastModifiedDate;

}
