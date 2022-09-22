## TripSplit-Backend

<img alt="Spring" src="https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white"/> <img alt="Java" src="https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white"/>

A bill spliting application, uses a greedy algorithm to give the min number of transactions to resolve the expenses, also reduces the complexity.

Made Using Spring Boot with fully scalable code, JWT authentication used to verify the user, database used AWS RDS.

Frontend : https://tripsplits.netlify.app/register

![](lld.png)

### Required request body
- ### UserLogin
```
{
    "username":	string,
    "password": string,
}
```
- ### User Register
```
{
    "userFirstName":	string,
    "userLastName":	string,
    "userName": string,
    "userPassword":	string,
    "userMatchingPassword": string
}
```
- ### Group
```
{
    "grpName":	string,
    "grpType":	string,
    "grpBudget": Long,
    "grpUser":	List<User>,
}
```
- ### Expense
```
{
    "expName":	string,
    "expAmt":	Long,
    "expPaidBy": Long,
    "usrSplitBtw":	List<User>,
    "expGrp": Group
}
```

## Examples

- ### User
**Endpoint:**      
```user/register```  
**Request Boddy:**       
 ```
{
    "userFirstName":"aarhan",
    "userLastName":"khan",
    "userName":"bdab",
    "userPassword":"hello123",
    "userMatchingPassword":"hello123"
}
 ```       
**Response:**       
  ```
{
    "jwtToken": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJiZGFiIiwiZXhwIjoxNjYzNzgwNTM1LCJpYXQiOjE2NjM3NjI1MzV9.jyxoG1RFcT9jNrDSnbYuKo7I0zUob8M- pJphmiUl7i61aTny_EZ0LtfZBQhqA-WgsblY240QHC92LWxCzf3nrA"
}
  ```
  
- ### Expense
**Endpoint:**      
```expense/create```      
**Request Body:**     
 ```
 {
    "expName":"Bus",
    "expAmt":60,
    "expPaidBy":1,
    "usrSplitBtw":[{"id":2}],
    "expGrp":
    {
        "id": 1,
        "groupName": "Shimla",
        "groupBudget": 10000,
        "groupType": "trip"
    }
}
 ```           
**Response:**
  ```
  {
    "id": 2,
    "expName": "Bus",
    "expAmt": 60,
    "expPaidBy": 1,
    "expGrp": {
        "id": 1,
        "groupName": "Shimla",
        "groupBudget": 10000,
        "groupType": "trip"
    }
}
  ```

- ### FinalSplit
**Endpoint:**      
```FinalSplit/{groupId}```  
**Reponse:**       
```
[
    {
        "finalPayTo": 1,
        "finalPayBy": 2,
        "finalAmt": 60.0,
        "finalSplitGrp": {
            "id": 1,
            "groupName": "Shimla",
            "groupBudget": 10000,
            "groupType": "trip"
        }
    }
]
```
