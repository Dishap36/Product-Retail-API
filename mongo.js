db.User.insertMany(
    [
        {
         "userId": "1",
         "username": "eclipse",
         "password":"code",
         "email": "code123@gmail.com",
         "role": "ADMIN"
     },
     {
     
        "userId": "2",
        "username": "vscode",
        "password":"main",
        "email": "main123@gmail.com",
        "role": "USER"
     }
     
     
     ]
);



db.product.insertMany(
    [
        {
            "prodId": "1",
            "category": "Vegetables",
            "productname": "Spinach",
            "price": 2.00,
            "expiration date": "11-13-2022",
            "Organic": "true",
            "pre-packed": "true"
                
        },
        {
            "prodId": "2",
            "category": "Vegetables",
            "productname": "Kale",
            "price": 2.50,
            "expiration date": "11-13-2022",
            "Organic": "true",
            "pre-packed": "true"
        },
        {
            "prodId": "3",
            "category": "Vegetables",
            "productname": "Mint",
            "price": 3.00,
            "expiration date": "11-13-2022",
            "Organic": "true",
            "pre-packed": "true"
        }
        ]
        
);

db.Cart.insertMany(
    [
        {
            "userId": "1",
            "purchased": [
                {
                    "prodId": "1",
                    "qty": 2,
                    "total": 4.00
                },
                {
                    "prodId": "2",
                    "qty": 1,
                    "total": 2.50 
                },
                {
                    "prodId": "3",
                    "qty": 3,
                    "total": 9.00
                }
    
            ],
            "Grand-Total": 15.50
        }
    ]
);