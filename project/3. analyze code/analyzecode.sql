create external table yz001 (movie_title string, director_name string, num_critic_for_reviews int, director_facebook_likes int, actor_3_facebook_likes int, actor_2_name string, actor_1_facebook_likes int, gross bigint, genres string, actor_1_name string, num_voted_users int, cast_total_facebook_likes int, actor_3_name string, num_user_for_reviews int,language string, country string, budget bigint, title_year int,actor_2_facebook_likes int, imdb_score float,movie_facebook_likes int)
row format delimited fields terminated by ','
location '/user/yz2444/projectInput/';

show tables;

describe yz001;
/*    gross  - genres   */
create table yz002 as select * from yz001 where country = "USA" and title_year >= 2007 order by gross desc limit 160;
select distinct genres from yz002;
select genres,count(movie_title) as count from yz002 group by genres order by count desc limit 16;

/*    imdb_score  - genres   */
create table yz003 as select * from yz001 where country = "USA" and title_year >= 2007 order by imdb_score desc limit 160;
select distinct genres from yz003;
select genres,count(movie_title) as count from yz003 group by genres order by count desc limit 16;

/*gross - genres movie sum  */
create external table yz004(movie_type string, num int)
row format delimited fields terminated by ','
location '/user/yz2444/gross_genresInput/';

select movie_type,sum(num) as sum from yz004 group by movie_type order by sum desc;

/*imdbscore - genres movie sum  */
create external table yz005(movie_type string, num int)
row format delimited fields terminated by ','
location '/user/yz2444/imdbscore_genresInput/';

select movie_type,sum(num) as sum from yz005 group by movie_type order by sum desc;


/*cause imdb is based on users and their votest , we gonna adjust imdbscore with other factors : num_user_for_reviews, num_voted_users */
create table yz006 as select * from yz001 where country = "USA" and title_year >= 2007 order by imdb_score*(num_user_for_reviews/num_voted_users) desc limit 160;
select distinct genres from yz006;
select genres,count(movie_title) as count from yz006 group by genres order by count desc limit 16;

/*imdbscore adjusted - genres movie sum  */
create external table yz007(movie_type string, num int)
row format delimited fields terminated by ','
location '/user/yz2444/imdbscore_adjustedInput/';

select movie_type,sum(num) as sum from yz007 group by movie_type order by sum desc;

/* movie_facebook_likes  - genres   */
create table yz008 as select * from yz001 where country = "USA" and title_year >= 2007 order by movie_facebook_likes desc limit 160;
select distinct genres from yz008;
select genres,count(movie_title) as count from yz008 group by genres order by count desc limit 16;

create external table yz012(movie_type string, num int)
row format delimited fields terminated by ','
location '/user/yz2444/movie_fblikesInput/';

select movie_type,sum(num) as sum from yz012 group by movie_type order by sum desc;

/* cast_total_fb_likes - genres*/
create table yz009 as select * from yz001 where country = "USA" and title_year >= 2007 order by cast_total_facebook_likes desc limit 160;
select distinct genres from yz009;
select genres,count(movie_title) as count from yz009 group by genres order by count desc limit 16;

create external table yz013(movie_type string, num int)
row format delimited fields terminated by ','
location '/user/yz2444/cast_total_fblieksInput/';

select movie_type,sum(num) as sum from yz013 group by movie_type order by sum desc;

/* actors_fb_likes -genres*/
create table yz010 as select * from yz001 where country = "USA" and title_year >= 2007 order by (actor_1_facebook_likes+actor_2_facebook_likes+actor_3_facebook_likes) desc limit 160;
select distinct genres from yz010;
select genres,count(movie_title) as count from yz010 group by genres order by count desc limit 16;

create external table yz014(movie_type string, num int)
row format delimited fields terminated by ','
location '/user/yz2444/actors_fblikesInput/';

select movie_type,sum(num) as sum from yz014 group by movie_type order by sum desc;

/* director_fb_likes - genres*/
create table yz011 as select * from yz001 where country = "USA" and title_year >= 2007 order by director_facebook_likes desc limit 160;
select distinct genres from yz011;
select genres,count(movie_title) as count from yz011 group by genres order by count desc limit 16;

create external table yz015(movie_type string, num int)
row format delimited fields terminated by ','
location '/user/yz2444/director_fblikesInput/';

select movie_type,sum(num) as sum from yz015 group by movie_type order by sum desc;

/* combination of director and actors fb_lieks - genres*/
create table yz016 as select * from yz001 where country = "USA" and title_year >= 2007 order by (actor_1_facebook_likes+actor_2_facebook_likes+actor_3_facebook_likes+director_facebook_likes) desc limit 160;
select distinct genres from yz016;
select genres,count(movie_title) as count from yz016 group by genres order by count desc limit 16;

create external table yz017(movie_type string, num int)
row format delimited fields terminated by ','
location '/user/yz2444/combination_fblikesInput/';

select movie_type,sum(num) as sum from yz017 group by movie_type order by sum desc;

/* combination of movie fblikes and cast_total */
create table yz018 as select * from yz001 where country = "USA" and title_year >= 2007 order by (movie_facebook_likes+cast_total_facebook_likes) desc limit 160;
select distinct genres from yz018;
select genres,count(movie_title) as count from yz018 group by genres order by count desc limit 16;

create external table yz019(movie_type string, num int)
row format delimited fields terminated by ','
location '/user/yz2444/combination2_fblikesInput/';

select movie_type,sum(num) as sum from yz019 group by movie_type order by sum desc;

/* combination of total fblikes*/
create table yz020 as select * from yz001 where country = "USA" and title_year >= 2007 order by (movie_facebook_likes+cast_total_facebook_likes+actor_1_facebook_likes+actor_2_facebook_likes+actor_3_facebook_likes+director_facebook_likes) desc limit 160;
select distinct genres from yz020;
select genres,count(movie_title) as count from yz020 group by genres order by count desc limit 16;

create external table yz021(movie_type string, num int)
row format delimited fields terminated by ','
location '/user/yz2444/combination3_fblikesInput/';

select movie_type,sum(num) as sum from yz021 group by movie_type order by sum desc;



