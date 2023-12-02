--Part 1
ID - int
Employer - string
Name - string
Skills - string
--Part 2
SELECT name, location
FROM employer
WHERE location = "St. Louis City";

--Part 3
DROP TABLE job;

--Part 4

SELECT *
FROM skill
LEFT JOIN job_skills ON skill.id = job_skills.skills.id
WHERE job_skills.jobs.id IS NOT NULL
ORDER BY name ASC;
