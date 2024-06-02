package com.ecesarkin.salarydatacase.entity;

import jakarta.persistence.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Entity
public class Entry implements Comparable {
    private static long nextId = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long Id;
    public String Timestamp;
    public String EmploymentType;
    public String CompanyName;
    public String CompanySize;
    public String PrimaryLocationCountry;
    public String PrimaryLocationCity;
    public String IndustryInCompany;
    public String CompanyType;
    public String YearsExperienceInIndustry;
    public String YearsExperienceInCurrentCompany;
    public String JobTitle;
    public String JobLadder;
    public String JobLevel;
    public String RequiredHoursPerWeek;
    public String ActualHoursPerWeek;
    public String HighestLevelOfEducationCompleted;
    public String TotalBaseSalary;
    public String TotalBonus;
    public String TotalStockOptions;
    public String IsHealthInsuranceOffered;
    public String PTOAnnualInWeeks;
    public String HappyAtCurrentPosition;
    public String WillResignInAYear;
    @Column(length = 1024)
    public String ReflectionOnFutureOfIndustry;
    public String Gender;
    @Column(length = 1024)
    public String ReflectionOnNecessarySkillsInIndustryInTenYears;
    public String BootcampExperience;

    public Entry() {

    }

    public Entry(
            String timestamp,
            String employmentType,
            String companyName,
            String companySize,
            String countryPrimaryLocation,
            String cityPrimaryLocation,
            String industryInCompany,
            String publicOrPrivate,
            String yearsExperienceInIndustry,
            String yearsExperienceInCompany,
            String jobTitle,
            String jobLadder,
            String jobLevel,
            String requiredHoursPerWeek,
            String actualHoursPerWeek,
            String highestLevelOfEducationCompleted,
            String totalBaseSalary,
            String totalBonus,
            String totalStockOptions,
            String isHealthInsuranceOffered,
            String ptoAnnualInWeeks,
            String happyAtCurrentPosition,
            String willResignInAYear,
            String reflectionOnFutureOfIndustry,
            String gender,
            String reflectionOnNecessarySkillsInIndustryInTenYears,
            String bootcampExperience
                 ) {
        this.Id = nextId;
        nextId++;

        this.Timestamp = timestamp;
        this.EmploymentType = employmentType;
        this.CompanyName = companyName;
        this.CompanySize = companySize;
        this.PrimaryLocationCountry = countryPrimaryLocation;
        this.PrimaryLocationCity = cityPrimaryLocation;
        this.IndustryInCompany = industryInCompany;
        this.CompanyType = publicOrPrivate;
        this.YearsExperienceInIndustry = yearsExperienceInIndustry;
        this.YearsExperienceInCurrentCompany = yearsExperienceInCompany;
        this.JobTitle = jobTitle;
        this.JobLadder = jobLadder;
        this.JobLevel = jobLevel;
        this.RequiredHoursPerWeek = requiredHoursPerWeek;
        this.ActualHoursPerWeek = actualHoursPerWeek;
        this.HighestLevelOfEducationCompleted = highestLevelOfEducationCompleted;
        this.TotalBaseSalary = totalBaseSalary;
        this.TotalBonus = totalBonus;
        this.TotalStockOptions = totalStockOptions;
        this.IsHealthInsuranceOffered = isHealthInsuranceOffered;
        this.PTOAnnualInWeeks = ptoAnnualInWeeks;
        this.HappyAtCurrentPosition = happyAtCurrentPosition;
        this.WillResignInAYear = willResignInAYear;
        this.ReflectionOnFutureOfIndustry = reflectionOnFutureOfIndustry;
        this.Gender = gender;
        this.ReflectionOnNecessarySkillsInIndustryInTenYears = reflectionOnNecessarySkillsInIndustryInTenYears;
        this.BootcampExperience = bootcampExperience;




    }

    @Override
    public int compareTo(Object o) {
        Entry item = (Entry) o;
        if (item.Id < this.Id) {
            return -1;
        }
        else if (item.Id == this.Id) {
            return 1;
        }
        return 0;
    }

    public String getCompanyName() {
        return this.CompanyName;
    }

    public int getCompanySizeMinValue() {
        if(this.CompanySize.contains("+")) {
            return Integer.parseInt(this.CompanySize.replace("+", "").replace(",", ""));
        }
        else {
            return Integer.parseInt(this.CompanySize.split("-")[0].replace(",", ""));
        }
    }

    public String getEmploymentType() {
        return this.EmploymentType;
    }

    public String getIndustryInCompany(){
        return this.IndustryInCompany;
    }

    public int getYearsExperienceIndustryMin() {
        if(this.YearsExperienceInIndustry.contains("+")) {
            return Integer.parseInt(this.YearsExperienceInIndustry.replace("+", "").replace(",", ""));
        }
        else {
            return Integer.parseInt(this.YearsExperienceInIndustry.split("-")[0]);
        }
    }
    public int getYearsExperienceCompanyMin() {
        if(this.YearsExperienceInCurrentCompany.contains("+")) {
            return Integer.parseInt(this.YearsExperienceInCurrentCompany.replace("+", "").replace(",", ""));
        }
        else {
            return Integer.parseInt(this.YearsExperienceInCurrentCompany.split("-")[0]);
        }
    }

    public String getJobTitle(){
        return this.JobTitle;
    }
    public String getJobLadder(){
        return this.JobLadder;
    }

    public String getJobLevel(){
        return this.JobLevel;
    }

    public int getRequiredHoursPerWeekMin() {
        if(this.RequiredHoursPerWeek.contains("+")) {
            return Integer.parseInt(this.RequiredHoursPerWeek.replace("+", "").replace(",", ""));
        }
        else {
            return Integer.parseInt(this.RequiredHoursPerWeek.split("-")[0]);
        }
    }

    public int getActualHoursPerWeekMin() {
        if(this.ActualHoursPerWeek.contains("+")) {
            return Integer.parseInt(this.RequiredHoursPerWeek.replace("+", "").replace(",", ""));
        }
        else {
            return Integer.parseInt(this.RequiredHoursPerWeek.split("-")[0]);
        }
    }

    public String getHighestLevelOfEducationCompleted() {
        return this.HighestLevelOfEducationCompleted;
    }

    public int getTotalBaseSalary() {
        return Integer.parseInt(this.TotalBaseSalary);
    }
    public int getTotalBonus() {
        return Integer.parseInt(this.TotalBonus);
    }
    public int getTotalStockOptions() {
        return Integer.parseInt(this.TotalStockOptions);
    }
    public String getIsHealthInsuranceOffered() {
        return this.IsHealthInsuranceOffered;
    }
    public int getPTOAnnualInWeek () {
        if(this.PTOAnnualInWeeks.equals("6+")) {
            return 6;
        }
        else {
            return Integer.parseInt(this.PTOAnnualInWeeks);
        }
    }

    public String getGender() {
        return this.Gender;
    }
    public String getCompanyType() {
        return this.CompanyType;
    }
    public String getCountryCode() {
        String regex = "\\(([^)]+)\\)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(this.PrimaryLocationCountry);

        if(matcher.find()) {
            return matcher.group(1);
        }
        return "";
    }
}
