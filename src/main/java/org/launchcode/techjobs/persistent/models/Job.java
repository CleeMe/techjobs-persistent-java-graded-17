package org.launchcode.techjobs.persistent.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Job extends AbstractEntity {

    @ManyToOne
    private Employer employer;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "job_skill",
            joinColumns = @JoinColumn(name = "job_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id")
    )
    private List<Skill> skills;

    public Job(String name, Employer employer, List<Skill> skills) {
        super();
        this.setName(name);
        this.employer = employer;
        this.skills = skills;
    }

//    Slash is this where I am supposed do SOMETHING!??!?! I am trying to read this
//    error I have tried job, name and now  new Job to match the test...  I am sooooo lost hahaha
//    public Job getJob() {
//        return new Job();
//    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        if (this.employer != null) {
            this.employer.getJobs().remove(this);
        }
        this.employer = employer;
        if (employer != null) {
            employer.getJobs().add(this);
        }
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    // Additional method to add a single skill to the job
    public void addSkill(Skill skill) {
        this.skills.add(skill);
    }

    // Additional method to remove a single skill from the job
    public void removeSkill(Skill skill) {
        this.skills.remove(skill);
    }
}