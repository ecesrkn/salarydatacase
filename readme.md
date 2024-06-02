## Exercise A


### Endpoints
#### compensation_data (GET)
All parameters are optional

| Parameters                     | Type        |
|--------------------------------|-------------|
| company_size[gte]              | integer     |
| company_size[lte]              | integer     |
| company_name                   | String      |
| employment_type                | String      |
| company_industry               | String      |
| company_type                   | String      |
| years_experience_industry[gte] | integer     |
| years_experience_industry[lte] | integer     |
| years_experience_company[gte]  | integer     |
| years_experience_company[lte]  | integer     |
| job_title                      | String      |
| job_ladder                     | String      |
| job_level                      | String      |
| education_level                | String      |
| required_hours_per_week[gte]   | integer     |
| required_hours_per_week[lte]   | integer     |
| actual_hours_per_week[gte]     | integer     |
| actual_hours_per_week[lte]     | integer     |
| salary[gte]                    | integer     |
| salary[lte]                    | integer     |
| bonus[gte]                     | integer     |
| bonus[lte]                     | integer     |
| stockOption[gte]               | integer     |
| stockOption[lte]               | integer     |
| pto_weeks[gte]                 | integer     |
| pto_weeks[lte]                 | integer     |
| health_insurance               | boolean     |
| gender                         | String      |
| sort                           | SortOptions |

SortOptions should be one of these string keys:

"company_size",
"company_name",
"employment_type",
"company_industry",
"company_type",
"years_experience_industry",
"years_experience_company",
"job_title",
"job_ladder",
"job_level",
"education_level",
"required_hours_per_week",
"actual_hours_per_week",
"salary",
"bonus",
"stockOption",
"pto_weeks",
"health_insurance",
"gender",


#### compensation_data/get_item (GET)

This method finds the first record where these 5 fields match:

| Parameters       | Type                                                                         |
|------------------|------------------------------------------------------------------------------|
| employment_type  | String                                                                       |
| company_name     | String                                                                       |
| country          | String   (Country Code must be given as parameter. (e.g. "...&country=ca&... |
| city             | String                                                                       |
| company_industry | String                                                                       |

