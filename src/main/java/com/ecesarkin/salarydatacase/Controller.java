package com.ecesarkin.salarydatacase;

import com.ecesarkin.salarydatacase.entity.Entry;
import com.ecesarkin.salarydatacase.services.CSVService;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

@RestController
public class Controller {

    @Autowired
    private CSVService csvService;

    @GetMapping("/compensation_data")
    public Map<String,Object> getFiltered(
            @RequestParam(required = false, name = "company_size[gte]") Integer companySizeGte,
            @RequestParam(required = false, name = "company_size[lte]") Integer companySizeLte,
            @RequestParam(required = false, name = "company_name") String companyName,
            @RequestParam(required = false, name = "employment_type") String employmentType,
            @RequestParam(required = false, name = "company_industry") String companyIndustry,
            @RequestParam(required = false, name = "company_type") String company_type,
            @RequestParam(required = false, name = "years_experience_industry[gte]") Integer yearsExperienceIndustryGte,
            @RequestParam(required = false, name = "years_experience_industry[lte]") Integer yearsExperienceIndustryLte,
            @RequestParam(required = false, name = "years_experience_company[gte]") Integer yearsExperienceCompanyGte,
            @RequestParam(required = false, name = "years_experience_company[lte]") Integer yearsExperienceCompanyLte,
            @RequestParam(required = false, name = "job_title") String jobTitle,
            @RequestParam(required = false, name = "job_ladder") String jobLadder,
            @RequestParam(required = false, name = "job_level") String jobLevel,
            @RequestParam(required = false, name = "education_level") String educationLevel,
            @RequestParam(required = false, name = "required_hours_per_week[lte]") Integer requiredHoursPerWeekLte,
            @RequestParam(required = false, name = "required_hours_per_week[gte]") Integer requiredHoursPerWeekGte,
            @RequestParam(required = false, name = "actual_hours_per_week[lte]") Integer actualHoursPerWeekLte,
            @RequestParam(required = false, name = "actual_hours_per_week[gte]") Integer actualHoursPerWeekGte,
            @RequestParam(required = false, name = "salary[lte]") Integer salaryLte,
            @RequestParam(required = false, name = "salary[gte]") Integer salaryGte,
            @RequestParam(required = false, name = "bonus[lte]") Integer bonusLte,
            @RequestParam(required = false, name = "bonus[gte]") Integer bonusGte,
            @RequestParam(required = false, name = "stockOption[lte]") Integer stockOptionLte,
            @RequestParam(required = false, name = "stockOption[gte]") Integer stockOptionGte,
            @RequestParam(required = false, name = "pto_weeks[lte]") Integer ptoWeeksLte,
            @RequestParam(required = false, name = "pto_weeks[gte]") Integer ptoWeeksGte,
            @RequestParam(required = false, name = "health_insurance") boolean healthInsurance,
            @RequestParam(required = false, name = "gender") String gender,
            @RequestParam(required = false, name = "sort") String sort
    ) {
        List<Entry> allEntries = csvService.getAllEntries();
        List<Entry> result = new ArrayList<>();
        if (companySizeGte != null) {
            for (Entry e : allEntries) {
                if(e.CompanySize.contains("+")) {
                    int min = Integer.parseInt(e.CompanySize.replace("+", "").replace(",", ""));
                    if (min >= companySizeGte) {
                        result.add(e);
                    }
                }
                else {
                    int max = Integer.parseInt(e.CompanySize.split("-")[1].replace(",", ""));
                    if (max >= companySizeGte) {
                        result.add(e);
                    }
                }
            }
            allEntries = new ArrayList<>(result);
            result = new ArrayList<>();
        }
        if (companySizeLte != null) {
            for (Entry e : allEntries) {
                if(e.CompanySize.contains("+")) {
                    int min = Integer.parseInt(e.CompanySize.replace("+", "").replace(",", ""));
                    if (min <= companySizeLte) {
                        result.add(e);
                    }
                }
                else {
                    int min = Integer.parseInt(e.CompanySize.split("-")[0].replace(",", ""));
                    if (min <= companySizeLte) {
                        result.add(e);
                    }
                }
            }
            allEntries = new ArrayList<>(result);
            result = new ArrayList<>();
        }
        if(companyName != null && !companyName.isEmpty()) {
            for (Entry e : allEntries) {
                if(e.CompanyName.toLowerCase().contains(companyName.toLowerCase())) {
                    result.add(e);
                }
            }
            allEntries = new ArrayList<>(result);
            result = new ArrayList<>();
        }
        if(employmentType != null && !employmentType.isEmpty()) {
            for (Entry e : allEntries) {
                if(e.EmploymentType.toLowerCase().replace("-","").contains(employmentType.replace("-","").toLowerCase())) {
                    result.add(e);
                }
            }
            allEntries = new ArrayList<>(result);
            result = new ArrayList<>();
        }
        if(companyIndustry != null && !companyIndustry.isEmpty()) {
            for (Entry e : allEntries) {
                if(e.IndustryInCompany.toLowerCase().replace("-","").contains(companyIndustry.replace("-","").toLowerCase())) {
                    result.add(e);
                }
            }
            allEntries = new ArrayList<>(result);
            result = new ArrayList<>();
        }
        if(company_type != null && !company_type.isEmpty()) {
            for (Entry e : allEntries) {
                if (e.CompanyType.toLowerCase().replace("-", "").contains(company_type.replace("-", "").toLowerCase())) {
                    result.add(e);
                }
            }
            allEntries = new ArrayList<>(result);
            result = new ArrayList<>();
        }
        if (yearsExperienceCompanyGte != null) {
            for (Entry e : allEntries) {
                if(e.YearsExperienceInCurrentCompany.contains("+")) {
                    int min = Integer.parseInt(e.YearsExperienceInCurrentCompany.replace("+", "").replace(",", ""));
                    if (min >= yearsExperienceCompanyGte) {
                        result.add(e);
                    }
                }
                else {
                    int max = Integer.parseInt(e.YearsExperienceInCurrentCompany.split("-")[1].replace(",", ""));
                    if (max >= yearsExperienceCompanyGte) {
                        result.add(e);
                    }
                }
            }
            allEntries = new ArrayList<>(result);
            result = new ArrayList<>();
        }
        if (yearsExperienceCompanyLte != null) {
            for (Entry e : allEntries) {
                if(e.YearsExperienceInCurrentCompany.contains("+")) {
                    int min = Integer.parseInt(e.YearsExperienceInCurrentCompany.replace("+", "").replace(",", ""));
                    if (min <= yearsExperienceCompanyLte) {
                        result.add(e);
                    }
                }
                else {
                    int min = Integer.parseInt(e.YearsExperienceInCurrentCompany.split("-")[0].replace(",", ""));
                    if (min <= yearsExperienceCompanyLte) {
                        result.add(e);
                    }
                }
            }
            allEntries = new ArrayList<>(result);
            result = new ArrayList<>();
        }
        if (yearsExperienceIndustryGte != null) {
            for (Entry e : allEntries) {
                if(e.YearsExperienceInIndustry.contains("+")) {
                    int min = Integer.parseInt(e.YearsExperienceInIndustry.replace("+", "").replace(",", ""));
                    if (min >= yearsExperienceIndustryGte) {
                        result.add(e);
                    }
                }
                else {
                    int max = Integer.parseInt(e.YearsExperienceInIndustry.split("-")[1].replace(",", ""));
                    if (max >= yearsExperienceIndustryGte) {
                        result.add(e);
                    }
                }
            }
            allEntries = new ArrayList<>(result);
            result = new ArrayList<>();
        }
        if (yearsExperienceIndustryLte != null) {
            for (Entry e : allEntries) {
                if(e.YearsExperienceInIndustry.contains("+")) {
                    int min = Integer.parseInt(e.YearsExperienceInIndustry.replace("+", "").replace(",", ""));
                    if (min <= yearsExperienceIndustryLte) {
                        result.add(e);
                    }
                }
                else {
                    int min = Integer.parseInt(e.YearsExperienceInIndustry.split("-")[0].replace(",", ""));
                    if (min <= yearsExperienceIndustryLte) {
                        result.add(e);
                    }
                }
            }
            allEntries = new ArrayList<>(result);
            result = new ArrayList<>();
        }
        if(jobTitle != null && !jobTitle.isEmpty()) {
            for (Entry e : allEntries) {
                if(e.JobTitle.toLowerCase().replace("-","").contains(jobTitle.replace("-","").toLowerCase())) {
                    result.add(e);
                }
            }
            allEntries = new ArrayList<>(result);
            result = new ArrayList<>();
        }
        if(jobLadder != null && !jobLadder.isEmpty()) {
            for (Entry e : allEntries) {
                if(e.JobLadder.toLowerCase().replace("-","").contains(jobLadder.replace("-","").toLowerCase())) {
                    result.add(e);
                }
            }
            allEntries = new ArrayList<>(result);
            result = new ArrayList<>();
        }
        if(jobLevel != null && !jobLevel.isEmpty()) {
            for (Entry e : allEntries) {
                if(e.JobLevel.toLowerCase().replace("-","").contains(jobLevel.replace("-","").toLowerCase())) {
                    result.add(e);
                }
            }
            allEntries = new ArrayList<>(result);
            result = new ArrayList<>();
        }
        if(educationLevel != null && !educationLevel.isEmpty()) {
            for (Entry e : allEntries) {
                if(e.HighestLevelOfEducationCompleted.toLowerCase().replace("-","").contains(educationLevel.replace("-","").toLowerCase())) {
                    result.add(e);
                }
            }
            allEntries = new ArrayList<>(result);
            result = new ArrayList<>();
        }



        if (requiredHoursPerWeekGte != null) {
            for (Entry e : allEntries) {
                if(e.RequiredHoursPerWeek.contains("+")) {
                    int min = Integer.parseInt(e.RequiredHoursPerWeek.replace("+", "").replace(",", ""));
                    if (min >= requiredHoursPerWeekGte) {
                        result.add(e);
                    }
                }
                else {
                    int max = Integer.parseInt(e.RequiredHoursPerWeek.split("-")[1].replace(",", ""));
                    if (max >= requiredHoursPerWeekGte) {
                        result.add(e);
                    }
                }
            }
            allEntries = new ArrayList<>(result);
            result = new ArrayList<>();
        }
        if (requiredHoursPerWeekLte != null) {
            for (Entry e : allEntries) {
                if(e.YearsExperienceInIndustry.contains("+")) {
                    int min = Integer.parseInt(e.RequiredHoursPerWeek.replace("+", "").replace(",", ""));
                    if (min <= requiredHoursPerWeekLte) {
                        result.add(e);
                    }
                }
                else {
                    int min = Integer.parseInt(e.RequiredHoursPerWeek.split("-")[0].replace(",", ""));
                    if (min <= requiredHoursPerWeekLte) {
                        result.add(e);
                    }
                }
            }
            allEntries = new ArrayList<>(result);
            result = new ArrayList<>();
        }
        if (actualHoursPerWeekGte != null) {
            for (Entry e : allEntries) {
                if(e.ActualHoursPerWeek.contains("+")) {
                    int min = Integer.parseInt(e.ActualHoursPerWeek.replace("+", "").replace(",", ""));
                    if (min >= actualHoursPerWeekGte) {
                        result.add(e);
                    }
                }
                else {
                    int max = Integer.parseInt(e.ActualHoursPerWeek.split("-")[1].replace(",", ""));
                    if (max >= actualHoursPerWeekGte) {
                        result.add(e);
                    }
                }
            }
            allEntries = new ArrayList<>(result);
            result = new ArrayList<>();
        }
        if (actualHoursPerWeekLte != null) {
            for (Entry e : allEntries) {
                if(e.ActualHoursPerWeek.contains("+")) {
                    int min = Integer.parseInt(e.ActualHoursPerWeek.replace("+", "").replace(",", ""));
                    if (min <= actualHoursPerWeekLte) {
                        result.add(e);
                    }
                }
                else {
                    int min = Integer.parseInt(e.ActualHoursPerWeek.split("-")[0].replace(",", ""));
                    if (min <= actualHoursPerWeekLte) {
                        result.add(e);
                    }
                }
            }
            allEntries = new ArrayList<>(result);
            result = new ArrayList<>();
        }

        if (salaryGte != null) {
            for (Entry e : allEntries) {
                int salary = Integer.parseInt(e.TotalBaseSalary);
                if (salary >= salaryGte) {
                    result.add(e);
                }

            }
            allEntries = new ArrayList<>(result);
            result = new ArrayList<>();
        }
        if (salaryLte != null) {
            for (Entry e : allEntries) {
                int salary = Integer.parseInt(e.TotalBaseSalary);
                if (salary <= salaryLte) {
                    result.add(e);
                }
            }
            allEntries = new ArrayList<>(result);
            result = new ArrayList<>();
        }


        if (bonusGte != null) {
            for (Entry e : allEntries) {
                int salary = Integer.parseInt(e.TotalBonus);
                if (salary >= bonusGte) {
                    result.add(e);
                }
            }
            allEntries = new ArrayList<>(result);
            result = new ArrayList<>();
        }
        if (bonusLte != null) {
            for (Entry e : allEntries) {
                int salary = Integer.parseInt(e.TotalBonus);
                if (salary <= bonusLte) {
                    result.add(e);
                }
            }
            allEntries = new ArrayList<>(result);
            result = new ArrayList<>();
        }


        if (stockOptionGte != null) {
            for (Entry e : allEntries) {
                int salary = Integer.parseInt(e.TotalStockOptions);
                if (salary >= stockOptionGte) {
                    result.add(e);
                    }
            }
            allEntries = new ArrayList<>(result);
            result = new ArrayList<>();
        }
        if (stockOptionLte != null) {
            for (Entry e : allEntries) {
                int salary = Integer.parseInt(e.TotalStockOptions);
                if (salary <= stockOptionLte) {
                    result.add(e);
                }
            }
            allEntries = new ArrayList<>(result);
            result = new ArrayList<>();
        }
        if (ptoWeeksGte != null) {
            for (Entry e : allEntries) {
                if(e.PTOAnnualInWeeks.contains("+")) {
                    int min = Integer.parseInt(e.PTOAnnualInWeeks.replace("+", "").replace(",", ""));
                    if (min >= ptoWeeksGte) {
                        result.add(e);
                    }
                }
                else {
                    int value = Integer.parseInt(e.PTOAnnualInWeeks);
                    if (value >= ptoWeeksGte) {
                        result.add(e);
                    }
                }
            }
            allEntries = new ArrayList<>(result);
            result = new ArrayList<>();
        }
        if (ptoWeeksLte != null) {
            for (Entry e : allEntries) {
                if(e.PTOAnnualInWeeks.contains("+")) {
                    int min = Integer.parseInt(e.PTOAnnualInWeeks.replace("+", "").replace(",", ""));
                    if (min <= ptoWeeksLte) {
                        result.add(e);
                    }
                }
                else {
                    int value = Integer.parseInt(e.PTOAnnualInWeeks);
                    if (value <= ptoWeeksLte) {
                        result.add(e);
                    }
                }
            }
            allEntries = new ArrayList<>(result);
            result = new ArrayList<>();
        }


        if(healthInsurance) {
            for (Entry e : allEntries) {
                if(e.IsHealthInsuranceOffered.equals("Yes")) {
                    result.add(e);
                }
            }
            allEntries = new ArrayList<>(result);
            result = new ArrayList<>();
        }

        if(gender != null && !gender.isEmpty()) {
            for (Entry e : allEntries) {
                if(e.Gender.equalsIgnoreCase(gender)) {
                    result.add(e);
                }
            }
            allEntries = new ArrayList<>(result);
            result = new ArrayList<>();
        }

        if(sort != null && !sort.isEmpty()) {
            allEntries = sortBy(allEntries, sort);
        }

        HashMap<String, Object> map = new HashMap<>();
        map.put("Items", allEntries);
        return map;
    }

    @GetMapping("/compensation_data/get_item")
    public Entry getEntry(
            @RequestParam(name = "employment_type") String employmentType,
            @RequestParam(name = "company_name") String companyName,
            @RequestParam(name = "country") String country,
            @RequestParam(name = "city") String city,
            @RequestParam(name = "company_industry") String industry
            ) {
        List<Entry> allEntries = csvService.getAllEntries();

        for (Entry e : allEntries) {
            if(
                    e.getEmploymentType().replace("-","").equalsIgnoreCase(employmentType.replace("-",""))
                            && e.getCompanyName().equalsIgnoreCase(companyName)
                            && e.getCountryCode().equalsIgnoreCase(country)
                            && e.PrimaryLocationCity.equalsIgnoreCase(city)
                            && e.getIndustryInCompany().equalsIgnoreCase(industry)) {
                return e;
            }
        }
        return null;

    }

    public List<Entry> sortBy(List<Entry> list, String sortKey) {
        switch (sortKey) {
            case "company_size":
                list.sort(Comparator.comparing(Entry::getCompanySizeMinValue));
                break;
            case "company_name":
                list.sort(Comparator.comparing(Entry::getCompanyName));
                break;
            case "employment_type":
                list.sort(Comparator.comparing(Entry::getEmploymentType));
                break;
            case "company_industry":
                list.sort(Comparator.comparing(Entry::getIndustryInCompany));
                break;
            case "company_type":
                list.sort(Comparator.comparing(Entry::getCompanyType));
                break;
            case "years_experience_industry":
                list.sort(Comparator.comparing(Entry::getYearsExperienceIndustryMin));
                break;
            case "years_experience_company":
                list.sort(Comparator.comparing(Entry::getYearsExperienceCompanyMin));
                break;
            case "job_title":
                list.sort(Comparator.comparing(Entry::getJobTitle));
                break;
            case "job_ladder":
                list.sort(Comparator.comparing(Entry::getJobLadder));
                break;
            case "job_level":
                list.sort(Comparator.comparing(Entry::getJobLevel));
                break;
            case "education_level":
                list.sort(Comparator.comparing(Entry::getHighestLevelOfEducationCompleted));
                break;
            case "required_hours_per_week":
                list.sort(Comparator.comparing(Entry::getRequiredHoursPerWeekMin));
                break;
            case "actual_hours_per_week":
                list.sort(Comparator.comparing(Entry::getActualHoursPerWeekMin));
                break;
            case "salary":
                list.sort(Comparator.comparing(Entry::getTotalBaseSalary));
                break;
            case "bonus":
                list.sort(Comparator.comparing(Entry::getTotalBonus));
                break;
            case "stockOption":
                list.sort(Comparator.comparing(Entry::getTotalStockOptions));
                break;
            case "pto_weeks":
                list.sort(Comparator.comparing(Entry::getPTOAnnualInWeek));
                break;
            case "health_insurance":
                list.sort(Comparator.comparing(Entry::getIsHealthInsuranceOffered));
                break;
            case "gender":
                list.sort(Comparator.comparing(Entry::getGender));
                break;
            default:
                break;
        }
        return list;
    }


}
