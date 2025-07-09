USER:-
1.Post/users 
{
  "id": 1003,
  "name": "nani",
  "email": "nani@gmail.com"
 }
2.Get/users/{id}
3.DELETE /users/{id}
4.DELETE /users 

 WALLET:-
1.GET /wallets/{user_id}
2. PUT /wallets/{user_id}
 {
  "action": "debit" or "credit",
  "amount": 500
 }
3.DELETE /wallets/{user_id}
4.DELETE /wallets

Products:-
1.GET /proucts
2.GET /products/id

orders:-
1.POST /orders
{
  "user_id": 1003,
  "items": [
    {
      "product": {
        "id": 101
      },
      "quantity": 2
    },
    {
      "product": {
        "id": 102
      },
      "quantity": 1
    }
  ]
}

