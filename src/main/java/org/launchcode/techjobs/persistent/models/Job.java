package org.launchcode.techjobs.persistent.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Job extends AbstractEntity {

    @ManyToOne
    private Employer employer;

    @ManyToMany
    private List<Skill> skills = new ArrayList<>();

    public Job(Employer employer, List<Skill> skills) {
        super(employer, skills);
        this.employer = employer;
        this.skills = skills;
    }

    public Job() {
        super();
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
       this.employer = employer;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

//    // Additional method to add a single skill to the job
//    public void addSkill(Skill skill) {
//        this.skills.add(skill);
//    }
//
//    // Additional method to remove a single skill from the job
//    public void removeSkill(Skill skill) {
//        this.skills.remove(skill);
//    }
}