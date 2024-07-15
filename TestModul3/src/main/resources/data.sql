INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (1,'miroslav@maildrop.cc','miroslav','$2y$12$NH2KM2BJaBl.ik90Z1YqAOjoPgSd0ns/bF.7WedMxZ54OhWQNNnh6','Miroslav','Simic','ADMIN');
INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (2,'tamara@maildrop.cc','tamara','$2y$12$DRhCpltZygkA7EZ2WeWIbewWBjLE0KYiUO.tHDUaJNMpsHxXEw9Ky','Tamara','Milosavljevic','KORISNIK');
INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (3,'petar@maildrop.cc','petar','$2y$12$i6/mU4w0HhG8RQRXHjNCa.tG2OwGSVXb0GYUnf8MZUdeadE4voHbC','Petar','Jovic','KORISNIK');

insert into proizvodjac values (1, 'AMD', 'Sjedinjene Američke Države (US)');
insert into proizvodjac values (2, 'Samsung', 'Juzna Korea (KR)');
insert into proizvodjac values (3, 'Gigabyte', 'Tajvan (TW)');
insert into proizvodjac values (4, 'Kingston', 'Sjedinjene Američke Države (US)');

insert into komponenta value (1, 10000.00 , '2019-09-25' , true, 'Ryzen 9 3950X', 'AMD Ryzen 9 3950X.jpg' , 1);
insert into komponenta value (2, 0 , '2018-07-25' , false, 'B450 Aorus M', 'Gigabyte B450 Aorus M.jpg' , 3);
insert into komponenta value (3, 18000.00 , '2019-02-01' , true, 'SSD 970 EVO PLUS 500GB', 'Samsung 970 EVO Plus.png' , 2);
insert into komponenta value (4, 21000.00 ,'2019-07-23' , false, 'GeForce RTX 2080 SUPER OC 8G', 'Gigabyte GeForce RTX 2080 Super OC.png' ,3);
insert into komponenta value (5, 24000.00 ,'2018-08-20' , true, 'HyperX Predator 16GB Kit 3200MHz', 'Kingston DDR4 HyperX Predator.jpeg' , 4);
insert into komponenta value (6, 0 , '2019-09-25' , false, 'C24FG73', 'Samsung C24FG73.jpg' , 2);
