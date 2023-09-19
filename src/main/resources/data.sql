delete from Ingredient_Ref;
delete from Giro;
delete from Giro_Order;

delete from Ingredient;
insert into Ingredient(id,name,type)
                    values ( 'FLPI', 'Flour Pita', 'WRAP');
insert into Ingredient(id,name,type)
                    values ( 'COPI', 'Corn Pita', 'WRAP');
insert into Ingredient(id,name,type)
                    values ( 'GRCH', 'Ground Chicken', 'PROTEIN');
insert into Ingredient(id,name,type)
                    values ( 'CHIC', 'Chicken', 'PROTEIN');
insert into Ingredient(id,name,type)
                    values ( 'SLTO', 'Sliced Tomatoes', 'VEGGIES');
insert into Ingredient(id,name,type)
                    values ( 'SLCU', 'Sliced Cucumber', 'VEGGIES');
insert into Ingredient(id,name,type)
                    values ( 'BRCH', 'Brynza cheese', 'CHEESE');
insert into Ingredient(id,name,type)
                    values ( 'PACH', 'Parmesan cheese', 'CHEESE');
insert into Ingredient(id,name,type)
                    values ( 'SOCR', 'Sour Cream', 'SAUCE');
insert into Ingredient(id,name,type)
                    values ( 'TZSA', 'Tzatziki sauce', 'SAUCE');

delete from users;