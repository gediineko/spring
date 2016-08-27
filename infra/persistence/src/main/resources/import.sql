INSERT INTO public.useraccount VALUES (1, true, true, true, true, '$2a$10$LehROxvGOls7KBbZuegOju3SDKYRb9GyPP9UpqIaJWiGjXvss0JUa', 'super_admin');
INSERT INTO public.useraccount VALUES (2, true, true, true, true, '$2a$10$LehROxvGOls7KBbZuegOju3SDKYRb9GyPP9UpqIaJWiGjXvss0JUa', 'ggolong');

INSERT INTO public.userprofile VALUES ('Spring Field', 'Beansworth', '#6733', '87511', '7/10/1980', true, '5/10/2000', 2.0, 'Arthur', 'Dayne', 'Markus', 'III', 'Mr.', 2);

INSERT INTO public.contact VALUES (2, 'adayne@gmail.com', 'Email', 2);

INSERT INTO public.role VALUES (1, 'Super Admin', 'ADMIN');
INSERT INTO public.role VALUES (2, 'User', 'USER');

INSERT INTO public.join_user_account_x_role VALUES (1, 1);
INSERT INTO public.join_user_account_x_role VALUES (2, 2);
