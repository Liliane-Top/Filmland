INSERT INTO Customer (customer_id, email_as_username, password) VALUES (2, 'France@gmail.com', '12345');
INSERT INTO Customer (customer_id, email_as_username, password) VALUES (1, 'USA@gmail.com', '23456');
INSERT INTO Customer (customer_id, email_as_username, password) VALUES (3, 'Brazil@gmail.com', '34567');
INSERT INTO Customer (customer_id, email_as_username, password) VALUES (4, 'Italy@gmail.com', '45678');
INSERT INTO Customer (customer_id, email_as_username, password) VALUES (5, 'Canada@gmail.com', '56789');
INSERT INTO Category (category_id, category_name, category_price) VALUES (1, 'Dutch Films', 4.0);
INSERT INTO Category (category_id, category_name, category_price) VALUES (2, 'Dutch Series', 6.0);
INSERT INTO Category (category_id, category_name, category_price) VALUES (3, 'International Films', 8.0);
INSERT INTO Subscription (subscription_id, start_date, max_to_watch, category_id) VALUES (1, '2023-6-16', 5, 1);
INSERT INTO Subscription (subscription_id, start_date, max_to_watch, category_id) VALUES (2, '2023-6-16', 5, 2);
INSERT INTO Subscription (subscription_id, start_date, max_to_watch, category_id) VALUES (3, '2023-6-16', 5, 3);
INSERT INTO Customer_Subscription(customer_id, subscription_id) VALUES (4, 1);
INSERT INTO Customer_Subscription(customer_id, subscription_id) VALUES (4, 2);
INSERT INTO Customer_Subscription(customer_id, subscription_id) VALUES (5, 1);
INSERT INTO Customer_Subscription(customer_id, subscription_id) VALUES (5, 2);
INSERT INTO Customer_Subscription(customer_id, subscription_id) VALUES (5, 3);




