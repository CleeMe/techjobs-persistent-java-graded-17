package org.launchcode.techjobs.persistent.models;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class Job extends AbstractEntity {

    @ManyToOne
    @JoinColumn (name = "employer_id")
    private Employer employer;

    @ManyToMany
    @JoinTable(
            name = "job_skill",
            joinColumns = @JoinColumn(name = "job_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id")
    )
    private List<Skill> skills;

    public Job() {
    }

    public Job(String name, Employer employer, List<Skill> skills) {
        super();
        this.setName(name);
        this.employer = employer;
        this.skills = skills;
    }

    public Job(Employer employer, List<Skill> skills) {
        super();
        this.employer = employer;
        this.skills = skills;
    }
    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
        employer.addJob(this);
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