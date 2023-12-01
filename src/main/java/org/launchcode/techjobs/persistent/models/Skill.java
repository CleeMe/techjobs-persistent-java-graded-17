package org.launchcode.techjobs.persistent.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.Size;

@Entity
public class Skill extends AbstractEntity {


    @Size(max = 500, message = "Description too long!")
   private String description;

    @ManyToMany (mappedBy = "skills")
    private List<Job> jobs;


    public Skill()  {}

    public String getDescription() {return description;}

    public void setDescription(String description)  {this.description = description;}

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs (List<Job> jobs) {
        this.jobs = jobs;
    }


}
