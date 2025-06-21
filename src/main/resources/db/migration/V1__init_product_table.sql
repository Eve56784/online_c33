create table if not exists product(
                                    id bigSerial primary key,
                                      name varchar(255) not null unique,
                                    description text not null,
                                    price decimal(9,2) check (price>0),
                                    quantity int check(quantity>=0)
    );