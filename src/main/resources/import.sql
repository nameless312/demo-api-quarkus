CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
-- Inserting authors with UUIDs
INSERT INTO Author (authorId, name, surname)
VALUES
    (uuid_generate_v4(), 'Sarah', 'Williams'),
    (uuid_generate_v4(), 'David', 'Jones'),
    (uuid_generate_v4(), 'Emily', 'Taylor');

-- Inserting genres with UUIDs
INSERT INTO Genre (genreId, description, name)
VALUES
    (uuid_generate_v4(), 'Science Fiction', 'Sci-Fi'),
    (uuid_generate_v4(), 'Fantasy', 'Fantasy'),
    (uuid_generate_v4(), 'Mystery', 'Mystery'),
    (uuid_generate_v4(), 'Thriller', 'Thriller'),
    (uuid_generate_v4(), 'Romance', 'Romance');

-- Inserting publishers with UUIDs
INSERT INTO Publisher (publisherId, address, description, email, name, phoneNumber, website)
VALUES
    (uuid_generate_v4(), '123 Main St, New York', 'Science fiction publisher', 'info@publisher1.com', 'Sci-Fi Publications', '123-456-7890', 'www.scifipublications.com'),
    (uuid_generate_v4(), '456 Oak St, Los Angeles', 'Fantasy publisher', 'info@publisher2.com', 'Fantasy House', '456-789-0123', 'www.fantasyhouse.com'),
    (uuid_generate_v4(), '789 Elm St, Chicago', 'Mystery publisher', 'info@publisher3.com', 'Mystery Press', '789-012-3456', 'www.mysterypress.com'),
    (uuid_generate_v4(), '101 Pine St, San Francisco', 'Thriller publisher', 'info@publisher4.com', 'Thriller Books Inc.', '101-112-1314', 'www.thrillerbooksinc.com'),
    (uuid_generate_v4(), '222 Maple St, Seattle', 'Romance publisher', 'info@publisher5.com', 'Romantic Reads', '222-333-4445', 'www.romanticreads.com');

-- Inserting books
INSERT INTO Book (pages, year, isbn, publicationDate, publisher_publisherId, description, language, title)
VALUES
    (300, 2019, 9781234567890, '2019-05-15 10:00:00', (SELECT publisherId FROM Publisher WHERE name = 'Sci-Fi Publications'), 'A thrilling space adventure', 'English', 'Galactic Odyssey'),
    (400, 2020, 9782345678901, '2020-08-20 11:30:00', (SELECT publisherId FROM Publisher WHERE name = 'Fantasy House'), 'A tale of magic and dragons', 'English', 'The Dragon King'),
    (250, 2018, 9783456789012, '2018-03-10 09:45:00', (SELECT publisherId FROM Publisher WHERE name = 'Mystery Press'), 'A gripping detective story', 'English', 'The Case of the Missing Heirloom'),
    (350, 2017, 9784567890123, '2017-11-05 14:20:00', (SELECT publisherId FROM Publisher WHERE name = 'Thriller Books Inc.'), 'An edge-of-your-seat thriller', 'English', 'Deadly Games'),
    (280, 2021, 9785678901234, '2021-06-25 16:10:00', (SELECT publisherId FROM Publisher WHERE name = 'Romantic Reads'), 'A heartwarming love story', 'English', 'Love in Bloom');


-- Linking books with authors
INSERT INTO Book_Author (books_isbn, authors_authorId)
VALUES
    (9781234567890, (SELECT authorId FROM Author WHERE name = 'Sarah' AND surname = 'Williams')),
    (9782345678901, (SELECT authorId FROM Author WHERE name = 'David' AND surname = 'Jones')),
    (9783456789012, (SELECT authorId FROM Author WHERE name = 'Emily' AND surname = 'Taylor')),
    (9784567890123, (SELECT authorId FROM Author WHERE name = 'Sarah' AND surname = 'Williams')),
    (9785678901234, (SELECT authorId FROM Author WHERE name = 'David' AND surname = 'Jones'));

-- Linking books with genres
INSERT INTO Book_Genre (books_isbn, genres_genreId)
VALUES
    (9781234567890, (SELECT genreId FROM Genre WHERE name = 'Sci-Fi')),
    (9782345678901, (SELECT genreId FROM Genre WHERE name = 'Fantasy')),
    (9783456789012, (SELECT genreId FROM Genre WHERE name = 'Mystery')),
    (9784567890123, (SELECT genreId FROM Genre WHERE name = 'Thriller')),
    (9785678901234, (SELECT genreId FROM Genre WHERE name = 'Romance'));
